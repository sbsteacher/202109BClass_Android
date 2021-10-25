package com.koreait.first.ch10.searchmoviemodel;

import java.util.List;

public class MovieInfoVO {
    private String movieNm;
    private String movieNmEn;
    private String showTm;
    private List<ActorVO> actors;

    public String getMovieNm() {
        return movieNm;
    }

    public void setMovieNm(String movieNm) {
        this.movieNm = movieNm;
    }

    public String getMovieNmEn() {
        return movieNmEn;
    }

    public void setMovieNmEn(String movieNmEn) {
        this.movieNmEn = movieNmEn;
    }

    public String getShowTm() {
        return showTm;
    }

    public void setShowTm(String showTm) {
        this.showTm = showTm;
    }

    public List<ActorVO> getActors() {
        return actors;
    }

    public void setActors(List<ActorVO> actors) {
        this.actors = actors;
    }
}
