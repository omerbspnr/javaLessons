package org.csystem.samples.asciiimage;

public abstract class AsciiImage {
    protected char [] m_tranposeofColumns;

    protected boolean transposed;
    protected boolean flippedVertical;

    protected abstract void setImage(String [] image);
    protected abstract void setTransposeOfImage(String [] image);

    public abstract void flipv();
    public abstract void transpose();
    public abstract void disp();


}
