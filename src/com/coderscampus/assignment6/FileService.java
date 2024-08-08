package com.coderscampus.assignment6;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.*;
import java.nio.file.*;
import java.time.*;
import java.io.*;
import java.util.stream.Collectors;

public class FileService {

    public List<YearlyReport> readYearlyReport (String filename) throws IOException {
        return Files.lines(Paths.get(filename))
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
