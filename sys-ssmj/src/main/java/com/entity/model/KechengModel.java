package com.entity.model;

import com.entity.KechengEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 课程表
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-02-26
 */
public class KechengModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 课程名称 Search
     */
    private String name;


    /**
     * 上课时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date attendTime;


    /**
     * 下课时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date finishTime;


    /**
     * 课程时间
     */
    private String course;


    /**
     * 负责老师 Search
     */
    private Integer lsTypes;


    /**
     * 专业 Search
     */
    private Integer zyTypes;


    /**
     * 具体内容
     */
    private String noticeContent;


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
	 * 设置：课程名称 Search
	 */
    public String getName() {
        return name;
    }


    /**
	 * 获取：课程名称 Search
	 */

    public void setName(String name) {
        this.name = name;
    }
    /**
	 * 设置：上课时间
	 */
    public Date getAttendTime() {
        return attendTime;
    }


    /**
	 * 获取：上课时间
	 */

    public void setAttendTime(Date attendTime) {
        this.attendTime = attendTime;
    }
    /**
	 * 设置：下课时间
	 */
    public Date getFinishTime() {
        return finishTime;
    }


    /**
	 * 获取：下课时间
	 */

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }
    /**
	 * 设置：课程时间
	 */
    public String getCourse() {
        return course;
    }


    /**
	 * 获取：课程时间
	 */

    public void setCourse(String course) {
        this.course = course;
    }
    /**
	 * 设置：负责老师 Search
	 */
    public Integer getLsTypes() {
        return lsTypes;
    }


    /**
	 * 获取：负责老师 Search
	 */

    public void setLsTypes(Integer lsTypes) {
        this.lsTypes = lsTypes;
    }
    /**
	 * 设置：专业 Search
	 */
    public Integer getZyTypes() {
        return zyTypes;
    }


    /**
	 * 获取：专业 Search
	 */

    public void setZyTypes(Integer zyTypes) {
        this.zyTypes = zyTypes;
    }
    /**
	 * 设置：具体内容
	 */
    public String getNoticeContent() {
        return noticeContent;
    }


    /**
	 * 获取：具体内容
	 */

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    }
