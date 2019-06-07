
package com.example.marvelapp.comics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;

public class ComicResult {

    @SerializedName("id")
    private Integer id;
    @SerializedName("digitalId")
    private Integer digitalId;
    @SerializedName("title")
    private String title;
    @SerializedName("issueNumber")
    private Integer issueNumber;
    @SerializedName("variantDescription")
    private String variantDescription;
    @SerializedName("description")
    private String description;
    @SerializedName("modified")
    private String modified;
    @SerializedName("isbn")
    private String isbn;
    @SerializedName("upc")
    private String upc;
    @SerializedName("diamondCode")
    private String diamondCode;
    @SerializedName("ean")
    private String ean;
    @SerializedName("issn")
    private String issn;
    @SerializedName("format")
    private String format;
    @SerializedName("pageCount")
    private Integer pageCount;
    @SerializedName("textObjects")
    private List<TextObject> textObjects = null;
    @SerializedName("resourceURI")
    private String resourceURI;
    @SerializedName("urls")
    private List<Url> urls = null;
    @SerializedName("series")
    private Series series;
    @SerializedName("variants")
    private List<Object> variants = null;
    @SerializedName("collections")
    private List<Object> collections = null;
    @SerializedName("collectedIssues")
    private List<Object> collectedIssues = null;
    @SerializedName("dates")
    private List<Date> dates = null;
    @SerializedName("prices")
    private List<Price> prices = null;
    @SerializedName("thumbnail")
    private Thumbnail thumbnail;
    @SerializedName("images")
    private List<Image> images = null;
    @SerializedName("creators")
    private Creators creators;
    @SerializedName("characters")
    private Characters characters;
    @SerializedName("stories")
    private Stories stories;
    @SerializedName("events")
    private Events events;

    public Integer getId() {
        return id;
    }

    public Integer getDigitalId() {
        return digitalId;
    }

    public String getTitle() {
        return title;
    }

    public Integer getIssueNumber() {
        return issueNumber;
    }

    public String getVariantDescription() {
        return variantDescription;
    }

    public String getDescription() {
        return description;
    }

    public String getModified() {
        return modified;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getUpc() {
        return upc;
    }

    public String getDiamondCode() {
        return diamondCode;
    }

    public String getEan() {
        return ean;
    }

    public String getIssn() {
        return issn;
    }

    public String getFormat() {
        return format;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public List<TextObject> getTextObjects() {
        return textObjects;
    }

    public String getResourceURI() {
        return resourceURI;
    }

    public List<Url> getUrls() {
        return urls;
    }

    public Series getSeries() {
        return series;
    }

    public List<Object> getVariants() {
        return variants;
    }

    public List<Object> getCollections() {
        return collections;
    }

    public List<Object> getCollectedIssues() {
        return collectedIssues;
    }

    public List<Date> getDates() {
        return dates;
    }

    public List<Price> getPrices() {
        return prices;
    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public List<Image> getImages() {
        return images;
    }

    public Creators getCreators() {
        return creators;
    }

    public Characters getCharacters() {
        return characters;
    }

    public Stories getStories() {
        return stories;
    }

    public Events getEvents() {
        return events;
    }

}

