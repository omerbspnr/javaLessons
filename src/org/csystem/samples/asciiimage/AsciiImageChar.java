package org.csystem.samples.asciiimage;

public class AsciiImageChar extends  AsciiImage {
    private final char [][] m_image;
    private final char [][] m_transposeOfImage;

    private static void flipVertical(char [][] image)
    {
        int len = image.length;
        for (int i = 0; i < len / 2; ++i)
        {
            char [] tmp = image[i];
            image[i] = image[len - 1 - i];

            image[len -1 - i] = tmp;
        }

    }
    private void controlForFlipVertical(char [][] image)
    {
        if (flippedVertical)
            flipVertical(image);

        super.flippedVertical = false;

    }
    private char [][] getTransposeOfImage()
    {
        this.controlForFlipVertical(m_transposeOfImage);

        return m_transposeOfImage;
    }
    private char [][] getImage()
    {
        this.controlForFlipVertical(m_image);

        return m_image;
    }
    private  char [][] displayProcess()
    {
        if (transposed)
            return this.getTransposeOfImage();

        return this.getImage();

    }

    protected void setTransposeOfImage(String[] image)
    {
        for (int i = 0; i < m_transposeOfImage.length; ++i)
            for (int k = 0; k < m_image.length; ++k)
                m_transposeOfImage [i][k] = image[k].charAt(i);
    }
    protected void setImage(String [] image)
    {
        for (int i = 0; i < m_image.length; ++i)
                m_image[i] = image[i].toCharArray();
    }

    public AsciiImageChar(String [] image)
    {
        m_image = new char[image.length][];
        m_transposeOfImage = new char[image[0].length()][image.length];

        this.setImage(image);
        this.setTransposeOfImage(image);
    }
    public void transpose()
    {
        transposed = !transposed;
    }
    public void flipv()
    {
        flippedVertical = !flippedVertical;

    }
    public void disp()
    {
        var obj = this.displayProcess();

        for (var row : obj) {
            for (var col : row)
                System.out.print(col);
            System.out.println();
        }

        System.out.printf("%d %d\n",obj.length, obj[0].length);
    }
}
