package com.example.administrator.movieplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.File;

/**
 * @创建人 Administrator
 * <p>
 * Created by Administrator on 2017/4/13 0013.
 */

public class PlayActivity extends AppCompatActivity {
    private static final String TAG = "PlayActivity";
    private MediaController mController;
    private VideoView mPlay;
    private MediaController mediaController;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play);
        mPlay = (VideoView) findViewById(R.id.play);
        mController = new MediaController(this);
        mPlay.setMediaController(mController);
        File file = new File("/sdcard/Movies/000001.mkv");
        Log.e(TAG, "onCreate: "+file );
     //   final File file2 = new File("/sdcard/Pictures/1.flv");
        if (file.exists()) {
            Toast.makeText(PlayActivity.this,"启动成功",Toast.LENGTH_LONG).show();
            mPlay.setVideoPath(file.getAbsolutePath());
            mPlay.setMediaController(mController);
            mController.setMediaPlayer(mPlay);
            mPlay.start();
        }else {
            Toast.makeText(PlayActivity.this,"启动失败",Toast.LENGTH_LONG).show();
        }
        mPlay.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.start();
                mp.setLooping(true);
            }
        });
        mPlay.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
              //  mPlay.setVideoPath(file2.getAbsolutePath());
                mPlay.start();
            }
        });

    }
}

