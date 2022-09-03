package com.example.nbp_currencies.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class LogRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double midValue;
    private String firstDate;
    private String lastDate;
    private Integer currenciesCount;
    private LocalDateTime todayDate;

    public LogRecord() {
    }

    public LogRecord(double midValue, String firstDate, String lastDate, Integer currenciesCount, LocalDateTime todayDate) {
        this.midValue = midValue;
        this.firstDate = firstDate;
        this.lastDate = lastDate;
        this.currenciesCount = currenciesCount;
        this.todayDate = todayDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getMidValue() {
        return midValue;
    }

    public void setMidValue(double midValue) {
        this.midValue = midValue;
    }

    public String getFirstDate() {
        return firstDate;
    }

    public void setFirstDate(String firstDate) {
        this.firstDate = firstDate;
    }

    public String getLastDate() {
        return lastDate;
    }

    public void setLastDate(String lastDate) {
        this.lastDate = lastDate;
    }

    public Integer getCurrenciesCount() {
        return currenciesCount;
    }

    public void setCurrenciesCount(Integer currenciesCount) {
        this.currenciesCount = currenciesCount;
    }

    public LocalDateTime getCurrentDate() {
        return todayDate;
    }

    public void setCurrentDate(LocalDateTime todayDate) {
        this.todayDate = todayDate;
    }
}
