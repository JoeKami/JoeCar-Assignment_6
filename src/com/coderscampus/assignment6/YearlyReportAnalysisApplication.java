package com.coderscampus.assignment6;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class YearlyReportAnalysisApplication {
    public static void main(String[] args) throws IOException {

        FileService fileService = new FileService();

        //Model 3 report
        System.out.println();
        System.out.println("Model 3 Yearly Sales Report");
        System.out.println("----------------------------");

        List<YearlyReport> model3Sales = fileService.readYearlyReport("resources/model3.csv");

        Map<Integer, Integer> totalYearlySales = model3Sales.stream()
                .collect(Collectors.groupingBy(report ->
                        report.getDate().getYear(),
                        Collectors.summingInt(YearlyReport::getSale)
                ));

        totalYearlySales.forEach((year, sales) -> System.out.println(year + "->" + sales));
        System.out.println();
        fileService.findBestMonth(model3Sales).ifPresent(report -> System.out.println("The best month for Model 3 was: " + report.getDate()));
        fileService.findWorstMonth(model3Sales).ifPresent(report -> System.out.println("The worst month for Model 3 was: " + report.getDate()));

        //Model S report
        System.out.println();
        System.out.println("Model S Yearly Sales Report");
        System.out.println("----------------------------");

        List<YearlyReport> modelSSales = fileService.readYearlyReport("resources/modelS.csv");

        Map<Integer, Integer> totalYearlySales2 = modelSSales.stream()
                .collect(Collectors.groupingBy(report ->
                                report.getDate().getYear(),
                        Collectors.summingInt(YearlyReport::getSale)
                ));

        totalYearlySales2.forEach((year, sales) -> System.out.println(year + "->" + sales));
        System.out.println();
        fileService.findBestMonth(modelSSales).ifPresent(report -> System.out.println("The best month for Model S was: " + report.getDate()));
        fileService.findWorstMonth(model3Sales).ifPresent(report -> System.out.println("The worst month for Model S was: " + report.getDate()));


        //Model X report
        System.out.println();
        System.out.println("Model X Yearly Sales Report");
        System.out.println("----------------------------");

        List<YearlyReport> modelXSales = fileService.readYearlyReport("resources/modelX.csv");

        Map<Integer, Integer> totalYearlySales3 = modelXSales.stream()
                .collect(Collectors.groupingBy(report ->
                                report.getDate().getYear(),
                        Collectors.summingInt(YearlyReport::getSale)
                ));

        totalYearlySales3.forEach((year, sales) -> System.out.println(year + " -> " + sales));

        System.out.println();
        fileService.findBestMonth(modelXSales).ifPresent(report -> System.out.println("The best month for Model X was: " + report.getDate()));
        fileService.findWorstMonth(modelXSales).ifPresent(report -> System.out.println("The worst month for Model X was: " + report.getDate()));

    }
}
