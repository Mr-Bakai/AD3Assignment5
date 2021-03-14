package com.hfad.ad3lesson2.ui;
import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
import com.hfad.ad3lesson2.data.model.Film;
import com.hfad.ad3lesson2.data.source.remote.FilmStorage;
import com.hfad.ad3lesson2.ui.base.BaseFragment;
import com.hfad.ad3lesson2.databinding.FragmentFilmBinding;

public class FilmFragment extends BaseFragment<FragmentFilmBinding> {
    private String filmId;

    public FilmFragment(){}

    @Override
    protected FragmentFilmBinding bind() {
        return FragmentFilmBinding.inflate(getLayoutInflater());
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {filmId = getArguments().getString("film");}}

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getFilm();
    }

    private void getFilm() {
        FilmStorage.getFilmById(filmId, new FilmStorage.FilmClick() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onSuccess(Film film) {
                ui.textTitle.setText(film.getTitle());
                ui.textRD.setText("Release Date:   "+ film.getReleaseDate());
                ui.textDesc.setText("Movie Description \n"+ film.getDescription());
                ui.textDirector.setText("Director:   "+film.getDirector());
                ui.textProducer.setText("Producer:   "+film.getProducer());
            }
            @Override
            public void onFailure(String error) {}});}}