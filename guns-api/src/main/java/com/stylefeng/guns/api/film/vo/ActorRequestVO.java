package com.stylefeng.guns.api.film.vo;

import com.stylefeng.guns.api.film.vo.ActorVO;
import lombok.Data;

import java.util.List;

/**
 * Created by hxk
 * 2019/3/10 17:44
 */

@Data
public class ActorRequestVO {

    private ActorVO director;
    private List<ActorVO> actors;
}
