// This is a generated file. Not intended for manual editing.
package com.bopr.intellij.iiahk.language.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.bopr.intellij.iiahk.language.psi.AhkTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.bopr.intellij.iiahk.psi.*;

public class AhkDecimalIntegerLiteralImpl extends ASTWrapperPsiElement implements AhkDecimalIntegerLiteral {

  public AhkDecimalIntegerLiteralImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AhkVisitor visitor) {
    visitor.visitDecimalIntegerLiteral(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AhkVisitor) accept((AhkVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public PsiElement getDecimalIntegerNumber() {
    return findNotNullChildByType(DECIMAL_INTEGER_NUMBER);
  }

}
