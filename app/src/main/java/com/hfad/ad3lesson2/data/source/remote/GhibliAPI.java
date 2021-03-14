package com.hfad.ad3lesson2.data.source.remote;
import com.hfad.ad3lesson2.data.model.Film;
import com.hfad.ad3lesson2.data.model.People;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GhibliAPI {
    @GET(EndPoints.END_POINTS)
    Call<List<Film>> getFilms();

    @GET(EndPoints.END_POINTS_ID)
    Call<Film> getSpecFilm(@Path("id") String id);

    @GET(EndPoints.END_POINTS_PEOPLE)
    Call<List<People>> getPeople();

    @GET(EndPoints.END_POINTS_PEOPLE_BY_ID)
    Call<People> getPeopleById(@Path("id") String id);
}