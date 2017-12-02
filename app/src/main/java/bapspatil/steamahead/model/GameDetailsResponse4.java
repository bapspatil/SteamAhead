package bapspatil.steamahead.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by bapspatil
 */

public class GameDetailsResponse4 implements Parcelable {
    @JsonProperty("582160") private Game game;

    public GameDetailsResponse4(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public GameDetailsResponse4() {

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.game, flags);
    }

    public GameDetailsResponse4(Parcel in) {
        this.game = in.readParcelable(Game.class.getClassLoader());
    }

    public static final Creator<GameDetailsResponse4> CREATOR = new Creator<GameDetailsResponse4>() {
        @Override
        public GameDetailsResponse4 createFromParcel(Parcel source) {
            return new GameDetailsResponse4(source);
        }

        @Override
        public GameDetailsResponse4[] newArray(int size) {
            return new GameDetailsResponse4[size];
        }
    };
}
