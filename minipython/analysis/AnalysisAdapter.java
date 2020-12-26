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

    public void caseACommaIdAssignValue(ACommaIdAssignValue node)
    {
        defaultCase(node);
    }

    public void caseAAssignValue(AAssignValue node)
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

    public void caseAAssignmentStatement(AAssignmentStatement node)
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

    public void caseAAssignAssignmentStatement(AAssignAssignmentStatement node)
    {
        defaultCase(node);
    }

    public void caseAMinusAssignAssignmentStatement(AMinusAssignAssignmentStatement node)
    {
        defaultCase(node);
    }

    public void caseADivAssignAssignmentStatement(ADivAssignAssignmentStatement node)
    {
        defaultCase(node);
    }

    public void caseAAssignListAssignmentStatement(AAssignListAssignmentStatement node)
    {
        defaultCase(node);
    }

    public void caseAExpression(AExpression node)
    {
        defaultCase(node);
    }

    public void caseASumSum(ASumSum node)
    {
        defaultCase(node);
    }

    public void caseAMinusSum(AMinusSum node)
    {
        defaultCase(node);
    }

    public void caseATermSum(ATermSum node)
    {
        defaultCase(node);
    }

    public void caseAMultTerm(AMultTerm node)
    {
        defaultCase(node);
    }

    public void caseADivTerm(ADivTerm node)
    {
        defaultCase(node);
    }

    public void caseAModuloTerm(AModuloTerm node)
    {
        defaultCase(node);
    }

    public void caseAPowerTerm(APowerTerm node)
    {
        defaultCase(node);
    }

    public void caseAExpPower(AExpPower node)
    {
        defaultCase(node);
    }

    public void caseASubscriptionPower(ASubscriptionPower node)
    {
        defaultCase(node);
    }

    public void caseASubscriptionSubscription(ASubscriptionSubscription node)
    {
        defaultCase(node);
    }

    public void caseAFuncSubscription(AFuncSubscription node)
    {
        defaultCase(node);
    }

    public void caseAOpenFunc(AOpenFunc node)
    {
        defaultCase(node);
    }

    public void caseATypeFunc(ATypeFunc node)
    {
        defaultCase(node);
    }

    public void caseAMaxFunc(AMaxFunc node)
    {
        defaultCase(node);
    }

    public void caseAMinFunc(AMinFunc node)
    {
        defaultCase(node);
    }

    public void caseAFuncFunc(AFuncFunc node)
    {
        defaultCase(node);
    }

    public void caseAParFunc(AParFunc node)
    {
        defaultCase(node);
    }

    public void caseAListDefFunc(AListDefFunc node)
    {
        defaultCase(node);
    }

    public void caseACommaValue(ACommaValue node)
    {
        defaultCase(node);
    }

    public void caseAParPar(AParPar node)
    {
        defaultCase(node);
    }

    public void caseASomethingPar(ASomethingPar node)
    {
        defaultCase(node);
    }

    public void caseAValueSomething(AValueSomething node)
    {
        defaultCase(node);
    }

    public void caseAIdentifierSomething(AIdentifierSomething node)
    {
        defaultCase(node);
    }

    public void caseAComparison(AComparison node)
    {
        defaultCase(node);
    }

    public void caseAOrDisjunction(AOrDisjunction node)
    {
        defaultCase(node);
    }

    public void caseAAndDisjunction(AAndDisjunction node)
    {
        defaultCase(node);
    }

    public void caseAAndConjuction(AAndConjuction node)
    {
        defaultCase(node);
    }

    public void caseANotConjuction(ANotConjuction node)
    {
        defaultCase(node);
    }

    public void caseANegatedNegated(ANegatedNegated node)
    {
        defaultCase(node);
    }

    public void caseAClauseNegated(AClauseNegated node)
    {
        defaultCase(node);
    }

    public void caseAGreatClause(AGreatClause node)
    {
        defaultCase(node);
    }

    public void caseALessClause(ALessClause node)
    {
        defaultCase(node);
    }

    public void caseALeqClause(ALeqClause node)
    {
        defaultCase(node);
    }

    public void caseAGeqClause(AGeqClause node)
    {
        defaultCase(node);
    }

    public void caseANeqClause(ANeqClause node)
    {
        defaultCase(node);
    }

    public void caseAEqClause(AEqClause node)
    {
        defaultCase(node);
    }

    public void caseALiteralClause(ALiteralClause node)
    {
        defaultCase(node);
    }

    public void caseATrueBooleanLiteral(ATrueBooleanLiteral node)
    {
        defaultCase(node);
    }

    public void caseAFalseBooleanLiteral(AFalseBooleanLiteral node)
    {
        defaultCase(node);
    }

    public void caseAFunCallValue(AFunCallValue node)
    {
        defaultCase(node);
    }

    public void caseANumValue(ANumValue node)
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

    public void caseANumber(ANumber node)
    {
        defaultCase(node);
    }

    public void caseAFunctionCall(AFunctionCall node)
    {
        defaultCase(node);
    }

    public void caseAArglist(AArglist node)
    {
        defaultCase(node);
    }

    public void caseACommaExpression(ACommaExpression node)
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
