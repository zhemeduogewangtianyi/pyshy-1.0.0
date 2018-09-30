package com.pyshy.entity.banner;

import com.pyshy.entity.page.PageQueryParam;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

public class BannerParam extends PageQueryParam {

    /** 主键ID */
    private Long id;

    /** Banner名称 */
    private String name;

    /** 排序 */
    private Integer sort;

    /** 图片创建时间 */
    private Date createTime;

    /** 图片修改时间 */
    private Date updateTime;

    /** 状态 */
    private String state;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
