
package com.moringaschool.eplstats;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FootballSearchResponse {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("area")
    @Expose
    private Area area;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("plan")
    @Expose
    private String plan;
    @SerializedName("currentSeason")
    @Expose
    private CurrentSeason currentSeason;
    @SerializedName("numberOfAvailableSeasons")
    @Expose
    private Integer numberOfAvailableSeasons;
    @SerializedName("lastUpdated")
    @Expose
    private String lastUpdated;

    /**
     * No args constructor for use in serialization
     * 
     */
    public FootballSearchResponse() {
    }

    /**
     * 
     * @param area
     * @param lastUpdated
     * @param code
     * @param currentSeason
     * @param name
     * @param id
     * @param numberOfAvailableSeasons
     * @param plan
     */
    public FootballSearchResponse(Integer id, Area area, String name, String code, String plan, CurrentSeason currentSeason, Integer numberOfAvailableSeasons, String lastUpdated) {
        super();
        this.id = id;
        this.area = area;
        this.name = name;
        this.code = code;
        this.plan = plan;
        this.currentSeason = currentSeason;
        this.numberOfAvailableSeasons = numberOfAvailableSeasons;
        this.lastUpdated = lastUpdated;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public CurrentSeason getCurrentSeason() {
        return currentSeason;
    }

    public void setCurrentSeason(CurrentSeason currentSeason) {
        this.currentSeason = currentSeason;
    }

    public Integer getNumberOfAvailableSeasons() {
        return numberOfAvailableSeasons;
    }

    public void setNumberOfAvailableSeasons(Integer numberOfAvailableSeasons) {
        this.numberOfAvailableSeasons = numberOfAvailableSeasons;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

}
