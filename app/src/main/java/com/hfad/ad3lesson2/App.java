package com.hfad.ad3lesson2;
import android.app.Application;
import androidx.room.Room;
import com.hfad.ad3lesson2.data.repo.FilmRepository;
import com.hfad.ad3lesson2.frameworks.room.AppDatabase;
import com.hfad.ad3lesson2.frameworks.room.RoomSource;

public class App extends Application {

    public static FilmRepository filmRepository;
    public static AppDatabase roomDb;

    @Override
    public void onCreate() {
        super.onCreate();
        roomDb = Room.databaseBuilder(
                this,
                AppDatabase.class,
                "app_database"
        )
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
        filmRepository = new FilmRepository(new RoomSource());
    }
}
