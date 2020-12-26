/* This file was generated by SableCC (http://www.sablecc.org/). */

package minipython.analysis;

import java.util.*;
import minipython.node.*;

public class AnalysisAdapter implements Analysis
{
    private Hashtable in;
    private Hashtable out;

    public Object getIn(Node node)
    {
        if(in == null)
        {
            return null;
        }

        return in.get(node);
    }

    public void setIn(Node node, Object in)
    {
        if(this.in == null)
        {
            this.in = new Hashtable(1);
        }

        if(in != null)
        {
            this.in.put(node, in);
        }
        else
        {
            this.in.remove(node);
        }
    }

    public Object getOut(Node node)
    {
        if(out == null)
        {
            return null;
        }

        return out.get(node);
    }

    public void setOut(Node node, Object out)
    {
        if(this.out == null)
        {
            this.out = new Hashtable(1);
        }

        if(out != null)
        {
            this.out.put(node, out);
        }
        else
        {
            this.out.remove(node);
        }
    }
    public void caseStart(Start node)
    {
        defaultCase(node);
    }

    public void caseAGoal(AGoal node)
    {
        defaultCase(node);
    }

    public void caseAFuncCommand(AFuncCommand node)
    {
        defaultCase(node);
    }

    public void caseAStatementCommand(AStatementCommand node)
    {
        defaultCase(node);
    }

    public void caseAFunction(AFunction node)
    {
        defaultCase(node);
    }

    public void caseAArgument(AArgument node)
    {
        defaultCase(node);
    }

    public void caseAIdentifierValue(AIdentifierValue node)
    {
        defaultCase(node);
    }

    public void caseAIfStatement(AIfStatement node)
    {
        defaultCase(node);
    }

    public void caseAWhileStatement(AWhileStatement node)
    {
        defaultCase(node);
    }

    public void caseAForStatement(AForStatement node)
    {
        defaultCase(node);
    }

    public void caseAReturnStatement(AReturnStatement node)
    {
        defaultCase(node);
    }

    public void caseAPrintStatement(APrintStatement node)
    {
        defaultCase(node);
    }

    public void caseAAssertStatement(AAssertStatement node)
    {
        defaultCase(node);
    }

    public void caseAFuncCallStatement(AFuncCallStatement node)
    {
        defaultCase(node);
    }

    public void caseAAssignStatement(AAssignStatement node)
    {
        defaultCase(node);
    }

    public void caseAMinusAssignStatement(AMinusAssignStatement node)
    {
        defaultCase(node);
    }

    public void caseADivAssignStatement(ADivAssignStatement node)
    {
        defaultCase(node);
    }

    public void caseAAssignListStatement(AAssignListStatement node)
    {
        defaultCase(node);
    }

    public void caseASumExpression(ASumExpression node)
    {
        defaultCase(node);
    }

    public void caseAMinusExpression(AMinusExpression node)
    {
        defaultCase(node);
    }

    public void caseAMultExpression(AMultExpression node)
    {
        defaultCase(node);
    }

    public void caseADivExpression(ADivExpression node)
    {
        defaultCase(node);
    }

    public void caseAModuloExpression(AModuloExpression node)
    {
        defaultCase(node);
    }

    public void caseAPowExpression(APowExpression node)
    {
        defaultCase(node);
    }

    public void caseASubscriptionExpression(ASubscriptionExpression node)
    {
        defaultCase(node);
    }

    public void caseAFuncCallExpression(AFuncCallExpression node)
    {
        defaultCase(node);
    }

    public void caseAValueExpression(AValueExpression node)
    {
        defaultCase(node);
    }

    public void caseAIdentifierExpression(AIdentifierExpression node)
    {
        defaultCase(node);
    }

    public void caseAOpenExpression(AOpenExpression node)
    {
        defaultCase(node);
    }

    public void caseATypeExpression(ATypeExpression node)
    {
        defaultCase(node);
    }

    public void caseAMaxExpression(AMaxExpression node)
    {
        defaultCase(node);
    }

    public void caseAMinExpression(AMinExpression node)
    {
        defaultCase(node);
    }

    public void caseAParExpression(AParExpression node)
    {
        defaultCase(node);
    }

    public void caseAListDefExpression(AListDefExpression node)
    {
        defaultCase(node);
    }

    public void caseAAndComparison(AAndComparison node)
    {
        defaultCase(node);
    }

    public void caseAOrComparison(AOrComparison node)
    {
        defaultCase(node);
    }

    public void caseANotComparison(ANotComparison node)
    {
        defaultCase(node);
    }

    public void caseAGreatComparison(AGreatComparison node)
    {
        defaultCase(node);
    }

    public void caseALessComparison(ALessComparison node)
    {
        defaultCase(node);
    }

    public void caseALeqComparison(ALeqComparison node)
    {
        defaultCase(node);
    }

    public void caseAGeqComparison(AGeqComparison node)
    {
        defaultCase(node);
    }

    public void caseANeqComparison(ANeqComparison node)
    {
        defaultCase(node);
    }

    public void caseAEqComparison(AEqComparison node)
    {
        defaultCase(node);
    }

