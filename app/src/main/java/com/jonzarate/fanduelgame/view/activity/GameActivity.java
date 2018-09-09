package com.jonzarate.fanduelgame.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.jonzarate.fanduelgame.R;
import com.jonzarate.fanduelgame.view.fragment.GameFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GameActivity extends AppCompatActivity {

    @BindView(R.id.game_toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        ButterKnife.bind(this);

        setToolbar();

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

    private void setToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
