package com.pyshy.entity.banner;

import java.awt.*;
import java.io.Serializable;
import java.util.Date;

public class BannerVO implements Serializable{

    /** 主键ID */
    private Long id;

    /** Banner名称 */
    private String name;

    /** 图片 */
    private byte[] picture;

    private Image pictureImage;

    /** 排序 */
    private Integer sort;

    /** 图片创建时间 */
    private Date createTime;
    private String createTimeStr;

    /** 图片创建人 */
    private String createName;

    /** 图片修改时间 */
    private Date updateTime;
    private String updateTimeStr;

    /** 图片修改人 */
    private String updateName;

    private Integer state;

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

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public void setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
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

    public String getUpdateTimeStr() {
        return updateTimeStr;
    }

    public void setUpdateTimeStr(String updateTimeStr) {
        this.updateTimeStr = updateTimeStr;
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

    public Image getPictureImage() {
        return pictureImage;
    }

    public void setPictureImage(Image pictureImage) {
        this.pictureImage = pictureImage;
    }
}
