package com.koreait.first.ch10;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.koreait.first.R;
import com.koreait.first.ch10.searchmoviemodel.MovieVO;

import java.util.ArrayList;
import java.util.List;

public class MovieListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);
    }
}

class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MyViewHolder> {
    private List<MovieVO> list = new ArrayList();

    public void addItem(MovieVO vo) {
        list.add(vo);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tvMovieNm;
        private TextView tvRepNationNm;
        private TextView tvMovieNmEn;
        private TextView tvRepGenreNm;

        public MyViewHolder(View v) {
            super(v);
            tvMovieNm = v.findViewById(R.id.tvMovieNm);
            tvRepNationNm = v.findViewById(R.id.tvRepNationNm);
            tvMovieNmEn = v.findViewById(R.id.tvMovieNmEn);
            tvRepGenreNm = v.findViewById(R.id.tvRepGenreNm);
        }

        public void setItem(MovieVO vo) {
            tvMovieNm.setText(vo.getMovieNm());
            tvRepNationNm.setText(vo.getRepNationNm());
            tvMovieNmEn.setText(vo.getMovieNmEn());
            tvRepGenreNm.setText(vo.getRepGenreNm());
        }
    }
}