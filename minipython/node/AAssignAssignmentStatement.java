/* This file was generated by SableCC (http://www.sablecc.org/). */

package minipython.node;

import java.util.*;
import minipython.analysis.*;

public final class AAssignAssignmentStatement extends PAssignmentStatement
{
    private TIdentifier _identifier_;
    private TAssign _assign_;
    private PExpression _expression_;

    public AAssignAssignmentStatement()
    {
    }

    public AAssignAssignmentStatement(
        TIdentifier _identifier_,
        TAssign _assign_,
        PExpression _expression_)
    {
        setIdentifier(_identifier_);

        setAssign(_assign_);

        setExpression(_expression_);

    }
    public Object clone()
    {
        return new AAssignAssignmentStatement(
            (TIdentifier) cloneNode(_identifier_),
            (TAssign) cloneNode(_assign_),
            (PExpression) cloneNode(_expression_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAAssignAssignmentStatement(this);
    }

    public TIdentifier getIdentifier()
    {
        return _identifier_;
    }

    public void setIdentifier(TIdentifier node)
    {
        if(_identifier_ != null)
        {
            _identifier_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _identifier_ = node;
    }

    public TAssign getAssign()
    {
        return _assign_;
    }

    public void setAssign(TAssign node)
    {
        if(_assign_ != null)
        {
            _assign_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _assign_ = node;
    }

    public PExpression getExpression()
    {
        return _expression_;
    }

    public void setExpression(PExpression node)
    {
        if(_expression_ != null)
        {
            _expression_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _expression_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_identifier_)
            + toString(_assign_)
            + toString(_expression_);
    }

    void removeChild(Node child)
    {
        if(_identifier_ == child)
        {
            _identifier_ = null;
            return;
        }

        if(_assign_ == child)
        {
            _assign_ = null;
            return;
        }

        if(_expression_ == child)
        {
            _expression_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_identifier_ == oldChild)
        {
            setIdentifier((TIdentifier) newChild);
            return;
        }

        if(_assign_ == oldChild)
        {
            setAssign((TAssign) newChild);
            return;
        }

        if(_expression_ == oldChild)
        {
            setExpression((PExpression) newChild);
            return;
        }

    }
}