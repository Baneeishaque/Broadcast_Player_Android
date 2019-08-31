package ndk.ccetv_jaseem.broadcast_player;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {

    private VideoView vv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_activity);

        vv = findViewById(R.id.videoView);
        Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.a);
        vv.setVideoURI(videoUri);
        vv.start();
    }

//    @Override
//    protected void onStart() {
//        vv.resume();
//        super.onStart();
//    }

    //    public void start(View view) {
//        vv.start();
//    }
//
//    public void stop(View view) {
//        vv.stopPlayback();
//    }
}