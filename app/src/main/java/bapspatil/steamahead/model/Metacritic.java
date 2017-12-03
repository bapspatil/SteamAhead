package bapspatil.steamahead.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by bapspatil
 */

public class Metacritic implements Parcelable {

    @SerializedName("score") int score;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Metacritic(int score) {

        this.score = score;
    }

    public Metacritic() {

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.score);
    }

    protected Metacritic(Parcel in) {
        this.score = in.readInt();
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
