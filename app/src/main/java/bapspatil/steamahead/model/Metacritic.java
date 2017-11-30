package bapspatil.steamahead.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by bapspatil
 */

public class Metacritic implements Parcelable {

    @SerializedName("score") int score;
    @SerializedName("url") String url;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.score);
        dest.writeString(this.url);
    }

    public Metacritic() {
    }

    protected Metacritic(Parcel in) {
        this.score = in.readInt();
        this.url = in.readString();
    }

    public static final Creator<Metacritic> CREATOR = new Creator<Metacritic>() {
        @Override
        public Metacritic createFromParcel(Parcel source) {
            return new Metacritic(source);
        }

        @Override
        public Metacritic[] newArray(int size) {
            return new Metacritic[size];
        }
    };
}
