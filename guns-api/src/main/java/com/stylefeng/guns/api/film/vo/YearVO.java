package com.stylefeng.guns.api.film.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by hxk
 * 2019/3/8 15:58
 */

@Data
public class YearVO implements Serializable {

    private String yearId;
    private String yearName;
    private boolean isActive;
}
