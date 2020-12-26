/* This file was generated by SableCC (http://www.sablecc.org/). */

package minipython.analysis;

import minipython.node.*;

public interface Analysis extends Switch
{
    Object getIn(Node node);
    void setIn(Node node, Object in);
    Object getOut(Node node);
    void setOut(Node node, Object out);

    void caseStart(Start node);
    void caseAGoal(AGoal node);
    void caseAFuncCommand(AFuncCommand node);
    void caseAStatementCommand(AStatementCommand node);
    void caseAFunction(AFunction node);
    void caseAArgument(AArgument node);
    void caseAIdentifierValue(AIdentifierValue node);
    void caseAIfStatement(AIfStatement node);
    void caseAWhileStatement(AWhileStatement node);
    void caseAForStatement(AForStatement node);
    void caseAReturnStatement(AReturnStatement node);
    void caseAPrintStatement(APrintStatement node);
    void caseAAssertStatement(AAssertStatement node);
    void caseAFuncCallStatement(AFuncCallStatement node);
    void caseAAssignStatement(AAssignStatement node);
    void caseAMinusAssignStatement(AMinusAssignStatement node);
    void caseADivAssignStatement(ADivAssignStatement node);
    void caseAAssignListStatement(AAssignListStatement node);
    void caseASumExpression(ASumExpression node);
    void caseAMinusExpression(AMinusExpression node);
    void caseAMultExpression(AMultExpression node);
    void caseADivExpression(ADivExpression node);
    void caseAModuloExpression(AModuloExpression node);
    void caseAPowExpression(APowExpression node);
    void caseASubscriptionExpression(ASubscriptionExpression node);
    void caseAFuncCallExpression(AFuncCallExpression node);
    void caseAValueExpression(AValueExpression node);
    void caseAIdentifierExpression(AIdentifierExpression node);
    void caseAOpenExpression(AOpenExpression node);
    void caseATypeExpression(ATypeExpression node);
    void caseAMaxExpression(AMaxExpression node);
    void caseAMinExpression(AMinExpression node);
    void caseAParExpression(AParExpression node);
    void caseAListDefExpression(AListDefExpression node);
    void caseAAndComparison(AAndComparison node);
    void caseAOrComparison(AOrComparison node);
    void caseANotComparison(ANotComparison node);
    void caseAGreatComparison(AGreatComparison node);
    void caseALessComparison(ALessComparison node);
    void caseALeqComparison(ALeqComparison node);
    void caseAGeqComparison(AGeqComparison node);
    void caseANeqComparison(ANeqComparison node);
    void caseAEqComparison(AEqComparison node);
    void caseATrueComparison(ATrueComparison node);
    void caseAFalseComparison(AFalseComparison node);
    void caseAFunctionCall(AFunctionCall node);
    void caseAMethodValue(AMethodValue node);
    void caseANumberValue(ANumberValue node);
    void caseAStringValue(AStringValue node);
    void caseANoneValue(ANoneValue node);

    void caseTLineComment(TLineComment node);
    void caseTTab(TTab node);
    void caseTAssign(TAssign node);
    void caseTMinusAssign(TMinusAssign node);
    void caseTDivAssign(TDivAssign node);
    void caseTExclam(TExclam node);
    void caseTLPar(TLPar node);
    void caseTRPar(TRPar node);
    void caseTLBr(TLBr node);
    void caseTRBr(TRBr node);
    void caseTComma(TComma node);
    void caseTQmark(TQmark node);
    void caseTSemi(TSemi node);
    void caseTDot(TDot node);
    void caseTPlus(TPlus node);
    void caseTMinus(TMinus node);
    void caseTMult(TMult node);
    void caseTDiv(TDiv node);
    void caseTMode(TMode node);
    void caseTDmult(TDmult node);
    void caseTIf(TIf node);
    void caseTIn(TIn node);
    void caseTElif(TElif node);
    void caseTElse(TElse node);
    void caseTWhile(TWhile node);
    void caseTFor(TFor node);
    void caseTPrint(TPrint node);
    void caseTReturn(TReturn node);
    void caseTOpen(TOpen node);
    void caseTType(TType node);
    void caseTMax(TMax node);
    void caseTMin(TMin node);
    void caseTAssert(TAssert node);
    void caseTDictt(TDictt node);
    void caseTDef(TDef node);
    void caseTNone(TNone node);
    void caseTLeq(TLeq node);
    void caseTLess(TLess node);
    void caseTGeq(TGeq node);
    void caseTGreat(TGreat node);
    void caseTNeq(TNeq node);
    void caseTEq(TEq node);
    void caseTTrue(TTrue node);
    void caseTFalse(TFalse node);
    void caseTAnd(TAnd node);
    void caseTOr(TOr node);
    void caseTNot(TNot node);
    void caseTColon(TColon node);
    void caseTQuote(TQuote node);
    void caseTBlank(TBlank node);
    void caseTIntegerLiteral(TIntegerLiteral node);
    void caseTIdentifier(TIdentifier node);
    void caseTStringLiteral(TStringLiteral node);
    void caseEOF(EOF node);
}
