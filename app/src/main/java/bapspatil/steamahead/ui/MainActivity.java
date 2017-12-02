package bapspatil.steamahead.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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

    List<String> mGameTitles = new ArrayList<>();
    List<String> mGameIds = new ArrayList<>();
    List<String> mGameHeaderImages = new ArrayList<>();
    List<Integer> mPlayers = new ArrayList<>();
    GamesRecyclerViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        toast("App developed by Bapusaheb Patil");

        mAdapter = new GamesRecyclerViewAdapter(this, mGameTitles, mGameHeaderImages, mGameIds, mPlayers, new GamesRecyclerViewAdapter.OnGameClickListener() {
            @Override
            public void onGameClicked(String gameId) {
                Intent intentToStartDetailsActivity = new Intent(MainActivity.this, DetailsActivity.class);
                intentToStartDetailsActivity.putExtra("GAME", gameId);
                startActivity(intentToStartDetailsActivity);
            }
        });
        gamesRecyclerView.setAdapter(mAdapter);

        final LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        gamesRecyclerView.setLayoutManager(layoutManager);

        fetchPlayers();
        fetchGames();

    }

    private void fetchPlayers() {
        RetrofitAPI playersDetailsAPI = RetrofitAPI.playersRetrofit.create(RetrofitAPI.class);
        Call<PlayersDetailsResponse> playersCall0 = playersDetailsAPI.getPlayersDetails(Steam.gameIdsList[0]);
        playersCall0.enqueue(new Callback<PlayersDetailsResponse>() {
            @Override
            public void onResponse(Call<PlayersDetailsResponse> call, Response<PlayersDetailsResponse> response) {
                PlayersDetailsResponse playersDetailsResponse = response.body();
                PlayersData playersData = playersDetailsResponse.getData();
                int numberOfPlayers = playersData.getValues().size();
                Log.e("NO_OF_PLAYERS", numberOfPlayers + "");
                toast(String.valueOf(numberOfPlayers));
                mPlayers.add(numberOfPlayers);
            }

            @Override
            public void onFailure(Call<PlayersDetailsResponse> call, Throwable t) {
                // Nothing
                Log.e("NO_PLAYERS!", t.getMessage());
            }
        });
        Call<PlayersDetailsResponse> playersCall1 = playersDetailsAPI.getPlayersDetails(Steam.gameIdsList[1]);
        playersCall1.enqueue(new Callback<PlayersDetailsResponse>() {
            @Override
            public void onResponse(Call<PlayersDetailsResponse> call, Response<PlayersDetailsResponse> response) {
                PlayersDetailsResponse playersDetailsResponse = response.body();
                PlayersData playersData = playersDetailsResponse.getData();
                int numberOfPlayers = playersData.getValues().size();
                Log.e("NO_OF_PLAYERS", numberOfPlayers + "");
                toast(String.valueOf(numberOfPlayers));
                mPlayers.add(numberOfPlayers);
            }

            @Override
            public void onFailure(Call<PlayersDetailsResponse> call, Throwable t) {
                // Nothing
                Log.e("NO_PLAYERS!", t.getMessage());
            }
        });
        Call<PlayersDetailsResponse> playersCall2 = playersDetailsAPI.getPlayersDetails(Steam.gameIdsList[2]);
        playersCall2.enqueue(new Callback<PlayersDetailsResponse>() {
            @Override
            public void onResponse(Call<PlayersDetailsResponse> call, Response<PlayersDetailsResponse> response) {
                PlayersDetailsResponse playersDetailsResponse = response.body();
                PlayersData playersData = playersDetailsResponse.getData();
                int numberOfPlayers = playersData.getValues().size();
                Log.e("NO_OF_PLAYERS", numberOfPlayers + "");
                toast(String.valueOf(numberOfPlayers));
                mPlayers.add(numberOfPlayers);
            }

            @Override
            public void onFailure(Call<PlayersDetailsResponse> call, Throwable t) {
                // Nothing
                Log.e("NO_PLAYERS!", t.getMessage());
            }
        });
        Call<PlayersDetailsResponse> playersCall3 = playersDetailsAPI.getPlayersDetails(Steam.gameIdsList[3]);
        playersCall3.enqueue(new Callback<PlayersDetailsResponse>() {
            @Override
            public void onResponse(Call<PlayersDetailsResponse> call, Response<PlayersDetailsResponse> response) {
                PlayersDetailsResponse playersDetailsResponse = response.body();
                PlayersData playersData = playersDetailsResponse.getData();
                int numberOfPlayers = playersData.getValues().size();
                Log.e("NO_OF_PLAYERS", numberOfPlayers + "");
                toast(String.valueOf(numberOfPlayers));
                mPlayers.add(numberOfPlayers);
            }

            @Override
            public void onFailure(Call<PlayersDetailsResponse> call, Throwable t) {
                // Nothing
                Log.e("NO_PLAYERS!", t.getMessage());
            }
        });
        Call<PlayersDetailsResponse> playersCall4 = playersDetailsAPI.getPlayersDetails(Steam.gameIdsList[4]);
        playersCall4.enqueue(new Callback<PlayersDetailsResponse>() {
            @Override
            public void onResponse(Call<PlayersDetailsResponse> call, Response<PlayersDetailsResponse> response) {
                PlayersDetailsResponse playersDetailsResponse = response.body();
                PlayersData playersData = playersDetailsResponse.getData();
                int numberOfPlayers = playersData.getValues().size();
                Log.e("NO_OF_PLAYERS", numberOfPlayers + "");
                toast(String.valueOf(numberOfPlayers));
                mPlayers.add(numberOfPlayers);
            }

            @Override
            public void onFailure(Call<PlayersDetailsResponse> call, Throwable t) {
                // Nothing
                Log.e("NO_PLAYERS!", t.getMessage());
            }
        });
        Call<PlayersDetailsResponse> playersCall5 = playersDetailsAPI.getPlayersDetails(Steam.gameIdsList[5]);
        playersCall5.enqueue(new Callback<PlayersDetailsResponse>() {
            @Override
            public void onResponse(Call<PlayersDetailsResponse> call, Response<PlayersDetailsResponse> response) {
                PlayersDetailsResponse playersDetailsResponse = response.body();
                PlayersData playersData = playersDetailsResponse.getData();
                int numberOfPlayers = playersData.getValues().size();
                Log.e("NO_OF_PLAYERS", numberOfPlayers + "");
                toast(String.valueOf(numberOfPlayers));
                mPlayers.add(numberOfPlayers);
            }

            @Override
            public void onFailure(Call<PlayersDetailsResponse> call, Throwable t) {
                // Nothing
                Log.e("NO_PLAYERS!", t.getMessage());
            }
        });
        Call<PlayersDetailsResponse> playersCall6 = playersDetailsAPI.getPlayersDetails(Steam.gameIdsList[6]);
        playersCall6.enqueue(new Callback<PlayersDetailsResponse>() {
            @Override
            public void onResponse(Call<PlayersDetailsResponse> call, Response<PlayersDetailsResponse> response) {
                PlayersDetailsResponse playersDetailsResponse = response.body();
                PlayersData playersData = playersDetailsResponse.getData();
                int numberOfPlayers = playersData.getValues().size();
                Log.e("NO_OF_PLAYERS", numberOfPlayers + "");
                toast(String.valueOf(numberOfPlayers));
                mPlayers.add(numberOfPlayers);
            }

            @Override
            public void onFailure(Call<PlayersDetailsResponse> call, Throwable t) {
                // Nothing
                Log.e("NO_PLAYERS!", t.getMessage());
            }
        });
        Log.e("PLAYERS!", mPlayers.toString());
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
                mGameTitles.add(gameData.getName());
                mGameHeaderImages.add(gameData.getHeader_image());
                mGameIds.add(gameData.getSteam_appid());
            }

            @Override
            public void onFailure(Call<GameDetailsResponse0> call, Throwable t) {
                toast("Couldn't fetch details!" + t.getMessage());
            }
        });
        Call<GameDetailsResponse1> gameCall1 = gameDetailsAPI.getGameDetails1(Steam.gameIdsList[1]);
        gameCall1.enqueue(new Callback<GameDetailsResponse1>() {
            @Override
            public void onResponse(Call<GameDetailsResponse1> call, Response<GameDetailsResponse1> response) {
                GameDetailsResponse1 gameDetailsResponse1 = response.body();
                Game game = gameDetailsResponse1.getGame();
                GameData gameData = game.getData();
                mGameTitles.add(gameData.getName());
                mGameHeaderImages.add(gameData.getHeader_image());
                mGameIds.add(gameData.getSteam_appid());
            }

            @Override
            public void onFailure(Call<GameDetailsResponse1> call, Throwable t) {
                toast("Couldn't fetch details!" + t.getMessage());
            }
        });
        Call<GameDetailsResponse2> gameCall2 = gameDetailsAPI.getGameDetails2(Steam.gameIdsList[2]);
        gameCall2.enqueue(new Callback<GameDetailsResponse2>() {
            @Override
            public void onResponse(Call<GameDetailsResponse2> call, Response<GameDetailsResponse2> response) {
                GameDetailsResponse2 gameDetailsResponse2 = response.body();
                Game game = gameDetailsResponse2.getGame();
                GameData gameData = game.getData();
                mGameTitles.add(gameData.getName());
                mGameHeaderImages.add(gameData.getHeader_image());
                mGameIds.add(gameData.getSteam_appid());
            }

            @Override
            public void onFailure(Call<GameDetailsResponse2> call, Throwable t) {
                toast("Couldn't fetch details!" + t.getMessage());
            }
        });
        Call<GameDetailsResponse3> gameCall3 = gameDetailsAPI.getGameDetails3(Steam.gameIdsList[3]);
        gameCall3.enqueue(new Callback<GameDetailsResponse3>() {
            @Override
            public void onResponse(Call<GameDetailsResponse3> call, Response<GameDetailsResponse3> response) {
                GameDetailsResponse3 gameDetailsResponse3 = response.body();
                Game game = gameDetailsResponse3.getGame();
                GameData gameData = game.getData();
                mGameTitles.add(gameData.getName());
                mGameHeaderImages.add(gameData.getHeader_image());
                mGameIds.add(gameData.getSteam_appid());
            }

            @Override
            public void onFailure(Call<GameDetailsResponse3> call, Throwable t) {
                toast("Couldn't fetch details!" + t.getMessage());
            }
        });
        Call<GameDetailsResponse4> gameCall4 = gameDetailsAPI.getGameDetails4(Steam.gameIdsList[4]);
        gameCall4.enqueue(new Callback<GameDetailsResponse4>() {
            @Override
            public void onResponse(Call<GameDetailsResponse4> call, Response<GameDetailsResponse4> response) {
                GameDetailsResponse4 gameDetailsResponse4 = response.body();
                Game game = gameDetailsResponse4.getGame();
                GameData gameData = game.getData();
                mGameTitles.add(gameData.getName());
                mGameHeaderImages.add(gameData.getHeader_image());
                mGameIds.add(gameData.getSteam_appid());
            }

            @Override
            public void onFailure(Call<GameDetailsResponse4> call, Throwable t) {
                toast("Couldn't fetch details!" + t.getMessage());
            }
        });
        Call<GameDetailsResponse5> gameCall5 = gameDetailsAPI.getGameDetails5(Steam.gameIdsList[5]);
        gameCall5.enqueue(new Callback<GameDetailsResponse5>() {
            @Override
            public void onResponse(Call<GameDetailsResponse5> call, Response<GameDetailsResponse5> response) {
                GameDetailsResponse5 gameDetailsResponse5 = response.body();
                Game game = gameDetailsResponse5.getGame();
                GameData gameData = game.getData();
                mGameTitles.add(gameData.getName());
                mGameHeaderImages.add(gameData.getHeader_image());
                mGameIds.add(gameData.getSteam_appid());
            }

            @Override
            public void onFailure(Call<GameDetailsResponse5> call, Throwable t) {
                toast("Couldn't fetch details!" + t.getMessage());
            }
        });
        Call<GameDetailsResponse6> gameCall6 = gameDetailsAPI.getGameDetails6(Steam.gameIdsList[6]);
        gameCall6.enqueue(new Callback<GameDetailsResponse6>() {
            @Override
            public void onResponse(Call<GameDetailsResponse6> call, Response<GameDetailsResponse6> response) {
                GameDetailsResponse6 gameDetailsResponse6 = response.body();
                Game game = gameDetailsResponse6.getGame();
                GameData gameData = game.getData();
                mGameTitles.add(gameData.getName());
                mGameHeaderImages.add(gameData.getHeader_image());
                mGameIds.add(gameData.getSteam_appid());
            }

            @Override
            public void onFailure(Call<GameDetailsResponse6> call, Throwable t) {
                toast("Couldn't fetch details!" + t.getMessage());
            }
        });
        mAdapter.setNumberOfPlayers(mPlayers);
        mAdapter.setGames(mGameTitles, mGameHeaderImages, mGameIds);
    }

    void toast(String toastMessage) {
        Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_SHORT).show();
    }
}
