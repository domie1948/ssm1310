package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;

import com.dao.YiqiDao;
import com.entity.YiqiEntity;
import com.service.YiqiService;
import com.entity.view.YiqiView;

/**
 * 仪器 服务实现类
 * @author 
 * @since 2021-02-26
 */
@Service("yiqiService")
@Transactional
public class YiqiServiceImpl extends ServiceImpl<YiqiDao, YiqiEntity> implements YiqiService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<YiqiView> page =new Query<YiqiView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }

}
