// This is a generated file. Not intended for manual editing.
package com.bopr.intellij.iiahk.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.bopr.intellij.iiahk.language.psi.impl.*;

public interface AhkTypes {

  IElementType COMMENT = new AhkElementType("COMMENT");
  IElementType DECIMAL_INTEGER_LITERAL = new AhkElementType("DECIMAL_INTEGER_LITERAL");
  IElementType REAL_LITERAL = new AhkElementType("REAL_LITERAL");

  IElementType DECIMAL_INTEGER_NUMBER = new AhkTokenType("DECIMAL_INTEGER_NUMBER");
  IElementType LINE_COMMENT = new AhkTokenType("LINE_COMMENT");
  IElementType REAL_LITERAL_NUMBER = new AhkTokenType("REAL_LITERAL_NUMBER");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == COMMENT) {
        return new AhkCommentImpl(node);
      }
      else if (type == DECIMAL_INTEGER_LITERAL) {
        return new AhkDecimalIntegerLiteralImpl(node);
      }
      else if (type == REAL_LITERAL) {
        return new AhkRealLiteralImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
