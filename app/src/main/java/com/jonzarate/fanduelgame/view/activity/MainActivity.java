package com.jonzarate.fanduelgame.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.jonzarate.fanduelgame.R;
import com.jonzarate.fanduelgame.view.fragment.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainFragment fragment = (MainFragment) getSupportFragmentManager()
                .findFragmentById(R.id.main_content_frame);
        if (fragment == null) {
            fragment = MainFragment.newInstance();

            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.main_content_frame, fragment)
                    .commit();
        }
    }
}
