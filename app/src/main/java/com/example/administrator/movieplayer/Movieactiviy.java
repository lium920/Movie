package com.example.administrator.movieplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * @创建人 Administrator
 * <p>
 * Created by Administrator on 2017/4/13 0013.
 */
public class Movieactiviy extends AppCompatActivity implements  MyItemClickListener{
    private static final String TAG ="Movieactiviy" ;

    private RecyclerView mRv;
    private GridLayoutManager mManager;
    private MyAdapter mAdapter;
    private MovieType mFirst;
    private List<MovieItem> mAllNews;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.moive_activity);
        String s = this.getIntent().getStringExtra("data");

        mFirst = DataSupport.findFirst(MovieType.class);

        mFirst.getTypename();
        Log.e(TAG, "initview: "+mFirst.getTypename() );
        mAllNews = DataSupport.findAll(MovieItem.class);
        Log.e(TAG, "onCreate: "+ mAllNews.size());

        initview();
    }

    private void initview() {

        mRv = (RecyclerView) findViewById(R.id.rv);
        mManager = new GridLayoutManager(this, 2);
        mManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRv.setLayoutManager(mManager);
        mAdapter = new MyAdapter(this,mAllNews );
        mRv.setAdapter(mAdapter);
        this.mAdapter.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(View view, int postion) {
      setdataflag(mAllNews.get(postion).getUrls());

    }
    public void setdataflag(String url){
        Intent intent = new Intent(Movieactiviy.this,PlayActivity.class);
        intent.putExtra("url",url);
        startActivity(intent);

    }
}
