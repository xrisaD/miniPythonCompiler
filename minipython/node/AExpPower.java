/* This file was generated by SableCC (http://www.sablecc.org/). */

package minipython.node;

import java.util.*;
import minipython.analysis.*;

public final class AExpPower extends PPower
{
    private PPower _power_;
    private TDmult _dmult_;
    private PSubscription _subscription_;

    public AExpPower()
    {
    }

    public AExpPower(
        PPower _power_,
        TDmult _dmult_,
        PSubscription _subscription_)
    {
        setPower(_power_);

        setDmult(_dmult_);

        setSubscription(_subscription_);

    }
    public Object clone()
    {
        return new AExpPower(
            (PPower) cloneNode(_power_),
            (TDmult) cloneNode(_dmult_),
            (PSubscription) cloneNode(_subscription_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAExpPower(this);
    }

    public PPower getPower()
    {
        return _power_;
    }

    public void setPower(PPower node)
    {
        if(_power_ != null)
        {
            _power_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _power_ = node;
    }

    public TDmult getDmult()
    {
        return _dmult_;
    }

    public void setDmult(TDmult node)
    {
        if(_dmult_ != null)
        {
            _dmult_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _dmult_ = node;
    }

    public PSubscription getSubscription()
    {
        return _subscription_;
    }

    public void setSubscription(PSubscription node)
    {
        if(_subscription_ != null)
        {
            _subscription_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _subscription_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_power_)
            + toString(_dmult_)
            + toString(_subscription_);
    }

    void removeChild(Node child)
    {
        if(_power_ == child)
        {
            _power_ = null;
            return;
        }

        if(_dmult_ == child)
        {
            _dmult_ = null;
            return;
        }

        if(_subscription_ == child)
        {
            _subscription_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_power_ == oldChild)
        {
            setPower((PPower) newChild);
            return;
        }

        if(_dmult_ == oldChild)
        {
            setDmult((TDmult) newChild);
            return;
        }

        if(_subscription_ == oldChild)
        {
            setSubscription((PSubscription) newChild);
            return;
        }

    }
}