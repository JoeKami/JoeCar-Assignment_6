package com.coderscampus.assignment6;

import java.io.IOException;

public class YearlyReportAnalysisApplication {
    public static void main(String[] args) throws IOException {

        FileService fileService = new FileService();
        //Model 3 report
        System.out.println("Model 3 Yearly Sales Report");
        System.out.println("----------------------------");
        System.out.println(fileService.readYearlyReport("resources/model3.csv"));

        //Model S report
        System.out.println("Model S Yearly Sales Report");
        System.out.println("----------------------------");
        System.out.println(fileService.readYearlyReport("resources/modelS.csv"));

        //Model X report
        System.out.println("Model X Yearly Sales Report");
        System.out.println("----------------------------");
        System.out.println(fileService.readYearlyReport("resources/modelX.csv"));
    }
}
