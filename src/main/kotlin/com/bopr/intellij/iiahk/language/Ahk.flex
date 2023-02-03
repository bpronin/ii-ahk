package com.bopr.intellij.iiahk.language;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static com.bopr.intellij.iiahk.language.psi.AhkTypes.*;

%%

%{
  public AhkLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class AhkLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL=\R
WHITE_SPACE=\s+
DECIMAL_INTEGER_NUMBER=[0-9]+
REAL_LITERAL_NUMBER=[0-9]+(\.[0-9]*)?
LINE_COMMENT=;.*

%%

<YYINITIAL> {
  {WHITE_SPACE}                 { return WHITE_SPACE; }
  {DECIMAL_INTEGER_NUMBER}      { return DECIMAL_INTEGER_NUMBER; }
  {REAL_LITERAL_NUMBER}         { return REAL_LITERAL_NUMBER; }
  {LINE_COMMENT}                { return LINE_COMMENT; }
}

[^] { return BAD_CHARACTER; }
