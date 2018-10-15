
package sokol.json.player;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Standard {

    @SerializedName("firstName")
    @Expose
    private String firstName;
    @SerializedName("lastName")
    @Expose
    private String lastName;
    @SerializedName("personId")
    @Expose
    private String personId;
    @SerializedName("teamId")
    @Expose
    private String teamId;
    @SerializedName("jersey")
    @Expose
    private String jersey;
    @SerializedName("pos")
    @Expose
    private String pos;
    @SerializedName("teams")
    @Expose
    private List<Team> teams = null;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getJersey() {
        return jersey;
    }

    public void setJersey(String jersey) {
        this.jersey = jersey;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    @Override
    public String toString() {
        return "Standard{" + "firstName=" + firstName + ", lastName=" + lastName + ", personId=" + personId + ", teamId=" + teamId + ", jersey=" + jersey + ", pos=" + pos + ", teams=" + teams + '}';
    }

    

}
