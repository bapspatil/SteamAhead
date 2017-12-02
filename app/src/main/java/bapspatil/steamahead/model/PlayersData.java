package bapspatil.steamahead.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bapspatil
 */

public class PlayersData implements Parcelable {
    @JsonProperty("values") private List<Integer> values;

    public List<Integer> getValues() {
        return values;
    }

    public void setValues(List<Integer> values) {
        this.values = values;
    }

    public PlayersData(List<Integer> values) {

        this.values = values;
    }

    public PlayersData() {

    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(this.values);
    }

    protected PlayersData(Parcel in) {
        this.values = new ArrayList<Integer>();
        in.readList(this.values, Integer.class.getClassLoader());
    }

    public static final Parcelable.Creator<PlayersData> CREATOR = new Parcelable.Creator<PlayersData>() {
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
