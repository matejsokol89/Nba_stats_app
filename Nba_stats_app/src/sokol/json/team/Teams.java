package sokol.json.team;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Teams {

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