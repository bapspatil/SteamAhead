package bapspatil.steamahead.network;

import bapspatil.steamahead.model.GameDetailsResponse0;
import bapspatil.steamahead.model.GameDetailsResponse1;
import bapspatil.steamahead.model.GameDetailsResponse2;
import bapspatil.steamahead.model.GameDetailsResponse3;
import bapspatil.steamahead.model.GameDetailsResponse4;
import bapspatil.steamahead.model.GameDetailsResponse5;
import bapspatil.steamahead.model.GameDetailsResponse6;
import bapspatil.steamahead.model.PlayersDetailsResponse;
import bapspatil.steamahead.utils.Steam;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by bapspatil
 */

public interface RetrofitAPI {

    @GET("appdetails/")
    Call<GameDetailsResponse0> getGameDetails0(@Query("appids") String APPIDS);

    @GET("appdetails/")
    Call<GameDetailsResponse1> getGameDetails1(@Query("appids") String APPIDS);

    @GET("appdetails/")
    Call<GameDetailsResponse2> getGameDetails2(@Query("appids") String APPIDS);

    @GET("appdetails/")
    Call<GameDetailsResponse3> getGameDetails3(@Query("appids") String APPIDS);

    @GET("appdetails/")
    Call<GameDetailsResponse4> getGameDetails4(@Query("appids") String APPIDS);

    @GET("appdetails/")
    Call<GameDetailsResponse5> getGameDetails5(@Query("appids") String APPIDS);

    @GET("appdetails/")
    Call<GameDetailsResponse6> getGameDetails6(@Query("appids") String APPIDS);

    @GET("GetGraph/?type=concurrent_week")
    Call<PlayersDetailsResponse> getPlayersDetails(@Query("appid") String APPID);

    Retrofit gamesRetrofit = new Retrofit.Builder()
            .baseUrl(Steam.GAME_DETAILS_URL)
            .addConverterFactory(JacksonConverterFactory.create())
            .build();

    Retrofit playersRetrofit = new Retrofit.Builder()
            .baseUrl(Steam.PLAYERS_DETAILS_URL)
            .addConverterFactory(JacksonConverterFactory.create())
            .build();
}
