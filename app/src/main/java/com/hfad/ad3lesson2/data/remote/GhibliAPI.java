package com.hfad.ad3lesson2.data.remote;

import com.hfad.ad3lesson2.data.model.Film;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GhibliAPI {

//    @GET("films/58611129-2dbc-4a81-a72f-77ddfc1b1b49")
//    Call<Film> getFilm();


//    @GET(EndPoints.END_POINTS)
//    Call<List<Film>> getFilms(
////            @Path("id") String id
//    );



    @GET(EndPoints.END_POINTS)
    Call<List<Film>> getFilms();

    @GET(EndPoints.END_POINTS_ID)
    Call<Film> getSpecFilm(
            @Path("id") String id
    );
}