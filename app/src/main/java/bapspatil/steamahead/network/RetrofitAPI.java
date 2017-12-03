package bapspatil.steamahead.network;

import java.util.Map;

import bapspatil.steamahead.model.Game;
import bapspatil.steamahead.model.TopGames;
import bapspatil.steamahead.utils.Steam;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by bapspatil
 */

public interface RetrofitAPI {

    @GET("appdetails/")
    Call<Map<String, Game>> getGameDetails(@Query("appids") String APPIDS);

    @GET("api.php/")
    Call<Map<String, TopGames>> getTopGames(@Query("request") String REQUEST);

    Retrofit gamesRetrofit = new Retrofit.Builder()
            .baseUrl(Steam.GAME_DETAILS_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    Retrofit topGamesRetrofit = new Retrofit.Builder()
            .baseUrl(Steam.STEAM_SPY_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
