package network;

import models.ChooseTeamResponse;
import models.FootballSearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FootballApi {
    @GET("competition/")
    Call<FootballSearchResponse> getCompetition(
            @Query("area") String area,
            @Query("name") String name
    );

    @GET("team/")
    Call<ChooseTeamResponse> getTeam(
            @Query("area") String area,
            @Query("name") String name
    );
}
