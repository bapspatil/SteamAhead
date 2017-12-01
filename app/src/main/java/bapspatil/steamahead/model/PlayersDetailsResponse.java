package bapspatil.steamahead.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by bapspatil
 */

public class PlayersDetailsResponse {
    @SerializedName("data") @Expose private PlayersData data;

    public PlayersData getData() {
        return data;
    }

    public void setData(PlayersData data) {
        this.data = data;
    }

    public PlayersDetailsResponse(PlayersData data) {

        this.data = data;
    }
}
