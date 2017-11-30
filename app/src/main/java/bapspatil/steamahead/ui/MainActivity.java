package bapspatil.steamahead.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import bapspatil.steamahead.R;
import bapspatil.steamahead.adapters.GamesRecyclerViewAdapter;
import bapspatil.steamahead.model.GameData;
import bapspatil.steamahead.model.GameDetailsResponse;
import bapspatil.steamahead.model.PlayersData;
import bapspatil.steamahead.model.PlayersDetailsResponse;
import bapspatil.steamahead.network.GameDetailsAPI;
import bapspatil.steamahead.network.PlayersDetailsAPI;
import bapspatil.steamahead.utils.Steam;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.games_rv) RecyclerView gamesRecyclerView;

    List<GameData> mGameData = new ArrayList<>();
    List<Integer> mPlayers = new ArrayList<>();
    GamesRecyclerViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        gamesRecyclerView.setLayoutManager(layoutManager);

        mAdapter = new GamesRecyclerViewAdapter(this, mGameData, mPlayers, new GamesRecyclerViewAdapter.OnGameClickListener() {
            @Override
            public void onGameClicked(GameData gameData) {
                Intent intentToStartDetailsActivity = new Intent(MainActivity.this, DetailsActivity.class);
                intentToStartDetailsActivity.putExtra("GAME", gameData);
                startActivity(intentToStartDetailsActivity);
            }
        });
        gamesRecyclerView.setAdapter(mAdapter);

        fetchGames();
    }

    private void fetchGames() {
        GameDetailsAPI gameDetailsAPI = GameDetailsAPI.retrofit.create(GameDetailsAPI.class);
        PlayersDetailsAPI playersDetailsAPI = PlayersDetailsAPI.retrofit.create(PlayersDetailsAPI.class);
        final int numberOfGames = Steam.gameIdsList.size();

        for(int i = 0; i < numberOfGames; i++) {
            Call<GameDetailsResponse> gameCall = gameDetailsAPI.getGameDetails(Steam.gameIdsList.get(i));
            gameCall.enqueue(new Callback<GameDetailsResponse>() {
                @Override
                public void onResponse(Call<GameDetailsResponse> call, Response<GameDetailsResponse> response) {
                    GameDetailsResponse gameDetailsResponse = response.body();
                    mGameData.add(gameDetailsResponse.getData());
                }

                @Override
                public void onFailure(Call<GameDetailsResponse> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), "Couldn't fetch game details!", Toast.LENGTH_LONG).show();
                }
            });

            Call<PlayersDetailsResponse> playersCall = playersDetailsAPI.getPlayersDetails("concurrent_week", Steam.gameIdsList.get(i));
            playersCall.enqueue(new Callback<PlayersDetailsResponse>() {
                @Override
                public void onResponse(Call<PlayersDetailsResponse> call, Response<PlayersDetailsResponse> response) {
                    PlayersDetailsResponse playersDetailsResponse = response.body();
                    // TODO: Fix crash for null stuff here, do something about it!
                    if(playersDetailsResponse != null) {
                        PlayersData playersData = playersDetailsResponse.getData();
                        ArrayList<Number> listOfPlayers = playersData.getPlayers();
                        mPlayers.add(listOfPlayers.size());
                    } else {
                        toast("Response is null!");
                    }
                }

                @Override
                public void onFailure(Call<PlayersDetailsResponse> call, Throwable t) {
                    toast("Couldn't fetch number of players!");
                }
            });

            mAdapter.notifyDataSetChanged();
        }
    }

    void toast(String toastMessage) {
        Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_LONG).show();
    }
}
