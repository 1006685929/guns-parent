package com.stylefeng.guns.rest.modular.cinema.vo;

import com.stylefeng.guns.api.cinema.vo.CinemaInfoVO;
import com.stylefeng.guns.api.cinema.vo.FilmInfoVO;
import lombok.Data;

import java.util.List;

/**
 * Created by hxk
 * 2019/3/15 10:39
 */

@Data
public class CinemaFieldsResponseVO {

    private CinemaInfoVO cinemaInfo;
    private List<FilmInfoVO> filmList;
}
