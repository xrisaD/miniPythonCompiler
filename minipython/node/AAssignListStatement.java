/* This file was generated by SableCC (http://www.sablecc.org/). */

package minipython.node;

import java.util.*;
import minipython.analysis.*;

public final class AAssignListStatement extends PStatement
{
    private PId _id_;
    private PExpression _ex1_;
    private PExpression _ex2_;

    public AAssignListStatement()
    {
    }

    public AAssignListStatement(
        PId _id_,
        PExpression _ex1_,
        PExpression _ex2_)
    {
        setId(_id_);

        setEx1(_ex1_);

        setEx2(_ex2_);

    }
    public Object clone()
    {
        return new AAssignListStatement(
            (PId) cloneNode(_id_),
            (PExpression) cloneNode(_ex1_),
            (PExpression) cloneNode(_ex2_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAAssignListStatement(this);
    }

    public PId getId()
    {
        return _id_;
    }

    public void setId(PId node)
    {
        if(_id_ != null)
        {
            _id_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _id_ = node;
    }

    public PExpression getEx1()
    {
        return _ex1_;
    }

    public void setEx1(PExpression node)
    {
        if(_ex1_ != null)
        {
            _ex1_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _ex1_ = node;
    }

    public PExpression getEx2()
    {
        return _ex2_;
    }

    public void setEx2(PExpression node)
    {
        if(_ex2_ != null)
        {
            _ex2_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _ex2_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_id_)
            + toString(_ex1_)
            + toString(_ex2_);
    }

    void removeChild(Node child)
    {
        if(_id_ == child)
        {
            _id_ = null;
            return;
        }

        if(_ex1_ == child)
        {
            _ex1_ = null;
            return;
        }

        if(_ex2_ == child)
        {
            _ex2_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_id_ == oldChild)
        {
            setId((PId) newChild);
            return;
        }

        if(_ex1_ == oldChild)
        {
            setEx1((PExpression) newChild);
            return;
        }

        if(_ex2_ == oldChild)
        {
            setEx2((PExpression) newChild);
            return;
        }

    }
}
