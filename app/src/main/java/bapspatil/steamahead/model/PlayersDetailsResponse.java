package bapspatil.steamahead.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by bapspatil
 */

public class PlayersDetailsResponse implements Parcelable {
    @SerializedName("data") PlayersData data;

    public PlayersData getData() {
        return data;
    }

    public void setData(PlayersData data) {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.data, flags);
    }

    public PlayersDetailsResponse() {
    }

    protected PlayersDetailsResponse(Parcel in) {
        this.data = in.readParcelable(PlayersData.class.getClassLoader());
    }

    public static final Creator<PlayersDetailsResponse> CREATOR = new Creator<PlayersDetailsResponse>() {
        @Override
        public PlayersDetailsResponse createFromParcel(Parcel source) {
            return new PlayersDetailsResponse(source);
        }

        @Override
        public PlayersDetailsResponse[] newArray(int size) {
            return new PlayersDetailsResponse[size];
        }
    };
}
