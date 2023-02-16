package com.bopr.intellij.iiahk.language

import com.bopr.intellij.iiahk.language.psi.AhkFile
import com.bopr.intellij.iiahk.language.psi.AkrPsiElement
import com.bopr.intellij.iiahk.parser.AhkParser
import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet

class AhkParserDefinition : ParserDefinition {

    override fun createLexer(project: Project): Lexer {
        return AhkLexerAdapter()
    }

    override fun createParser(project: Project): PsiParser {
        return AhkParser()
    }

    override fun getFileNodeType(): IFileElementType {
        return FILE
    }

    override fun getCommentTokens(): TokenSet {
        return TokenSet.EMPTY
    }

    override fun getStringLiteralElements(): TokenSet {
        return TokenSet.EMPTY
    }

    override fun createElement(node: ASTNode): PsiElement {
        return AkrPsiElement(node)
    }

    override fun createFile(viewProvider: FileViewProvider): PsiFile {
        return AhkFile(viewProvider)
    }

    companion object {

        private val FILE = IFileElementType(AhkLanguage.INSTANCE)
    }
}