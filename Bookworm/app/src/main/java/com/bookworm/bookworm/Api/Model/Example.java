package com.bookworm.bookworm.Api.Model;

/**
 * Created by Valdrin on 2/7/2018.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Example {

    @SerializedName("start")
    @Expose
    private Integer start;
    @SerializedName("numFound")
    @Expose
    private Integer numFound;
    @SerializedName("docs")
    @Expose
    private List<Doc> docs = null;

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getNumFound() {
        return numFound;
    }

    public void setNumFound(Integer numFound) {
        this.numFound = numFound;
    }

    public List<Doc> getDocs() {
        return docs;
    }

    public void setDocs(List<Doc> docs) {
        this.docs = docs;
    }

}