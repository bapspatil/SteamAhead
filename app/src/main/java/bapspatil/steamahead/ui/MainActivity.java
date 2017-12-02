package bapspatil.steamahead.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import bapspatil.steamahead.R;
import bapspatil.steamahead.adapters.GamesRecyclerViewAdapter;
import bapspatil.steamahead.model.Game;
import bapspatil.steamahead.model.GameData;
import bapspatil.steamahead.model.GameDetailsResponse0;
import bapspatil.steamahead.model.GameDetailsResponse1;
import bapspatil.steamahead.model.GameDetailsResponse2;
import bapspatil.steamahead.model.GameDetailsResponse3;
import bapspatil.steamahead.model.GameDetailsResponse4;
import bapspatil.steamahead.model.GameDetailsResponse5;
import bapspatil.steamahead.model.GameDetailsResponse6;
import bapspatil.steamahead.model.PlayersData;
import bapspatil.steamahead.model.PlayersDetailsResponse;
import bapspatil.steamahead.network.RetrofitAPI;
import bapspatil.steamahead.utils.Steam;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.games_rv) RecyclerView gamesRecyclerView;

    List<GameData> mGames = new ArrayList<>();
    ArrayList<Integer> mPlayers = new ArrayList<>();
    GamesRecyclerViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        toast("App developed by Bapusaheb Patil");

        mAdapter = new GamesRecyclerViewAdapter(this, mGames, mPlayers, new GamesRecyclerViewAdapter.OnGameClickListener() {
            @Override
            public void onGameClicked(GameData gameData, ImageView imageView) {
                Intent intentToStartDetailsActivity = new Intent(MainActivity.this, DetailsActivity.class);
                intentToStartDetailsActivity.putExtra("GAME", gameData);
                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this, imageView, "BackdropTransition");
                startActivity(intentToStartDetailsActivity, options.toBundle());
            }
        });
        gamesRecyclerView.setAdapter(mAdapter);
        fetchPlayers();
    }

    private void setupRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        gamesRecyclerView.setLayoutManager(layoutManager);
    }

    private void fetchPlayers() {
        RetrofitAPI playersDetailsAPI = RetrofitAPI.playersRetrofit.create(RetrofitAPI.class);
        final Call<PlayersDetailsResponse> playersCall0 = playersDetailsAPI.getPlayersDetails(Steam.gameIdsList[0]);
        playersCall0.enqueue(new Callback<PlayersDetailsResponse>() {
            @Override
            public void onResponse(Call<PlayersDetailsResponse> call, Response<PlayersDetailsResponse> response) {
                PlayersDetailsResponse playersDetailsResponse = response.body();
                PlayersData playersData = playersDetailsResponse.getData();
                ArrayList<Integer> players = playersData.getValues();
                int numberOfPlayers = players.size();
                Log.e("NO_OF_PLAYERS", numberOfPlayers + "");
                mPlayers.add(numberOfPlayers);
            }

            @Override
            public void onFailure(Call<PlayersDetailsResponse> call, Throwable t) {
                // Nothing
                Log.e("NO_PLAYERS!", t.getMessage());
            }
        });
        Call<PlayersDetailsResponse> playersCall1 = playersDetailsAPI.getPlayersDetails(Steam.gameIdsList[1]);
        if (playersCall0.isExecuted())
            playersCall1.enqueue(new Callback<PlayersDetailsResponse>() {
                @Override
                public void onResponse(Call<PlayersDetailsResponse> call, Response<PlayersDetailsResponse> response) {
                    PlayersDetailsResponse playersDetailsResponse = response.body();
                    PlayersData playersData = playersDetailsResponse.getData();
                    int numberOfPlayers = playersData.getValues().size();
                    Log.e("NO_OF_PLAYERS", numberOfPlayers + "");
                    mPlayers.add(numberOfPlayers);
                }

                @Override
                public void onFailure(Call<PlayersDetailsResponse> call, Throwable t) {
                    // Nothing
                    Log.e("NO_PLAYERS!", t.getMessage());
                }
            });
        Call<PlayersDetailsResponse> playersCall2 = playersDetailsAPI.getPlayersDetails(Steam.gameIdsList[2]);
        if (playersCall1.isExecuted())
            playersCall2.enqueue(new Callback<PlayersDetailsResponse>() {
                @Override
                public void onResponse(Call<PlayersDetailsResponse> call, Response<PlayersDetailsResponse> response) {
                    PlayersDetailsResponse playersDetailsResponse = response.body();
                    PlayersData playersData = playersDetailsResponse.getData();
                    int numberOfPlayers = playersData.getValues().size();
                    Log.e("NO_OF_PLAYERS", numberOfPlayers + "");
                    mPlayers.add(numberOfPlayers);
                }

                @Override
                public void onFailure(Call<PlayersDetailsResponse> call, Throwable t) {
                    // Nothing
                    Log.e("NO_PLAYERS!", t.getMessage());
                }
            });
        Call<PlayersDetailsResponse> playersCall3 = playersDetailsAPI.getPlayersDetails(Steam.gameIdsList[3]);
        if (playersCall2.isExecuted())
            playersCall3.enqueue(new Callback<PlayersDetailsResponse>() {
                @Override
                public void onResponse(Call<PlayersDetailsResponse> call, Response<PlayersDetailsResponse> response) {
                    PlayersDetailsResponse playersDetailsResponse = response.body();
                    PlayersData playersData = playersDetailsResponse.getData();
                    int numberOfPlayers = playersData.getValues().size();
                    Log.e("NO_OF_PLAYERS", numberOfPlayers + "");
                    mPlayers.add(numberOfPlayers);
                }

                @Override
                public void onFailure(Call<PlayersDetailsResponse> call, Throwable t) {
                    // Nothing
                    Log.e("NO_PLAYERS!", t.getMessage());
                }
            });
        Call<PlayersDetailsResponse> playersCall4 = playersDetailsAPI.getPlayersDetails(Steam.gameIdsList[4]);
        if (playersCall3.isExecuted())
            playersCall4.enqueue(new Callback<PlayersDetailsResponse>() {
                @Override
                public void onResponse(Call<PlayersDetailsResponse> call, Response<PlayersDetailsResponse> response) {
                    PlayersDetailsResponse playersDetailsResponse = response.body();
                    PlayersData playersData = playersDetailsResponse.getData();
                    int numberOfPlayers = playersData.getValues().size();
                    Log.e("NO_OF_PLAYERS", numberOfPlayers + "");
                    mPlayers.add(numberOfPlayers);
                }

                @Override
                public void onFailure(Call<PlayersDetailsResponse> call, Throwable t) {
                    // Nothing
                    Log.e("NO_PLAYERS!", t.getMessage());
                }
            });
        Call<PlayersDetailsResponse> playersCall5 = playersDetailsAPI.getPlayersDetails(Steam.gameIdsList[5]);
        if (playersCall4.isExecuted())
            playersCall5.enqueue(new Callback<PlayersDetailsResponse>() {
                @Override
                public void onResponse(Call<PlayersDetailsResponse> call, Response<PlayersDetailsResponse> response) {
                    PlayersDetailsResponse playersDetailsResponse = response.body();
                    PlayersData playersData = playersDetailsResponse.getData();
                    int numberOfPlayers = playersData.getValues().size();
                    Log.e("NO_OF_PLAYERS", numberOfPlayers + "");
                    mPlayers.add(numberOfPlayers);
                }

                @Override
                public void onFailure(Call<PlayersDetailsResponse> call, Throwable t) {
                    // Nothing
                    Log.e("NO_PLAYERS!", t.getMessage());
                }
            });
        Call<PlayersDetailsResponse> playersCall6 = playersDetailsAPI.getPlayersDetails(Steam.gameIdsList[6]);
        if (playersCall5.isExecuted())
            playersCall6.enqueue(new Callback<PlayersDetailsResponse>() {
                @Override
                public void onResponse(Call<PlayersDetailsResponse> call, Response<PlayersDetailsResponse> response) {
                    PlayersDetailsResponse playersDetailsResponse = response.body();
                    PlayersData playersData = playersDetailsResponse.getData();
                    int numberOfPlayers = playersData.getValues().size();
                    Log.e("NO_OF_PLAYERS", numberOfPlayers + "");
                    mPlayers.add(numberOfPlayers);
                    mAdapter.notifyDataSetChanged();
                }

                @Override
                public void onFailure(Call<PlayersDetailsResponse> call, Throwable t) {
                    // Nothing
                    Log.e("NO_PLAYERS!", t.getMessage());
                }
            });
        if (playersCall6.isExecuted())
            fetchGames();
    }

    private void fetchGames() {
        RetrofitAPI gameDetailsAPI = RetrofitAPI.gamesRetrofit.create(RetrofitAPI.class);
        Call<GameDetailsResponse0> gameCall0 = gameDetailsAPI.getGameDetails0(Steam.gameIdsList[0]);
        gameCall0.enqueue(new Callback<GameDetailsResponse0>() {
            @Override
            public void onResponse(Call<GameDetailsResponse0> call, Response<GameDetailsResponse0> response) {
                GameDetailsResponse0 gameDetailsResponse0 = response.body();
                Game game = gameDetailsResponse0.getGame();
                GameData gameData = game.getData();
                mGames.add(gameData);
            }

            @Override
            public void onFailure(Call<GameDetailsResponse0> call, Throwable t) {
                toast("Couldn't fetch details!" + t.getMessage());
            }
        });
        Call<GameDetailsResponse1> gameCall1 = gameDetailsAPI.getGameDetails1(Steam.gameIdsList[1]);
        if (gameCall0.isExecuted())
            gameCall1.enqueue(new Callback<GameDetailsResponse1>() {
                @Override
                public void onResponse(Call<GameDetailsResponse1> call, Response<GameDetailsResponse1> response) {
                    GameDetailsResponse1 gameDetailsResponse1 = response.body();
                    Game game = gameDetailsResponse1.getGame();
                    GameData gameData = game.getData();
                    mGames.add(gameData);
                }

                @Override
                public void onFailure(Call<GameDetailsResponse1> call, Throwable t) {
                    toast("Couldn't fetch details!" + t.getMessage());
                }
            });
        Call<GameDetailsResponse2> gameCall2 = gameDetailsAPI.getGameDetails2(Steam.gameIdsList[2]);
        if (gameCall1.isExecuted())
            gameCall2.enqueue(new Callback<GameDetailsResponse2>() {
                @Override
                public void onResponse(Call<GameDetailsResponse2> call, Response<GameDetailsResponse2> response) {
                    GameDetailsResponse2 gameDetailsResponse2 = response.body();
                    Game game = gameDetailsResponse2.getGame();
                    GameData gameData = game.getData();
                    mGames.add(gameData);
                }

                @Override
                public void onFailure(Call<GameDetailsResponse2> call, Throwable t) {
                    toast("Couldn't fetch details!" + t.getMessage());
                }
            });
        Call<GameDetailsResponse3> gameCall3 = gameDetailsAPI.getGameDetails3(Steam.gameIdsList[3]);
        if (gameCall2.isExecuted())
            gameCall3.enqueue(new Callback<GameDetailsResponse3>() {
                @Override
                public void onResponse(Call<GameDetailsResponse3> call, Response<GameDetailsResponse3> response) {
                    GameDetailsResponse3 gameDetailsResponse3 = response.body();
                    Game game = gameDetailsResponse3.getGame();
                    GameData gameData = game.getData();
                    mGames.add(gameData);
                }

                @Override
                public void onFailure(Call<GameDetailsResponse3> call, Throwable t) {
                    toast("Couldn't fetch details!" + t.getMessage());
                }
            });
        Call<GameDetailsResponse4> gameCall4 = gameDetailsAPI.getGameDetails4(Steam.gameIdsList[4]);
        if (gameCall3.isExecuted())
            gameCall4.enqueue(new Callback<GameDetailsResponse4>() {
                @Override
                public void onResponse(Call<GameDetailsResponse4> call, Response<GameDetailsResponse4> response) {
                    GameDetailsResponse4 gameDetailsResponse4 = response.body();
                    Game game = gameDetailsResponse4.getGame();
                    GameData gameData = game.getData();
                    mGames.add(gameData);
                }

                @Override
                public void onFailure(Call<GameDetailsResponse4> call, Throwable t) {
                    toast("Couldn't fetch details!" + t.getMessage());
                }
            });
        Call<GameDetailsResponse5> gameCall5 = gameDetailsAPI.getGameDetails5(Steam.gameIdsList[5]);
        if (gameCall4.isExecuted())
            gameCall5.enqueue(new Callback<GameDetailsResponse5>() {
                @Override
                public void onResponse(Call<GameDetailsResponse5> call, Response<GameDetailsResponse5> response) {
                    GameDetailsResponse5 gameDetailsResponse5 = response.body();
                    Game game = gameDetailsResponse5.getGame();
                    GameData gameData = game.getData();
                    mGames.add(gameData);
                }

                @Override
                public void onFailure(Call<GameDetailsResponse5> call, Throwable t) {
                    toast("Couldn't fetch details!" + t.getMessage());
                }
            });
        Call<GameDetailsResponse6> gameCall6 = gameDetailsAPI.getGameDetails6(Steam.gameIdsList[6]);
        if (gameCall5.isExecuted())
            gameCall6.enqueue(new Callback<GameDetailsResponse6>() {
                @Override
                public void onResponse(Call<GameDetailsResponse6> call, Response<GameDetailsResponse6> response) {
                    GameDetailsResponse6 gameDetailsResponse6 = response.body();
                    Game game = gameDetailsResponse6.getGame();
                    GameData gameData = game.getData();
                    mGames.add(gameData);
                }

                @Override
                public void onFailure(Call<GameDetailsResponse6> call, Throwable t) {
                    toast("Couldn't fetch details!" + t.getMessage());
                }
            });
        Log.d("PLAYERS", mPlayers.toString());
        if (gameCall6.isExecuted())
            setupRecyclerView();
    }

    void toast(String toastMessage) {
        Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_SHORT).show();
    }
}
