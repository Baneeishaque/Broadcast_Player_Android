package ndk.ccetv_jaseem.broadcast_player;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.WindowManager;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {

    private static final String TAG = "Broadcast Player";
    private VideoView vv;
    int[] videoArray = {R.raw.v1, R.raw.v2, R.raw.v3};
    int videoIndex = 0;
    private int stopPosition;

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

    @Override
    public void onPause() {
        stopPosition = vv.getCurrentPosition(); //stopPosition is an int
        vv.pause();
        Log.d(TAG, "onPause called");
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume called");
        vv.seekTo(stopPosition);
        vv.start(); //Or use resume() if it doesn't work. I'm not sure
    }

    private void playVideo(int localVideoIndex) {
        Log.d(TAG, "Video Index : " + localVideoIndex);
        Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + videoArray[localVideoIndex]);
        vv.setVideoURI(videoUri);
        vv.start();
    }

}