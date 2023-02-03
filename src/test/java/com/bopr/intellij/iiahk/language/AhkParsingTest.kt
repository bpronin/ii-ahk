package com.bopr.intellij.iiahk.language

import com.intellij.testFramework.ParsingTestCase

class AhkParsingTest : ParsingTestCase("", "ahk", AhkParserDefinition()) {

    fun testParsingTestData() {
        doTest(true)
    }

    override fun getTestDataPath(): String {
        return "src/test/testData"
    }

    override fun skipSpaces(): Boolean {
        return false
    }

    override fun includeRanges(): Boolean {
        return true
    }
}