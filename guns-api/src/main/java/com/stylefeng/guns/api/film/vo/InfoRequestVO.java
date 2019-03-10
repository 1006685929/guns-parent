package com.stylefeng.guns.api.film.vo;

import com.stylefeng.guns.api.film.vo.ImgVO;
import lombok.Data;

/**
 * Created by hxk
 * 2019/3/10 17:45
 */

@Data
public class InfoRequestVO {

    private String biography;
    private ActorRequestVO actors;
    private ImgVO imgVO;
    private String filmId;
}
