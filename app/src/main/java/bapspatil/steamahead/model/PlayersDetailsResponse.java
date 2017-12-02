package bapspatil.steamahead.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bapspatil
 */

public class PlayersDetailsResponse implements Parcelable {
    @JsonProperty("values") private List<Integer> values;

    public List<Integer> getValues() {
        return values;
    }

    public void setValues(List<Integer> values) {
        this.values = values;
    }

    public PlayersDetailsResponse(List<Integer> values) {

        this.values = values;
    }

    public PlayersDetailsResponse() {}

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(this.values);
    }

    protected PlayersDetailsResponse(Parcel in) {
        this.values = new ArrayList<Integer>();
        in.readList(this.values, Integer.class.getClassLoader());
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
