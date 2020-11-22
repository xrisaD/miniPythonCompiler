/* This file was generated by SableCC (http://www.sablecc.org/). */

package minipython.node;

import java.util.*;
import minipython.analysis.*;

public final class AFunctionCall extends PFunctionCall
{
    private TIdentifier _identifier_;
    private TLPar _lPar_;
    private PArglist _arglist_;
    private TRPar _rPar_;

    public AFunctionCall()
    {
    }

    public AFunctionCall(
        TIdentifier _identifier_,
        TLPar _lPar_,
        PArglist _arglist_,
        TRPar _rPar_)
    {
        setIdentifier(_identifier_);

        setLPar(_lPar_);

        setArglist(_arglist_);

        setRPar(_rPar_);

    }
    public Object clone()
    {
        return new AFunctionCall(
            (TIdentifier) cloneNode(_identifier_),
            (TLPar) cloneNode(_lPar_),
            (PArglist) cloneNode(_arglist_),
            (TRPar) cloneNode(_rPar_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAFunctionCall(this);
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

    public PArglist getArglist()
    {
        return _arglist_;
    }

    public void setArglist(PArglist node)
    {
        if(_arglist_ != null)
        {
            _arglist_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _arglist_ = node;
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
            + toString(_identifier_)
            + toString(_lPar_)
            + toString(_arglist_)
            + toString(_rPar_);
    }

    void removeChild(Node child)
    {
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

        if(_arglist_ == child)
        {
            _arglist_ = null;
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

        if(_arglist_ == oldChild)
        {
            setArglist((PArglist) newChild);
            return;
        }

        if(_rPar_ == oldChild)
        {
            setRPar((TRPar) newChild);
            return;
        }

    }
}
