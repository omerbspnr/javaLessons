package org.csystem.samples.parseapp;

public class Parser {
    private Source m_source;

    public Parser(Source source)
    {
        this.setSource(source);
    }

    public void setSource(Source source)
    {
        m_source = source;
    }
}
