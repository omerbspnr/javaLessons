package org.csystem.games.cardgames;

import java.util.Random;

public class Card {

    private static final String [] CARDTYPESTR = {"SINEK", "MAÇA", "KARO", "KUPA"};
    private static final String [] CARDVALUESTR = {"IKI", "ÜÇ", "DÖRT", "BEŞ", "ALTI", "YEDI", "SEKIZ",
            "DOKUZ", "ON", "JILET", "KIZ", "PAPAZ", "AS"};

    private CardValue m_value;
    private CardType m_type;

    ///////////////////////////////////////////7
    /*PRIVATE STATIC AREA */
    ///////////////////////////////////////////7

    private static void doWorkForException(String msg)
    {
        System.out.println(msg);
        System.exit(-1);
    }

    private static void control(String str)
    {
        control(str, str.indexOf('-'));
    }
    private static void control(String str, int idx)
    {

        if (idx == -1)
            doWorkForException("Invalid Enter, please enter like cardtype-cardValue");

        if (!isValidType(str.substring(0, idx)) || !isValidVal(str.substring(idx + 1)))
            doWorkForException("Invalid Card Type or Value");
    }
    private static void controlForType(String str)
    {
        if (!isValidType(str))
            doWorkForException("Invalid type");
    }



    private static void controlForVal(String str)
    {
        if (!isValidVal(str))
            doWorkForException("Invalid value");
    }

    private static boolean isValidType(String str)
    {
        for (String type : CARDTYPESTR)
            if(type.equalsIgnoreCase(str))
                return true;

        return  false;
    }

    private static boolean isValidVal(String str)
    {
        for (String val : CARDVALUESTR)
            if(val.equals(str))
                return true;

        return false;
    }

    private static CardValue getValue(String val) //never return null
    {

        for (String s :  CARDVALUESTR)
            if (s.equals(val))
                return CardValue.valueOf(val);

        return null;
    }
    private static CardType getType(String type)//never return null
    {
        for (String s :  CARDTYPESTR)
            if (s.equals(type))
                return CardType.valueOf(type);

        return null;
    }


    private static CardType getType(int ordinal)
    {
        return CardType.values()[ordinal];
    }
    private static CardValue getValue(int ordinal)
    {
        return CardValue.values()[ordinal];
    }

    ///////////////////////////////////////////7
    /*
    PRIVATE AREA
     */
    ///////////////////////////////////////////7

    private void set(String str)
    {
        this.set(str, str.indexOf('-'));
    }

    private void set(String str, int idx)
    {
        this.set(getType(str.substring(0, idx)), getValue(str.substring(idx + 1)));
    }
    private void set(CardType type, CardValue val)
    {
        m_value = val;
        m_type = type;
    }

    ///////////////////////////////////////////7
    /*
    PUBLIC STATIC AREA
     */
    ///////////////////////////////////////////7

    public static Card getRandomCard()
    {
     return getRandomCard(new Random());
    }

    public static Card getRandomCard(Random r)
    {
        return new Card(getType(r.nextInt(4)), getValue(r.nextInt(13)));
    }


    public static Card [] getShuffledDeck()
    {
        return getShuffledDeck(new Random());

    }
    public static Card [] getShuffledDeck(Random r)
    {


        return getShuffledDeck(r, 26);

    }
    public static Card [] getShuffledDeck(int n)
    {

        return  getShuffledDeck(new Random(),  n);

    }
    public static Card [] getShuffledDeck(Random r,int n)
    {
        Card [] deck = new Card[52];

        int idx = 0;
        for (CardType type : CardType.values())
            for (CardValue value : CardValue.values())
                deck[idx++] = new Card(type, value);


            return getShuffledDeck(r, deck, n);

    }
    public static Card [] getShuffledDeck(Card [] deck)
    {

        return getShuffledDeck(new Random(),deck);
    }

    public static Card [] getShuffledDeck(Random r, Card [] deck)
    {

        return getShuffledDeck(r, deck, 26);
    }

    public static Card [] getShuffledDeck(Card [] deck, int n)
    {

        return getShuffledDeck(new Random(),deck, n);
    }

    public static Card [] getShuffledDeck(Random r, Card [] deck, int n)
    {

        int idx1, idx2;

        for (int i = 0; i <n; ++i)
        {
            do {
                idx1 = r.nextInt(deck.length);
                idx2 = r.nextInt(deck.length);
            } while (idx1 == idx2);

            Card tmp = deck[idx1];
            deck[idx1] = deck[idx2];
            deck[idx2] = tmp;
        }

        return deck;
    }
    ///////////////////////////////////////////7
    /*
        PUBLIC AREA
     */
    ///////////////////////////////////////////7

    /*
        CONSTRUCTORS
     */
    public Card(CardType type, CardValue val)
    {
        set(type,val);
    }

    public Card(String name)
    {
       name = name.toUpperCase();
       control(name);
       this.set(name);
    }

    /*
        SETTERS
     */
    public void setName(String name)
    {
        name = name.toUpperCase();

        if (name.equals(this.toString()))
            return;

        control(name);

        this.set(name);
    }

    public void setValue(String value)
    {
        value = value.toUpperCase();

        if (value.equals(this.getValue()))
            return;

        controlForVal(value);

        this.setValue(getValue(value));
    }

    public void setValue(CardValue cardValue)
    {
        m_value = cardValue;
    }

    public void setType(String type)
    {
        type = type.toUpperCase();

        if (type.equals(this.getType()))
            return;

        controlForType(type);

        this.setType(getType(type));

    }

    public void setType(CardType cardtype)
    {



        m_type = cardtype;
    }
    /*
        GETTERS
     */
    public String getValue()
    {
        return  CARDVALUESTR[this.m_value.ordinal()];
    }

    public String getType()
    {
        return CARDTYPESTR[this.m_type.ordinal()];
    }


    public String toString()
    {
        return String.format("%s-%s",getType(), getValue());
    }
}
