package bapspatil.steamahead.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by bapspatil
 */

public class PlayersData {
    @SerializedName("values") @Expose private int[] values;

    public int[] getValues() {
        return values;
    }

    public void setValues(int[] values) {
        this.values = values;
    }

    public PlayersData(int[] values) {

        this.values = values;
    }
}
