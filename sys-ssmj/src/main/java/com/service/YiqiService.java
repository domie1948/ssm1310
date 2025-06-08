package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YiqiEntity;
import java.util.Map;

/**
 * 仪器 服务类
 * @author 
 * @since 2021-02-26
 */
public interface YiqiService extends IService<YiqiEntity> {

     PageUtils queryPage(Map<String, Object> params);

}