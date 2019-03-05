package com.stylefeng.guns.rest.modular.film.vo;

import lombok.Data;

import java.util.List;

/**
 * Created by hxk
 * 2019/3/5 10:36
 */

@Data
public class FilmVO {

    private int filmNum;
    private List<FilmInfo> filmInfo;
}
