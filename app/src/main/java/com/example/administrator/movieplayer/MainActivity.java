package com.example.administrator.movieplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class    MainActivity extends AppCompatActivity implements View.OnClickListener{
    private static int flag=1;
    private static final String TAG = "MainActivity";
    private TextView mText;
    private Button mBt;
    private MovieItem mMovieItem;
    private ImageButton mButton1;
    private ImageButton mButton2;
    private ImageButton mButton3;
    private ImageButton mButton4;
    private ImageButton mButton5;
    private ImageButton mButton6;
    private ImageButton mButton7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         initview();

    }

    private void initview() {
        mButton1 = (ImageButton) findViewById(R.id.image1);
        mButton2 = (ImageButton) findViewById(R.id.image2);
        mButton3 = (ImageButton) findViewById(R.id.image3);
        mButton4 = (ImageButton) findViewById(R.id.image4);
        mButton5 = (ImageButton) findViewById(R.id.image5);
        mButton6 = (ImageButton) findViewById(R.id.image6);
        mButton7 = (ImageButton) findViewById(R.id.image7);
        mButton1.setOnClickListener(this);
        mButton2.setOnClickListener(this);
        mButton3.setOnClickListener(this);
        mButton4.setOnClickListener(this);
        mButton5.setOnClickListener(this);
        mButton6.setOnClickListener(this);
        mButton7.setOnClickListener(this);
        initdata();

    }

    private void initdata() {
        if (flag==1){
            MovieItem item1 = new MovieItem();
            item1.setMoviename("时光游戏1");
            item1.setUrls("111");
            item1.setAdess(R.drawable.image1);
            item1.save();
            MovieItem item2 = new MovieItem();
            item2.setMoviename("时光游戏2");
            item2.setUrls("111");
            item2.setAdess(R.drawable.image2);
            item2.save();
            MovieItem item3 = new MovieItem();
            item3.setMoviename("时光游戏3");
            item3.setUrls("111");
            item3.setAdess(R.drawable.image3);
            item3.save();
            MovieItem item4 = new MovieItem();
            item4.setMoviename("时光游戏4");
               item4.setUrls("111");
            item4.setAdess(R.drawable.image4);
            item4.save();
            MovieItem item5 = new MovieItem();
            item5.setMoviename("时光游戏5");
            item5.setUrls("111");
            item5.setAdess(R.drawable.image5);
            item5.save();
            MovieItem item6 = new MovieItem();
            item6.setMoviename("时光游戏6");
            item6.setUrls("111");
            item6.setAdess(R.drawable.image6);
            item6.save();
            MovieItem item7 = new MovieItem();
            item7.setMoviename("时光游戏7");
            item7.setUrls("111");
            item7.setAdess(R.drawable.image7);
            item7.save();
            MovieItem item8 = new MovieItem();
            item8.setMoviename("时光游戏8");
            item8.setUrls("111");
            item8.setAdess(R.drawable.image8);
            item8.save();
            MovieItem item9 = new MovieItem();
            item9.setMoviename("时光游戏9");
            item9.setUrls("111");
            item9.setAdess(R.drawable.image9);
            item9.save();
            MovieItem item10= new MovieItem();
            item10.setMoviename("时光游戏10");
            item10.setUrls("111");
            item10.setAdess(R.drawable.image10);
            item10.save();
            List<MovieItem>list =new ArrayList<>();
            list.add(item1);
            list.add(item2);
            list.add(item3);
            list.add(item4);
            list.add(item5);
            list.add(item6);
            list.add(item7);
            list.add(item8);
            list.add(item9);
            list.add(item10);
            MovieType type = new MovieType();
            type.setTypename("港台");
            type.setList(list);
            Log.e(TAG, "initdata: "+type.getList().size() );
            type.save();
            if (type.save()){
                Toast.makeText(MainActivity.this,"保存成功",Toast.LENGTH_LONG).show();

            }else {
                Toast.makeText(MainActivity.this,"保存失败",Toast.LENGTH_LONG).show();
            }
            flag++;
        }


    }

    public  void click(View view){
        mText.setText(mMovieItem.getMoviename());

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case  R.id.image1:
                setdataflag("1");

                break;
            case  R.id.image2:
                setdataflag("2");
                break;
            case  R.id.image3:
                setdataflag("3");
                break;
            case  R.id.image4:
                setdataflag("4");
                break;
            case  R.id.image5:
                setdataflag("5");
                break;
            case  R.id.image6:
                setdataflag("6");
                break;
            case  R.id.image7:
                setdataflag("7");
                break;
        }

    }
    public void setdataflag(String data){
        Intent intent = new Intent(MainActivity.this,Movieactiviy.class);
        intent.putExtra("data",data);
        startActivity(intent);

    }
}
