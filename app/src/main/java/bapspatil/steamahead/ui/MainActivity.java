package bapspatil.steamahead.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import bapspatil.steamahead.R;
import bapspatil.steamahead.adapters.GamesRecyclerViewAdapter;
import bapspatil.steamahead.model.GameData;
import bapspatil.steamahead.model.GameDetailsResponse;
import bapspatil.steamahead.network.RetrofitAPI;
import bapspatil.steamahead.utils.Steam;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.games_rv) RecyclerView gamesRecyclerView;
    @BindView(R.id.response_tv) TextView responseTextView;

    List<GameData> mGames = new ArrayList<>();
    List<Integer> mPlayers = new ArrayList<>();
    GamesRecyclerViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        toast("App developed by Bapusaheb Patil");

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        gamesRecyclerView.setLayoutManager(layoutManager);

        mAdapter = new GamesRecyclerViewAdapter(this, mGames, mPlayers, new GamesRecyclerViewAdapter.OnGameClickListener() {
            @Override
            public void onGameClicked(GameData game) {
                Intent intentToStartDetailsActivity = new Intent(MainActivity.this, DetailsActivity.class);
                intentToStartDetailsActivity.putExtra("GAME", game);
                startActivity(intentToStartDetailsActivity);
            }
        });
        gamesRecyclerView.setAdapter(mAdapter);

        fetchGames();
    }

    private void fetchGames() {
        int numberOfGames = Steam.gameIdsList.length;

        RetrofitAPI gameDetailsAPI = RetrofitAPI.gamesRetrofit.create(RetrofitAPI.class);
        Call<GameDetailsResponse> gameCall;

        gameCall = gameDetailsAPI.getGameDetails(Steam.gameIdsList[0]);
        gameCall.enqueue(new Callback<GameDetailsResponse>() {
            @Override
            public void onResponse(Call<GameDetailsResponse> call, Response<GameDetailsResponse> response) {
                GameDetailsResponse gameDetailsResponse = response.body();
                toast(String.valueOf(response.code()));
                toast(gameDetailsResponse.getGame().getData().getName());
                mGames.add(gameDetailsResponse.getGame().getData());
            }

            @Override
            public void onFailure(Call<GameDetailsResponse> call, Throwable t) {
                toast("Couldn't fetch details!");
            }
        });
        mAdapter.notifyDataSetChanged();

    }

    void toast(String toastMessage) {
        Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_SHORT).show();
    }
}
