package com.hfad.ad3lesson2.ui.start.adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.hfad.ad3lesson2.data.model.Film;
import com.hfad.ad3lesson2.databinding.ListFilmsBinding;
import java.util.List;

public class StartAdapter extends RecyclerView.Adapter<StartAdapter.ViewHolder> {
    private final List<Film> list;
    private final OnFilmListener onFilmListener;
    private final OnFilmSaveListener onFilmSaveListener;

    public StartAdapter(List<Film> list,
                        OnFilmListener onFilmListener,
                        OnFilmSaveListener onFilmSaveListener) {
        this.list = list;
        this.onFilmListener = onFilmListener;
        this.onFilmSaveListener = onFilmSaveListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ListFilmsBinding ui = ListFilmsBinding.inflate(inflater,parent,false);
        return new ViewHolder(ui);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() { return list.size();}

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ListFilmsBinding ui;

        public ViewHolder(@NonNull ListFilmsBinding ui) {
            super(ui.getRoot());
            this.ui = ui;
            ui.getRoot().setOnClickListener(v -> onFilmListener.onFilmClick(list.get(getAdapterPosition())));
            ui.btnSave.setOnClickListener(v -> onFilmSaveListener.onSaveLocal(list.get(getAdapterPosition())));
        }

        public void onBind(Film film) { ui.textView.setText(film.getTitle());}
    }

    public interface OnFilmListener {
        void onFilmClick(Film film);
    }

    public interface OnFilmSaveListener {
        void onSaveLocal(Film film);
    }
}
