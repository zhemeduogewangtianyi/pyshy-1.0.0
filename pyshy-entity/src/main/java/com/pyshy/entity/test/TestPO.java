package com.pyshy.entity.test;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "test")
public class TestPO implements Serializable{

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "parent_id")
    private Long parentId;

    @Column(name = "category")
    private String category;

    @Column(name = "add_select")
    private String addSelect;

    @Column(name = "error_info")
    private String errorInfo;

    @Column(name = "state")
    private Integer state;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "update_name")
    private String updateName;

//    private String childrenId;

//    private TestPO param;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAddSelect() {
        return addSelect;
    }

    public void setAddSelect(String addSelect) {
        this.addSelect = addSelect;
    }

    public String getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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

//    public String getChildrenId() {
//        return childrenId;
//    }
//
//    public void setChildrenId(String childrenId) {
//        this.childrenId = childrenId;
//    }

//    public TestPO getParam() {
//        return param;
//    }
//
//    public void setParam(TestPO param) {
//        this.param = param;
//    }
}
