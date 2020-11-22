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
        {
            Object temp[] = node.getTab().toArray();
            for(int i = temp.length - 1; i >= 0; i--)
            {
                ((TTab) temp[i]).apply(this);
            }
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
        if(node.getSum() != null)
        {
            node.getSum().apply(this);
        }
        outAExpression(node);
    }

    public void inASumSum(ASumSum node)
    {
        defaultIn(node);
    }

    public void outASumSum(ASumSum node)
    {
        defaultOut(node);
    }

    public void caseASumSum(ASumSum node)
    {
        inASumSum(node);
        if(node.getTerm() != null)
        {
            node.getTerm().apply(this);
        }
        if(node.getPlus() != null)
        {
            node.getPlus().apply(this);
        }
        if(node.getSum() != null)
        {
            node.getSum().apply(this);
        }
        outASumSum(node);
    }

    public void inAMinusSum(AMinusSum node)
    {
        defaultIn(node);
    }

    public void outAMinusSum(AMinusSum node)
    {
        defaultOut(node);
    }

    public void caseAMinusSum(AMinusSum node)
    {
        inAMinusSum(node);
        if(node.getTerm() != null)
        {
            node.getTerm().apply(this);
        }
        if(node.getMinus() != null)
        {
            node.getMinus().apply(this);
        }
        if(node.getSum() != null)
        {
            node.getSum().apply(this);
        }
        outAMinusSum(node);
    }

    public void inATermSum(ATermSum node)
    {
        defaultIn(node);
    }

    public void outATermSum(ATermSum node)
    {
        defaultOut(node);
    }

    public void caseATermSum(ATermSum node)
    {
        inATermSum(node);
        if(node.getTerm() != null)
        {
            node.getTerm().apply(this);
        }
        outATermSum(node);
    }

    public void inAMultTerm(AMultTerm node)
    {
        defaultIn(node);
    }

    public void outAMultTerm(AMultTerm node)
    {
        defaultOut(node);
    }

    public void caseAMultTerm(AMultTerm node)
    {
        inAMultTerm(node);
        if(node.getPower() != null)
        {
            node.getPower().apply(this);
        }
        if(node.getMult() != null)
        {
            node.getMult().apply(this);
        }
        if(node.getTerm() != null)
        {
            node.getTerm().apply(this);
        }
        outAMultTerm(node);
    }

    public void inADivTerm(ADivTerm node)
    {
        defaultIn(node);
    }

    public void outADivTerm(ADivTerm node)
    {
        defaultOut(node);
    }

    public void caseADivTerm(ADivTerm node)
    {
        inADivTerm(node);
        if(node.getPower() != null)
        {
            node.getPower().apply(this);
        }
        if(node.getDiv() != null)
        {
            node.getDiv().apply(this);
        }
        if(node.getTerm() != null)
        {
            node.getTerm().apply(this);
        }
        outADivTerm(node);
    }

    public void inAModuloTerm(AModuloTerm node)
    {
        defaultIn(node);
    }

    public void outAModuloTerm(AModuloTerm node)
    {
        defaultOut(node);
    }

    public void caseAModuloTerm(AModuloTerm node)
    {
        inAModuloTerm(node);
        if(node.getPower() != null)
        {
            node.getPower().apply(this);
        }
        if(node.getMode() != null)
        {
            node.getMode().apply(this);
        }
        if(node.getTerm() != null)
        {
            node.getTerm().apply(this);
        }
        outAModuloTerm(node);
    }

    public void inAPowerTerm(APowerTerm node)
    {
        defaultIn(node);
    }

    public void outAPowerTerm(APowerTerm node)
    {
        defaultOut(node);
    }

    public void caseAPowerTerm(APowerTerm node)
    {
        inAPowerTerm(node);
        if(node.getPower() != null)
        {
            node.getPower().apply(this);
        }
        outAPowerTerm(node);
    }

    public void inAExpPower(AExpPower node)
    {
        defaultIn(node);
    }

    public void outAExpPower(AExpPower node)
    {
        defaultOut(node);
    }

    public void caseAExpPower(AExpPower node)
    {
        inAExpPower(node);
        if(node.getSubscription() != null)
        {
            node.getSubscription().apply(this);
        }
        if(node.getDmult() != null)
        {
            node.getDmult().apply(this);
        }
        if(node.getPower() != null)
        {
            node.getPower().apply(this);
        }
        outAExpPower(node);
    }

    public void inASubscriptionPower(ASubscriptionPower node)
    {
        defaultIn(node);
    }

    public void outASubscriptionPower(ASubscriptionPower node)
    {
        defaultOut(node);
    }

    public void caseASubscriptionPower(ASubscriptionPower node)
    {
        inASubscriptionPower(node);
        if(node.getSubscription() != null)
        {
            node.getSubscription().apply(this);
        }
        outASubscriptionPower(node);
    }

    public void inASubscriptionSubscription(ASubscriptionSubscription node)
    {
        defaultIn(node);
    }

    public void outASubscriptionSubscription(ASubscriptionSubscription node)
    {
        defaultOut(node);
    }

    public void caseASubscriptionSubscription(ASubscriptionSubscription node)
    {
        inASubscriptionSubscription(node);
        if(node.getRBr() != null)
        {
            node.getRBr().apply(this);
        }
        if(node.getExpression() != null)
        {
            node.getExpression().apply(this);
        }
        if(node.getLBr() != null)
        {
            node.getLBr().apply(this);
        }
        if(node.getIdentifier() != null)
        {
            node.getIdentifier().apply(this);
        }
        outASubscriptionSubscription(node);
    }

    public void inAFuncSubscription(AFuncSubscription node)
    {
        defaultIn(node);
    }

    public void outAFuncSubscription(AFuncSubscription node)
    {
        defaultOut(node);
    }

    public void caseAFuncSubscription(AFuncSubscription node)
    {
        inAFuncSubscription(node);
        if(node.getFunc() != null)
        {
            node.getFunc().apply(this);
        }
        outAFuncSubscription(node);
    }

    public void inAOpenFunc(AOpenFunc node)
    {
        defaultIn(node);
    }

    public void outAOpenFunc(AOpenFunc node)
    {
        defaultOut(node);
    }

    public void caseAOpenFunc(AOpenFunc node)
    {
        inAOpenFunc(node);
        if(node.getRPar() != null)
        {
            node.getRPar().apply(this);
        }
        if(node.getRight() != null)
        {
            node.getRight().apply(this);
        }
        if(node.getComma() != null)
        {
            node.getComma().apply(this);
        }
        if(node.getLeft() != null)
        {
            node.getLeft().apply(this);
        }
        if(node.getLPar() != null)
        {
            node.getLPar().apply(this);
        }
        if(node.getOpen() != null)
        {
            node.getOpen().apply(this);
        }
        outAOpenFunc(node);
    }

    public void inATypeFunc(ATypeFunc node)
    {
        defaultIn(node);
    }

    public void outATypeFunc(ATypeFunc node)
    {
        defaultOut(node);
    }

    public void caseATypeFunc(ATypeFunc node)
    {
        inATypeFunc(node);
        if(node.getRPar() != null)
        {
            node.getRPar().apply(this);
        }
        if(node.getIdentifier() != null)
        {
            node.getIdentifier().apply(this);
        }
        if(node.getLPar() != null)
        {
            node.getLPar().apply(this);
        }
        if(node.getType() != null)
        {
            node.getType().apply(this);
        }
        outATypeFunc(node);
    }

    public void inAMaxFunc(AMaxFunc node)
    {
        defaultIn(node);
    }

    public void outAMaxFunc(AMaxFunc node)
    {
        defaultOut(node);
    }

    public void caseAMaxFunc(AMaxFunc node)
    {
        inAMaxFunc(node);
        if(node.getRPar() != null)
        {
            node.getRPar().apply(this);
        }
        {
            Object temp[] = node.getCommaValue().toArray();
            for(int i = temp.length - 1; i >= 0; i--)
            {
                ((PCommaValue) temp[i]).apply(this);
            }
        }
        if(node.getValue() != null)
        {
            node.getValue().apply(this);
        }
        if(node.getLPar() != null)
        {
            node.getLPar().apply(this);
        }
        if(node.getMax() != null)
        {
            node.getMax().apply(this);
        }
        outAMaxFunc(node);
    }

    public void inAMinFunc(AMinFunc node)
    {
        defaultIn(node);
    }

    public void outAMinFunc(AMinFunc node)
    {
        defaultOut(node);
    }

    public void caseAMinFunc(AMinFunc node)
    {
        inAMinFunc(node);
        if(node.getRPar() != null)
        {
            node.getRPar().apply(this);
        }
        {
            Object temp[] = node.getCommaValue().toArray();
            for(int i = temp.length - 1; i >= 0; i--)
            {
                ((PCommaValue) temp[i]).apply(this);
            }
        }
        if(node.getValue() != null)
        {
            node.getValue().apply(this);
        }
        if(node.getLPar() != null)
        {
            node.getLPar().apply(this);
        }
        if(node.getMin() != null)
        {
            node.getMin().apply(this);
        }
        outAMinFunc(node);
    }

    public void inAFuncFunc(AFuncFunc node)
    {
        defaultIn(node);
    }

    public void outAFuncFunc(AFuncFunc node)
    {
        defaultOut(node);
    }

    public void caseAFuncFunc(AFuncFunc node)
    {
        inAFuncFunc(node);
        if(node.getFunctionCall() != null)
        {
            node.getFunctionCall().apply(this);
        }
        outAFuncFunc(node);
    }

    public void inAParFunc(AParFunc node)
    {
        defaultIn(node);
    }

    public void outAParFunc(AParFunc node)
    {
        defaultOut(node);
    }

    public void caseAParFunc(AParFunc node)
    {
        inAParFunc(node);
        if(node.getPar() != null)
        {
            node.getPar().apply(this);
        }
        outAParFunc(node);
    }

    public void inACommaValue(ACommaValue node)
    {
        defaultIn(node);
    }

    public void outACommaValue(ACommaValue node)
    {
        defaultOut(node);
    }

    public void caseACommaValue(ACommaValue node)
    {
        inACommaValue(node);
        if(node.getValue() != null)
        {
            node.getValue().apply(this);
        }
        if(node.getComma() != null)
        {
            node.getComma().apply(this);
        }
        outACommaValue(node);
    }

    public void inAParPar(AParPar node)
    {
        defaultIn(node);
    }

    public void outAParPar(AParPar node)
    {
        defaultOut(node);
    }

    public void caseAParPar(AParPar node)
    {
        inAParPar(node);
        if(node.getRPar() != null)
        {
            node.getRPar().apply(this);
        }
        if(node.getExpression() != null)
        {
            node.getExpression().apply(this);
        }
        if(node.getLPar() != null)
        {
            node.getLPar().apply(this);
        }
        outAParPar(node);
    }

    public void inASomethingPar(ASomethingPar node)
    {
        defaultIn(node);
    }

    public void outASomethingPar(ASomethingPar node)
    {
        defaultOut(node);
    }

    public void caseASomethingPar(ASomethingPar node)
    {
        inASomethingPar(node);
        if(node.getSomething() != null)
        {
            node.getSomething().apply(this);
        }
        outASomethingPar(node);
    }

    public void inAValueSomething(AValueSomething node)
    {
        defaultIn(node);
    }

    public void outAValueSomething(AValueSomething node)
    {
        defaultOut(node);
    }

    public void caseAValueSomething(AValueSomething node)
    {
        inAValueSomething(node);
        if(node.getValue() != null)
        {
            node.getValue().apply(this);
        }
        outAValueSomething(node);
    }

    public void inAIdentifierSomething(AIdentifierSomething node)
    {
        defaultIn(node);
    }

    public void outAIdentifierSomething(AIdentifierSomething node)
    {
        defaultOut(node);
    }

    public void caseAIdentifierSomething(AIdentifierSomething node)
    {
        inAIdentifierSomething(node);
        if(node.getIdentifier() != null)
        {
            node.getIdentifier().apply(this);
        }
        outAIdentifierSomething(node);
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
        if(node.getDisjunction() != null)
        {
            node.getDisjunction().apply(this);
        }
        outAComparison(node);
    }

    public void inAOrDisjunction(AOrDisjunction node)
    {
        defaultIn(node);
    }

    public void outAOrDisjunction(AOrDisjunction node)
    {
        defaultOut(node);
    }

    public void caseAOrDisjunction(AOrDisjunction node)
    {
        inAOrDisjunction(node);
        if(node.getConjuction() != null)
        {
            node.getConjuction().apply(this);
        }
        if(node.getOr() != null)
        {
            node.getOr().apply(this);
        }
        if(node.getDisjunction() != null)
        {
            node.getDisjunction().apply(this);
        }
        outAOrDisjunction(node);
    }

    public void inAAndDisjunction(AAndDisjunction node)
    {
        defaultIn(node);
    }

    public void outAAndDisjunction(AAndDisjunction node)
    {
        defaultOut(node);
    }

    public void caseAAndDisjunction(AAndDisjunction node)
    {
        inAAndDisjunction(node);
        if(node.getConjuction() != null)
        {
            node.getConjuction().apply(this);
        }
        outAAndDisjunction(node);
    }

    public void inAAndConjuction(AAndConjuction node)
    {
        defaultIn(node);
    }

    public void outAAndConjuction(AAndConjuction node)
    {
        defaultOut(node);
    }

    public void caseAAndConjuction(AAndConjuction node)
    {
        inAAndConjuction(node);
        if(node.getNegated() != null)
        {
            node.getNegated().apply(this);
        }
        if(node.getAnd() != null)
        {
            node.getAnd().apply(this);
        }
        if(node.getConjuction() != null)
        {
            node.getConjuction().apply(this);
        }
        outAAndConjuction(node);
    }

    public void inANotConjuction(ANotConjuction node)
    {
        defaultIn(node);
    }

    public void outANotConjuction(ANotConjuction node)
    {
        defaultOut(node);
    }

    public void caseANotConjuction(ANotConjuction node)
    {
        inANotConjuction(node);
        if(node.getNegated() != null)
        {
            node.getNegated().apply(this);
        }
        outANotConjuction(node);
    }

    public void inANegatedNegated(ANegatedNegated node)
    {
        defaultIn(node);
    }

    public void outANegatedNegated(ANegatedNegated node)
    {
        defaultOut(node);
    }

    public void caseANegatedNegated(ANegatedNegated node)
    {
        inANegatedNegated(node);
        if(node.getClause() != null)
        {
            node.getClause().apply(this);
        }
        if(node.getNot() != null)
        {
            node.getNot().apply(this);
        }
        outANegatedNegated(node);
    }

    public void inAClauseNegated(AClauseNegated node)
    {
        defaultIn(node);
    }

    public void outAClauseNegated(AClauseNegated node)
    {
        defaultOut(node);
    }

    public void caseAClauseNegated(AClauseNegated node)
    {
        inAClauseNegated(node);
        if(node.getClause() != null)
        {
            node.getClause().apply(this);
        }
        outAClauseNegated(node);
    }

    public void inAGreatClause(AGreatClause node)
    {
        defaultIn(node);
    }

    public void outAGreatClause(AGreatClause node)
    {
        defaultOut(node);
    }

    public void caseAGreatClause(AGreatClause node)
    {
        inAGreatClause(node);
        if(node.getRhs() != null)
        {
            node.getRhs().apply(this);
        }
        if(node.getGreat() != null)
        {
            node.getGreat().apply(this);
        }
        if(node.getLhs() != null)
        {
            node.getLhs().apply(this);
        }
        outAGreatClause(node);
    }

    public void inALessClause(ALessClause node)
    {
        defaultIn(node);
    }

    public void outALessClause(ALessClause node)
    {
        defaultOut(node);
    }

    public void caseALessClause(ALessClause node)
    {
        inALessClause(node);
        if(node.getRhs() != null)
        {
            node.getRhs().apply(this);
        }
        if(node.getLess() != null)
        {
            node.getLess().apply(this);
        }
        if(node.getLhs() != null)
        {
            node.getLhs().apply(this);
        }
        outALessClause(node);
    }

    public void inALeqClause(ALeqClause node)
    {
        defaultIn(node);
    }

    public void outALeqClause(ALeqClause node)
    {
        defaultOut(node);
    }

    public void caseALeqClause(ALeqClause node)
    {
        inALeqClause(node);
        if(node.getRhs() != null)
        {
            node.getRhs().apply(this);
        }
        if(node.getLeq() != null)
        {
            node.getLeq().apply(this);
        }
        if(node.getLhs() != null)
        {
            node.getLhs().apply(this);
        }
        outALeqClause(node);
    }

    public void inAGeqClause(AGeqClause node)
    {
        defaultIn(node);
    }

    public void outAGeqClause(AGeqClause node)
    {
        defaultOut(node);
    }

    public void caseAGeqClause(AGeqClause node)
    {
        inAGeqClause(node);
        if(node.getRhs() != null)
        {
            node.getRhs().apply(this);
        }
        if(node.getGeq() != null)
        {
            node.getGeq().apply(this);
        }
        if(node.getLhs() != null)
        {
            node.getLhs().apply(this);
        }
        outAGeqClause(node);
    }

    public void inANeqClause(ANeqClause node)
    {
        defaultIn(node);
    }

    public void outANeqClause(ANeqClause node)
    {
        defaultOut(node);
    }

    public void caseANeqClause(ANeqClause node)
    {
        inANeqClause(node);
        if(node.getRhs() != null)
        {
            node.getRhs().apply(this);
        }
        if(node.getNeq() != null)
        {
            node.getNeq().apply(this);
        }
        if(node.getLhs() != null)
        {
            node.getLhs().apply(this);
        }
        outANeqClause(node);
    }

    public void inAEqClause(AEqClause node)
    {
        defaultIn(node);
    }

    public void outAEqClause(AEqClause node)
    {
        defaultOut(node);
    }

    public void caseAEqClause(AEqClause node)
    {
        inAEqClause(node);
        if(node.getRhs() != null)
        {
            node.getRhs().apply(this);
        }
        if(node.getEq() != null)
        {
            node.getEq().apply(this);
        }
        if(node.getLhs() != null)
        {
            node.getLhs().apply(this);
        }
        outAEqClause(node);
    }

    public void inALiteralClause(ALiteralClause node)
    {
        defaultIn(node);
    }

    public void outALiteralClause(ALiteralClause node)
    {
        defaultOut(node);
    }

    public void caseALiteralClause(ALiteralClause node)
    {
        inALiteralClause(node);
        if(node.getBooleanLiteral() != null)
        {
            node.getBooleanLiteral().apply(this);
        }
        outALiteralClause(node);
    }

    public void inATrueBooleanLiteral(ATrueBooleanLiteral node)
    {
        defaultIn(node);
    }

    public void outATrueBooleanLiteral(ATrueBooleanLiteral node)
    {
        defaultOut(node);
    }

    public void caseATrueBooleanLiteral(ATrueBooleanLiteral node)
    {
        inATrueBooleanLiteral(node);
        if(node.getTrue() != null)
        {
            node.getTrue().apply(this);
        }
        outATrueBooleanLiteral(node);
    }

    public void inAFalseBooleanLiteral(AFalseBooleanLiteral node)
    {
        defaultIn(node);
    }

    public void outAFalseBooleanLiteral(AFalseBooleanLiteral node)
    {
        defaultOut(node);
    }

    public void caseAFalseBooleanLiteral(AFalseBooleanLiteral node)
    {
        inAFalseBooleanLiteral(node);
        if(node.getFalse() != null)
        {
            node.getFalse().apply(this);
        }
        outAFalseBooleanLiteral(node);
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
