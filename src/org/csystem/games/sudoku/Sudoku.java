package org.csystem.games.sudoku;

public class Sudoku {

    private int [][] m_sdm = new int[9][9];
    private boolean [] m_numberFlags = new boolean[10];

    private boolean m_validGame;

    private boolean controlForNumbers()
    {
        if(!this.checkNumbers())
            return false;

        this.resetFlags();

        return true;
    }

    private boolean checkNumbers()
    {
        for (int i = 1; i < m_numberFlags.length; ++i)
            if(!m_numberFlags[i])
                return false;

        return true;
    }
    private void resetFlags()
    {
        for (int i = 1; i < m_numberFlags.length; ++i)
            m_numberFlags[i] = false;
    }

    private boolean isValidRows()
    {
        for (int [] rows : m_sdm)
        {
            for (int val : rows)
                m_numberFlags[val] = true;

            if(!this.controlForNumbers())
                return false;

        }

        return true;
    }
    private boolean isValidColumns()
    {

        for (int i = 0; i < m_sdm.length; ++i) {
            for (int k = 0; k < m_sdm[i].length; ++k)
                m_numberFlags[m_sdm[k][i]] = true;

            if(!this.controlForNumbers())
                return false;
        }

        return true;

    }

    private boolean isValidSquare()
    {
        for (int i = 0; i < m_sdm.length; i += 3)
            for (int k = 0; k < m_sdm[i].length; k += 3) {
                this.checkNumbersForSquare(i, k);

                if(!this.controlForNumbers())
                    return false;
            }

        return true;
    }

    private void checkNumbersForSquare(int row, int col)
    {
        for (int i = row; i < row + 3; ++i)
            for (int k = col; k < col + 3; ++k)
                m_numberFlags[m_sdm[i][k]] = true;
    }

    private void setValidGame()
    {
        m_validGame = isValidRows() && isValidColumns() && isValidSquare();

    }

    public Sudoku()
    {
        this.read();
        this.setValidGame();
    }

    public void read()
    {
        m_sdm =  new int [][]{
                {3, 6, 7,  5, 1, 9,  8, 4, 2},
                {8, 4, 2,  3, 7, 6,  9, 1, 5},
                {5, 9, 1,  4, 8, 2,  7, 6, 3},
                {1, 8, 5,  9, 2, 4,  3, 7, 6},
                {9, 3, 6,  7, 5, 1,  2, 8, 4},
                {2, 7, 4,  6, 3, 8,  5, 9, 1},
                {6, 2, 3,  8, 4, 7,  1, 5, 9},
                {4, 5, 8,  1, 9, 3,  6, 2, 7},
                {7, 1, 9,  2, 6, 5,  4, 3, 8}
        };

    }


    public boolean isValidGame()
    {
        return m_validGame;
    }
}