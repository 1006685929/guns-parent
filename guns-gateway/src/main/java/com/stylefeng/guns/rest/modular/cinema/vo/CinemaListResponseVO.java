package com.stylefeng.guns.rest.modular.cinema.vo;

import com.stylefeng.guns.api.cinema.vo.CinemaVO;
import lombok.Data;

import java.util.List;

/**
 * Created by hxk
 * 2019/3/15 10:31
 */

@Data
public class CinemaListResponseVO {

    private List<CinemaVO> cinemas;
}
