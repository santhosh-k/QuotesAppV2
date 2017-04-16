package net.santhoshk.quotesappv2.model;

import java.util.ArrayList;

/**
 * Created by Sandy on 4/16/2017.
 */

public class Topic {

    private long hitCount;
    private ArrayList<String> categories;
    private String fullTitle;
    private int quotesAvailabe;
    private String title;
    private String thumbUrl;
    private String fullImg;

    public long getHitCount() {
        return hitCount;
    }

    public void setHitCount(long hitCount) {
        this.hitCount = hitCount;
    }

    public ArrayList<String> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<String> categories) {
        this.categories = categories;
    }

    public String getFullTitle() {
        return fullTitle;
    }

    public void setFullTitle(String fullTitle) {
        this.fullTitle = fullTitle;
    }

    public int getQuotesAvailabe() {
        return quotesAvailabe;
    }

    public void setQuotesAvailabe(int quotesAvailabe) {
        this.quotesAvailabe = quotesAvailabe;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public void setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
    }

    public String getFullImg() {
        return fullImg;
    }

    public void setFullImg(String fullImg) {
        this.fullImg = fullImg;
    }

}
