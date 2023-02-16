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
%caseless
%ignorecase

NEW_LINE = [\r\n]
WHITE_SPACE = \s+
LINE_COMMENT = ";" .*
PREPROCESSOR = "#" .*
//BLOCK_COMMENT= "/*" [^]  "/*"

%%

<YYINITIAL> {
    {NEW_LINE}                      { return NEW_LINE; }
    {PREPROCESSOR}                  { return PREPROCESSOR; }
    {WHITE_SPACE}                   { return WHITE_SPACE; }
    {LINE_COMMENT}                  { return LINE_COMMENT; }
}

[^] { return BAD_CHARACTER; }
