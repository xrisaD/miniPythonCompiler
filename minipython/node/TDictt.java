/* This file was generated by SableCC (http://www.sablecc.org/). */

package minipython.node;

import minipython.analysis.*;

public final class TDictt extends Token
{
    public TDictt()
    {
        super.setText("dict");
    }

    public TDictt(int line, int pos)
    {
        super.setText("dict");
        setLine(line);
        setPos(pos);
    }

    public Object clone()
    {
      return new TDictt(getLine(), getPos());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTDictt(this);
    }

    public void setText(String text)
    {
        throw new RuntimeException("Cannot change TDictt text.");
    }
}