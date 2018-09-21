package com.pyshy.common.baseEnum;

public enum SourceEnum {
    MANAGER("/manager"),
    ;

    private String source;

    SourceEnum(String source) {
        this.source = source;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
