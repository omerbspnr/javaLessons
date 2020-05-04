/*----------------------------------------------------------------------------------------------------------------------
    IntValue sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util;

public final class IntValue {
    private final int m_val;
    private static final IntValue [] ms_cache;

    static {
        ms_cache = new IntValue[256];
        ZERO = of(0);
        ONE = of(1);
    }

    private IntValue(int val)
    {
        m_val = val;
    }

    public static final IntValue ZERO;
    public static final IntValue ONE;

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
        return this.plus(1);
    }

    public IntValue plus(IntValue other)
    {
        return this.plus(other.m_val);
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
