package com.koreait.first.ch10;

import com.koreait.first.ch10.boxofficemodel.BoxOfficeResultBodyVO;
import com.koreait.first.ch10.searchmoviemodel.MovieInfoResultBodyVO;
import com.koreait.first.ch10.searchmoviemodel.MovieListResultBodyVO;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface KobisService {

    //일별 박스오피스
    @GET("boxoffice/searchDailyBoxOfficeList.json")
    Call<BoxOfficeResultBodyVO> boxofficeSearchDailyBoxOfficeList
        (@Query("key") String key, @Query("targetDt") String targetDt);


    //주간 박스오피스 (디폴트: 주말)
    @GET("boxoffice/searchWeeklyBoxOfficeList.json?weekGb=0")
    Call<BoxOfficeResultBodyVO> searchWeeklyBoxOfficeList
    (@Query("key") String key, @Query("targetDt") String targetDt);

    //https://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=1a0a7ecf96ad3364d8de70e91560767a&targetDt=20201021
    //https://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchWeeklyBoxOfficeList.json?key=1a0a7ecf96ad3364d8de70e91560767a&targetDt=20201021

    //영화 목록
    @GET("movie/searchMovieList.json")
    Call<MovieListResultBodyVO> searchMovieList(@Query("key") String key
            , @Query("itemPerPage") String itemPerPage, @Query("curPage") int curPage);


    //영화 디테일
    @GET("movie/searchMovieInfo.json")
    Call<MovieInfoResultBodyVO> searchMovieInfo(@Query("key") String key, @Query("movieCd") String asdfasdf);

}
