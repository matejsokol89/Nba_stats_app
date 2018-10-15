
package sokol.json.player;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Player {

    @SerializedName("league")
    @Expose
    private League league;

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    
}
