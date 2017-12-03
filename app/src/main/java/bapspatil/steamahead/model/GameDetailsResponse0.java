package bapspatil.steamahead.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by bapspatil
 */

public class GameDetailsResponse0 implements Parcelable {
    @SerializedName("271590") private Game game;

    public GameDetailsResponse0(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public GameDetailsResponse0() {

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.game, flags);
    }

    public GameDetailsResponse0(Parcel in) {
        this.game = in.readParcelable(Game.class.getClassLoader());
    }

    public static final Creator<GameDetailsResponse0> CREATOR = new Creator<GameDetailsResponse0>() {
        @Override
        public GameDetailsResponse0 createFromParcel(Parcel source) {
            return new GameDetailsResponse0(source);
        }

        @Override
        public GameDetailsResponse0[] newArray(int size) {
            return new GameDetailsResponse0[size];
        }
    };
}
