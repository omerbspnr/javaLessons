package org.csystem.collection;

import java.util.Arrays;

public class CSDArrayList {
    private final static int DEFAULT_CAPACITY = 10;
    private Object [] m_elems;
    private int m_index;

    private static void doWorkForException(String msg)
    {
        System.out.println(msg);
        System.exit(-1);
    }

    private static void checkForIllegalArgumentException(int capacity)
    {
        if (capacity < 0)
            doWorkForException("Illegal capacity, capacity has to be larger than zero");
    }

    private static void checkForIndexOutOfBounds(int index, int maxIndex)
    {
        if (index < 0 && index >= maxIndex)
            doWorkForException("Out of range error");

    }

    private void allocateCapacity(int capacity)
    {
        Object [] tmp = Arrays.copyOf(m_elems, capacity);

        Arrays.fill(m_elems, null);

        m_elems = tmp;
    }

    public void ensureCapacity(int capacity)
    {
        if (capacity > m_elems.length)
            allocateCapacity(capacity);
    }
    private void checkAndAllocCapacity(int capacity)
    {
        if (m_index == m_elems.length)
            allocateCapacity(capacity);
    }
    public CSDArrayList()
    {
        this(DEFAULT_CAPACITY);
    }

    public CSDArrayList(int initialCapacity)
    {
        checkForIllegalArgumentException(initialCapacity);
        m_elems = new Object[initialCapacity];
    }
    public boolean add(Object elem)
    {
        checkAndAllocCapacity(m_elems.length * 2);
        m_elems[m_index++] = elem;
        return true;
    }

    public int capacity()
    {
        return m_elems.length;
    }

    public void clear()
    {
        Arrays.fill(m_elems, null);
        m_index = 0;
    }

    public boolean add(int index, Object elem)
    {
        checkForIndexOutOfBounds(index, m_elems.length + 1);
        checkAndAllocCapacity(m_elems.length * 2);

        for (int i = m_index++ - 1; i >= index; --i)
            m_elems[i + 1] = m_elems[i];

        m_elems[index] = elem;
        return  true;
    }
    public Object get(int index)
    {
        checkForIndexOutOfBounds(index, m_elems.length);
        return m_elems[index];
    }
    public Object set(int index, Object elem)
    {
        checkForIndexOutOfBounds(index, m_elems.length);
        Object old = m_elems[index];

        m_elems[index] = elem;
        return old;
    }

    public Object remove(int index)
    {
        checkForIndexOutOfBounds(index, m_elems.length);
        Object old = m_elems[index];

        for (int i = index; i < m_index - 1; ++i)
            m_elems[i] = m_elems[i  + 1];

        m_elems[--m_index] = null;
        return old;
    }

    public boolean remove (Object elem)
    {
        for (int i = 0; i < m_index; ++i)
        {
            if (elem.equals(m_elems[i]))
                remove(i);
        }

        return true;
    }
    public void trimToSize()
    {
        if (m_index == DEFAULT_CAPACITY)
            return;

        allocateCapacity(m_index <= 10 ? DEFAULT_CAPACITY : m_index);
    }

    public int size()
    {
        return  m_index;
    }

    public void show()
    {
        System.out.println(Arrays.toString(m_elems));
    }
}