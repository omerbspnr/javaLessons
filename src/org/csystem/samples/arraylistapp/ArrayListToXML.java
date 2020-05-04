package org.csystem.samples.arraylistapp;

import java.util.ArrayList;

public class ArrayListToXML {
    private final ArrayList<ArrayList<String>> m_inputs;
    private final ArrayList<String> m_res;


    {
        m_res = new ArrayList<>();
    }

    private static String createTag(String tagName, boolean isOpenTag)
    {
        return String.format("<%s%s>",isOpenTag ? "" : "/", tagName);
    }
    private static String createCloseTag(String tagName)
    {
        return createTag(tagName, false);
    }
    private static String createOpenTag(String tagName)
    {
        return createTag(tagName, true);
    }

    private static String createOpenCloseTag(String tagName, String node)
    {
        return String.format("%s%s%s",createOpenTag(tagName),node,createCloseTag(tagName));
    }

    private static String  addTab(int cnt)
    {
        String res = "";

        while (cnt-- != 0)
            res += "\t";

        return res;
    }
    private void createLineWithTab(String tagName,String node, int cnt)
    {
        m_res.add(addTab(cnt) + createOpenCloseTag(tagName,node));
    }
    private  void createOpenTagWithTab(String tagName, int cnt)
    {
        m_res.add(addTab(cnt) + createOpenTag(tagName));
    }
    private  void createCloseTagWithTab(String tagName, int cnt)
    {

        m_res.add(addTab(cnt) + createCloseTag(tagName));
    }


    private void createXML()
    {
        this.createOpenTagWithTab("Names", 0);
        for (ArrayList<String> lines : m_inputs)
        {
            this.createOpenTagWithTab("Lines", 1);
            for (String name : lines) {
                this.createLineWithTab("Name", name,2);
            }
            this.createCloseTagWithTab("Lines", 1);

        }
        this.createCloseTagWithTab("Names", 0);
    }



    public ArrayListToXML(ArrayList<ArrayList<String>> inputs)
    {
        m_inputs = inputs;
        createXML();
    }

    public void showXML()
    {
        for (String s : m_res)
        {
            System.out.println(s);
        }

    }
}