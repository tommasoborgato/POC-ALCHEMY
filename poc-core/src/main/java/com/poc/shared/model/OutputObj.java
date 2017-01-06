package com.poc.shared.model;

import java.util.List;

/**
 * Created by icttb0 on 06/12/2016.
 */
public class OutputObj {
    private long id;
    private String content;
    private List<OutputObjElem> outputObjElems;

    public OutputObj(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public List<OutputObjElem> getOutputObjElems() {
        return outputObjElems;
    }

    public void setOutputObjElems(List<OutputObjElem> outputObjElems) {
        this.outputObjElems = outputObjElems;
    }
}
