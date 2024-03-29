/* This file was generated by SableCC (http://www.sablecc.org/). */

package minipython.node;

import java.util.*;
import minipython.analysis.*;

public final class AOpenExpression extends PExpression
{
    private PExpression _e1_;
    private PExpression _e2_;

    public AOpenExpression()
    {
    }

    public AOpenExpression(
        PExpression _e1_,
        PExpression _e2_)
    {
        setE1(_e1_);

        setE2(_e2_);

    }
    public Object clone()
    {
        return new AOpenExpression(
            (PExpression) cloneNode(_e1_),
            (PExpression) cloneNode(_e2_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAOpenExpression(this);
    }

    public PExpression getE1()
    {
        return _e1_;
    }

    public void setE1(PExpression node)
    {
        if(_e1_ != null)
        {
            _e1_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _e1_ = node;
    }

    public PExpression getE2()
    {
        return _e2_;
    }

    public void setE2(PExpression node)
    {
        if(_e2_ != null)
        {
            _e2_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _e2_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_e1_)
            + toString(_e2_);
    }

    void removeChild(Node child)
    {
        if(_e1_ == child)
        {
            _e1_ = null;
            return;
        }

        if(_e2_ == child)
        {
            _e2_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_e1_ == oldChild)
        {
            setE1((PExpression) newChild);
            return;
        }

        if(_e2_ == oldChild)
        {
            setE2((PExpression) newChild);
            return;
        }

    }
}
