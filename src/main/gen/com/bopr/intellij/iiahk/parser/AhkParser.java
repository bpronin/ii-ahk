// This is a generated file. Not intended for manual editing.
package com.bopr.intellij.iiahk.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.bopr.intellij.iiahk.language.psi.AhkTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class AhkParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return root(b, l + 1);
  }

  /* ********************************************************** */
  // LINE_COMMENT
  public static boolean comment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comment")) return false;
    if (!nextTokenIs(b, LINE_COMMENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LINE_COMMENT);
    exit_section_(b, m, COMMENT, r);
    return r;
  }

  /* ********************************************************** */
  // DECIMAL_INTEGER_NUMBER
  public static boolean decimal_integer_literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "decimal_integer_literal")) return false;
    if (!nextTokenIs(b, DECIMAL_INTEGER_NUMBER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DECIMAL_INTEGER_NUMBER);
    exit_section_(b, m, DECIMAL_INTEGER_LITERAL, r);
    return r;
  }

  /* ********************************************************** */
  // literal | comment | whitespace
  static boolean element(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "element")) return false;
    boolean r;
    r = literal(b, l + 1);
    if (!r) r = comment(b, l + 1);
    if (!r) r = whitespace(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // decimal-integer-literal
  //   | real-literal
  static boolean literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literal")) return false;
    if (!nextTokenIs(b, "", DECIMAL_INTEGER_NUMBER, REAL_LITERAL_NUMBER)) return false;
    boolean r;
    r = decimal_integer_literal(b, l + 1);
    if (!r) r = real_literal(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // REAL_LITERAL_NUMBER
  public static boolean real_literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "real_literal")) return false;
    if (!nextTokenIs(b, REAL_LITERAL_NUMBER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, REAL_LITERAL_NUMBER);
    exit_section_(b, m, REAL_LITERAL, r);
    return r;
  }

  /* ********************************************************** */
  // element *
  static boolean root(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "root")) return false;
    while (true) {
      int c = current_position_(b);
      if (!element(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "root", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // 'regexp:\s+'
  static boolean whitespace(PsiBuilder b, int l) {
    return consumeToken(b, "regexp:\\s+");
  }

}
