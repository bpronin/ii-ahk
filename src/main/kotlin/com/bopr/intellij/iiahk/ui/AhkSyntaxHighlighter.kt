package com.bopr.intellij.iiahk.ui

import com.bopr.intellij.iiahk.language.AhkLexerAdapter
import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import com.bopr.intellij.iiahk.language.psi.AhkTypes as Types
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors as Colors

class AhkSyntaxHighlighter : SyntaxHighlighterBase() {

    override fun getHighlightingLexer(): Lexer {
        return AhkLexerAdapter()
    }

    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> {
        return KEYS[tokenType] ?: EMPTY_KEYS
    }

    companion object {

        private val EMPTY_KEYS = arrayOf<TextAttributesKey>()
        private val KEYS: MutableMap<IElementType, Array<TextAttributesKey>> = mutableMapOf()

        private fun createKey(
            externalName: String, fallbackKey: TextAttributesKey, vararg elementTypes: IElementType
        ): TextAttributesKey {
            val key = createTextAttributesKey(externalName, fallbackKey)
            for (type in elementTypes) {
                KEYS[type] = arrayOf(key)
            }
            return key
        }

        val BAD_CHARACTER = createKey("AHK_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER, TokenType.BAD_CHARACTER)
        val BLOCK_COMMENT = createKey("AHK_BLOCK_COMMENT", Colors.BLOCK_COMMENT, Types.BLOCK_COMMENT)
        val BRACE = createKey("AHK_BRACE", Colors.BRACES, Types.LBRACE, Types.RBRACE)
        val BRACKET = createKey("AHK_BRACKET", Colors.BRACKETS, Types.LBRACKET, Types.RBRACKET)
        val FLOATING_POINT_NUMBER = createKey("AHK_REAL_NUMBER", Colors.NUMBER, Types.FLOAT_NUMBER)
        val KEYWORD = createKey("AHK_KEYWORD", Colors.KEYWORD, Types.KEYWORD)
        val LINE_COMMENT = createKey("AHK_LINE_COMMENT", Colors.LINE_COMMENT, Types.LINE_COMMENT)
        val PARENTHESIS = createKey("AHK_PARENTHESIS", Colors.PARENTHESES, Types.LPARENTHESIS, Types.RPARENTHESIS)
        val SEMICOLON = createKey("AHK_SEMICOLON", Colors.SEMICOLON, Types.SEMICOLON)
        val OPERATOR = createKey("AHK_OPERATOR", Colors.OPERATION_SIGN, Types.OPERATOR)
        val DECIMAL_INTEGER_NUMBER =
            createKey("AHK_DECIMAL_INTEGER_NUMBER", Colors.NUMBER, Types.DECIMAL_INTEGER_NUMBER)
//        val LOCAL_VARIABLE =
//            createKey("AHK_LOCAL_VARIABLE", Colors.LOCAL_VARIABLE, Types.LOCAL_VARIABLE, Types.STATIC_VARIABLE)
//        val GLOBAL_VARIABLE = createKey("AHK_GLOBAL_VARIABLE", Colors.GLOBAL_VARIABLE, Types.GLOBAL_VARIABLE)
        val DOT = createKey("AHK_DOT", Colors.DOT, Types.DOT)
        val COMMA = createKey("AHK_COMMA", Colors.COMMA, Types.COMMA)
        val LABEL = createKey("AHK_LABEL", Colors.LABEL, Types.LABEL)
//        val FUNCTION_DECLARATION =
//            createKey("AHK_FUNCTION_DECLARATION", Colors.FUNCTION_DECLARATION, Types.FUNCTION_DECLARATION)
        val CALL =
            createKey("AHK_FUNCTION_CALL", Colors.FUNCTION_CALL, Types.FUNCTION_CALL_EXPRESSION, Types.COMMAND)
        val HEXADECIMAL_INTEGER_NUMBER =
            createKey("AHK_HEXADECIMAL_INTEGER_NUMBER", Colors.NUMBER, Types.HEXADECIMAL_INTEGER_NUMBER)
        val STRING = createKey("AHK_STRING", Colors.STRING, Types.STRING)
    }
}
