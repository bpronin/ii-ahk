package com.bopr.intellij.iiahk.language;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static com.bopr.intellij.iiahk.language.psi.AhkTypes.*;

%%

%{
    public AhkLexer() {
        this(null);
    }
%}

%public
%class AhkLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode
//%caseless
//%ignorecase

NEW_LINE = [\r\n]
WHITE_SPACE = \s+
LINE_COMMENT = ; .*
BLOCK_COMMENT = "/*" ([^] | {NEW_LINE} | "/*")* "*/"
STRING = \"([^\"]|\"\")*\"
DECIMAL_INTEGER_NUMBER = [+-]?[0-9]+
HEXADECIMAL_INTEGER_NUMBER = [+-]?0x[0-9a-fA-F]+
FLOAT_NUMBER = [+-]?[0-9]*\.[0-9]+([eE][+-]?[0-9]+)?
OPERATOR = ::|:=|&|=

KEYWORD = return|if|else|while|global|static

KEY = LButton|RButton|MButton|XButton1|XButton2|WheelDown|WheelUp|WheelLeft|WheelRight
    | CapsLock|Space|Tab|Enter|Return|Escape|Esc|Backspace|BS
    |ScrollLock|Delete|Del|Insert|Ins|Home|End|PgUp|PgDn|Up|Down|Left|Right
    |NumLock|Numpad([0-9]|Ins|End|Down|PgDn|Left|Clear|Right|Home|Up|PgUp|Dot|Div|Mult|Add|Sub|Enter)
    |F(1[0-9]|2[0-4]|[1-9])
    |LWin|RWin|Control|Ctrl|Alt|Shift|LControl|LCtrl|RControl|RCtrl|LShift|RShift|LAlt|RAlt
    |Browser_(Back|Forward|Refresh|Stop|Search|Favorites|Home)
    |Volume_(Mute|Down|Up)
    |Media_(Next|Prev|Stop|Play_Pause)
    |Launch_(Mail|Media|App1|App2)
    |AppsKey|PrintScreen|CtrlBreak|Pause|Break|Help|Sleep
    |SC[0-9a-fA-F][0-9a-fA-F][0-9a-fA-F]
    |VK[0-9a-fA-F][0-9a-fA-F]
    |Joy([1-2][0-9]|3[0-2]|[1-9])
//    |[\S]

BUILT_IN_VARIABLE = A_Clipboard|Clipboard|ErrorLevel

BUILT_IN_CONSTANT = A_Space|A_Tab
    // todo: 1, 2, 3, etc
    |A_Args|A_WorkingDir|A_InitialWorkingDir|A_ScriptDir|A_ScriptName|A_ScriptFullPath|A_ScriptHwnd
    |A_LineNumber|A_LineFile|A_ThisFunc|A_ThisLabel|A_AhkVersion|A_AhkPath|A_IsUnicode|A_IsCompiled
    |A_ExitReason
    //todo:...

BUILD_IN_COMMAND = AutoTrim|BlockInput|Break|Catch|Click|ClipWait

BUILD_IN_FUNCTION = Abs|Asc|ASin|ACos|ATan|Ceil|Chr

PREPROCESSOR_DIRECTIVE = # [a-zA-Z_0-9]+

COMPILER_DIRECTIVE = @Ahk2Exe-AddResource // FileName [, ResourceName]
    |@Ahk2Exe-Bin //  [Path\]Name [, [Exe_path\][Name], Codepage] ; Deprecated
    |@Ahk2Exe-Base // [Path\]Name [, [Exe_path\][Name], Codepage] ;
    |@Ahk2Exe-ConsoleApp
    |@Ahk2Exe-Cont // Text
    |@Ahk2Exe-Debug // Text
    |@Ahk2Exe-ExeName // [Path\][Name]
    |@Ahk2Exe-Let // Name = Value [, Name = Value, ...]
    |@Ahk2Exe-Nop // [Text]
    |@Ahk2Exe-Obey // Name, CmdOrExp [, Extra]
    |@Ahk2Exe-PostExec // Program [parameters] [, When, WorkingDir, Hidden, IgnoreErrors]
    |@Ahk2Exe-ResourceID // Name
    |@Ahk2Exe-SetMainIcon // [IcoFile]
    |@Ahk2Exe-SetProp // Value
    |@Ahk2Exe-Set // Prop, Value
    |@Ahk2Exe-UpdateManifest // RequireAdmin [, Name, Version, UIAccess]
    |@Ahk2Exe-UseResourceLang // LangCode

IDENTIFIER = [a-zA-Z_0-9]+

%%

<YYINITIAL> {
  {WHITE_SPACE}                     { return WHITE_SPACE; }

  "."                               { return DOT; }
  ","                               { return COMMA; }
  ";"                               { return SEMICOLON; }
  "("                               { return LPARENTHESIS; }
  ")"                               { return RPARENTHESIS; }
  "["                               { return LBRACKET; }
  "]"                               { return RBRACKET; }
  "{"                               { return LBRACE; }
  "}"                               { return RBRACE; }

  {LINE_COMMENT}                    { return LINE_COMMENT; }
  {BLOCK_COMMENT}                   { return BLOCK_COMMENT; }
  {KEYWORD}                         { return KEYWORD; }
  {KEY}                             { return KEY; }
  {BUILT_IN_VARIABLE}               { return BUILT_IN_VARIABLE; }
  {BUILT_IN_CONSTANT}               { return BUILT_IN_CONSTANT; }
  {BUILD_IN_COMMAND}                { return BUILD_IN_COMMAND; }
  {BUILD_IN_FUNCTION}               { return BUILD_IN_FUNCTION; }
  {OPERATOR}                        { return OPERATOR; }
  {STRING}                          { return STRING; }
  {DECIMAL_INTEGER_NUMBER}          { return DECIMAL_INTEGER_NUMBER; }
  {HEXADECIMAL_INTEGER_NUMBER}      { return HEXADECIMAL_INTEGER_NUMBER; }
  {FLOAT_NUMBER}                    { return FLOAT_NUMBER; }
  {PREPROCESSOR_DIRECTIVE}          { return PREPROCESSOR_DIRECTIVE; }
  {COMPILER_DIRECTIVE}              { return COMPILER_DIRECTIVE; }
  {IDENTIFIER}                      { return IDENTIFIER; }

}

[^]                                 { return BAD_CHARACTER; }
