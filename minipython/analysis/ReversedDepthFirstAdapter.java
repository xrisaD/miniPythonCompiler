/* This file was generated by SableCC (http://www.sablecc.org/). */

package minipython.analysis;

import minipython.node.*;

public class ReversedDepthFirstAdapter extends AnalysisAdapter
{
    public void inStart(Start node)
    {
        defaultIn(node);
    }

    public void outStart(Start node)
    {
        defaultOut(node);
    }

    public void defaultIn(Node node)
    {
    }

    public void defaultOut(Node node)
    {
    }

    public void caseStart(Start node)
    {
        inStart(node);
        node.getEOF().apply(this);
        node.getPGoal().apply(this);
        outStart(node);
    }

    public void inAGoal(AGoal node)
    {
        defaultIn(node);
    }

    public void outAGoal(AGoal node)
    {
        defaultOut(node);
    }

    public void caseAGoal(AGoal node)
    {
        inAGoal(node);
        {
            Object temp[] = node.getCommand().toArray();
            for(int i = temp.length - 1; i >= 0; i--)
            {
                ((PCommand) temp[i]).apply(this);
            }
        }
        outAGoal(node);
    }

    public void inAFuncCommand(AFuncCommand node)
    {
        defaultIn(node);
    }

    public void outAFuncCommand(AFuncCommand node)
    {
        defaultOut(node);
    }

    public void caseAFuncCommand(AFuncCommand node)
    {
        inAFuncCommand(node);
        if(node.getFunction() != null)
        {
            node.getFunction().apply(this);
        }
        outAFuncCommand(node);
    }

    public void inAStatementCommand(AStatementCommand node)
    {
        defaultIn(node);
    }

    public void outAStatementCommand(AStatementCommand node)
    {
        defaultOut(node);
    }

    public void caseAStatementCommand(AStatementCommand node)
    {
        inAStatementCommand(node);
        if(node.getStatement() != null)
        {
            node.getStatement().apply(this);
        }
        outAStatementCommand(node);
    }

    public void inAFunction(AFunction node)
    {
        defaultIn(node);
    }

    public void outAFunction(AFunction node)
    {
        defaultOut(node);
    }

    public void caseAFunction(AFunction node)
    {
        inAFunction(node);
        if(node.getStatement() != null)
        {
            node.getStatement().apply(this);
        }
        if(node.getColon() != null)
        {
            node.getColon().apply(this);
        }
        if(node.getRPar() != null)
        {
            node.getRPar().apply(this);
        }
        if(node.getArgument() != null)
        {
            node.getArgument().apply(this);
        }
        if(node.getLPar() != null)
        {
            node.getLPar().apply(this);
        }
        if(node.getIdentifier() != null)
        {
            node.getIdentifier().apply(this);
        }
        if(node.getDef() != null)
        {
            node.getDef().apply(this);
        }
        outAFunction(node);
    }

    public void inAArgument(AArgument node)
    {
        defaultIn(node);
    }

    public void outAArgument(AArgument node)
    {
        defaultOut(node);
    }

    public void caseAArgument(AArgument node)
    {
        inAArgument(node);
        {
            Object temp[] = node.getCommaIdAssignValue().toArray();
            for(int i = temp.length - 1; i >= 0; i--)
            {
                ((PCommaIdAssignValue) temp[i]).apply(this);
            }
        }
        if(node.getAssignValue() != null)
        {
            node.getAssignValue().apply(this);
        }
        if(node.getIdentifier() != null)
        {
            node.getIdentifier().apply(this);
        }
        outAArgument(node);
    }

    public void inACommaIdAssignValue(ACommaIdAssignValue node)
    {
        defaultIn(node);
    }

    public void outACommaIdAssignValue(ACommaIdAssignValue node)
    {
        defaultOut(node);
    }

    public void caseACommaIdAssignValue(ACommaIdAssignValue node)
    {
        inACommaIdAssignValue(node);
        if(node.getAssignValue() != null)
        {
            node.getAssignValue().apply(this);
        }
        if(node.getIdentifier() != null)
        {
            node.getIdentifier().apply(this);
        }
        if(node.getComma() != null)
        {
            node.getComma().apply(this);
        }
        outACommaIdAssignValue(node);
    }

    public void inAAssignValue(AAssignValue node)
    {
        defaultIn(node);
    }

    public void outAAssignValue(AAssignValue node)
    {
        defaultOut(node);
    }

