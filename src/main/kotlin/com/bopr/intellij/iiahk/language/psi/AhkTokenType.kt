package com.bopr.intellij.iiahk.language.psi

import com.bopr.intellij.iiahk.language.AhkLanguage
import com.intellij.psi.tree.IElementType

class AhkTokenType(debugName: String) : IElementType(debugName, AhkLanguage.INSTANCE) {

    override fun toString(): String {
        return "AhkTokenType." + super.toString()
    }
}