package com.moringaschool.eplstats.network;

import com.moringaschool.eplstats.models.ChooseCompetition;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FootballApi {
    @GET("competitions")
    Call<ChooseCompetition> getCompetitions();
}
