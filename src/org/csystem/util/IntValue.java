/*----------------------------------------------------------------------------------------------------------------------
    IntValue sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util;

public class IntValue {
    private final int m_val;
    private static final IntValue [] ms_cache = new IntValue[256];

    private IntValue(int val)
    {
        m_val = val;
    }

    public static final IntValue ZERO = of(0);
    public static final IntValue ONE = of(1);

    public static IntValue of(int val)
    {
        if (val < -128 || val > 127)
            return new IntValue(val);

        if (ms_cache[val + 128] == null)
            ms_cache[val + 128] = new IntValue(val);

        return ms_cache[val + 128];
    }


    public int getVal()
    {
        return m_val;
    }

    public IntValue inc()
    {
        return plus(1);
    }

    public IntValue plus(IntValue other)
    {
        return plus(other.m_val);
    }

    public IntValue plus(int val)
    {
        return of(m_val + val);
    }

    public int compareTo(IntValue other)
    {
        return m_val - other.m_val;
    }

    public String toString()
    {
        return m_val + "";
    }
}
