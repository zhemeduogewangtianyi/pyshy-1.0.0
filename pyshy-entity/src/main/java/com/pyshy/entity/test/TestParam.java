package com.pyshy.entity.test;

import com.pyshy.entity.page.PageQueryParam;

public class TestParam extends PageQueryParam{

    private String category;

    private String addSelect;

    private Integer state;

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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
