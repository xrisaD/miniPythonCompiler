/* This file was generated by SableCC (http://www.sablecc.org/). */

package minipython.node;

import java.util.*;
import minipython.analysis.*;

public final class ASumSum extends PSum
{
    private PSum _sum_;
    private TPlus _plus_;
    private PTerm _term_;

    public ASumSum()
    {
    }

    public ASumSum(
        PSum _sum_,
        TPlus _plus_,
        PTerm _term_)
    {
        setSum(_sum_);

        setPlus(_plus_);

        setTerm(_term_);

    }
    public Object clone()
    {
        return new ASumSum(
            (PSum) cloneNode(_sum_),
            (TPlus) cloneNode(_plus_),
            (PTerm) cloneNode(_term_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseASumSum(this);
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

    public TPlus getPlus()
    {
        return _plus_;
    }

    public void setPlus(TPlus node)
    {
        if(_plus_ != null)
        {
            _plus_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _plus_ = node;
    }

    public PTerm getTerm()
    {
        return _term_;
    }

    public void setTerm(PTerm node)
    {
        if(_term_ != null)
        {
            _term_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _term_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_sum_)
            + toString(_plus_)
            + toString(_term_);
    }

    void removeChild(Node child)
    {
        if(_sum_ == child)
        {
            _sum_ = null;
            return;
        }

        if(_plus_ == child)
        {
            _plus_ = null;
            return;
        }

        if(_term_ == child)
        {
            _term_ = null;
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

        if(_plus_ == oldChild)
        {
            setPlus((TPlus) newChild);
            return;
        }

        if(_term_ == oldChild)
        {
            setTerm((PTerm) newChild);
            return;
        }

    }
}
