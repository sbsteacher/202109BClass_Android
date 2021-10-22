package com.koreait.first.ch10.searchmoviemodel;

import java.util.List;

public class MovieListResultVO {
    private int totCnt;
    private List<MovieVO> movieList;

    public int getTotCnt() {
        return totCnt;
    }

    public void setTotCnt(int totCnt) {
        this.totCnt = totCnt;
    }

    public List<MovieVO> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<MovieVO> movieList) {
        this.movieList = movieList;
    }
}
