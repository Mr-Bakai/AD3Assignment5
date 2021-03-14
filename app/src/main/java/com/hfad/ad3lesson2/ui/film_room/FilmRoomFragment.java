package com.hfad.ad3lesson2.ui.film_room;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
import com.hfad.ad3lesson2.App;
import com.hfad.ad3lesson2.R;
import com.hfad.ad3lesson2.data.model.Film;
import com.hfad.ad3lesson2.databinding.FilmFragmentRoomBinding;
import com.hfad.ad3lesson2.ui.base.BaseFragment;
import com.hfad.ad3lesson2.ui.film_room.adapter.FilmRoomAdapter;

import java.util.ArrayList;

public class FilmRoomFragment extends BaseFragment<FilmFragmentRoomBinding> {
    private ArrayList<Film> list;

    public FilmRoomFragment(){}

    @Override
    protected FilmFragmentRoomBinding bind() {
        return FilmFragmentRoomBinding.inflate(getLayoutInflater());
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list = (ArrayList<Film>) App.filmRepository.getFilms();
    }

    @Override
    public void onViewCreated(@NonNull View view,
                              @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ui.recyclerView.setAdapter(new FilmRoomAdapter(list, this::send));
    }

    private void send(Film film) {
        String filmId = film.getId();
        Bundle bundle = new Bundle();
        bundle.putString("film", filmId);
        navigate(R.id.filmFragment, bundle);
    }

    @Override
    protected void navigate(int id, Bundle bundle) {
        super.navigate(id, bundle);
    }
}