/* This file was generated by SableCC (http://www.sablecc.org/). */

package minipython.node;

import java.util.*;
import minipython.analysis.*;

public final class AFunction extends PFunction
{
    private TDef _def_;
    private TIdentifier _identifier_;
    private TLPar _lPar_;
    private PArgument _argument_;
    private TRPar _rPar_;
    private TColon _colon_;
    private PStatement _statement_;

    public AFunction()
    {
    }

    public AFunction(
        TDef _def_,
        TIdentifier _identifier_,
        TLPar _lPar_,
        PArgument _argument_,
        TRPar _rPar_,
        TColon _colon_,
        PStatement _statement_)
    {
        setDef(_def_);

        setIdentifier(_identifier_);

        setLPar(_lPar_);

        setArgument(_argument_);

        setRPar(_rPar_);

        setColon(_colon_);

        setStatement(_statement_);

    }
    public Object clone()
    {
        return new AFunction(
            (TDef) cloneNode(_def_),
            (TIdentifier) cloneNode(_identifier_),
            (TLPar) cloneNode(_lPar_),
            (PArgument) cloneNode(_argument_),
            (TRPar) cloneNode(_rPar_),
            (TColon) cloneNode(_colon_),
            (PStatement) cloneNode(_statement_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAFunction(this);
    }

    public TDef getDef()
    {
        return _def_;
    }

    public void setDef(TDef node)
    {
        if(_def_ != null)
        {
            _def_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _def_ = node;
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

    public PArgument getArgument()
    {
        return _argument_;
    }

    public void setArgument(PArgument node)
    {
        if(_argument_ != null)
        {
            _argument_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _argument_ = node;
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

    public TColon getColon()
    {
        return _colon_;
    }

    public void setColon(TColon node)
    {
        if(_colon_ != null)
        {
            _colon_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _colon_ = node;
    }

    public PStatement getStatement()
    {
        return _statement_;
    }

    public void setStatement(PStatement node)
    {
        if(_statement_ != null)
        {
            _statement_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _statement_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_def_)
            + toString(_identifier_)
            + toString(_lPar_)
            + toString(_argument_)
            + toString(_rPar_)
            + toString(_colon_)
            + toString(_statement_);
    }

    void removeChild(Node child)
    {
        if(_def_ == child)
        {
            _def_ = null;
            return;
        }

        if(_identifier_ == child)
        {
            _identifier_ = null;
            return;
        }

        if(_lPar_ == child)
        {
            _lPar_ = null;
            return;
        }

        if(_argument_ == child)
        {
            _argument_ = null;
            return;
        }

        if(_rPar_ == child)
        {
            _rPar_ = null;
            return;
        }

        if(_colon_ == child)
        {
            _colon_ = null;
            return;
        }

        if(_statement_ == child)
        {
            _statement_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_def_ == oldChild)
        {
            setDef((TDef) newChild);
            return;
        }

        if(_identifier_ == oldChild)
        {
            setIdentifier((TIdentifier) newChild);
            return;
        }

        if(_lPar_ == oldChild)
        {
            setLPar((TLPar) newChild);
            return;
        }

        if(_argument_ == oldChild)
        {
            setArgument((PArgument) newChild);
            return;
        }

        if(_rPar_ == oldChild)
        {
            setRPar((TRPar) newChild);
            return;
        }

        if(_colon_ == oldChild)
        {
            setColon((TColon) newChild);
            return;
        }

        if(_statement_ == oldChild)
        {
            setStatement((PStatement) newChild);
            return;
        }

    }
}