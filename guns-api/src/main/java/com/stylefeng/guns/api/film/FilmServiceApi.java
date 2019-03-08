package com.stylefeng.guns.api.film;

import com.stylefeng.guns.api.film.vo.*;

import java.util.List;

public interface FilmServiceApi {

    //获取banners
    List<BannerVO> getBanners();

    //获取热映影片
    FilmVO getHotFilms(boolean isLimit,int nums);

    //获取即上映影片【按照欢迎度排序】
    FilmVO getSoonFilms(boolean isLimit,int nums);

    //获取票房排行榜
    List<FilmInfo> getBoxRanking();

    //获取人气排行榜
    List<FilmInfo> getExpectRanking();

    //获取Top100
    List<FilmInfo> getTop();


    //获取影片条件接口
    //分类条件
    List<CatVO> getCats();

    //片源条件
    List<SourceVO> getSources();

    //获取年代条件
    List<YearVO> getYears();
}
