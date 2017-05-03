package admopub.selfapps.rav.amopub;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.mopub.common.MoPub;
import com.mopub.common.MoPubReward;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.mobileads.MoPubRewardedVideoListener;
import com.mopub.mobileads.MoPubRewardedVideos;

import java.util.Set;

public class RewardedVideoActivity extends AppCompatActivity implements MoPubRewardedVideoListener {
    private static final String AD_UNIT_ID ="56bd5c6af224424da08dd897ffe8d287" ;
    private static final String TEXT = "rewardred video test";
    private static final String BUTTON_TEXT = "Main menu";
    private static final String BUTTON2_TEXT = "Show Ad";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button) findViewById(R.id.button);
        Button btn2 = (Button) findViewById(R.id.button2);
        TextView tw = (TextView) findViewById(R.id.textView);
        tw.setText(TEXT);


        btn.setText(BUTTON_TEXT);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RewardedVideoActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btn2.setText(BUTTON2_TEXT);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userClickedToWatchAd();
            }
        });

        MoPubRewardedVideos.initializeRewardedVideo(this);
        MoPubRewardedVideos.setRewardedVideoListener(this);//optional !!!!
        MoPub.onCreate(this);
        loadRewardedVideo();

    }

    private void loadRewardedVideo(){
        MoPubRewardedVideos.loadRewardedVideo(AD_UNIT_ID);
    }

    private void userClickedToWatchAd() {
        MoPubRewardedVideos.showRewardedVideo(AD_UNIT_ID);
    }

    @Override
    public void onPause() {
        super.onPause();
        MoPub.onPause(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        MoPub.onResume(this);
    }

    // The following methods are required for Chartboost rewarded video mediation
    @Override
    public void onStart() {
        super.onStart();
        MoPub.onStart(this);
    }

    @Override
    public void onRestart() {
        super.onRestart();
        MoPub.onRestart(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        MoPub.onStop(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        MoPub.onDestroy(this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        MoPub.onBackPressed(this);
    }


    @Override
    public void onRewardedVideoLoadSuccess(@NonNull String adUnitId) {
        Toast.makeText(getApplicationContext(),
                "RewardedVideoLoadSuccess", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewardedVideoLoadFailure(@NonNull String adUnitId, @NonNull MoPubErrorCode errorCode) {
        Toast.makeText(getApplicationContext(),
                "RewardedVideoLoadFailure", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewardedVideoStarted(@NonNull String adUnitId) {
        Toast.makeText(getApplicationContext(),
                "RewardedVideoStarted", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onRewardedVideoPlaybackError(@NonNull String adUnitId, @NonNull MoPubErrorCode errorCode) {
        Toast.makeText(getApplicationContext(),
                "RewardedVideoPlaybackError", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewardedVideoClosed(@NonNull String adUnitId) {
        Toast.makeText(getApplicationContext(),
                "RewardedVideoClosed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewardedVideoCompleted(@NonNull Set<String> adUnitIds, @NonNull MoPubReward reward) {
        Toast.makeText(getApplicationContext(),
                "RewardedVideoClosed", Toast.LENGTH_SHORT).show();
    }
}
