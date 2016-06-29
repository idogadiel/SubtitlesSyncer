
package RippedLipsPoints;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "time",
    "talking",
    "points"
})
public class Frame {

    @JsonProperty("time")
    private String time;
    @JsonProperty("talking")
    private String talking;
    @JsonProperty("points")
    private List<Point> points = new ArrayList<Point>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Frame() {
    }

    /**
     * 
     * @param talking
     * @param time
     * @param points
     */
    public Frame(String time, String talking, List<Point> points) {
        this.time = time;
        this.talking = talking;
        this.points = points;
    }

    /**
     * 
     * @return
     *     The time
     */
    @JsonProperty("time")
    public String getTime() {
        return time;
    }

    /**
     * 
     * @param time
     *     The time
     */
    @JsonProperty("time")
    public void setTime(String time) {
        this.time = time;
    }

    public Frame withTime(String time) {
        this.time = time;
        return this;
    }

    /**
     * 
     * @return
     *     The talking
     */
    @JsonProperty("talking")
    public String getTalking() {
        return talking;
    }

    /**
     * 
     * @param talking
     *     The talking
     */
    @JsonProperty("talking")
    public void setTalking(String talking) {
        this.talking = talking;
    }

    public Frame withTalking(String talking) {
        this.talking = talking;
        return this;
    }

    /**
     * 
     * @return
     *     The points
     */
    @JsonProperty("points")
    public List<Point> getPoints() {
        return points;
    }

    /**
     * 
     * @param points
     *     The points
     */
    @JsonProperty("points")
    public void setPoints(List<Point> points) {
        this.points = points;
    }

    public Frame withPoints(List<Point> points) {
        this.points = points;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Frame withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(time).append(talking).append(points).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Frame) == false) {
            return false;
        }
        Frame rhs = ((Frame) other);
        return new EqualsBuilder().append(time, rhs.time).append(talking, rhs.talking).append(points, rhs.points).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