    public void caseAAssignValue(AAssignValue node)
    {
        inAAssignValue(node);
        if(node.getValue() != null)
        {
            node.getValue().apply(this);
        }
        if(node.getAssign() != null)
        {
            node.getAssign().apply(this);
        }
        outAAssignValue(node);
    }

    public void inAIfStatement(AIfStatement node)
    {
        defaultIn(node);
    }

    public void outAIfStatement(AIfStatement node)
    {
        defaultOut(node);
    }

    public void caseAIfStatement(AIfStatement node)
    {
        inAIfStatement(node);
        if(node.getStatement() != null)
        {
            node.getStatement().apply(this);
        }
        if(node.getColon() != null)
        {
            node.getColon().apply(this);
        }
        if(node.getComparison() != null)
        {
            node.getComparison().apply(this);
        }
        if(node.getIf() != null)
        {
            node.getIf().apply(this);
        }
        {
            Object temp[] = node.getTab().toArray();
            for(int i = temp.length - 1; i >= 0; i--)
            {
                ((TTab) temp[i]).apply(this);
            }
        }
        outAIfStatement(node);
    }

    public void inAWhileStatement(AWhileStatement node)
    {
        defaultIn(node);
    }

    public void outAWhileStatement(AWhileStatement node)
    {
        defaultOut(node);
    }

    public void caseAWhileStatement(AWhileStatement node)
    {
        inAWhileStatement(node);
        if(node.getStatement() != null)
        {
            node.getStatement().apply(this);
        }
        if(node.getColon() != null)
        {
            node.getColon().apply(this);
        }
        if(node.getComparison() != null)
        {
            node.getComparison().apply(this);
        }
        if(node.getWhile() != null)
        {
            node.getWhile().apply(this);
        }
        {
            Object temp[] = node.getTab().toArray();
            for(int i = temp.length - 1; i >= 0; i--)
            {
                ((TTab) temp[i]).apply(this);
            }
        }
        outAWhileStatement(node);
    }

    public void inAForStatement(AForStatement node)
    {
        defaultIn(node);
    }

    public void outAForStatement(AForStatement node)
    {
        defaultOut(node);
    }

    public void caseAForStatement(AForStatement node)
    {
        inAForStatement(node);
        if(node.getStatement() != null)
        {
            node.getStatement().apply(this);
        }
        if(node.getColon() != null)
        {
            node.getColon().apply(this);
        }
        if(node.getId2() != null)
        {
            node.getId2().apply(this);
        }
        if(node.getIn() != null)
        {
            node.getIn().apply(this);
        }
        if(node.getId1() != null)
        {
            node.getId1().apply(this);
        }
        if(node.getFor() != null)
        {
            node.getFor().apply(this);
        }
        {
            Object temp[] = node.getTab().toArray();
            for(int i = temp.length - 1; i >= 0; i--)
            {
                ((TTab) temp[i]).apply(this);
            }
        }
        outAForStatement(node);
    }

    public void inAReturnStatement(AReturnStatement node)
    {
        defaultIn(node);
    }

    public void outAReturnStatement(AReturnStatement node)
    {
        defaultOut(node);
    }

    public void caseAReturnStatement(AReturnStatement node)
    {
        inAReturnStatement(node);
        if(node.getExpression() != null)
        {
            node.getExpression().apply(this);
        }
        if(node.getReturn() != null)
        {
            node.getReturn().apply(this);
        }
        {
            Object temp[] = node.getTab().toArray();
            for(int i = temp.length - 1; i >= 0; i--)
            {
                ((TTab) temp[i]).apply(this);
            }
        }
        outAReturnStatement(node);
    }

    public void inAPrintStatement(APrintStatement node)
    {
        defaultIn(node);
    }

    public void outAPrintStatement(APrintStatement node)
    {
        defaultOut(node);
    }

    public void caseAPrintStatement(APrintStatement node)
    {
        inAPrintStatement(node);
        {
            Object temp[] = node.getCommaExpression().toArray();
            for(int i = temp.length - 1; i >= 0; i--)
            {
                ((PCommaExpression) temp[i]).apply(this);
            }
        }
        if(node.getExpression() != null)
        {
            node.getExpression().apply(this);
        }
        if(node.getPrint() != null)
        {
            node.getPrint().apply(this);
        }
        {
            Object temp[] = node.getTab().toArray();
            for(int i = temp.length - 1; i >= 0; i--)
            {
                ((TTab) temp[i]).apply(this);
            }
        }
        outAPrintStatement(node);
    }

    public void inAAssignmentStatement(AAssignmentStatement node)
    {
        defaultIn(node);
    }

    public void outAAssignmentStatement(AAssignmentStatement node)
    {
        defaultOut(node);
    }

