package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;

import com.dao.LaoshixinxiDao;
import com.entity.LaoshixinxiEntity;
import com.service.LaoshixinxiService;
import com.entity.view.LaoshixinxiView;

/**
 *  服务实现类
 * @author 
 * @since 2021-02-25
 */
@Service("laoshixinxiService")
@Transactional
public class LaoshixinxiServiceImpl extends ServiceImpl<LaoshixinxiDao, LaoshixinxiEntity> implements LaoshixinxiService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<LaoshixinxiView> page =new Query<LaoshixinxiView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }

}
