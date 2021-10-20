package com.koreait.first.ch10;

import java.util.List;

public class BoxOfficeResultVO {
    private String boxofficeType;
    private String showRange;
    private List<DailyBoxOfficeVO> dailyBoxOfficeList;

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

    public List<DailyBoxOfficeVO> getDailyBoxOfficeList() {
        return dailyBoxOfficeList;
    }

    public void setDailyBoxOfficeList(List<DailyBoxOfficeVO> dailyBoxOfficeList) {
        this.dailyBoxOfficeList = dailyBoxOfficeList;
    }
}
