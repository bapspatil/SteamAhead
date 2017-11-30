package bapspatil.steamahead.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by bapspatil
 */

public class PlayersDetailsResponse implements Parcelable {
    @SerializedName("data") @Expose PlayersData playersData;

    public PlayersData getPlayersData() {
        return playersData;
    }

    public void setPlayersData(PlayersData playersData) {
        this.playersData = playersData;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.playersData, flags);
    }

    public PlayersDetailsResponse() {
    }

    protected PlayersDetailsResponse(Parcel in) {
        this.playersData = in.readParcelable(PlayersData.class.getClassLoader());
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
