package org.csystem.samples.examsimulation;

import org.csystem.util.ArrayUtil;

import java.util.Random;
import java.util.Scanner;

public class ExamSimulation {
    private String m_lectureName;
    private int [][] m_grades;
    private double [] m_averages;
    private double m_average;

    private Scanner m_kb;


    private void calculateAverages()
    {
        int totalGrades = 0, numberOfStudents = 0;

        for (int i = 0; i < m_grades.length; ++i) {
            int sumGrades = ArrayUtil.sum(m_grades[i]);

            totalGrades += sumGrades;
            numberOfStudents += m_grades[i].length;

            m_averages[i] = (double) sumGrades / m_grades[i].length;
        }

        m_average = (double)totalGrades / numberOfStudents;
    }
    private void getGradesInfo()
    {
        System.out.println("Şube sayisini giriniz");

        int classNumber = Integer.parseInt(m_kb.nextLine());

        m_grades = new int [classNumber][];
        m_averages = new double[classNumber];
    }
    private void fillGrades()
    {

        Random r= new Random();


        for (int i = 0; i  < m_grades.length; ++i) {

            System.out.printf("%d. sinifin öğrenci sayisini giriniz%n",i + 1);
            int val = Integer.parseInt(m_kb.nextLine());
            m_grades[i] = ArrayUtil.getRandomArray(r,val,0,101);
        }
    }
    public ExamSimulation(String name)
    {
        m_lectureName = name;
        m_kb = new Scanner(System.in);
    }
    public void displayGrades()
    {

        ArrayUtil.display(m_grades, 2);
        System.out.println("----------------------------------------");

    }

    public void report()
    {

    }

    public void run()
    {
        getGradesInfo();
        fillGrades();
        calculateAverages();
    }
}
