package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.LaoshixinxiEntity;
import java.util.Map;

/**
 *  服务类
 * @author 
 * @since 2021-02-25
 */
public interface LaoshixinxiService extends IService<LaoshixinxiEntity> {

     PageUtils queryPage(Map<String, Object> params);

}