package com.hfad.ad3lesson2.frameworks.room;
import com.hfad.ad3lesson2.App;
import com.hfad.ad3lesson2.data.model.Film;
import com.hfad.ad3lesson2.data.source.local.FilmSource;
import java.util.List;

public class RoomSource implements FilmSource {
    @Override
    public void addFilm(Film film) { App.roomDb.filmsDao().insertFilm(film);}

    @Override
    public List<Film> getFilms() { return App.roomDb.filmsDao().getAllFilms();}
}
