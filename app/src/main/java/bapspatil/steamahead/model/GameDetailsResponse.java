package bapspatil.steamahead.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by bapspatil
 */

public class GameDetailsResponse {
    @SerializedName("/[0-9]+/") Game game;

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public GameDetailsResponse(Game game) {

        this.game = game;
    }
}
