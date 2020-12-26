/* This file was generated by SableCC (http://www.sablecc.org/). */

package minipython.node;

import java.util.*;
import minipython.analysis.*;

public final class AOpenFunc extends PFunc
{
    private TOpen _open_;
    private TLPar _lPar_;
    private PExpression _left_;
    private TComma _comma_;
    private PExpression _right_;
    private TRPar _rPar_;

    public AOpenFunc()
    {
    }

    public AOpenFunc(
        TOpen _open_,
        TLPar _lPar_,
        PExpression _left_,
        TComma _comma_,
        PExpression _right_,
        TRPar _rPar_)
    {
        setOpen(_open_);

        setLPar(_lPar_);

        setLeft(_left_);

        setComma(_comma_);

        setRight(_right_);

        setRPar(_rPar_);

    }
    public Object clone()
    {
        return new AOpenFunc(
            (TOpen) cloneNode(_open_),
            (TLPar) cloneNode(_lPar_),
            (PExpression) cloneNode(_left_),
            (TComma) cloneNode(_comma_),
            (PExpression) cloneNode(_right_),
            (TRPar) cloneNode(_rPar_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAOpenFunc(this);
    }

    public TOpen getOpen()
    {
        return _open_;
    }

    public void setOpen(TOpen node)
    {
        if(_open_ != null)
        {
            _open_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _open_ = node;
    }

    public TLPar getLPar()
    {
        return _lPar_;
    }

    public void setLPar(TLPar node)
    {
        if(_lPar_ != null)
        {
            _lPar_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _lPar_ = node;
    }

    public PExpression getLeft()
    {
        return _left_;
    }

    public void setLeft(PExpression node)
    {
        if(_left_ != null)
        {
            _left_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _left_ = node;
    }

    public TComma getComma()
    {
        return _comma_;
    }

    public void setComma(TComma node)
    {
        if(_comma_ != null)
        {
            _comma_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _comma_ = node;
    }

    public PExpression getRight()
    {
        return _right_;
    }

    public void setRight(PExpression node)
    {
        if(_right_ != null)
        {
            _right_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _right_ = node;
    }

    public TRPar getRPar()
    {
        return _rPar_;
    }

    public void setRPar(TRPar node)
    {
        if(_rPar_ != null)
        {
            _rPar_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _rPar_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_open_)
            + toString(_lPar_)
            + toString(_left_)
            + toString(_comma_)
            + toString(_right_)
            + toString(_rPar_);
    }

    void removeChild(Node child)
    {
        if(_open_ == child)
        {
            _open_ = null;
            return;
        }

        if(_lPar_ == child)
        {
            _lPar_ = null;
            return;
        }

        if(_left_ == child)
        {
            _left_ = null;
            return;
        }

        if(_comma_ == child)
        {
            _comma_ = null;
            return;
        }

        if(_right_ == child)
        {
            _right_ = null;
            return;
        }

        if(_rPar_ == child)
        {
            _rPar_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_open_ == oldChild)
        {
            setOpen((TOpen) newChild);
            return;
        }

        if(_lPar_ == oldChild)
        {
            setLPar((TLPar) newChild);
            return;
        }

        if(_left_ == oldChild)
        {
            setLeft((PExpression) newChild);
            return;
        }

        if(_comma_ == oldChild)
        {
            setComma((TComma) newChild);
            return;
        }

        if(_right_ == oldChild)
        {
            setRight((PExpression) newChild);
            return;
        }

        if(_rPar_ == oldChild)
        {
            setRPar((TRPar) newChild);
            return;
        }

    }
}