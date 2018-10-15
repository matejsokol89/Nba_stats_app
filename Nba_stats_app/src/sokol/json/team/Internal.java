
package sokol.json.team;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Internal {

    @SerializedName("pubDateTime")
    @Expose
    private String pubDateTime;
    @SerializedName("xslt")
    @Expose
    private String xslt;
    @SerializedName("eventName")
    @Expose
    private String eventName;

    public String getPubDateTime() {
        return pubDateTime;
    }

    public void setPubDateTime(String pubDateTime) {
        this.pubDateTime = pubDateTime;
    }

    public String getXslt() {
        return xslt;
    }

    public void setXslt(String xslt) {
        this.xslt = xslt;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

}
