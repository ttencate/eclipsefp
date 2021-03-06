package net.sf.eclipsefp.haskell.ui.internal.editors.haskell.codeassist;

import net.sf.eclipsefp.haskell.core.HaskellCorePlugin;
import net.sf.eclipsefp.haskell.core.halamo.IHaskellModelManager;
import net.sf.eclipsefp.haskell.core.parser.IHaskellParser;
import net.sf.eclipsefp.haskell.core.parser.ParserManager;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.texteditor.ITextEditor;

public class WorkbenchHaskellCompletionContext extends HaskellCompletionContext {

	public WorkbenchHaskellCompletionContext(final ITextViewer viewer, final int offset) throws CoreException {
		this(HaskellCorePlugin.getDefaultModelManager(), viewer, offset);
	}

	public WorkbenchHaskellCompletionContext(final IHaskellModelManager manager, final ITextViewer viewer, final int offset) throws CoreException {
		this(manager, ParserManager.getInstance().getParser(), viewer, offset);
	}

	public WorkbenchHaskellCompletionContext(final IHaskellParser parser, final ITextViewer viewer, final int offset) throws CoreException {
		this(HaskellCorePlugin.getDefaultModelManager(), parser, viewer, offset);
	}

	protected WorkbenchHaskellCompletionContext(final IHaskellModelManager manager,
												final IHaskellParser parser,
												final ITextViewer viewer,
												final int offset) throws CoreException
	{
		super(parser.parse(getFile(viewer), viewer.getDocument().get()),
				manager.getModelFor(getFile(viewer).getProject()),
				offset);
	}

	private static IFile getFile(final ITextViewer viewer) {
		IDocument currentDocument = viewer.getDocument();

		IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		IEditorReference editorReferences[] = window.getActivePage().getEditorReferences();

		IEditorInput input = null;

		for (int i = 0; i < editorReferences.length; i++) {
			IEditorPart editor = editorReferences[i].getEditor(false);
			if (editor instanceof ITextEditor) {
				ITextEditor textEditor = (ITextEditor) editor;
				IDocument doc = textEditor.getDocumentProvider().getDocument(textEditor.getEditorInput());
				if (currentDocument.equals(doc)) {
					input = textEditor.getEditorInput();
					break;
				}
			}
		}

		if (input instanceof IFileEditorInput) {
			IFileEditorInput fileInput = (IFileEditorInput) input;
			return fileInput.getFile();
		}
    //TODO what to do when there isn't a file editor opened?
		return null;
	}
}
