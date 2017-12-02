package bapspatil.steamahead.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bapspatil
 */

public class GameData implements Parcelable {
        @JsonProperty("name") String name;
        @JsonProperty("detailed_description") String detailed_description;
        @JsonProperty("metacritic") Metacritic metacritic;
        @JsonProperty("screenshots") List<Screenshots> screenshots = new ArrayList<>();
        @JsonProperty("release_date") ReleaseDate release_date;
        @JsonProperty("background") String background;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetailed_description() {
        return detailed_description;
    }

    public void setDetailed_description(String detailed_description) {
        this.detailed_description = detailed_description;
    }

    public Metacritic getMetacritic() {
        return metacritic;
    }

    public void setMetacritic(Metacritic metacritic) {
        this.metacritic = metacritic;
    }

    public List<Screenshots> getScreenshots() {
        return screenshots;
    }

    public void setScreenshots(List<Screenshots> screenshots) {
        this.screenshots = screenshots;
    }

    public ReleaseDate getRelease_date() {
        return release_date;
    }

    public void setRelease_date(ReleaseDate release_date) {
        this.release_date = release_date;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public GameData(String name, String detailed_description, Metacritic metacritic, List<Screenshots> screenshots, ReleaseDate release_date, String background) {

        this.name = name;
        this.detailed_description = detailed_description;
        this.metacritic = metacritic;
        this.screenshots = screenshots;
        this.release_date = release_date;
        this.background = background;
    }

    public GameData() {

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.detailed_description);
        dest.writeParcelable(this.metacritic, flags);
        dest.writeTypedList(this.screenshots);
        dest.writeParcelable(this.release_date, flags);
        dest.writeString(this.background);
    }

    protected GameData(Parcel in) {
        this.name = in.readString();
        this.detailed_description = in.readString();
        this.metacritic = in.readParcelable(Metacritic.class.getClassLoader());
        this.screenshots = in.createTypedArrayList(Screenshots.CREATOR);
        this.release_date = in.readParcelable(ReleaseDate.class.getClassLoader());
        this.background = in.readString();
    }

    public static final Creator<GameData> CREATOR = new Creator<GameData>() {
        @Override
        public GameData createFromParcel(Parcel source) {
            return new GameData(source);
        }

        @Override
        public GameData[] newArray(int size) {
            return new GameData[size];
        }
    };
}
