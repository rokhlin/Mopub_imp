package admopub.selfapps.rav.amopub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.mobileads.MoPubInterstitial;

public class IntersitialActivity extends AppCompatActivity implements MoPubInterstitial.InterstitialAdListener {

    private static final String INTERSTITIAL_AD_UNIT_ID ="56bd5c6af224424da08dd897ffe8d287" ;
    private static final String TEXT = "Intersitial test";
    private static final String BUTTON_TEXT = "Main menu";
    private MoPubInterstitial mInterstitial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mInterstitial = new MoPubInterstitial(this, INTERSTITIAL_AD_UNIT_ID);
// Remember that "this" refers to your current activity.
        mInterstitial.setInterstitialAdListener(this);
        Button btn = (Button) findViewById(R.id.button);
        Button btn2 = (Button) findViewById(R.id.button2);
        TextView tw = (TextView) findViewById(R.id.textView);
        tw.setText(TEXT);


        btn.setText(BUTTON_TEXT);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mInterstitial.show();

            }
        });

        btn2.setVisibility(View.GONE);


        mInterstitial.load();
    }


    // Defined by your application, indicating that you're ready to show an interstitial ad.
    void yourAppsShowInterstitialMethod() {
        if (mInterstitial.isReady()) {
            mInterstitial.show();
        } else {
            // Caching is likely already in progress if `isReady()` is false.
            // Avoid calling `load()` here and instead rely on the callbacks as suggested below.
        }
    }

    @Override
    public void onInterstitialLoaded(MoPubInterstitial interstitial) {
        Toast.makeText(getApplicationContext(),
                "Intersitial loaded.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onInterstitialFailed(MoPubInterstitial interstitial, MoPubErrorCode errorCode) {
        Toast.makeText(getApplicationContext(),
                "Intersitial Failed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onInterstitialShown(MoPubInterstitial interstitial) {
        Toast.makeText(getApplicationContext(),
                "Intersitial Shown.", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mInterstitial.destroy();
    }

    @Override
    public void onInterstitialClicked(MoPubInterstitial interstitial) {
        Toast.makeText(getApplicationContext(),
                "Intersitial Clicked", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onInterstitialDismissed(MoPubInterstitial interstitial) {
        Toast.makeText(getApplicationContext(),
                "Intersitial Dismissed", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(IntersitialActivity.this,MainActivity.class);
        startActivity(intent);
    }
}
