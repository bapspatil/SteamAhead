package bapspatil.steamahead.network;

import bapspatil.steamahead.model.GameDetailsResponse;
import bapspatil.steamahead.model.PlayersDetailsResponse;
import bapspatil.steamahead.utils.Steam;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by bapspatil
 */

public interface SteamAPI {

    @GET("appdetails")
    Call<GameDetailsResponse> getGameDetails(@Query("appids") String APPIDS);

    @GET("GetGraph")
    Call<PlayersDetailsResponse> getPlayersDetails(@Query("type") String TYPE, @Query("appid") String APPID);

    public static Retrofit gamesRetrofit = new Retrofit.Builder()
            .baseUrl(Steam.GAME_DETAILS_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static Retrofit playersRetrofit = new Retrofit.Builder()
            .baseUrl(Steam.PLAYERS_DETAILS_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
