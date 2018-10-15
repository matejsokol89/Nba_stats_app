
package sokol.json.team;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class League {

    @SerializedName("standard")
    @Expose
    private List<Standard> standard = null;

    public List<Standard> getStandard() {
        return standard;
    }

    public void setStandard(List<Standard> standard) {
        this.standard = standard;
    }

}
