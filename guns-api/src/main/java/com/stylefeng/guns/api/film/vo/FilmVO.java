package com.stylefeng.guns.api.film.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by hxk
 * 2019/3/5 10:36
 */

@Data
public class FilmVO implements Serializable{

    private int filmNum;
    private int nowPage;
    private int totalPage;
    private List<FilmInfo> filmInfo;
}
