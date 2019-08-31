package ndk.ccetv_jaseem.broadcast_player;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.WindowManager;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {

    private VideoView vv;
    int[] videoArray = {R.raw.v1, R.raw.v2, R.raw.v3};
    int videoIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_activity);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        vv = findViewById(R.id.videoView);

        playVideo(videoIndex);

        vv.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {

                videoIndex++;
                if (!(videoIndex < videoArray.length)) {
                    videoIndex = 0;
                }
                playVideo(videoIndex);
            }
        });
    }

    private void playVideo(int localVideoIndex) {
        Log.d("Broadcast Player", "Video Index : " + localVideoIndex);
        Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + videoArray[localVideoIndex]);
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