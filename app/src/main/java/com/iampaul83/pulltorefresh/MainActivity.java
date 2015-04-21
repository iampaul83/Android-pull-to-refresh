package com.iampaul83.pulltorefresh;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    private TextView titleTextView;
    private Button swipeRefreshLayoutButton;
    private Button pullToRefreshButton;
    private String[] fakeData = new String[30];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titleTextView = (TextView) findViewById(R.id.titleTextView);
        swipeRefreshLayoutButton = (Button) findViewById(R.id.swipeRefreshLayoutButton);
        pullToRefreshButton = (Button) findViewById(R.id.pullToRefreshButton);

        for (int i = 0 ; i < 30 ; i++) {
            fakeData[i] = "item" + i;
        }

    }

    public void swipeRefreshLayout(View view) {
        changeFragment(SwipeRefreshLayoutFragment.newInstance(fakeData));
        titleTextView.setText("SwipeRefreshLayout");
        swipeRefreshLayoutButton.setEnabled(false);
        pullToRefreshButton.setEnabled(true);
    }

    public void pullToRefresh(View view) {
        changeFragment(PullToRefreshFragment.newInstance(fakeData));
        titleTextView.setText("android-Ultra-Pull-To-Refresh");
        swipeRefreshLayoutButton.setEnabled(true);
        pullToRefreshButton.setEnabled(false);
    }


    private void changeFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }

}
