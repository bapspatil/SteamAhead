package bapspatil.steamahead.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bapspatil
 */

public class PlayersData implements Parcelable {
    private @SerializedName("values_twitch") List<Integer> players;

    public List<Integer> getPlayers() {
        return players;
    }

    public void setPlayers(List<Integer> players) {
        this.players = players;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(this.players);
    }

    public PlayersData() {
    }

    protected PlayersData(Parcel in) {
        this.players = new ArrayList<Integer>();
        in.readList(this.players, Integer.class.getClassLoader());
    }

    public static final Creator<PlayersData> CREATOR = new Creator<PlayersData>() {
        @Override
        public PlayersData createFromParcel(Parcel source) {
            return new PlayersData(source);
        }

        @Override
        public PlayersData[] newArray(int size) {
            return new PlayersData[size];
        }
    };
}
