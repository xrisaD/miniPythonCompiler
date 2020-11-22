/* This file was generated by SableCC (http://www.sablecc.org/). */

package minipython.node;

import java.util.*;
import minipython.analysis.*;

public final class ANotConjuction extends PConjuction
{
    private PNegated _negated_;

    public ANotConjuction()
    {
    }

    public ANotConjuction(
        PNegated _negated_)
    {
        setNegated(_negated_);

    }
    public Object clone()
    {
        return new ANotConjuction(
            (PNegated) cloneNode(_negated_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseANotConjuction(this);
    }

    public PNegated getNegated()
    {
        return _negated_;
    }

    public void setNegated(PNegated node)
    {
        if(_negated_ != null)
        {
            _negated_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _negated_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_negated_);
    }

    void removeChild(Node child)
    {
        if(_negated_ == child)
        {
            _negated_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_negated_ == oldChild)
        {
            setNegated((PNegated) newChild);
            return;
        }

    }
}
