package bapspatil.steamahead.network;

import bapspatil.steamahead.model.GameDetailsResponse;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by bapspatil
 */

public interface RetrofitAPI {

    @GET("api/appdetails/")
    Call<GameDetailsResponse> getGameDetails(@Query("appids") int APPIDS);

    public static Retrofit gamesRetrofit = new Retrofit.Builder()
            .baseUrl("http://store.steampowered.com/")
            .addConverterFactory(JacksonConverterFactory.create())
            .build();
}
