package com.example.administrator.movieplayer;

import org.litepal.crud.DataSupport;

/**
 * @创建人 Administrator
 * <p>
 * Created by Administrator on 2017/4/13 0013.
 */

public class MovieItem extends DataSupport {
    private String moviename;
    private String urls;
    private  int  adess;

    public String getUrls() {
        return urls;
    }

    public void setUrls(String urls) {
        this.urls = urls;
    }

    public String getMoviename() {
        return moviename;
    }

    public void setMoviename(String moviename) {
        this.moviename = moviename;
    }

    public int getAdess() {
        return adess;
    }

    public void setAdess(int adess) {
        this.adess = adess;
    }
}