    public void caseAAssignmentStatement(AAssignmentStatement node)
    {
        inAAssignmentStatement(node);
        if(node.getAssignmentStatement() != null)
        {
            node.getAssignmentStatement().apply(this);
        }
        {
            Object temp[] = node.getTab().toArray();
            for(int i = temp.length - 1; i >= 0; i--)
            {
                ((TTab) temp[i]).apply(this);
            }
        }
        outAAssignmentStatement(node);
    }

    public void inAAssertStatement(AAssertStatement node)
    {
        defaultIn(node);
    }

    public void outAAssertStatement(AAssertStatement node)
    {
        defaultOut(node);
    }

    public void caseAAssertStatement(AAssertStatement node)
    {
        inAAssertStatement(node);
        if(node.getCommaExpression() != null)
        {
            node.getCommaExpression().apply(this);
        }
        if(node.getExpression() != null)
        {
            node.getExpression().apply(this);
        }
        if(node.getAssert() != null)
        {
            node.getAssert().apply(this);
        }
        {
            Object temp[] = node.getTab().toArray();
            for(int i = temp.length - 1; i >= 0; i--)
            {
                ((TTab) temp[i]).apply(this);
            }
        }
        outAAssertStatement(node);
    }

    public void inAFuncCallStatement(AFuncCallStatement node)
    {
        defaultIn(node);
    }

    public void outAFuncCallStatement(AFuncCallStatement node)
    {
        defaultOut(node);
    }

    public void caseAFuncCallStatement(AFuncCallStatement node)
    {
        inAFuncCallStatement(node);
        if(node.getFunctionCall() != null)
        {
            node.getFunctionCall().apply(this);
        }
        outAFuncCallStatement(node);
    }

    public void inAAssignAssignmentStatement(AAssignAssignmentStatement node)
    {
        defaultIn(node);
    }

    public void outAAssignAssignmentStatement(AAssignAssignmentStatement node)
    {
        defaultOut(node);
    }

    public void caseAAssignAssignmentStatement(AAssignAssignmentStatement node)
    {
        inAAssignAssignmentStatement(node);
        if(node.getExpression() != null)
        {
            node.getExpression().apply(this);
        }
        if(node.getAssign() != null)
        {
            node.getAssign().apply(this);
        }
        if(node.getIdentifier() != null)
        {
            node.getIdentifier().apply(this);
        }
        outAAssignAssignmentStatement(node);
    }

    public void inAMinusAssignAssignmentStatement(AMinusAssignAssignmentStatement node)
    {
        defaultIn(node);
    }

    public void outAMinusAssignAssignmentStatement(AMinusAssignAssignmentStatement node)
    {
        defaultOut(node);
    }

    public void caseAMinusAssignAssignmentStatement(AMinusAssignAssignmentStatement node)
    {
        inAMinusAssignAssignmentStatement(node);
        if(node.getExpression() != null)
        {
            node.getExpression().apply(this);
        }
        if(node.getMinusAssign() != null)
        {
            node.getMinusAssign().apply(this);
        }
        if(node.getIdentifier() != null)
        {
            node.getIdentifier().apply(this);
        }
        outAMinusAssignAssignmentStatement(node);
    }

    public void inADivAssignAssignmentStatement(ADivAssignAssignmentStatement node)
    {
        defaultIn(node);
    }

    public void outADivAssignAssignmentStatement(ADivAssignAssignmentStatement node)
    {
        defaultOut(node);
    }

    public void caseADivAssignAssignmentStatement(ADivAssignAssignmentStatement node)
    {
        inADivAssignAssignmentStatement(node);
        if(node.getExpression() != null)
        {
            node.getExpression().apply(this);
        }
        if(node.getDivAssign() != null)
        {
            node.getDivAssign().apply(this);
        }
        if(node.getIdentifier() != null)
        {
            node.getIdentifier().apply(this);
        }
        outADivAssignAssignmentStatement(node);
    }

    public void inAAssignListAssignmentStatement(AAssignListAssignmentStatement node)
    {
        defaultIn(node);
    }

    public void outAAssignListAssignmentStatement(AAssignListAssignmentStatement node)
    {
        defaultOut(node);
    }

