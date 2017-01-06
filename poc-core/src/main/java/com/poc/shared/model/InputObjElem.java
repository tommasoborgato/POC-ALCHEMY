package com.poc.shared.model;

/**
 * Created by icttb0 on 06/12/2016.
 */
public class InputObjElem {
    private long id;
    private String content;

    public InputObjElem() {
    }

    public InputObjElem(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
