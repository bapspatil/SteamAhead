package bapspatil.steamahead.network;

import bapspatil.steamahead.model.GameDetailsResponse;
import bapspatil.steamahead.utils.Steam;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by bapspatil
 */

public interface GameDetailsAPI {

    @GET("appdetails/{appids}")
    Call<GameDetailsResponse> getGameDetails(@Query("appids") String APPIDS);

    public static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(Steam.GAME_DETAILS_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

}
