package com.koreait.first.ch10;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.koreait.first.R;
import com.koreait.first.ch10.searchmoviemodel.MovieListResultBodyVO;
import com.koreait.first.ch10.searchmoviemodel.MovieVO;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieListActivity extends AppCompatActivity {
    private Retrofit rf;
    private final String KEY = "1a0a7ecf96ad3364d8de70e91560767a";

    private RecyclerView rvList;
    private MovieListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);

        rf = new Retrofit.Builder()
                .baseUrl("https://www.kobis.or.kr/kobisopenapi/webservice/rest/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        rvList = findViewById(R.id.rvList);
        adapter = new MovieListAdapter();
        rvList.setAdapter(adapter);

        getList();
    }

    private void getList() {
        KobisService service = rf.create(KobisService.class);

        Call<MovieListResultBodyVO> call = service.searchMovieList(KEY);
        call.enqueue(new Callback<MovieListResultBodyVO>() {
            @Override
            public void onResponse(Call<MovieListResultBodyVO> call, Response<MovieListResultBodyVO> response) {
                if(response.isSuccessful()) {
                    MovieListResultBodyVO result = response.body();

                    List<MovieVO> list = result.getMovieListResult().getMovieList();
                    //adapter에 하나씩 넣어준다.
                    for(MovieVO vo : list) {
                        adapter.addItem(vo);
                    }
                    adapter.notifyDataSetChanged();
                } else {
                    Log.e("myLog", "통신 오류");
                }
            }

            @Override
            public void onFailure(Call<MovieListResultBodyVO> call, Throwable t) {
                Log.e("myLog", "통신 실패");
            }
        });
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
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_movie, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        MovieVO obj = list.get(position);
        holder.setItem(obj);
    }

    @Override
    public int getItemCount() {
        return list.size();
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