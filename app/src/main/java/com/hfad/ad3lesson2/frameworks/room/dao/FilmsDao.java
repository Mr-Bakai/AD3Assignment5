package com.hfad.ad3lesson2.frameworks.room.dao;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import com.hfad.ad3lesson2.data.model.Film;
import java.util.List;

@Dao
public interface FilmsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertFilm(Film film);

    @Delete
    void deleteFilm(Film film);

    @Update
    void updateFilm(Film film);

    @Query("SELECT * FROM films")
    List<Film> getAllFilms();
}
