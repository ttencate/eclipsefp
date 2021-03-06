package net.sf.eclipsefp.haskell.core.jparser.ast;

import java.util.List;
import java.util.Vector;

import net.sf.eclipsefp.haskell.core.halamo.IInfixDeclaration;

public class InfixDeclaration extends Declaration implements IInfixDeclaration {

	private int fAssociativity;
	private int fPrecedence = 9;
	private final List<String> fOperators = new Vector<String>();

	public int getAssociativity() {
		return fAssociativity;
	}

	public int getPrecedenceLevel() {
		return fPrecedence;
	}

	public String[] getOperators() {
		return fOperators .toArray(new String[fOperators.size()]);
	}

	public void setAssociativity(final int associativity) {
		fAssociativity = associativity;
	}

	public void setPrecedence(final int precedence) {
		fPrecedence = precedence;
	}

	public void addOperators(final List<String> operators) {
		fOperators.addAll(operators);
	}

}
