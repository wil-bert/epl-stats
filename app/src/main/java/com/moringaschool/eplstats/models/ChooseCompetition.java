
package com.moringaschool.eplstats.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.List;

@Parcel
public class ChooseCompetition {

    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("filters")
    @Expose
    private Filters filters;
    @SerializedName("competitions")
    @Expose
    private List<Competition_> competitions = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ChooseCompetition() {
    }

    /**
     * 
     * @param count
     * @param competitions
     * @param filters
     */
    public ChooseCompetition(Integer count, Filters filters, List<Competition_> competitions) {
        super();
        this.count = count;
        this.filters = filters;
        this.competitions = competitions;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Filters getFilters() {
        return filters;
    }

    public void setFilters(Filters filters) {
        this.filters = filters;
    }

    public List<Competition_> getCompetitions() {
        return competitions;
    }

    public void setCompetitions(List<Competition_> competitions) {
        this.competitions = competitions;
    }

}
