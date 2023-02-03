package com.bopr.intellij.iiahk.language

import com.bopr.intellij.iiahk.util.string
import com.intellij.openapi.fileTypes.LanguageFileType
import com.intellij.openapi.util.IconLoader
import javax.swing.Icon

class AhkFileType : LanguageFileType(AhkLanguage.INSTANCE) {

    override fun getName(): String {
        return AHK_FILE_NAME
    }

    override fun getDescription(): String {
        return string("ahk_script_file")
    }

    override fun getDefaultExtension(): String {
        return AHK_FILE_EXTENSION
    }

    override fun getIcon(): Icon {
        return AHK_FILE_ICON
    }

    companion object {

        const val AHK_FILE_NAME = "Ahk Script"
        const val AHK_FILE_EXTENSION = "ahk"
        val AHK_FILE_ICON = IconLoader.getIcon("/icons/ahk-file.png", Companion::class.java)

        @JvmStatic
        val INSTANCE = AhkFileType()
    }
}