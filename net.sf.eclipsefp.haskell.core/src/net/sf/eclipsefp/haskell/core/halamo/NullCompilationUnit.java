package net.sf.eclipsefp.haskell.core.halamo;

import org.eclipse.core.resources.IFile;

public class NullCompilationUnit implements ICompilationUnit {

	private static NullCompilationUnit instance;

	private NullCompilationUnit() {
		//hide default constructor for singleton
	}
	
	public static ICompilationUnit getInstance() {
		if (null == instance) {
			instance = new NullCompilationUnit();
		}
		return instance;
	}

	public IModule[] getModules() {
		return new IModule[0];
	}

	public ISourceLocation getNextLocation(ISourceLocation srcLoc) {
		return null;
	}

	public String getOriginalSourceCode() {
		return "";
	}

	public IFile getUnderlyingResource() {
		return null;
	}

	public Object getAdapter(Class adapter) {
		return null;
	}

}