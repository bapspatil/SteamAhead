package bapspatil.steamahead.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by bapspatil
 */

public class Screenshots implements Parcelable {

    private @SerializedName("path_thumbnail") String pathThumbnail;

    public String getPathThumbnail() {
        return pathThumbnail;
    }

    public void setPathThumbnail(String pathThumbnail) {
        this.pathThumbnail = pathThumbnail;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.pathThumbnail);
    }

    public Screenshots() {
    }

    protected Screenshots(Parcel in) {
        this.pathThumbnail = in.readString();
    }

    public static final Creator<Screenshots> CREATOR = new Creator<Screenshots>() {
        @Override
        public Screenshots createFromParcel(Parcel source) {
            return new Screenshots(source);
        }

        @Override
        public Screenshots[] newArray(int size) {
            return new Screenshots[size];
        }
    };
}
