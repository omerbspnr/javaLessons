/*----------------------------------------------------------------------------------------------------------------------
    CSDArrayList sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.collection;

import java.util.Arrays;

public class CSDArrayList<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private T [] m_elems;
    private int m_index;

    private static void checkForIllegalArgumentException(int capacity)
    {
        if (capacity < 0)
            throw new IllegalArgumentException("Capactiy value can not be negative");
    }

    private static void checkForIndexOutOfBounds(int index, int end)
    {
        if (index < 0 || index >= end)
            throw new IndexOutOfBoundsException("Index out of bounds");
    }

    private void allocateCapacity(int capacity)
    {
        T [] temp = (T[])new Object[capacity];

        for (int i = 0; i < m_index; ++i)
            temp[i] = m_elems[i];

        m_elems = temp;
    }

    private void checkAndAllocCapacity(int capacity)
    {
        if (m_index < m_elems.length)
            return;

        this.allocateCapacity(capacity);
    }

    public CSDArrayList()
    {
        this(DEFAULT_CAPACITY);
    }

    public CSDArrayList(int initialCapacity)
    {
        checkForIllegalArgumentException(initialCapacity);
        m_elems = (T[])new Object[initialCapacity];
    }

    public boolean add(T elem)
    {
        this.checkAndAllocCapacity(m_elems.length * 2);
        m_elems[m_index++] = elem;

        return true;
    }

    public void add(int index, T elem)
    {
        checkForIndexOutOfBounds(index, m_index + 1); // add size verildiğinde sona ekler
        this.checkAndAllocCapacity(m_elems.length * 2);

        //TODO:
    }

    public int capacity() {return m_elems.length;}

    public void clear()
    {
        for (int i = 0; i < m_index; ++i)
            m_elems[i] = null;

        m_index = 0;
    }

    public T get(int index)
    {
        checkForIndexOutOfBounds(index, m_index);

        return m_elems[index];
    }

    public T set(int index, T elem)
    {
        checkForIndexOutOfBounds(index, m_index);
        T old = m_elems[index];

        m_elems[index] = elem;

        return old;
    }

    public T remove(int index)
    {
        checkForIndexOutOfBounds(index, m_index);
        T old = m_elems[index];

        //TODO:
        return old;
    }
    public int size() {return m_index;}

    public void trimToSize()
    {
        if (m_index == m_elems.length)
            return;

        this.allocateCapacity(m_index == 0 ? DEFAULT_CAPACITY : m_index);
    }
}
