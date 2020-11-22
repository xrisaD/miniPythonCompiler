/* This file was generated by SableCC (http://www.sablecc.org/). */

package minipython.node;

import java.util.*;
import minipython.analysis.*;

public final class ASumExpression extends PExpression
{
    private PSum _sum_;

    public ASumExpression()
    {
    }

    public ASumExpression(
        PSum _sum_)
    {
        setSum(_sum_);

    }
    public Object clone()
    {
        return new ASumExpression(
            (PSum) cloneNode(_sum_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseASumExpression(this);
    }

    public PSum getSum()
    {
        return _sum_;
    }

    public void setSum(PSum node)
    {
        if(_sum_ != null)
        {
            _sum_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _sum_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_sum_);
    }

    void removeChild(Node child)
    {
        if(_sum_ == child)
        {
            _sum_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_sum_ == oldChild)
        {
            setSum((PSum) newChild);
            return;
        }

    }
}
