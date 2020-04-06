package org.csystem.samples.randomobjarraygenerator;

import org.csystem.util.IntValue;
import org.csystem.util.StringUtil;

import java.util.Random;

public class RandomObjectArrayGenerator {
    private Random m_random;
    private Object [] m_objects;

    public Object getObject()
    {
        int val = m_random.nextInt(3);
        Object obj = new Random();

        switch (val) {
            case 0:
                obj = StringUtil.getRandomTextTR(m_random, 10);
                break;
            case 1:
                obj = IntValue.of(m_random.nextInt(255) - 128);
                break;
        }

        return obj;
    }

    public RandomObjectArrayGenerator(int n)
    {
        m_random = new Random();
        m_objects = new Object[n];
    }

    public Object[] getObjects()
    {
        return m_objects;
    }

    public void generateArray()
    {
        for (int i = 0; i < m_objects.length; ++i)
            m_objects[i] = getObject();
    }
}