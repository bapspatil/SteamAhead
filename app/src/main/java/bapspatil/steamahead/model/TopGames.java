package bapspatil.steamahead.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by bapspatil
 */

public class TopGames implements Parcelable {
    @SerializedName("appid") int appid;
    @SerializedName("name") String name;
    @SerializedName("players_2weeks") long players;

    public String getHeaderImage() {
        return headerImage;
    }

    public void setHeaderImage(String headerImage) {
        this.headerImage = headerImage;
    }

    String headerImage;

    public int getAppid() {
        return appid;
    }

    public void setAppid(int appid) {
        this.appid = appid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPlayers() {
        return players;
    }

    public void setPlayers(long players) {
        this.players = players;
    }

    public TopGames() {

    }

    public TopGames(int appid, String name, long players) {

        this.appid = appid;
        this.name = name;
        this.players = players;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.appid);
        dest.writeString(this.name);
        dest.writeLong(this.players);
    }

    protected TopGames(Parcel in) {
        this.appid = in.readInt();
        this.name = in.readString();
        this.players = in.readLong();
    }

    public static final Creator<TopGames> CREATOR = new Creator<TopGames>() {
        @Override
        public TopGames createFromParcel(Parcel source) {
            return new TopGames(source);
        }

        @Override
        public TopGames[] newArray(int size) {
            return new TopGames[size];
        }
    };
}
