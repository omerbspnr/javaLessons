package org.csystem.collection;

import java.util.Arrays;

public class CSDArrayList {
    private final static int DEFAULT_CAPACITY = 10;
    private int m_index;

    private Object [] m_elems;

    private static void doWorkForException(String msg)
    {
        System.out.println(msg);
        System.exit(-1);
    }

    private static void checkForIllegalArgumentCapacity(int capacity)
    {
        if (capacity < 0)
            doWorkForException("Illegal capacity, capacity has to be positive");

    }
    private static void checkIndexOutOfBounds(int index, int maxIndex)
    {
        if (index < 0 || index >= maxIndex)
            doWorkForException("Index Out Of bounds");

    }
    private  void allocateCapacity(int capacity)
    {
        m_elems = Arrays.copyOf(m_elems, capacity);
    }
    private void checkAndEnsureCapacity(int capacity)
    {
        int len = m_elems.length;

        if(capacity < len)
            return;

         allocateCapacity(Math.max(capacity, len * 2));
    }
    private void checkAndAllocCapacity(int capacity)
    {
        if (m_index < m_elems.length)
            return;

        allocateCapacity(capacity == 0 ? 1 : capacity);
    }
    public CSDArrayList()
    {
        this(DEFAULT_CAPACITY);
    }
    public CSDArrayList(int initialCapacity)
    {
        checkForIllegalArgumentCapacity(initialCapacity);
        m_elems = new Object[initialCapacity];
    }

    public boolean add(Object elem)
    {
        checkAndAllocCapacity(m_elems.length * 2);
        m_elems[m_index++] = elem;
        return true;
    }
    public void add(int index, Object elem)
    {
        checkIndexOutOfBounds(index, m_elems.length + 1);
        checkAndAllocCapacity(m_elems.length * 2);

        for (int i = m_index - 1; i >= index; --i)
            m_elems[i + 1] = m_elems[i];


        m_elems[index] = elem;

        m_index++;
    }

    public int capacity()
    {
        return m_elems.length;
    }
    public void ensureCapacity(int capacity)
    {
        checkAndEnsureCapacity(capacity);
    }
    public Object remove(int index)
    {
        checkIndexOutOfBounds(index, m_index);
        Object tmp = m_elems[index];

        for (int i = index ; i < m_elems.length - 1; ++i)
        {
            m_elems[i] = m_elems[i + 1];
        }

        m_elems[--m_index] = null;

        return  tmp;
    }
    public int size()
    {
        return m_index;
    }

    public Object set(int index, Object elem)
    {
        checkIndexOutOfBounds(index, m_index);

        Object tmp = m_elems[index];

        m_elems[index] = elem;

        return tmp;
    }
    public Object get(int index)
    {
        checkIndexOutOfBounds(index, m_index);


        return m_elems[index];
    }


    public void clear()
    {
        Arrays.fill(m_elems, null);
        m_index = 0;
    }
    public void trimToSize()
    {
        if (m_index == m_elems.length)
            return;

        allocateCapacity(m_index == 0 ? DEFAULT_CAPACITY : m_index);
    }

}
