package com.koreait.first.ch10;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.koreait.first.R;
import com.koreait.first.ch10.searchmoviemodel.ActorVO;
import com.koreait.first.ch10.searchmoviemodel.MovieInfoResultBodyVO;
import com.koreait.first.ch10.searchmoviemodel.MovieInfoResultVO;
import com.koreait.first.ch10.searchmoviemodel.MovieInfoVO;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieDetailActivity extends AppCompatActivity {

    private TextView tvMovieNm;
    private TextView tvMovieNmEn;
    private TextView tvShowTm;
    private RecyclerView rvActorList;
    private ActorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        Intent intent = getIntent();
        String movieCd = intent.getStringExtra("movieCd");
        Log.i("myLog", "detail - movieCd : " + movieCd);
        getData(movieCd);

        tvMovieNm = findViewById(R.id.tvMovieNm);
        tvMovieNmEn = findViewById(R.id.tvMovieNmEn);
        tvShowTm = findViewById(R.id.tvShowTm);
        rvActorList = findViewById(R.id.rvActorList);
        adapter = new ActorAdapter();
        rvActorList.setAdapter(adapter);
    }

    private void getData(String movieCd) {
        Retrofit rf = new Retrofit.Builder()
                .baseUrl("https://www.kobis.or.kr/kobisopenapi/webservice/rest/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        KobisService service = rf.create(KobisService.class);
        final String KEY = "1a0a7ecf96ad3364d8de70e91560767a";
        Call<MovieInfoResultBodyVO> call = service.searchMovieInfo(KEY, movieCd);
        call.enqueue(new Callback<MovieInfoResultBodyVO>() {
            @Override
            public void onResponse(Call<MovieInfoResultBodyVO> call, Response<MovieInfoResultBodyVO> res) {
                if(res.isSuccessful()) { //state : 200 - 통신 성공!!!
                    MovieInfoResultBodyVO result = res.body(); //

                    //2줄로 풀어쓰기
                    MovieInfoResultVO result2 = result.getMovieInfoResult();
                    MovieInfoVO data = result2.getMovieInfo();

                    //1줄로 쓰기
                    MovieInfoVO data2 = result.getMovieInfoResult().getMovieInfo();

                    //전부 1줄
                    MovieInfoVO data3 = res.body().getMovieInfoResult().getMovieInfo();

                    //data나 data2나 같은 주소값

                    tvMovieNm.setText(data.getMovieNm());
                    tvMovieNmEn.setText(data.getMovieNmEn());
                    tvShowTm.setText(data.getShowTm());

                    List<ActorVO> list = data.getActors();
                    adapter.setList(list);

                    // adapter.setList(data.getActors());

                    adapter.notifyDataSetChanged();

                } else {

                }
            }

            @Override
            public void onFailure(Call<MovieInfoResultBodyVO> call, Throwable t) { //baseUrl이 틀리거나, 그 서버가 죽어있을 때, 망에 문제 있거나

            }
        });
    }
}

class ActorAdapter extends RecyclerView.Adapter<ActorAdapter.MyViewHolder> {
    private List<ActorVO> list;

    public void setList(List<ActorVO> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_actor, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ActorVO vo = list.get(position);
        holder.setItem(vo);
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tvPeopleNm;
        private TextView tvPeopleNmEn;
        private TextView tvCast;
        private TextView tvCastEn;

        public MyViewHolder(View v) {
            super(v);
            tvPeopleNm = v.findViewById(R.id.tvPeopleNm);
            tvPeopleNmEn = v.findViewById(R.id.tvPeopleNmEn);
            tvCast = v.findViewById(R.id.tvCast);
            tvCastEn = v.findViewById(R.id.tvCastEn);
        }

        public void setItem(ActorVO vo) {
            tvPeopleNm.setText(vo.getPeopleNm());
            tvPeopleNmEn.setText(vo.getPeopleNmEn());
            tvCast.setText(vo.getCast());
            tvCastEn.setText(vo.getCastEn());
        }
    }
}