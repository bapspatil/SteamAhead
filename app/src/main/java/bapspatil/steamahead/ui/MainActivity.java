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
import bapspatil.steamahead.model.Game;
import bapspatil.steamahead.model.GameDetailsResponse;
import bapspatil.steamahead.model.PlayersDetailsResponse;
import bapspatil.steamahead.network.SteamAPI;
import bapspatil.steamahead.utils.Steam;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.games_rv) RecyclerView gamesRecyclerView;
    @BindView(R.id.response_tv) TextView responseTextView;

    List<Game> mGames = new ArrayList<>();
    List<Integer> mPlayers = new ArrayList<>();
    GamesRecyclerViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        gamesRecyclerView.setLayoutManager(layoutManager);

        mAdapter = new GamesRecyclerViewAdapter(this, mGames, mPlayers, new GamesRecyclerViewAdapter.OnGameClickListener() {
            @Override
            public void onGameClicked(Game game) {
                Intent intentToStartDetailsActivity = new Intent(MainActivity.this, DetailsActivity.class);
                intentToStartDetailsActivity.putExtra("GAME", game);
                startActivity(intentToStartDetailsActivity);
            }
        });
        gamesRecyclerView.setAdapter(mAdapter);

        fetchGames();
    }

    private void fetchGames() {
        SteamAPI gameDetailsAPI = SteamAPI.gamesRetrofit.create(SteamAPI.class);
        Call<GameDetailsResponse> gameCall;
        SteamAPI playersDetailsAPI = SteamAPI.playersRetrofit.create(SteamAPI.class);
        Call<PlayersDetailsResponse> playersCall;
        final int numberOfGames = Steam.gameIdsList.size();

        for (int i = 0; i < numberOfGames; i++) {
            gameCall = gameDetailsAPI.getGameDetails(Steam.gameIdsList.get(i));
            gameCall.enqueue(new Callback<GameDetailsResponse>() {
                @Override
                public void onResponse(Call<GameDetailsResponse> call, Response<GameDetailsResponse> response) {
                    GameDetailsResponse gameDetailsResponse = response.body();
                    Game game = gameDetailsResponse.getGame();
                    mGames.add(game);
                    responseTextView.setText(game.getData().getName());
                }

                @Override
                public void onFailure(Call<GameDetailsResponse> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), "Couldn't fetch game details!", Toast.LENGTH_LONG).show();
                }
            });
            /*playersCall = playersDetailsAPI.getPlayersDetails("concurrent_week", Steam.gameIdsList.get(i));
            playersCall.enqueue(new Callback<PlayersDetailsResponse>() {
                @Override
                public void onResponse(Call<PlayersDetailsResponse> call, Response<PlayersDetailsResponse> response) {
                    PlayersDetailsResponse playersDetailsResponse = response.body();
                    PlayersData playersData = playersDetailsResponse.getData();
                    int[] players = playersData.getValues();
                    int numberOfPlayers = players.length;
                    mPlayers.add(numberOfPlayers);
                }

                @Override
                public void onFailure(Call<PlayersDetailsResponse> call, Throwable t) {

                }
            });*/
        }
        mAdapter.notifyDataSetChanged();
    }

    void toast(String toastMessage) {
        Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_SHORT).show();
    }
}
