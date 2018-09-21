package com.pyshy.entity.page;

import com.pyshy.entity.page.base.BaseParam;

import java.io.Serializable;

public class PageQueryParam extends BaseParam implements Serializable{

    private static final long serialVersionUID = 1L;

    /**  默认分页大小 */
    private static final int DEFAULT_LIMIT = 10;

    /** 默认索引位置 */
    private static final int DEFAULT_OFFSET = 0;

    /** 默认当前页 */
    private static final int DEFAULT_CURRENT_PAGE = 1;

    /** 分页大小 */
    private Integer limit = null;

    /** 索引位置 */
    private Integer offset = null;

    /** 当前页 */
    private Integer currentPage = null;

    /** 获取分页大小 */
    public int getLimit(){
        if(limit == null){
            return DEFAULT_LIMIT;
        }
        return limit;
    }

    /** 获取分页大小 */
    public Integer getPageSize(){
        return getLimit();
    }

    /** 获取索引位置 */
    public int getOffset(){
        if(offset != null){
            return offset;
        }
        if(currentPage != null){
            return (currentPage - 1) * getLimit();
        }
        return DEFAULT_OFFSET;
    }

    /** 获取当前页 */
    public int getCurrentPage(){
        if(currentPage != null){
            return currentPage;
        }
        if(offset != null){
            return offset / getLimit() + 1;
        }
        return DEFAULT_CURRENT_PAGE;
    }

    public void setLimit(int limit){
        this.limit = limit;
    }

    public void setOffset(int offset){
        this.offset = offset;
    }

    public void setPageSize(Integer pageSize){
        this.limit = pageSize;
    }

    public void setStart(int start){
        this.offset = start - 1 ;
    }

    public void setCurrentPage(Integer currentPage){
        this.currentPage = currentPage;
    }

}
