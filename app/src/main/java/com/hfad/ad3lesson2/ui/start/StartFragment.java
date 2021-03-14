package com.hfad.ad3lesson2.ui.start;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
import com.hfad.ad3lesson2.App;
import com.hfad.ad3lesson2.R;
import com.hfad.ad3lesson2.data.model.Film;
import com.hfad.ad3lesson2.data.source.remote.FilmStorage;
import com.hfad.ad3lesson2.ui.base.BaseFragment;
import com.hfad.ad3lesson2.ui.start.adapter.StartAdapter;
import java.util.List;
import com.hfad.ad3lesson2.databinding.FragmentStartBinding;

public class StartFragment extends BaseFragment<FragmentStartBinding> {

    public StartFragment(){}

    @Override
    protected FragmentStartBinding bind() {
        return FragmentStartBinding.inflate(getLayoutInflater());
    }

    @Override
    public void onViewCreated(@NonNull View view,
                              @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadFilm();
    }

    private void loadFilm() {
        FilmStorage.getListFilm(new FilmStorage.Result() {
            @Override
            public void onSuccess(List<Film> film) {set(film);}
            @Override
            public void onFailure(String error) {}});
    }

    private void set(List<Film> film) {
        ui.recyclerView.setAdapter(new StartAdapter(
                film,
                this::send,
                (Film film2) -> App.filmRepository.addFilm(film2)));
        ui.btnSaved.setOnClickListener((View v) -> navigate(R.id.filmRoomFragment, null));
    }

    private void send(Film film1) {
        String filmId = film1.getId();
        Bundle bundle = new Bundle();
        bundle.putString("film", filmId);
        StartFragment.this.navigate(R.id.filmFragment, bundle);
    }

    @Override
    protected void navigate(int id, Bundle bundle) { super.navigate(id, bundle);}
}