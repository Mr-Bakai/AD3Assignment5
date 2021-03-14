package com.hfad.ad3lesson2.frameworks.room;
import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.hfad.ad3lesson2.data.model.Film;
import com.hfad.ad3lesson2.frameworks.room.dao.FilmsDao;

@Database(entities = {Film.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract FilmsDao filmsDao();
}
