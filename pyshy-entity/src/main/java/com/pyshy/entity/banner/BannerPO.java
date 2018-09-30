package com.pyshy.entity.banner;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "banner")
public class BannerPO {

    /** 主键ID */
    @Id
    @Column(name = "id")
    private Long id;

    /** Banner名称 */
    @Column(name = "name")
    private String name;

    /** 图片 */
    @Column(name = "picture")
    private byte[] picture;

    /** 排序 */
    @Column(name = "sort")
    private Integer sort;

    /** 图片创建时间 */
    @Column(name = "create_time")
    private Date createTime;

    /** 图片创建人 */
    @Column(name = "create_name")
    private String createName;

    /** 图片修改时间 */
    @Column(name = "update_time")
    private Date updateTime;

    /** 图片修改人 */
    @Column(name = "update_name")
    private String updateName;

    /** 状态 */
    @Column(name = "state")
    private Integer state;

//    @Column(name = "width")
//    private Integer width;
//
//    @Column(name = "height")
//    private Integer height;

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

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
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

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateName() {
        return updateName;
    }

    public void setUpdateName(String updateName) {
        this.updateName = updateName;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
