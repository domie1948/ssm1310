package com.entity.vo;

import com.entity.ZhuanyeEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 专业
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-02-26
 */
@TableName("zhuanye")
public class ZhuanyeVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 专业名称 Search
     */

    @TableField(value = "serial")
    private String serial;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：专业名称 Search
	 */
    public String getSerial() {
        return serial;
    }


    /**
	 * 获取：专业名称 Search
	 */

    public void setSerial(String serial) {
        this.serial = serial;
    }

}
