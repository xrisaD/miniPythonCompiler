/* This file was generated by SableCC (http://www.sablecc.org/). */

package minipython.node;

import java.util.*;
import minipython.analysis.*;

public final class ANegatedNegated extends PNegated
{
    private TNot _not_;
    private PClause _clause_;

    public ANegatedNegated()
    {
    }

    public ANegatedNegated(
        TNot _not_,
        PClause _clause_)
    {
        setNot(_not_);

        setClause(_clause_);

    }
    public Object clone()
    {
        return new ANegatedNegated(
            (TNot) cloneNode(_not_),
            (PClause) cloneNode(_clause_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseANegatedNegated(this);
    }

    public TNot getNot()
    {
        return _not_;
    }

    public void setNot(TNot node)
    {
        if(_not_ != null)
        {
            _not_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _not_ = node;
    }

    public PClause getClause()
    {
        return _clause_;
    }

    public void setClause(PClause node)
    {
        if(_clause_ != null)
        {
            _clause_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _clause_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_not_)
            + toString(_clause_);
    }

    void removeChild(Node child)
    {
        if(_not_ == child)
        {
            _not_ = null;
            return;
        }

        if(_clause_ == child)
        {
            _clause_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_not_ == oldChild)
        {
            setNot((TNot) newChild);
            return;
        }

        if(_clause_ == oldChild)
        {
            setClause((PClause) newChild);
            return;
        }

    }
}
