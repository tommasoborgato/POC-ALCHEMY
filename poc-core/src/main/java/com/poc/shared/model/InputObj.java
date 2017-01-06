package com.poc.shared.model;

import java.util.List;

/**
 * Created by icttb0 on 06/12/2016.
 */
public class InputObj {
    private long id;
    private String content;
    private List<InputObjElem> inputObjElems;

    public InputObj() {
    }

    public InputObj(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public List<InputObjElem> getInputObjElems() {
        return inputObjElems;
    }

    public void setInputObjElems(List<InputObjElem> inputObjElems) {
        this.inputObjElems = inputObjElems;
    }
}
