package com.stylefeng.guns.rest.modular.cinema;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.api.cinema.CinemaServiceApi;
import com.stylefeng.guns.api.cinema.vo.*;
import com.stylefeng.guns.api.order.OrderServiceAPI;
import com.stylefeng.guns.rest.modular.cinema.vo.CinemaConditionResponseVO;
import com.stylefeng.guns.rest.modular.cinema.vo.CinemaFieldResponseVO;
import com.stylefeng.guns.rest.modular.cinema.vo.CinemaFieldsResponseVO;
import com.stylefeng.guns.rest.modular.vo.ResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by hxk
 * 2019/3/13 11:16
 */

@Slf4j
@RestController
@RequestMapping("/cinema/")
public class CinemaController {

    @Reference(interfaceClass = CinemaServiceApi.class,connections = 10,cache = "lru",check = false)
    private CinemaServiceApi cinemaServiceApi;

    @Reference(interfaceClass = OrderServiceAPI.class,check = false,group = "order2018")
    private OrderServiceAPI orderServiceAPI;

    private static final String IMG_PRE = "http://img.meetingshop.cn/";

    //获取影院列表接口
    @RequestMapping(value = "getCinemas")
    public ResponseVO getCinemas(CinemaQueryVO cinemaQueryVO){
        try{
            // 按照五个条件进行筛选
            Page<CinemaVO> cinemas = cinemaServiceApi.getCinemas(cinemaQueryVO);
            // 判断是否有满足条件的影院
            if(cinemas.getRecords() == null || cinemas.getRecords().size()==0){
                return ResponseVO.success("没有影院可查");
            }else{
                return ResponseVO.success(cinemas.getCurrent(),(int)cinemas.getPages(),"",cinemas.getRecords());
            }

        }catch (Exception e){
            // 如果出现异常，应该如何处理
            log.error("获取影院列表异常",e);
            return ResponseVO.serviceFail("查询影院列表失败");
        }
    }

    //获取影院列表查询条件
    /*
            1.热点数据 --》 放缓存
            2.banner
     */
    @RequestMapping(value = "getCondition")
    public ResponseVO getCondition(CinemaQueryVO cinemaQueryVO){
        try{
            // 获取三个集合，然后封装成一个对象返回即可
            List<BrandVO> brands = cinemaServiceApi.getBrands(cinemaQueryVO.getBrandId());
            List<AreaVO> areas = cinemaServiceApi.getAreas(cinemaQueryVO.getAreaId());
            List<HallTypeVO> hallTypes = cinemaServiceApi.getHallTypes(cinemaQueryVO.getHalltypeId());

            CinemaConditionResponseVO cinemaConditionResponseVO = new CinemaConditionResponseVO();
            cinemaConditionResponseVO.setAreaList(areas);
            cinemaConditionResponseVO.setBrandList(brands);
            cinemaConditionResponseVO.setHalltypeList(hallTypes);

            return ResponseVO.success(cinemaConditionResponseVO);
        }catch (Exception e) {
            log.error("获取条件列表失败", e);
            return ResponseVO.serviceFail("获取影院查询条件失败");
        }
    }

    //获取播放场次列表接口
    @RequestMapping(value = "getFields")
    public ResponseVO getFields(Integer cinemaId){
        try{

            CinemaInfoVO cinemaInfoById = cinemaServiceApi.getCinemaInfoById(cinemaId);

            List<FilmInfoVO> filmInfoByCinemaId = cinemaServiceApi.getFilmInfoByCinemaId(cinemaId);

            CinemaFieldsResponseVO cinemaFieldResponseVO = new CinemaFieldsResponseVO();
            cinemaFieldResponseVO.setCinemaInfo(cinemaInfoById);
            cinemaFieldResponseVO.setFilmList(filmInfoByCinemaId);

            return ResponseVO.success(IMG_PRE,cinemaFieldResponseVO);
        }catch (Exception e){
            log.error("获取播放场次失败",e);
            return ResponseVO.serviceFail("获取播放场次失败");
        }
    }

    //获得场次详细接口
    @RequestMapping(value = "getFieldInfo",method = RequestMethod.POST)
    public ResponseVO getFieldInfo(Integer cinemaId,Integer fieldId){
        try{

            CinemaInfoVO cinemaInfoById = cinemaServiceApi.getCinemaInfoById(cinemaId);
            FilmInfoVO filmInfoByFieldId = cinemaServiceApi.getFilmInfoByFieldId(fieldId);
            HallInfoVO filmFieldInfo = cinemaServiceApi.getFilmFieldInfo(fieldId);

            // 造几个销售的假数据，后续会对接订单接口
            filmFieldInfo.setSoldSeats(orderServiceAPI.getSoldSeatsByFieldId(fieldId));

            CinemaFieldResponseVO cinemaFieldResponseVO = new CinemaFieldResponseVO();
            cinemaFieldResponseVO.setCinemaInfo(cinemaInfoById);
            cinemaFieldResponseVO.setFilmInfo(filmInfoByFieldId);
            cinemaFieldResponseVO.setHallInfo(filmFieldInfo);

            return ResponseVO.success(IMG_PRE,cinemaFieldResponseVO);
        }catch (Exception e){
            log.error("获取选座信息失败了",e);
            return ResponseVO.serviceFail("获取选座信息失败");
        }
    }
}
