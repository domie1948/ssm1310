package com.controller;

import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.YiqiEntity;

import com.service.YiqiService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 仪器
 * 后端接口
 * @author
 * @email
 * @date 2021-02-26
*/
@RestController
@Controller
@RequestMapping("/yiqi")
public class YiqiController {
    private static final Logger logger = LoggerFactory.getLogger(YiqiController.class);

    @Autowired
    private YiqiService yiqiService;

    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params){
        logger.debug("Controller:"+this.getClass().getName()+",page方法");
        PageUtils page = yiqiService.queryPage(params);
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("Controller:"+this.getClass().getName()+",info方法");
        YiqiEntity yiqi = yiqiService.selectById(id);
        if(yiqi!=null){
            return R.ok().put("data", yiqi);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody YiqiEntity yiqi, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",save");
        Wrapper<YiqiEntity> queryWrapper = new EntityWrapper<YiqiEntity>()
            .eq("serial", yiqi.getSerial())
            .eq("lx_types", yiqi.getLxTypes())
            .eq("zy_types", yiqi.getZyTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YiqiEntity yiqiEntity = yiqiService.selectOne(queryWrapper);
        if(yiqiEntity==null){
            yiqiService.insert(yiqi);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody YiqiEntity yiqi, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",update");
        //根据字段查询是否有相同数据
        Wrapper<YiqiEntity> queryWrapper = new EntityWrapper<YiqiEntity>()
            .notIn("id",yiqi.getId())
            .eq("serial", yiqi.getSerial())
            .eq("lx_types", yiqi.getLxTypes())
            .eq("zy_types", yiqi.getZyTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YiqiEntity yiqiEntity = yiqiService.selectOne(queryWrapper);
        if(yiqiEntity==null){
            yiqiService.updateById(yiqi);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        logger.debug("Controller:"+this.getClass().getName()+",delete");
        yiqiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}

