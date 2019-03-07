package com.stylefeng.guns.rest.modular.film;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.api.film.FilmServiceApi;
import com.stylefeng.guns.rest.modular.film.vo.FilmIndexVO;
import com.stylefeng.guns.rest.modular.vo.ResponseVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hxk
 * 2019/3/4 17:29
 */

@RestController
@RequestMapping("/film/")
public class FilmController {

    @Reference(interfaceClass = FilmServiceApi.class)
    private FilmServiceApi filmServiceApi;

    //获取首页信息接口【API聚合】
    /*
        1.功能聚合
           优点：
                1.六个接口，一次请求，同一时刻节省了五次HTTp请求
                2.同一个接口对外暴露，降低了前后端分离开发难度和复杂度
           缺点
                1.一次获取数据过多，容易出现问题
     */
    @RequestMapping(value = "getIndex",method = RequestMethod.GET)
    public ResponseVO getIndex(){

        //测试Lombok
        //BannerVO bannerVO = new BannerVO();
        //bannerVO.getBannerAddress();
        FilmIndexVO filmIndexVO = new FilmIndexVO();

        //获取banner信息
        filmIndexVO.setBanners(filmServiceApi.getBanners());

        //获取正在热映电影
        filmIndexVO.setHotFilms(filmServiceApi.getHotFilms(true,8));

        //即将上映电影
        filmIndexVO.setSoonFilms(filmServiceApi.getSoonFilms(true,8));

        //票房排行榜
        filmIndexVO.setBoxRanking(filmServiceApi.getBoxRanking());

        //获取受欢迎榜单
        filmIndexVO.setExpectRanking(filmServiceApi.getExpectRanking());

        //获取前一百
        filmIndexVO.setTop100(filmServiceApi.getTop());

        return ResponseVO.success(filmIndexVO);
    }
}
