package com.hfad.ad3lesson2.data.source.local;
import com.hfad.ad3lesson2.data.model.Film;
import java.util.List;
public interface FilmSource {
    void addFilm(Film film);
    List<Film> getFilms();
}
