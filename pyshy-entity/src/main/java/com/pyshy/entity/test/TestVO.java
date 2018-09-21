package com.pyshy.entity.test;

import java.io.Serializable;
import java.util.Date;

public class TestVO implements Serializable{

    private Long id;

    private Long parentId;

    private String category;

    private String addSelect;

    private String errorInfo;

    private Integer state;

    private Date updateTime;

    private String updateStr;

    private String updateName;

    private TestPO param;

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

    public String getUpdateStr() {
        return updateStr;
    }

    public void setUpdateStr(String updateStr) {
        this.updateStr = updateStr;
    }

    public String getUpdateName() {
        return updateName;
    }

    public void setUpdateName(String updateName) {
        this.updateName = updateName;
    }

    public TestPO getParam() {
        return param;
    }

    public void setParam(TestPO param) {
        this.param = param;
    }

}
