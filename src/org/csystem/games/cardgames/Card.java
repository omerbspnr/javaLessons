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
                deck[idx++] = new Card(value, type);


            return getShuffledDeck(r, deck, n);

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
    public Card(CardValue val, CardType type)
    {
        set(val,type);
    }

    public Card(String str)
    {
       str= str.toUpperCase();
       control(str);
       set(str);
    }

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
    public String getType()
    {
        return m_type.toString();
    }

    public String getValue()
    {
        return  m_value.toString();
    }
    public String toString()
    {
        return String.format("%s-%s",CardTypeTR.values()[m_type.ordinal()], CardValTR.values()[m_value.ordinal()]);
    }

}
