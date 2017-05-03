package admopub.selfapps.rav.amopub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.mobileads.MoPubView;

public class MainActivity extends AppCompatActivity implements MoPubView.BannerAdListener {

    private MoPubView moPubView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        moPubView = (MoPubView) findViewById(R.id.adview);
        moPubView.setAdUnitId("56bd5c6af224424da08dd897ffe8d287"); // Enter your Ad Unit ID from www.mopub.com
        moPubView.loadAd();
        moPubView.setBannerAdListener(this);

        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,IntersitialActivity.class);
                startActivity(intent);
            }
        });
        Button btn2 = (Button) findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,RewardedVideoActivity.class);
                startActivity(intent);
            }
        });

        Button btn3 = (Button) findViewById(R.id.button3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,NativeListAdActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        moPubView.destroy();
    }

    @Override
    public void onBannerLoaded(MoPubView banner) {
        Toast.makeText(getApplicationContext(),
                "Banner successfully loaded.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBannerFailed(MoPubView banner, MoPubErrorCode errorCode) {
        Toast.makeText(getApplicationContext(),
                "onBannerFailed.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBannerClicked(MoPubView banner) {
        Toast.makeText(getApplicationContext(),
                "onBannerClicked", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBannerExpanded(MoPubView banner) {
        Toast.makeText(getApplicationContext(),
                "onBannerExpanded", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBannerCollapsed(MoPubView banner) {
        Toast.makeText(getApplicationContext(),
                "onBannerCollapsed", Toast.LENGTH_SHORT).show();
    }
}
