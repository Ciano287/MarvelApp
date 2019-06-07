
package com.example.marvelapp.comics;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {

    @SerializedName("offset")
    private Integer offset;
    @SerializedName("limit")
    private Integer limit;
    @SerializedName("total")
    private Integer total;
    @SerializedName("count")
    private Integer count;
    @SerializedName("results")
    private List<ComicResult> comicResults = null;

    public Integer getOffset() {
        return offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public Integer getTotal() {
        return total;
    }

    public Integer getCount() {
        return count;
    }

    public List<ComicResult> getComicResults() {
        return comicResults;
    }

}
