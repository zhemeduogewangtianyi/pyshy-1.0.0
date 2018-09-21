package com.pyshy.entity.page.base;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.io.Serializable;
import java.util.LinkedHashMap;

public class BaseParam implements Serializable {

    /**
     * 序列号
     * */
    private  static final long serialVersionUID = 1L;

    /**
     * 排序字段
     * */
    private String sort;

    /**
     * 排序方式
     * */
    private String order;

    private LinkedHashMap<String,SortType> sortMap;

    private Integer rowNo;

    public enum SortType{
        ASC("asc"),DESC("desc");

        String code;

        SortType(String code){
            this.code = code;
        }

        public String getCode(){
            return code;
        }

        public void setCode(String code){
            this.code = code;
        }

        public static SortType getEnum(String code){
            SortType[] sortType = SortType.values();
            for(int i = 0 ; i < sortType.length ; i++){
                if(sortType[i].getCode().equals(code)){
                    return sortType[i];
                }
            }
            return null;
        }
    }

    public LinkedHashMap<String,SortType> getSortMap(){
        return sortMap;
    }

    public void setSortMap(LinkedHashMap<String,SortType> sortMap){
        this.sortMap = sortMap;
    }

    public void addSort(String sort,String order){
        if(StringUtils.isEmpty(order) || StringUtils.isEmpty(sort)){
            return ;
        }
        if(sortMap == null){
            sortMap = new LinkedHashMap<String,SortType>();
        }
        sortMap.put(sort, SortType.getEnum(order));
    }

    public void setSort(String sort){
        this.sort = sort;
        addSort(sort,order);
    }

    public void setOrder(String order){
        this.order = order;
        addSort(sort,order);
    }

    @Override
    public String toString(){
        return ReflectionToStringBuilder.toString(this);
    }
}