    public void caseATrueComparison(ATrueComparison node)
    {
        defaultCase(node);
    }

    public void caseAFalseComparison(AFalseComparison node)
    {
        defaultCase(node);
    }

    public void caseAFunctionCall(AFunctionCall node)
    {
        defaultCase(node);
    }

    public void caseAMethodValue(AMethodValue node)
    {
        defaultCase(node);
    }

    public void caseANumberValue(ANumberValue node)
    {
        defaultCase(node);
    }

    public void caseAStringValue(AStringValue node)
    {
        defaultCase(node);
    }

    public void caseANoneValue(ANoneValue node)
    {
        defaultCase(node);
    }

    public void caseTLineComment(TLineComment node)
    {
        defaultCase(node);
    }

    public void caseTTab(TTab node)
    {
        defaultCase(node);
    }

    public void caseTAssign(TAssign node)
    {
        defaultCase(node);
    }

    public void caseTMinusAssign(TMinusAssign node)
    {
        defaultCase(node);
    }

    public void caseTDivAssign(TDivAssign node)
    {
        defaultCase(node);
    }

    public void caseTExclam(TExclam node)
    {
        defaultCase(node);
    }

    public void caseTLPar(TLPar node)
    {
        defaultCase(node);
    }

    public void caseTRPar(TRPar node)
    {
        defaultCase(node);
    }

    public void caseTLBr(TLBr node)
    {
        defaultCase(node);
    }

    public void caseTRBr(TRBr node)
    {
        defaultCase(node);
    }

    public void caseTComma(TComma node)
    {
        defaultCase(node);
    }

    public void caseTQmark(TQmark node)
    {
        defaultCase(node);
    }

    public void caseTSemi(TSemi node)
    {
        defaultCase(node);
    }

    public void caseTDot(TDot node)
    {
        defaultCase(node);
    }

    public void caseTPlus(TPlus node)
    {
        defaultCase(node);
    }

    public void caseTMinus(TMinus node)
    {
        defaultCase(node);
    }

    public void caseTMult(TMult node)
    {
        defaultCase(node);
    }

    public void caseTDiv(TDiv node)
    {
        defaultCase(node);
    }

    public void caseTMode(TMode node)
    {
        defaultCase(node);
    }

    public void caseTDmult(TDmult node)
    {
        defaultCase(node);
    }

    public void caseTIf(TIf node)
    {
        defaultCase(node);
    }

    public void caseTIn(TIn node)
    {
        defaultCase(node);
    }

    public void caseTElif(TElif node)
    {
        defaultCase(node);
    }

    public void caseTElse(TElse node)
    {
        defaultCase(node);
    }

    public void caseTWhile(TWhile node)
    {
        defaultCase(node);
    }

    public void caseTFor(TFor node)
    {
        defaultCase(node);
    }

    public void caseTPrint(TPrint node)
    {
        defaultCase(node);
    }

    public void caseTReturn(TReturn node)
    {
        defaultCase(node);
    }

    public void caseTOpen(TOpen node)
    {
        defaultCase(node);
    }

    public void caseTType(TType node)
    {
        defaultCase(node);
    }

    public void caseTMax(TMax node)
    {
        defaultCase(node);
    }

    public void caseTMin(TMin node)
    {
        defaultCase(node);
    }

    public void caseTAssert(TAssert node)
    {
        defaultCase(node);
    }

    public void caseTDictt(TDictt node)
    {
        defaultCase(node);
    }

    public void caseTDef(TDef node)
    {
        defaultCase(node);
    }

    public void caseTNone(TNone node)
    {
        defaultCase(node);
    }

    public void caseTLeq(TLeq node)
    {
        defaultCase(node);
    }

    public void caseTLess(TLess node)
    {
        defaultCase(node);
    }

    public void caseTGeq(TGeq node)
    {
        defaultCase(node);
    }

    public void caseTGreat(TGreat node)
    {
        defaultCase(node);
    }

    public void caseTNeq(TNeq node)
    {
        defaultCase(node);
    }

    public void caseTEq(TEq node)
    {
        defaultCase(node);
    }

    public void caseTTrue(TTrue node)
    {
        defaultCase(node);
    }

    public void caseTFalse(TFalse node)
    {
        defaultCase(node);
    }

    public void caseTAnd(TAnd node)
    {
        defaultCase(node);
    }

    public void caseTOr(TOr node)
    {
        defaultCase(node);
    }

    public void caseTNot(TNot node)
    {
        defaultCase(node);
    }

    public void caseTColon(TColon node)
    {
        defaultCase(node);
    }

    public void caseTQuote(TQuote node)
    {
        defaultCase(node);
    }

    public void caseTBlank(TBlank node)
    {
        defaultCase(node);
    }

    public void caseTIntegerLiteral(TIntegerLiteral node)
    {
        defaultCase(node);
    }

    public void caseTIdentifier(TIdentifier node)
    {
        defaultCase(node);
    }

    public void caseTStringLiteral(TStringLiteral node)
    {
        defaultCase(node);
    }

    public void caseEOF(EOF node)
    {
        defaultCase(node);
    }

    public void defaultCase(Node node)
    {
    }
}
