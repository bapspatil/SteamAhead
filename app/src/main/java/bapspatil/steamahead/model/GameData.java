package bapspatil.steamahead.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bapspatil
 */

public class GameData implements Parcelable {
    @JsonIgnore Object type, required_age, is_free, controller_support, about_the_game, supported_languages, short_description, website, pc_requirements, mac_requirements, linux_requirements, legal_notice, ext_user_account_notice, developers, publishers, price_overview, packages, package_groups, platforms, categories, genres, movies, recommendations, achievements, support_info, background, dlc, reviews;

    @JsonProperty("steam_appid") String steam_appid;
    @JsonProperty("name") String name;
    @JsonProperty("detailed_description") String detailed_description;
    @JsonProperty("metacritic") Metacritic metacritic;
    @JsonProperty("screenshots") List<Screenshots> screenshots = new ArrayList<>();
    @JsonProperty("release_date") ReleaseDate release_date;
    @JsonProperty("header_image") String header_image;

    public GameData(String steam_appid, String name, String detailed_description, Metacritic metacritic, List<Screenshots> screenshots, ReleaseDate release_date, String header_image) {
        this.steam_appid = steam_appid;
        this.name = name;
        this.detailed_description = detailed_description;
        this.metacritic = metacritic;
        this.screenshots = screenshots;
        this.release_date = release_date;
        this.header_image = header_image;
    }

    public String getSteam_appid() {
        return steam_appid;
    }

    public void setSteam_appid(String steam_appid) {
        this.steam_appid = steam_appid;
    }

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

    public String getHeader_image() {
        return header_image;
    }

    public void setHeader_image(String header_image) {
        this.header_image = header_image;
    }

    public GameData(JSONObject jsonGameData) {
        try {
            this.name = jsonGameData.getString("name");
            this.detailed_description = jsonGameData.getString("detailed_description");
            this.header_image = jsonGameData.getString("header_image");
            JSONObject jsonMetacritic = jsonGameData.getJSONObject("metacritic");
            this.metacritic = new Metacritic(jsonMetacritic.getInt("score"));
            JSONObject jsonReleaseDate = jsonGameData.getJSONObject("release_date");
            this.release_date = new ReleaseDate(jsonReleaseDate.getString("date"));
            JSONArray jsonScreenshots = jsonGameData.getJSONArray("screenshots");
            this.screenshots = new ArrayList<>();
            for (int j = 0; j < jsonScreenshots.length(); j++) {
                JSONObject jsonScreenshot = jsonScreenshots.getJSONObject(j);
                Screenshots screenshot = new Screenshots(jsonScreenshot.getString("path_thumbnail"));
                screenshots.add(screenshot);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public GameData() {

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.steam_appid);
        dest.writeString(this.name);
        dest.writeString(this.detailed_description);
        dest.writeParcelable(this.metacritic, flags);
        dest.writeTypedList(this.screenshots);
        dest.writeParcelable(this.release_date, flags);
        dest.writeString(this.header_image);
    }

    protected GameData(Parcel in) {
        this.steam_appid = in.readString();
        this.name = in.readString();
        this.detailed_description = in.readString();
        this.metacritic = in.readParcelable(Metacritic.class.getClassLoader());
        this.screenshots = in.createTypedArrayList(Screenshots.CREATOR);
        this.release_date = in.readParcelable(ReleaseDate.class.getClassLoader());
        this.header_image = in.readString();
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
