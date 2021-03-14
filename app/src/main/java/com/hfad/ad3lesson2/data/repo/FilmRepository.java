package com.hfad.ad3lesson2.data.repo;
import com.hfad.ad3lesson2.data.model.Film;
import com.hfad.ad3lesson2.data.source.local.FilmSource;
import java.util.List;

public class FilmRepository {
    private final FilmSource filmSource;

    public FilmRepository(FilmSource filmSource) { this.filmSource = filmSource;}

    public void addFilm(Film film){ filmSource.addFilm(film);}

    public List<Film> getFilms(){ return filmSource.getFilms();}
}
