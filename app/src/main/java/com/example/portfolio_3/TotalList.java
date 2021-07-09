package com.example.portfolio_3;

public class TotalList {
    private int total_month;
    private int total;
    public TotalList(){}
    public int getTotal_month() {
        return total_month;
    }

    public void setTotal_month(int total_month) {
        this.total_month = total_month;
    }
    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    public TotalList(int total, int total_month){
        this.total = total;
        this.total_month = total_month;
    }
}
