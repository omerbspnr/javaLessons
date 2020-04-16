package org.csystem.samples.arraylistapp;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListApp {

    private ArrayList inputs;
    private ArrayList m_res;
    private StringBuilder source = new StringBuilder();

    private static String createTag(String tagName, String delim)
    {
        return String.format("<%s%s>", delim, tagName);
    }
    private static String createOpenTag(String tagName)
    {
        return createTag(tagName,"");
    }

    private static String createCloseTag(String tagName)
    {
        return createTag(tagName,"/");
    }

    private static String createCompleteTag(String source, String tagName)
    {
        return String.format("%s%s%s", createOpenTag(tagName), source, createCloseTag(tagName));
    }
    private String createLineForArrayList(String tagName)
    {
        return String.format("%s",tagName);
    }
    private String addTabForArrayList(int count)
    {
        String res = "\t";

        while (--count != 0)
            res += "\t";

        return res;
    }
    private String addLineWithTabForArrayList(String tagName)
    {
        return String.format("%s%s",addTabForArrayList(1), tagName);
    }
    private String addLineWithTabForArrayList(String tagNode,String tagName, int count)
    {
        return String.format("%s%s",addTabForArrayList(2),createCompleteTag(tagNode,tagName));
    }
    private  StringBuilder createLine(String tagName)
    {
       return source.append(tagName).append("\n");
    }

    private StringBuilder addTab(int count)
    {
        while (count-- != 0)
            source.append('\t');

        return source;
    }

    private StringBuilder addLineWithTab(String tagName)
    {
        this.addTab(1);
        return this.createLine(tagName);
    }

    private StringBuilder addLineWithTab(String tagNode, String tagName, int count)
    {
        return this.addTab(2)
                .append(createCompleteTag(tagNode, tagName))
                .append("\n");
    }
    private void showArrayList()
    {
        String s = "";

        for (Object o : m_res)
            s += o.toString().concat("\n");

        System.out.println(s);
    }
    private void getParticularArea(String outerTag, String InnerTag)
    {
        for (var row :  inputs)
        {
            this.addLineWithTab(createOpenTag(outerTag));
            m_res.add(addLineWithTabForArrayList(createOpenTag(outerTag)));

            for (var name : (ArrayList)row)
            {

                this.addLineWithTab(name.toString(), InnerTag, 2);
                m_res.add(addLineWithTabForArrayList(name.toString(),InnerTag,2));
            }

            this.addLineWithTab(createCloseTag(outerTag));
            m_res.add(addLineWithTabForArrayList(createCloseTag(outerTag)));

        }
    }
    private void setSource()
    {
        this.createLine(createOpenTag("Names"));
        m_res.add(createOpenTag("Names"));

        this.getParticularArea("Line","Name");

        this.createLine(createCloseTag("Names"));
        m_res.add(createCloseTag("Names"));
    }

    public ArrayListApp(ArrayList inputs)
    {
        this.inputs = inputs;
        this.m_res =  new ArrayList(inputs.size());
        setSource();

    }
    public ArrayList getMinXMLForArrayList()
    {
        ArrayList tmp = new ArrayList(m_res.size());
        for (Object o : m_res)
        {
            tmp.add(((String)o).replaceAll("[\t\n]+", ""));
        }
        return tmp;
    }
    public void showXMLFormatArrayList()
    {
        for (Object o : m_res)
            System.out.println(o.toString());
    }
    public String getXML()
    {
        return source.toString();
    }
    public String getMinXML()
    {
        return source.toString().replaceAll("[\t\n]+", "");
    }

}
