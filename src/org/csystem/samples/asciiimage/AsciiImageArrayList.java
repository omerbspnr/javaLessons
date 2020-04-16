package org.csystem.samples.asciiimage;

import java.util.ArrayList;

public class AsciiImageArrayList extends AsciiImage {
    private final ArrayList m_image;
    private final ArrayList m_transposeImage;


    private static void flipv(ArrayList img)
    {
        for (int i = 0, len = img.size(); i < len / 2;++i)
        {
            Object o = img.set(i,img.get(len - 1 - i));
            img.set(len -1 - i, o);
        }
    }
    private void controlForFlipVertical(ArrayList img)
    {
        if (super.flippedVertical)
            flipv(m_image);

        super.flippedVertical = false;
    }
    private ArrayList getImage()
    {
        this.controlForFlipVertical(m_image);

        return m_image;
    }
    private ArrayList getTransposeImage()
    {
        this.controlForFlipVertical(m_transposeImage);
        return m_transposeImage;
    }
    private ArrayList displayProcess()
    {
        if (transposed) {
            return this.getTransposeImage();
        }

        return this.getImage();
    }

    protected void setImage(String [] image)
    {
        for (var s : image)
            m_image.add(s);
    }

    protected void setTransposeOfImage(String [] image)
    {
        for (int i = 0; i < image[0].length(); ++i) {
            for (int k = 0; k < image.length; ++k)
                m_tranposeofColumns[k] = image[k].charAt(i);

            m_transposeImage.add(new String(m_tranposeofColumns));
        }

    }


    public AsciiImageArrayList(String [] image)
    {
        m_image = new ArrayList(image.length);
        m_transposeImage = new ArrayList(image[0].length());
        m_tranposeofColumns = new char[image.length];

        this.setImage(image);
        this.setTransposeOfImage(image);

    }

    public void flipv()
    {
        super.flippedVertical = !super.flippedVertical;
    }
    public void transpose()
    {
        transposed = !transposed;
    }
    public void disp()
    {
        var image = this.displayProcess();

        for (var s : image)
            System.out.println(s.toString());
        System.out.printf("%d %d\n",image.size(), ((String)image.get(0)).length());
    }

}
