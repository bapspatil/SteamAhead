package bapspatil.steamahead.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by bapspatil
 */

public class GameDetailsResponse5 implements Parcelable {
    @SerializedName("203140") private Game game;

    public GameDetailsResponse5(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public GameDetailsResponse5() {

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.game, flags);
    }

    public GameDetailsResponse5(Parcel in) {
        this.game = in.readParcelable(Game.class.getClassLoader());
    }

    public static final Creator<GameDetailsResponse5> CREATOR = new Creator<GameDetailsResponse5>() {
        @Override
        public GameDetailsResponse5 createFromParcel(Parcel source) {
            return new GameDetailsResponse5(source);
        }

        @Override
        public GameDetailsResponse5[] newArray(int size) {
            return new GameDetailsResponse5[size];
        }
    };
}
