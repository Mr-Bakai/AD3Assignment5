package com.hfad.ad3lesson2.ui;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.hfad.ad3lesson2.R;
import com.hfad.ad3lesson2.data.model.Film;
import com.hfad.ad3lesson2.data.remote.FilmStorage;

public class FilmFragment extends Fragment {

    private TextView textTitle;
    private TextView textRD;
    private TextView textDesc;
    private TextView textDirector;
    private TextView textProducer;
    private String filmId;

    public FilmFragment(){}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {filmId = getArguments().getString("film");}}

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_film, container, false);
        init(view);
        getFilm();
        return view;
    }

    private void init(View view) {
        textTitle = view.findViewById(R.id.textTitle);
        textRD = view.findViewById(R.id.textRD);
        textDesc = view.findViewById(R.id.textDesc);
        textDirector = view.findViewById(R.id.textDirector);
        textProducer = view.findViewById(R.id.textProducer);
    }

    private void getFilm() {
        FilmStorage.getFilmById(filmId, new FilmStorage.FilmClick() {
            @Override
            public void onSuccess(Film film) {
                textTitle.setText(film.getTitle());
                textRD.setText(film.getReleaseDate());
                textDesc.setText(film.getDescription());
                textDirector.setText(film.getDirector());
                textProducer.setText(film.getProducer());
            }

            @Override
            public void onFailure(String error) {
            }});}
}