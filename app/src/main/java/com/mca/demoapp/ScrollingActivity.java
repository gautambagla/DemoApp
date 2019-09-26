package com.mca.demoapp;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.widget.VideoView;

public class ScrollingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String str = "Double Tap on Video to Play";
        Toast.makeText(getApplicationContext(), str, Toast.LENGTH_LONG).show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void play(View view) {

        VideoView videoView1 = (VideoView) findViewById(R.id.video_view);
        VideoView videoView2 = (VideoView) findViewById(R.id.video_view2);
        VideoView videoView3 = (VideoView) findViewById(R.id.video_view3);
        VideoView videoView4 = (VideoView) findViewById(R.id.video_view4);
        videoView1.stopPlayback();
        videoView2.stopPlayback();
        videoView3.stopPlayback();
        videoView4.stopPlayback();


        VideoView videoView = (VideoView) view;
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.legion);
        ;

        if (videoView == videoView1)
            uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.marvel_aos);
        if (videoView == videoView2)
            uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.dark_knight);
        if (videoView == videoView3)
            uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.inter_stellar);
        if (videoView == videoView4)
            uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.legion);


        //Setting MediaController and URI, then starting the videoView
        videoView.setVideoURI(uri);
        videoView.start();
    }
}
