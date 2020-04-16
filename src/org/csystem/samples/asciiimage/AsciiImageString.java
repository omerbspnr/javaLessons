package org.csystem.samples.asciiimage;

public class AsciiImageString extends  AsciiImage {
    private final String [] m_image;
    private final String [] m_transposeOfImage;

    private static void flipVertical(String [] image)
    {
        int len = image.length;
        for (int i = 0; i < len / 2; ++i)
        {
            String  tmp = image[i];
            image[i] = image[len - 1 - i];
             image[len - 1 - i] = tmp;

        }
    }

    private void controlForFlipVertical(String [] image)
    {
        if (super.flippedVertical)
            flipVertical(image);

        super.flippedVertical = false;
    }
    private String [] getImage()
    {
        this.controlForFlipVertical(m_image);

        return m_image;

    }
    private String [] getTransposedImage()
    {
        this.controlForFlipVertical(m_transposeOfImage);


        return m_transposeOfImage;

    }
    private String [] displayProc()
    {
        if (super.transposed)
            return this.getTransposedImage();
        return this.getImage();
    }
    protected void setTransposeOfImage(String [] image)
    {
        for (int i = 0; i < image[0].length(); ++i) {
            for (int k = 0; k < image.length; ++k)
                m_tranposeofColumns[k] = image[k].charAt(i);

            m_transposeOfImage[i] = new String(m_tranposeofColumns);
        }
    }
    protected void setImage(String [] image)
    {
        for (int i = 0; i < image.length; ++i)
            m_image[i] = image[i];
    }
    public AsciiImageString(String [] image)
    {
        m_image = new String[image.length];
        m_transposeOfImage = new String[image[0].length()];
        m_tranposeofColumns = new char[image.length];

        this.setImage(image);
        this.setTransposeOfImage(image);
    }

    public void transpose()
    {
        super.transposed = !super.transposed;
    }
    public void flipv()
    {
        super.flippedVertical = !super.flippedVertical;

    }
    public void disp()
    {
        var image = this.displayProc();

        for (var  s : image)
            System.out.println(s);

        System.out.printf("%d %d\n", image.length, image[0].length());
    }
}
