/*----------------------------------------------------------------------------------------------------------------------
    MutableIntValue sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util;

public final class MutableIntValue  {
    private int m_val;

    public MutableIntValue(int val)
    {
        m_val = val;
    }

    public int getVal()
    {
        return m_val;
    }

    public void setVal(int val)
    {
        m_val = val;
    }

    public MutableIntValue inc()
    {
        return this.plus(1);
    }

    public MutableIntValue plus(MutableIntValue other)
    {
        return this.plus(other.m_val);
    }

    public MutableIntValue plus(int val)
    {
        m_val += val;

        return this;
    }

    public int compareTo(MutableIntValue other)
    {
        return m_val - other.m_val;
    }

    public String toString()
    {
        return m_val + "";
    }
}
