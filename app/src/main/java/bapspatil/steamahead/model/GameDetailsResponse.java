package bapspatil.steamahead.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by bapspatil
 */

public class GameDetailsResponse implements Parcelable {
    @SerializedName("data") GameData data;

    public GameData getData() {
        return data;
    }

    public void setData(GameData data) {
        this.data = data;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.data, flags);
    }

    public GameDetailsResponse() {
    }

    protected GameDetailsResponse(Parcel in) {
        this.data = in.readParcelable(GameData.class.getClassLoader());
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
