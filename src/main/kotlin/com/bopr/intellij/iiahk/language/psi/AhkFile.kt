package com.bopr.intellij.iiahk.language.psi

import com.bopr.intellij.iiahk.language.AhkFileType
import com.bopr.intellij.iiahk.language.AhkLanguage
import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider

class AhkFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, AhkLanguage.INSTANCE) {

    override fun getFileType(): FileType {
        return AhkFileType.INSTANCE
    }

    override fun toString(): String {
        return "Ahk Script"
    }
}