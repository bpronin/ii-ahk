package com.bopr.intellij.iiahk.language

import com.intellij.lexer.FlexAdapter

class AhkLexerAdapter : FlexAdapter(AhkLexer(null))