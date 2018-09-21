package com.pyshy.entity.picture;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "picture")
public class PicturePO {

    /** 主键ID */
    @Id
    @Column(name = "id")
    private Long id;

    /** 图片名称 */
    @Column(name = "picture_name")
    private String pictureName;

    /** 图片作者 */
    @Column(name = "author")
    private String author;

    /** 图片描述 */
    @Column(name = "remark")
    private String remark;

    /** 图片描述 */
    @Column(name = "content")
    private String content;

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

    /** 图片地址 */
    @Column(name = "img_url")
    private String imgUrl;

    /** 图片状态 0展示中 1未展示 */
    @Column(name = "state")
    private Integer state;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
