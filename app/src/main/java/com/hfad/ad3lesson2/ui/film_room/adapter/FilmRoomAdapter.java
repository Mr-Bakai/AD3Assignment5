package com.hfad.ad3lesson2.ui.film_room.adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.hfad.ad3lesson2.data.model.Film;
import com.hfad.ad3lesson2.databinding.ListSavedBinding;
import java.util.List;

public class FilmRoomAdapter extends RecyclerView.Adapter<FilmRoomAdapter.ViewHolder> {

    private final List<Film> list;
    private final OnFilmRoomListener onFilmRoomListener;

    public FilmRoomAdapter(List<Film> list, OnFilmRoomListener onFilmRoomListener) {
        this.list = list;
        this.onFilmRoomListener = onFilmRoomListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ListSavedBinding ui = ListSavedBinding.inflate(inflater,parent,false);
        return new ViewHolder(ui);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {return list.size();}

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ListSavedBinding ui;

        public ViewHolder(@NonNull ListSavedBinding ui) {
            super(ui.getRoot());
            this.ui = ui;
            ui.getRoot().setOnClickListener(v -> onFilmRoomListener.onFilmRoomClick(list.get(getAdapterPosition())));
        }

        public void onBind(Film s) {ui.textView.setText(s.getTitle());}
    }

    public interface OnFilmRoomListener {
        void onFilmRoomClick(Film film);
    }
}
