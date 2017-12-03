package bapspatil.steamahead.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by bapspatil
 */

public class GameDetailsResponse6 implements Parcelable {
    @SerializedName("550") private Game game;

    public GameDetailsResponse6(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public GameDetailsResponse6() {

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.game, flags);
    }

    public GameDetailsResponse6(Parcel in) {
        this.game = in.readParcelable(Game.class.getClassLoader());
    }

    public static final Creator<GameDetailsResponse6> CREATOR = new Creator<GameDetailsResponse6>() {
        @Override
        public GameDetailsResponse6 createFromParcel(Parcel source) {
            return new GameDetailsResponse6(source);
        }

        @Override
        public GameDetailsResponse6[] newArray(int size) {
            return new GameDetailsResponse6[size];
        }
    };
}
