package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.KechengEntity;
import java.util.Map;

/**
 * 课程表 服务类
 * @author 
 * @since 2021-02-26
 */
public interface KechengService extends IService<KechengEntity> {

     PageUtils queryPage(Map<String, Object> params);

}