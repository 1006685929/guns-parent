package com.stylefeng.guns.rest.modular.film.vo;

import lombok.Data;

/**
 * Created by hxk
 * 2019/3/5 10:46
 */

@Data
public class FilmInfo {

    private String filmId;
    private int filmType;
    private String imgAddress;
    private String filmName;
    private String filmScore;
    private int expectNum;
    private String showTime;
    private int boxNum;
    private String score;
}
