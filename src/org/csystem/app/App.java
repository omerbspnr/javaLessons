package org.csystem.app;


class App {
    public static void main(String [] args)
    {
        System.out.println("hello world");
    }

}

class Fighter {
    private String m_name;
    private int [] m_attributes;
    enum FighterAttributes {
        HEALTH,AGILITY,POWER,WEIGHT;
    }
    private void setAttributesForOrdinal(FighterAttributes ord, int val) {
        m_attributes[ord.ordinal()] = val;
    }
    public Fighter(String name, int health, int agility, int power, int weight)
    {
        m_name = name;
        setAttributesForOrdinal(FighterAttributes.HEALTH, health);
        setAttributesForOrdinal(FighterAttributes.AGILITY, agility);
        setAttributesForOrdinal(FighterAttributes.POWER, power);
        setAttributesForOrdinal(FighterAttributes.WEIGHT, weight);

    }
    private int getAttributesOrdinal(FighterAttributes ord)
    {
        return ord.ordinal();
    }
    public String getName()
    {
        return m_name;
    }

    public void setName(String name)
    {
        m_name = name;
    }

    public int getHealth()
    {
        return m_attributes[getAttributesOrdinal(FighterAttributes.HEALTH)];
    }

    public void setHealth(int health)
    {
        setAttributesForOrdinal(FighterAttributes.HEALTH,health);
    }

    public int getAgility()
    {
        return m_attributes[getAttributesOrdinal(FighterAttributes.AGILITY)];
    }

    public void setAgility(int agility)
    {
        setAttributesForOrdinal(FighterAttributes.AGILITY,agility);
    }

    public int getPower()
    {
        return m_attributes[getAttributesOrdinal(FighterAttributes.POWER)];
    }

    public void setPower(int power)
    {
        setAttributesForOrdinal(FighterAttributes.POWER,power);
    }
    public int getWeight() {
        return m_attributes[getAttributesOrdinal(FighterAttributes.AGILITY)];

    }
    public void setWeight(int weight)
    {
        setAttributesForOrdinal(FighterAttributes.WEIGHT,weight);

    }
    public int sumOfAbilities()
    {
        int sum = 0;

        for (FighterAttributes f : FighterAttributes.values())
            sum += m_attributes[f.ordinal()];

        return sum;
    }

    public double averageOfAbilities()
    {
        return (double)sumOfAbilities() / FighterAttributes.values().length;
    }
}
