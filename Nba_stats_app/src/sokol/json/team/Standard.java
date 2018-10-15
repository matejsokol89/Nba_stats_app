
package sokol.json.team;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Standard {

    @SerializedName("isNBAFranchise")
    @Expose
    private Boolean isNBAFranchise;
    @SerializedName("isAllStar")
    @Expose
    private Boolean isAllStar;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("altCityName")
    @Expose
    private String altCityName;
    @SerializedName("fullName")
    @Expose
    private String fullName;
    @SerializedName("tricode")
    @Expose
    private String tricode;
    @SerializedName("teamId")
    @Expose
    private String teamId;
    @SerializedName("nickname")
    @Expose
    private String nickname;
    @SerializedName("urlName")
    @Expose
    private String urlName;
    @SerializedName("confName")
    @Expose
    private String confName;
    @SerializedName("divName")
    @Expose
    private String divName;

    public Boolean getIsNBAFranchise() {
        return isNBAFranchise;
    }

    public void setIsNBAFranchise(Boolean isNBAFranchise) {
        this.isNBAFranchise = isNBAFranchise;
    }

    public Boolean getIsAllStar() {
        return isAllStar;
    }

    public void setIsAllStar(Boolean isAllStar) {
        this.isAllStar = isAllStar;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAltCityName() {
        return altCityName;
    }

    public void setAltCityName(String altCityName) {
        this.altCityName = altCityName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getTricode() {
        return tricode;
    }

    public void setTricode(String tricode) {
        this.tricode = tricode;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUrlName() {
        return urlName;
    }

    public void setUrlName(String urlName) {
        this.urlName = urlName;
    }

    public String getConfName() {
        return confName;
    }

    public void setConfName(String confName) {
        this.confName = confName;
    }

    public String getDivName() {
        return divName;
    }

    public void setDivName(String divName) {
        this.divName = divName;
    }

    @Override
    public String toString() {
        return "Standard{" + "isNBAFranchise=" + isNBAFranchise + ", isAllStar=" + isAllStar + ", city=" + city + ", altCityName=" + altCityName + ", fullName=" + fullName + ", tricode=" + tricode + ", teamId=" + teamId + ", nickname=" + nickname + ", urlName=" + urlName + ", confName=" + confName + ", divName=" + divName + '}';
    }
    

}
