package bapspatil.steamahead.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by bapspatil
 */

public class GameDetailsResponse implements Parcelable {
    private Game game;

    public GameDetailsResponse(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public GameDetailsResponse() {

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.game, flags);
    }

    protected GameDetailsResponse(Parcel in) {
        this.game = in.readParcelable(Game.class.getClassLoader());
    }

    public static final Creator<GameDetailsResponse> CREATOR = new Creator<GameDetailsResponse>() {
        @Override
        public GameDetailsResponse createFromParcel(Parcel source) {
            return new GameDetailsResponse(source);
        }

        @Override
        public GameDetailsResponse[] newArray(int size) {
            return new GameDetailsResponse[size];
        }
    };
}
