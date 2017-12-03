package bapspatil.steamahead.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by bapspatil
 */

public class ReleaseDate implements Parcelable {

    @SerializedName("date") String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ReleaseDate(String date) {
        this.date = date;
    }

    @Override

    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.date);
    }

    public ReleaseDate() {
    }

    protected ReleaseDate(Parcel in) {
        this.date = in.readString();
    }

    public static final Creator<ReleaseDate> CREATOR = new Creator<ReleaseDate>() {
        @Override
        public ReleaseDate createFromParcel(Parcel source) {
            return new ReleaseDate(source);
        }

        @Override
        public ReleaseDate[] newArray(int size) {
            return new ReleaseDate[size];
        }
    };
}
