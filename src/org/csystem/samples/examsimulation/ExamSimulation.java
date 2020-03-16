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

    private void getGradesInfo()
    {
        System.out.print("Şube sayısını giriniz:");
        m_grades = new int[Integer.parseInt(m_kb.nextLine())][];
        m_averages = new double[m_grades.length];
    }

    private void fillGrades()
    {
        Random r = new Random();

        for (int i = 0; i < m_grades.length; ++i) {
            System.out.printf("%d. şube öğrenci sayısını giriniz:", i + 1);
            int n = Integer.parseInt(m_kb.nextLine());
            m_grades[i] = ArrayUtil.getRandomArray(r, n, 0, 101);
        }
    }

    private void calculateAverages()
    {
        int totalGrades = 0, numberOfStudents = 0;


        for (int i = 0; i < m_grades.length; ++i) {
            int sumOfGrades = ArrayUtil.sum(m_grades[i]);

            totalGrades += sumOfGrades;
            numberOfStudents += m_grades[i].length;
            m_averages[i] = (double)sumOfGrades / m_grades[i].length;
        }

        m_average = (double)totalGrades / numberOfStudents;
    }

    public ExamSimulation(String name)
    {
        m_lectureName = name;
        m_kb = new Scanner(System.in);
    }


    public double[] getAverages()
    {
        return m_averages;
    }

    public double getAverage()
    {
        return m_average;
    }

    public String getLectureName()
    {
        return m_lectureName;
    }

    public void setLectureName(String lectureName)
    {
        m_lectureName = lectureName;
    }

    public void displayGrades()
    {
        ArrayUtil.display(m_grades, 2);

        System.out.println("***************************");
    }

    public void report()
    {
        System.out.printf("%s dersi sınav raporu:%n", m_lectureName);
        for (int i = 0; i < m_grades.length; ++i) {
            System.out.printf("%d.sınıf:", i + 1);
            for (int k = 0; k < m_grades[i].length; ++k)
                System.out.printf("%02d ", m_grades[i][k]);

            System.out.printf("Ortalama:%f%n", m_averages[i]);
        }

        System.out.printf("Okul Ortalaması:%f%n", m_average);
    }

    public void run()
    {
        getGradesInfo();
        fillGrades();
        calculateAverages();
    }
}
