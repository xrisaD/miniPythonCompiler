/* This file was generated by SableCC (http://www.sablecc.org/). */

package minipython.parser;

import minipython.node.*;
import minipython.analysis.*;

class TokenIndex extends AnalysisAdapter
{
    int index;

    public void caseTTab(TTab node)
    {
        index = 0;
    }

    public void caseTAssign(TAssign node)
    {
        index = 1;
    }

    public void caseTMinusAssign(TMinusAssign node)
    {
        index = 2;
    }

    public void caseTDivAssign(TDivAssign node)
    {
        index = 3;
    }

    public void caseTExclam(TExclam node)
    {
        index = 4;
    }

    public void caseTLPar(TLPar node)
    {
        index = 5;
    }

    public void caseTRPar(TRPar node)
    {
        index = 6;
    }

    public void caseTLBr(TLBr node)
    {
        index = 7;
    }

    public void caseTRBr(TRBr node)
    {
        index = 8;
    }

    public void caseTComma(TComma node)
    {
        index = 9;
    }

    public void caseTQmark(TQmark node)
    {
        index = 10;
    }

    public void caseTSemi(TSemi node)
    {
        index = 11;
    }

    public void caseTDot(TDot node)
    {
        index = 12;
    }

    public void caseTPlus(TPlus node)
    {
        index = 13;
    }

    public void caseTMinus(TMinus node)
    {
        index = 14;
    }

    public void caseTMult(TMult node)
    {
        index = 15;
    }

    public void caseTDiv(TDiv node)
    {
        index = 16;
    }

    public void caseTMode(TMode node)
    {
        index = 17;
    }

    public void caseTDmult(TDmult node)
    {
        index = 18;
    }

    public void caseTIf(TIf node)
    {
        index = 19;
    }

    public void caseTIn(TIn node)
    {
        index = 20;
    }

    public void caseTElif(TElif node)
    {
        index = 21;
    }

    public void caseTElse(TElse node)
    {
        index = 22;
    }

    public void caseTWhile(TWhile node)
    {
        index = 23;
    }

    public void caseTFor(TFor node)
    {
        index = 24;
    }

    public void caseTPrint(TPrint node)
    {
        index = 25;
    }

    public void caseTReturn(TReturn node)
    {
        index = 26;
    }

    public void caseTOpen(TOpen node)
    {
        index = 27;
    }

    public void caseTType(TType node)
    {
        index = 28;
    }

    public void caseTMax(TMax node)
    {
        index = 29;
    }

    public void caseTMin(TMin node)
    {
        index = 30;
    }

    public void caseTAssert(TAssert node)
    {
        index = 31;
    }

    public void caseTDictt(TDictt node)
    {
        index = 32;
    }

    public void caseTDef(TDef node)
    {
        index = 33;
    }

    public void caseTNone(TNone node)
    {
        index = 34;
    }

    public void caseTLeq(TLeq node)
    {
        index = 35;
    }

    public void caseTLess(TLess node)
    {
        index = 36;
    }

    public void caseTGeq(TGeq node)
    {
        index = 37;
    }

    public void caseTGreat(TGreat node)
    {
        index = 38;
    }

    public void caseTNeq(TNeq node)
    {
        index = 39;
    }

    public void caseTEq(TEq node)
    {
        index = 40;
    }

    public void caseTTrue(TTrue node)
    {
        index = 41;
    }

    public void caseTFalse(TFalse node)
    {
        index = 42;
    }

    public void caseTAnd(TAnd node)
    {
        index = 43;
    }

    public void caseTOr(TOr node)
    {
        index = 44;
    }

    public void caseTColon(TColon node)
    {
        index = 45;
    }

    public void caseTQuote(TQuote node)
    {
        index = 46;
    }

    public void caseTIntegerLiteral(TIntegerLiteral node)
    {
        index = 47;
    }

    public void caseTIdentifier(TIdentifier node)
    {
        index = 48;
    }

    public void caseTStringLiteral(TStringLiteral node)
    {
        index = 49;
    }

    public void caseEOF(EOF node)
    {
        index = 50;
    }
}
