package bapspatil.steamahead.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by bapspatil
 */

public class GameDetailsResponse3 implements Parcelable {
    @SerializedName("235600") private Game game;

    public GameDetailsResponse3(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public GameDetailsResponse3() {

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.game, flags);
    }

    public GameDetailsResponse3(Parcel in) {
        this.game = in.readParcelable(Game.class.getClassLoader());
    }

    public static final Creator<GameDetailsResponse3> CREATOR = new Creator<GameDetailsResponse3>() {
        @Override
        public GameDetailsResponse3 createFromParcel(Parcel source) {
            return new GameDetailsResponse3(source);
        }

        @Override
        public GameDetailsResponse3[] newArray(int size) {
            return new GameDetailsResponse3[size];
        }
    };
}
