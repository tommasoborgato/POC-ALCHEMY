package com.poc.shared.model;

/**
 * Created by icttb0 on 15/12/2016.
 */
public class OutputObjElem {
    private long id;
    private String content;

    public OutputObjElem() {
    }

    public OutputObjElem(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
