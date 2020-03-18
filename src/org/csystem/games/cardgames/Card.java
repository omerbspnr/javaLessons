package org.csystem.games.cardgames;

import java.util.Random;

public class Card {

    private enum CardTypeTR {
        SINEK, MAÇA, KARO, KUPA;
    }

    private enum CardValTR  {
        IKI, ÜÇ, DÖRT, BEŞ, ALTI, YEDI, SEKIZ,
        DOKUZ, ON, JILET, KIZ, PAPAZ, AS;
    }

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

    private static void controlForType(String str)
    {
        if (!isValidType(str))
            doWorkForException("Invalid type");
    }

    private static boolean isValidType(String str)
    {
        for (CardTypeTR type : CardTypeTR.values())
            if(type.toString().equalsIgnoreCase(str))
                return true;

         return  false;
    }

    private static void controlForVal(String str)
    {
        if (!isValidVal(str))
            doWorkForException("Invalid value");
    }
    private static boolean isValidVal(String str)
    {
        for (CardValTR val : CardValTR.values())
            if(val.toString().equals(str))
                return true;

        return false;
    }

    private static CardValue getValue(String val)
    {

        for (CardValTR values : CardValTR.values())
            if (values.toString().equals(val))
                return CardValue.values()[values.ordinal()];

        return null;
    }
    private static CardType getType(String type)
    {
        for (CardTypeTR types : CardTypeTR.values())
            if (types.toString().equals(type))
                return CardType.values()[types.ordinal()];

        return null;
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
            doWorkForException("Invalid Card");
    }

    ///////////////////////////////////////////7
    /*
    PRIVATE AREA
     */
    ///////////////////////////////////////////7

    private void set(String str)
    {
        set(str, str.indexOf('-'));
    }

    private void set(String str, int idx)
    {
        m_type = getType(str.substring(0, idx));
        m_value = getValue(str.substring(idx + 1));
    }
    private void set(CardValue val, CardType type)
    {
        m_value = val;
        m_type = type;
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
    PUBLIC STATIC AREA
     */
    ///////////////////////////////////////////7

    public static Card getRandomCard()
    {
     return getRandomCard(new Random());
    }

    public static Card getRandomCard(Random r)
    {
        return new Card(CardType.values()[r.nextInt(4)], CardValue.values()[r.nextInt(13)]);
    }

    public static Card [] getRandomNCard ()
    {
        return  getRandomNCard(7);
    }

    public static Card [] getRandomNCard(int n)
    {
        return getRandomNCard(new Random(), n);

    }

    public static Card [] getRandomNCard(Random r, int n)
    {
        Card [] cards = new Card[n];
        boolean [] typeFlags = new boolean[4];
        boolean [] valueFlags = new boolean[13];

        for (int i = 0; i < n; ++i)
        {
            int type, value;
            do {
                type = r.nextInt(4);
                value = r.nextInt(13);
            } while (typeFlags[type] && valueFlags[value]);

                cards[i] = new Card(getType(type), getValue(value));
        }

        return cards;
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

    public Card(CardType type, CardValue val)
    {
        set(val,type);
    }

    public Card(String str)
    {
       str= str.toUpperCase();
       control(str);
       set(str);
    }

    /*
        SETTERS
     */
    public void setName(String str)
    {
        str = str.toUpperCase();

        if (str.equals(toString()))
            return;

        control(str);

        set(str);
    }

    public void setValue(String str)
    {
        str = str.toUpperCase();

        if (str.equals(getValue()))
            return;

        controlForVal(str);
        setValue(getValue(str));
    }

    public void setValue(CardValue cardValue)
    {
        if (cardValue.ordinal() == m_value.ordinal())
            return;

        m_value = cardValue;
    }

    public void setType(String str)
    {
        str = str.toUpperCase();

        if (str.equals(getType()))
            return;

        controlForType(str);
        setType(getType(str));

    }

    public void setType(CardType cardtype)
    {
        if (cardtype.ordinal() == m_type.ordinal())
            return;

        m_type = cardtype;
    }
    /*
        GETTERS
     */
    public String getValue()
    {
        return  getValue(m_value.ordinal()).toString();
    }

    public String getType()
    {
        return getType(m_type.ordinal()).toString();
    }


    public String toString()
    {
        return String.format("%s-%s",getType(), getValue());
    }
}
