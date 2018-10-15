
package sokol.json.player;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Team {

    @SerializedName("teamId")
    @Expose
    private String teamId;
    @SerializedName("seasonStart")
    @Expose
    private String seasonStart;
    @SerializedName("seasonEnd")
    @Expose
    private String seasonEnd;

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getSeasonStart() {
        return seasonStart;
    }

    public void setSeasonStart(String seasonStart) {
        this.seasonStart = seasonStart;
    }

    public String getSeasonEnd() {
        return seasonEnd;
    }

    public void setSeasonEnd(String seasonEnd) {
        this.seasonEnd = seasonEnd;
    }

    @Override
    public String toString() {
        return "Team{" + "teamId=" + teamId + ", seasonStart=" + seasonStart + ", seasonEnd=" + seasonEnd + '}';
    }

    

}
