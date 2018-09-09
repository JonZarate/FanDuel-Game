package com.jonzarate.fanduelgame.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jonzarate.fanduelgame.R;
import com.jonzarate.fanduelgame.view.fragment.GameFragment;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        GameFragment fragment = (GameFragment) getSupportFragmentManager()
                .findFragmentById(R.id.main_content_frame);
        if (fragment == null) {
            fragment = GameFragment.newInstance();

            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.game_content_frame, fragment)
                    .commit();
        }
    }
}
