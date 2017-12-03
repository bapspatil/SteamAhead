package bapspatil.steamahead.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Map;

import bapspatil.steamahead.R;
import bapspatil.steamahead.adapters.GamesRecyclerViewAdapter;
import bapspatil.steamahead.model.Game;
import bapspatil.steamahead.model.GameData;
import bapspatil.steamahead.model.TopGames;
import bapspatil.steamahead.network.RetrofitAPI;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.games_rv) RecyclerView gamesRecyclerView;
    @BindView(R.id.toolbar) Toolbar toolbar;

    ArrayList<TopGames> mTopGames = new ArrayList<>();
    ArrayList<GameData> mGames = new ArrayList<>();
    GamesRecyclerViewAdapter mAdapter;
    Call<Map<String, Game>> gamesCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        toast("App developed by Bapusaheb Patil");

        setupRecyclerView();
        fetchTopGames();

        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gamesRecyclerView.smoothScrollToPosition(0);
            }
        });
    }

    private void fetchTopGames() {
        final RetrofitAPI topGamesAPI = RetrofitAPI.topGamesRetrofit.create(RetrofitAPI.class);
        Call<Map<String, TopGames>> topGamesCall = topGamesAPI.getTopGames("top100in2weeks");
        topGamesCall.enqueue(new Callback<Map<String, TopGames>>() {
            @Override
            public void onResponse(Call<Map<String, TopGames>> call, Response<Map<String, TopGames>> response) {
                Map<String, TopGames> topGamesMap = response.body();
                if (topGamesMap != null) {
                    for (Map.Entry<String, TopGames> entry : topGamesMap.entrySet()) {
                        mTopGames.add(entry.getValue());
                        Log.e("GAME FETCHED: ", entry.getValue().getName());
                        int gameAddedId = mTopGames.get(mTopGames.size() - 1).getAppid();
                        fetchGames(gameAddedId, entry.getValue().getPlayers());
                    }
                }
            }

            @Override
            public void onFailure(Call<Map<String, TopGames>> call, Throwable t) {
                toast("Couldn't load top 100 games!");
            }
        });
    }

    private void fetchGames(final int gameAddedId, final long players) {
        RetrofitAPI gamesAPI = RetrofitAPI.gamesRetrofit.create(RetrofitAPI.class);
        gamesCall = gamesAPI.getGameDetails(String.valueOf(gameAddedId));
        gamesCall.enqueue(new Callback<Map<String, Game>>() {
            @Override
            public void onResponse(Call<Map<String, Game>> call, Response<Map<String, Game>> response) {
                Map<String, Game> gameMap = response.body();
                if (gameMap != null) {
                    for (Map.Entry<String, Game> entry : gameMap.entrySet()) {
                        if (entry.getValue().getData() != null) {
                            mGames.add(entry.getValue().getData());
                            mGames.get(mGames.size() - 1).setPlayers(players);
                            mAdapter.notifyDataSetChanged();
                            Log.e("GAME DATA ADDED", entry.getValue().getData().getName());
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<Map<String, Game>> call, Throwable t) {
                toast("Couldn't load images for these games, bro!");
            }
        });
    }

    private void setupRecyclerView() {
        mAdapter = new GamesRecyclerViewAdapter(this, mGames, new GamesRecyclerViewAdapter.OnGameClickListener() {
            @Override
            public void onGameClicked(GameData gameData, ImageView imageView) {
                Intent intentToStartDetailsActivity = new Intent(MainActivity.this, DetailsActivity.class);
                intentToStartDetailsActivity.putExtra("GAME", gameData);
                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this, imageView, "BackdropTransition");
                startActivity(intentToStartDetailsActivity, options.toBundle());
            }
        });
        gamesRecyclerView.setAdapter(mAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        gamesRecyclerView.setLayoutManager(layoutManager);
    }

    void toast(String toastMessage) {
        Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_SHORT).show();
    }
}
