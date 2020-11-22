/* This file was generated by SableCC (http://www.sablecc.org/). */

package minipython.node;

import java.util.*;
import minipython.analysis.*;

public final class AArgument extends PArgument
{
    private TIdentifier _identifier_;
    private PAssignValue _assignValue_;
    private final LinkedList _commaIdAssignValue_ = new TypedLinkedList(new CommaIdAssignValue_Cast());

    public AArgument()
    {
    }

    public AArgument(
        TIdentifier _identifier_,
        PAssignValue _assignValue_,
        List _commaIdAssignValue_)
    {
        setIdentifier(_identifier_);

        setAssignValue(_assignValue_);

        {
            this._commaIdAssignValue_.clear();
            this._commaIdAssignValue_.addAll(_commaIdAssignValue_);
        }

    }
    public Object clone()
    {
        return new AArgument(
            (TIdentifier) cloneNode(_identifier_),
            (PAssignValue) cloneNode(_assignValue_),
            cloneList(_commaIdAssignValue_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAArgument(this);
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

    public PAssignValue getAssignValue()
    {
        return _assignValue_;
    }

    public void setAssignValue(PAssignValue node)
    {
        if(_assignValue_ != null)
        {
            _assignValue_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _assignValue_ = node;
    }

    public LinkedList getCommaIdAssignValue()
    {
        return _commaIdAssignValue_;
    }

    public void setCommaIdAssignValue(List list)
    {
        _commaIdAssignValue_.clear();
        _commaIdAssignValue_.addAll(list);
    }

    public String toString()
    {
        return ""
            + toString(_identifier_)
            + toString(_assignValue_)
            + toString(_commaIdAssignValue_);
    }

    void removeChild(Node child)
    {
        if(_identifier_ == child)
        {
            _identifier_ = null;
            return;
        }

        if(_assignValue_ == child)
        {
            _assignValue_ = null;
            return;
        }

        if(_commaIdAssignValue_.remove(child))
        {
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

        if(_assignValue_ == oldChild)
        {
            setAssignValue((PAssignValue) newChild);
            return;
        }

        for(ListIterator i = _commaIdAssignValue_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set(newChild);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

    }

    private class CommaIdAssignValue_Cast implements Cast
    {
        public Object cast(Object o)
        {
            PCommaIdAssignValue node = (PCommaIdAssignValue) o;

            if((node.parent() != null) &&
                (node.parent() != AArgument.this))
            {
                node.parent().removeChild(node);
            }

            if((node.parent() == null) ||
                (node.parent() != AArgument.this))
            {
                node.parent(AArgument.this);
            }

            return node;
        }
    }
}