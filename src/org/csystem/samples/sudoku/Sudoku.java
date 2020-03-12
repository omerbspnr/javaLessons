package org.csystem.samples.sudoku;

import org.csystem.util.ArrayUtil;

import java.util.Random;
import java.util.Scanner;





public class Sudoku {
    private int [][] m_game;
    private boolean m_validGame;
    private static boolean checkFlag(boolean [] flags, int [][] arr)
    {
        Scanner kb = new Scanner(System.in);

        for (int [] array : arr){


            for (int val : array) {
                flags[val] = true;
            }

            if (!isValidValues(flags))
                return false;

            resetFlags(flags);

        }
        return true;
    }
    private static boolean isValidValues(boolean [] flags)
    {
        for (int i = 1; i < flags.length; ++i) {
            if (!flags[i])
                return false;
        }

        return true;
    }

    public Sudoku() {
        m_game = new int[9][9];
    }
    public Sudoku(int [][] a) {
        m_game = a;
    }

    private boolean checkColumns(boolean [] flags)
    {
        return checkFlag(flags,ArrayUtil.getTransposedMatrix(m_game));
    }

    private boolean checkRows(boolean [] flags)
    {
        return checkFlag(flags,m_game);
    }

    private static void resetFlags(boolean [] flags)
    {
        for (int i = 0; i < flags.length;++i )
            flags[i] = false;
    }


    public void read(){
        Scanner kb = new Scanner(System.in);
        for (int i = 0; i < m_game.length; ++i) {
            String[] vals = kb.nextLine().split("[ ]+");
            for (int k = 0; k < m_game[i].length; ++k)
                m_game[i][k] = Integer.parseInt(vals[k]);
        }
        m_validGame = false;

        validate();

     }
     private void validate() {
         boolean [] flags = new boolean[10];

         if(!checkRows(flags))
             return;

         if(!checkColumns(flags))
             return;

         for(int i = 0; i < m_game.length; i += 3) {
             for (int k = 0; k < m_game[i].length; k += 3) {
                 checkSquareMatrix(flags, i, k);
                 if (!isValidValues(flags))
                     return;
                 resetFlags(flags);
             }
         }

        m_validGame = true;
     }




     public boolean isValid() {

        return m_validGame;
     }
     private static void setVal(Random r,boolean [] flags,int [][] game, int row, int col )
     {
         for (int i = 0; i < row; ++i)
            flags[game[i][col]] = true;

         for (int i = 0; i < col; ++i)
             flags[game[row][i]] = true;

         int rowStart = row < 3 ? 0 : (row < 6 ? 3 : 6);
         int colStart = col < 3 ? 0 : (col < 6 ? 3 : 6);

         for (int i = rowStart; i <= row; ++i)
             for (int k = colStart; k <= col; ++k)
                 flags[game[i][k]] = true;

             int val = r.nextInt(9) + 1;
             do {
                 val = r.nextInt(9) + 1;
             }while(flags[val]);

            game[row][col] = val;

            for (int [] arr : game) {
                for (int val1 : arr)
                    System.out.printf("%d ", val1);
                System.out.println();
            }
            Scanner kb = new Scanner(System.in);
            String s = kb.nextLine();
     }
     public static int [][] getRandomGame()
     {
         Random rand = new Random();
         int [][] game = new int [9][9];
         boolean [] flags = new boolean[10];
         int val;
         for (int i = 0;  i < game.length; ++i) {
             for (int k = 0; k < game[i].length; ++k) {
                 setVal(rand, flags, game, i, k);
                 resetFlags(flags);

             }
         }

         return game;

     }
     private void checkSquareMatrix(boolean [] flags, int row_start, int col_start)
     {
        for (int i = row_start; i < row_start + 3; ++i)
            for (int k = col_start; k < col_start + 3; ++k)
                flags[m_game[i][k]] = true;
     }

     public void display() {
        for (int [] arr : m_game) {
            for (int val : arr)
                System.out.printf("%d ", val);
            System.out.println();

        }
     }

}
