package com.coderscampus.assignment6;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.*;
import java.nio.file.*;
import java.time.*;
import java.io.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileService {

    public List<YearlyReport> readYearlyReport (String filename) throws IOException {
       try(Stream<String> lines = Files.lines(Paths.get(filename))) {
           return lines
                .skip(1)
                   .map(line -> {
                       String[] parts = line.split(",");
                       YearMonth date = YearMonth.parse(parts[0], DateTimeFormatter.ofPattern("MMM-yy"));
                       Integer sales = Integer.parseInt(parts[1]);
                       return new YearlyReport(date, sales);
                   })
                   .collect(Collectors.toList());
       }
    }

    public Optional<YearlyReport> findBestMonth (List<YearlyReport> yearlyReports) {
        return yearlyReports.stream()
                .max(Comparator.comparingInt(YearlyReport::getSale));
    }

    public Optional<YearlyReport> findWorstMonth (List<YearlyReport> yearlyReports) {
        return yearlyReports.stream()
                .min(Comparator.comparingInt(YearlyReport::getSale));
    }
}
