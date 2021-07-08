package com.example.portfolio_3;

public class dayList {
    private String diary;
    private String day;
    private int num;
    public dayList(){}

    public String getDiary() {
        return diary;
    }

    public void setDiary(String diary) {
        this.diary = diary;
    }
    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
    public dayList(String diary, String day){
        this.diary = diary;
        this.day = day;
    }
}
