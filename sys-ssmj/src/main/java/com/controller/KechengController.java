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

import com.entity.KechengEntity;

import com.service.KechengService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 课程表
 * 后端接口
 * @author
 * @email
 * @date 2021-02-26
*/
@RestController
@Controller
@RequestMapping("/kecheng")
public class KechengController {
    private static final Logger logger = LoggerFactory.getLogger(KechengController.class);

    @Autowired
    private KechengService kechengService;

    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",page方法");
        Object role = request.getSession().getAttribute("role");
        PageUtils page = null;
        if(role.equals("老师")){
            params.put("yh",request.getSession().getAttribute("userId"));
            page = kechengService.queryPage(params);
        }else{
            page = kechengService.queryPage(params);
        }
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("Controller:"+this.getClass().getName()+",info方法");
        KechengEntity kecheng = kechengService.selectById(id);
        if(kecheng!=null){
            return R.ok().put("data", kecheng);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody KechengEntity kecheng, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",save");
        Wrapper<KechengEntity> queryWrapper = new EntityWrapper<KechengEntity>()
            .eq("name", kecheng.getName())
            .eq("course", kecheng.getCourse())
            .eq("ls_types", kecheng.getLsTypes())
            .eq("finish_time", kecheng.getFinishTime())
            .eq("attend_time", kecheng.getAttendTime())
            .eq("zy_types", kecheng.getZyTypes())
            .eq("notice_content", kecheng.getNoticeContent())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        KechengEntity kechengEntity = kechengService.selectOne(queryWrapper);

        //获取上课时间分钟数
        int minutes = kecheng.getAttendTime().getMinutes();
        //获取上课时间小时数
        int hours = kecheng.getAttendTime().getHours();

        //获取下课时间分钟数
        int minutes1 = kecheng.getFinishTime().getMinutes();
        //获取下课时间小时数
        int hours1 = kecheng.getFinishTime().getHours();

        if(hours == hours1 && minutes1==minutes){
            return R.error("下课时间、上课时间不能相等");
        }

        if(kechengEntity==null){
            if(hours1 == hours){
                kecheng.setCourse(minutes1-minutes+"分钟");
                kechengService.insert(kecheng);
                return R.ok();
            }

            if(hours1 > hours){
                kecheng.setCourse(((hours1*60)+minutes1) - ((hours*60)+minutes)+"分钟");
                kechengService.insert(kecheng);
                return R.ok();
            }
            return R.error();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody KechengEntity kecheng, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",update");
        //根据字段查询是否有相同数据
        Wrapper<KechengEntity> queryWrapper = new EntityWrapper<KechengEntity>()
            .notIn("id",kecheng.getId())
            .eq("name", kecheng.getName())
            .eq("course", kecheng.getCourse())
            .eq("ls_types", kecheng.getLsTypes())
            .eq("zy_types", kecheng.getZyTypes())
            .eq("notice_content", kecheng.getNoticeContent())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        KechengEntity kechengEntity = kechengService.selectOne(queryWrapper);
        //获取上课时间分钟数
        int minutes = kecheng.getAttendTime().getMinutes();
        //获取上课时间小时数
        int hours = kecheng.getAttendTime().getHours();

        //获取下课时间分钟数
        int minutes1 = kecheng.getFinishTime().getMinutes();
        //获取下课时间小时数
        int hours1 = kecheng.getFinishTime().getHours();

        if(hours == hours1 && minutes1==minutes){
            return R.error("下课时间、上课时间不能相等");
        }

        if(kechengEntity==null){
            if(hours1 == hours){
                kecheng.setCourse(minutes1-minutes+"分钟");
                kechengService.updateById(kecheng);
                return R.ok();
            }

            if(hours1 > hours){
                kecheng.setCourse(((hours1*60)+minutes1) - ((hours*60)+minutes)+"分钟");
                kechengService.updateById(kecheng);
                return R.ok();
            }
            return R.error();
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
        kechengService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}

