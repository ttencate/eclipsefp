/*
 * File haskell-lexer.g
 * 
 * This file is an ANTLR grammar file that describes a lexer (scanner)
 * for Haskell.
 *
 * ANTLR is needed to translate this grammar to executable code. It is
 * freely available at http://www.antlr.org
 *
 * Author: Thiago Arrais - thiago.arrais@gmail.com
 */
header {
package net.sf.eclipsefp.haskell.core.jparser;
}

class HaskellLexer extends Lexer;

options	{
    k = 6;
}

WS	:	(' '
    |    '\t'
    |    '\n' { newline(); }
    |    '\r')+
    	{ $setType(Token.SKIP); }
    ;
    
MODULE : "module" ;
       
WHERE : "where" ;

CONSTRUCTOR_ID : UPPER_CASE	( LETTER
							| DIGIT
							| '\'' )* ;
							
VARIABLE_ID : LOWER_CASE	( LETTER
							| DIGIT
							| '\'' )* ;

DECIMAL : '0' | ('1'..'9') (DIGIT)* ;

LEFT_CURLY : '{' ;

RIGHT_CURLY : '}' ;

SEMICOLON : ';' ;

LEFT_PAREN : '(' ;

RIGHT_PAREN : ')' ;

COMMA : ',' ;

protected
UPPER_CASE : 'A'..'Z';

protected
LOWER_CASE : 'a'..'z';

protected
LETTER : UPPER_CASE | LOWER_CASE;

protected
DIGIT : '0'..'9';

SYMBOL : ~('a'..'z' | 'A'..'Z' | '0'..'9');