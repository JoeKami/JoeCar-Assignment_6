package com.coderscampus.assignment6;

import java.time.YearMonth;
import java.util.Date;

public class YearlyReport {
    YearMonth date;
    Integer sale;

    public YearlyReport(YearMonth date, Integer sale) {
        this.date = date;
        this.sale = sale;
    }

    public YearMonth getDate() {
        return date;
    }

    public void setDate(YearMonth date) {
        this.date = date;
    }

    public Integer getSale() {
        return sale;
    }

    public void setSale(Integer sale) {
        this.sale = sale;
    }

    @Override
    public String toString() {
        return "YearlyReport{" +
                "date=" + date +
                ", sale=" + sale +
                '}';
    }
}
