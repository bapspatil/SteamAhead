package bapspatil.steamahead.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import bapspatil.steamahead.adapters.GamesRecyclerViewAdapter;
import bapspatil.steamahead.R;
import bapspatil.steamahead.utils.Steam;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.games_rv) RecyclerView gamesRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        gamesRecyclerView.setLayoutManager(layoutManager);

        GamesRecyclerViewAdapter mAdapter = new GamesRecyclerViewAdapter(this, Steam.gameIdsList, new GamesRecyclerViewAdapter.OnGameClickListener() {
            @Override
            public void onGameClicked(String gameId) {
                Intent intentToStartDetailsActivity = new Intent(MainActivity.this, DetailsActivity.class);
                intentToStartDetailsActivity.putExtra("GAME", gameId);
                startActivity(intentToStartDetailsActivity);
            }
        });
        gamesRecyclerView.setAdapter(mAdapter);
    }
}
