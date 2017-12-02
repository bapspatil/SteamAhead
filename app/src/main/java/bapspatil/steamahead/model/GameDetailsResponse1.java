package bapspatil.steamahead.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by bapspatil
 */

public class GameDetailsResponse1 implements Parcelable {
    @JsonProperty("476600") private Game game;

    public GameDetailsResponse1(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public GameDetailsResponse1() {

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.game, flags);
    }

    public GameDetailsResponse1(Parcel in) {
        this.game = in.readParcelable(Game.class.getClassLoader());
    }

    public static final Creator<GameDetailsResponse1> CREATOR = new Creator<GameDetailsResponse1>() {
        @Override
        public GameDetailsResponse1 createFromParcel(Parcel source) {
            return new GameDetailsResponse1(source);
        }

        @Override
        public GameDetailsResponse1[] newArray(int size) {
            return new GameDetailsResponse1[size];
        }
    };
}
