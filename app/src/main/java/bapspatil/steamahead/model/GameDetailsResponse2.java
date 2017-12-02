package bapspatil.steamahead.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by bapspatil
 */

public class GameDetailsResponse2 implements Parcelable {
    @JsonProperty("730") private Game game;

    public GameDetailsResponse2(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public GameDetailsResponse2() {

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.game, flags);
    }

    public GameDetailsResponse2(Parcel in) {
        this.game = in.readParcelable(Game.class.getClassLoader());
    }

    public static final Creator<GameDetailsResponse2> CREATOR = new Creator<GameDetailsResponse2>() {
        @Override
        public GameDetailsResponse2 createFromParcel(Parcel source) {
            return new GameDetailsResponse2(source);
        }

        @Override
        public GameDetailsResponse2[] newArray(int size) {
            return new GameDetailsResponse2[size];
        }
    };
}
