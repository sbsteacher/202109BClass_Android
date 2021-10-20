package com.koreait.first.ch10;

public class DailyBoxOfficeVO {
    private String rank; //순위
    private String movieNm; //영화명
    private String openDt; //개봉일

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getMovieNm() {
        return movieNm;
    }

    public void setMovieNm(String movieNm) {
        this.movieNm = movieNm;
    }

    public String getOpenDt() {
        return openDt;
    }

    public void setOpenDt(String openDt) {
        this.openDt = openDt;
    }
}
