package bapspatil.steamahead.network;

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

public interface PlayersDetailsAPI {

    @GET("GetGraph/?type=concurrent_week")
    Call<PlayersDetailsResponse> getPlayersDetails(@Query("appid") String APPID);

    public static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(Steam.PLAYERS_DETAILS_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
