package com.example.administrator.movieplayer;

import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * @创建人 Administrator
 * <p>
 * Created by Administrator on 2017/4/13 0013.
 */

public class MovieType extends DataSupport {
    private String  typename ;
    private List<MovieItem> list;

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public List<MovieItem> getList() {
        return list;
    }

    public void setList(List<MovieItem> list) {
        this.list = list;
    }
}