    public void caseAAssignListAssignmentStatement(AAssignListAssignmentStatement node)
    {
        inAAssignListAssignmentStatement(node);
        if(node.getEx2() != null)
        {
            node.getEx2().apply(this);
        }
        if(node.getAssign() != null)
        {
            node.getAssign().apply(this);
        }
        if(node.getRBr() != null)
        {
            node.getRBr().apply(this);
        }
        if(node.getEx1() != null)
        {
            node.getEx1().apply(this);
        }
        if(node.getLBr() != null)
        {
            node.getLBr().apply(this);
        }
        if(node.getIdentifier() != null)
        {
            node.getIdentifier().apply(this);
        }
        outAAssignListAssignmentStatement(node);
    }

    public void inAExpression(AExpression node)
    {
        defaultIn(node);
    }

    public void outAExpression(AExpression node)
    {
        defaultOut(node);
    }

    public void caseAExpression(AExpression node)
    {
        inAExpression(node);
        if(node.getTrue() != null)
        {
            node.getTrue().apply(this);
        }
        outAExpression(node);
    }

    public void inAComparison(AComparison node)
    {
        defaultIn(node);
    }

    public void outAComparison(AComparison node)
    {
        defaultOut(node);
    }

    public void caseAComparison(AComparison node)
    {
        inAComparison(node);
        if(node.getTrue() != null)
        {
            node.getTrue().apply(this);
        }
        outAComparison(node);
    }

    public void inAFunCallValue(AFunCallValue node)
    {
        defaultIn(node);
    }

    public void outAFunCallValue(AFunCallValue node)
    {
        defaultOut(node);
    }

    public void caseAFunCallValue(AFunCallValue node)
    {
        inAFunCallValue(node);
        if(node.getFunctionCall() != null)
        {
            node.getFunctionCall().apply(this);
        }
        if(node.getDot() != null)
        {
            node.getDot().apply(this);
        }
        if(node.getIdentifier() != null)
        {
            node.getIdentifier().apply(this);
        }
        outAFunCallValue(node);
    }

    public void inANumValue(ANumValue node)
    {
        defaultIn(node);
    }

    public void outANumValue(ANumValue node)
    {
        defaultOut(node);
    }

    public void caseANumValue(ANumValue node)
    {
        inANumValue(node);
        if(node.getNumber() != null)
        {
            node.getNumber().apply(this);
        }
        outANumValue(node);
    }

    public void inAStringValue(AStringValue node)
    {
        defaultIn(node);
    }

    public void outAStringValue(AStringValue node)
    {
        defaultOut(node);
    }

    public void caseAStringValue(AStringValue node)
    {
        inAStringValue(node);
        if(node.getStringLiteral() != null)
        {
            node.getStringLiteral().apply(this);
        }
        outAStringValue(node);
    }

    public void inANumber(ANumber node)
    {
        defaultIn(node);
    }

    public void outANumber(ANumber node)
    {
        defaultOut(node);
    }

    public void caseANumber(ANumber node)
    {
        inANumber(node);
        if(node.getIntegerLiteral() != null)
        {
            node.getIntegerLiteral().apply(this);
        }
        outANumber(node);
    }

    public void inAFunctionCall(AFunctionCall node)
    {
        defaultIn(node);
    }

    public void outAFunctionCall(AFunctionCall node)
    {
        defaultOut(node);
    }

    public void caseAFunctionCall(AFunctionCall node)
    {
        inAFunctionCall(node);
        if(node.getRPar() != null)
        {
            node.getRPar().apply(this);
        }
        if(node.getArglist() != null)
        {
            node.getArglist().apply(this);
        }
        if(node.getLPar() != null)
        {
            node.getLPar().apply(this);
        }
        if(node.getIdentifier() != null)
        {
            node.getIdentifier().apply(this);
        }
        outAFunctionCall(node);
    }

    public void inAArglist(AArglist node)
    {
        defaultIn(node);
    }

    public void outAArglist(AArglist node)
    {
        defaultOut(node);
    }

    public void caseAArglist(AArglist node)
    {
        inAArglist(node);
        {
            Object temp[] = node.getCommaExpression().toArray();
            for(int i = temp.length - 1; i >= 0; i--)
            {
                ((PCommaExpression) temp[i]).apply(this);
            }
        }
        if(node.getExpression() != null)
        {
            node.getExpression().apply(this);
        }
        outAArglist(node);
    }

    public void inACommaExpression(ACommaExpression node)
    {
        defaultIn(node);
    }

    public void outACommaExpression(ACommaExpression node)
    {
        defaultOut(node);
    }

    public void caseACommaExpression(ACommaExpression node)
    {
        inACommaExpression(node);
        if(node.getExpression() != null)
        {
            node.getExpression().apply(this);
        }
        if(node.getComma() != null)
        {
            node.getComma().apply(this);
        }
        outACommaExpression(node);
    }
}
