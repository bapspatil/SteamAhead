package bapspatil.steamahead.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by bapspatil
 */

public class PlayersData implements Parcelable {
    @SerializedName("values") private ArrayList<Integer> values = new ArrayList<>(10000);


    public PlayersData() {

    }

    public ArrayList<Integer> getValues() {
        return values;
    }

    public void setValues(ArrayList<Integer> values) {
        this.values = values;
    }

    public PlayersData(ArrayList<Integer> values) {

        this.values = values;
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
