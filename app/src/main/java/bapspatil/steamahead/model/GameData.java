package bapspatil.steamahead.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by bapspatil
 */

public class GameData implements Parcelable {
    @SerializedName("name") String name;
    @SerializedName("detailed_description") String detailedDescription;
    @SerializedName("metacritic") Metacritic metacritic;
    @SerializedName("screenshots") List<Screenshots> screenshots;
    @SerializedName("release_date") ReleaseDate releaseDate;
    @SerializedName("background") String background;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetailedDescription() {
        return detailedDescription;
    }

    public void setDetailedDescription(String detailedDescription) {
        this.detailedDescription = detailedDescription;
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

    public ReleaseDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(ReleaseDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.detailedDescription);
        dest.writeParcelable(this.metacritic, flags);
        dest.writeTypedList(this.screenshots);
        dest.writeParcelable(this.releaseDate, flags);
        dest.writeString(this.background);
    }

    public GameData() {
    }

    protected GameData(Parcel in) {
        this.name = in.readString();
        this.detailedDescription = in.readString();
        this.metacritic = in.readParcelable(Metacritic.class.getClassLoader());
        this.screenshots = in.createTypedArrayList(Screenshots.CREATOR);
        this.releaseDate = in.readParcelable(ReleaseDate.class.getClassLoader());
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
