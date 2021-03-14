package com.hfad.ad3lesson2.data.source.remote;
import com.hfad.ad3lesson2.data.model.Film;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilmStorage {
    public static void getListFilm(Result result) {
        RetrofitFactory
                .getInstance()
                .getFilms()
                .enqueue(new Callback<List<Film>>() {
                    @Override
                    public void onResponse(Call<List<Film>> call, Response<List<Film>> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            result.onSuccess(response.body());
                        } else {
                            result.onFailure("Something went wrong");
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Film>> call, Throwable t) {
                        result.onFailure(t.getLocalizedMessage());
                    }
                });
    }

    public static void getFilmById(String id, FilmClick filmClick) {
        RetrofitFactory
                .getInstance()
                .getSpecFilm(id)
                .enqueue(new Callback<Film>() {
                    @Override
                    public void onResponse(Call<Film> call, Response<Film> response) {

                        if (response.isSuccessful() && response.body() != null) {
                            filmClick.onSuccess(response.body());
                        } else {
                            filmClick.onFailure(response.message());
                        }
                    }

                    @Override
                    public void onFailure(Call<Film> call, Throwable t) {
                    }
                });
    }


    public interface Result {
        void onSuccess(List<Film> film);
        void onFailure(String error);
    }

    public interface FilmClick {
        void onSuccess(Film film);
        void onFailure(String error);
    }
}
