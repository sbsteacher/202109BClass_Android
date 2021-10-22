package com.koreait.first.ch10.boxofficemodel;

import java.util.List;

public class BoxOfficeResultVO {
    private String boxofficeType;
    private String showRange;
    private List<BoxOfficeVO> dailyBoxOfficeList;

    private String yearWeekTime;
    private List<BoxOfficeVO> weeklyBoxOfficeList;

    public String getYearWeekTime() {
        return yearWeekTime;
    }

    public void setYearWeekTime(String yearWeekTime) {
        this.yearWeekTime = yearWeekTime;
    }

    public List<BoxOfficeVO> getWeeklyBoxOfficeList() {
        return weeklyBoxOfficeList;
    }

    public void setWeeklyBoxOfficeList(List<BoxOfficeVO> weeklyBoxOfficeList) {
        this.weeklyBoxOfficeList = weeklyBoxOfficeList;
    }

    public String getBoxofficeType() {
        return boxofficeType;
    }

    public void setBoxofficeType(String boxofficeType) {
        this.boxofficeType = boxofficeType;
    }

    public String getShowRange() {
        return showRange;
    }

    public void setShowRange(String showRange) {
        this.showRange = showRange;
    }

    public List<BoxOfficeVO> getDailyBoxOfficeList() {
        return dailyBoxOfficeList;
    }

    public void setDailyBoxOfficeList(List<BoxOfficeVO> dailyBoxOfficeList) {
        this.dailyBoxOfficeList = dailyBoxOfficeList;
    }
}
