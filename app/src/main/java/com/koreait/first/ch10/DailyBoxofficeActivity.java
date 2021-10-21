package com.koreait.first.ch10;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import com.koreait.first.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DailyBoxofficeActivity extends AppCompatActivity {

    private DatePicker dpTargetDt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_boxoffice);
        dpTargetDt = findViewById(R.id.dpTargetDt);
    }

    private void network(String targetDt) {
        Retrofit rf = new Retrofit.Builder()
                .baseUrl("https://www.kobis.or.kr/kobisopenapi/webservice/rest/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        KobisService service = rf.create(KobisService.class);
        final String KEY = "1a0a7ecf96ad3364d8de70e91560767a";
        Call<BoxOfficeResultBodyVO> call = service.boxofficeSearchDailyBoxOfficeList(KEY, targetDt);

        call.enqueue(new Callback<BoxOfficeResultBodyVO>() {
            @Override
            public void onResponse(Call<BoxOfficeResultBodyVO> call, Response<BoxOfficeResultBodyVO> res) {
                if(res.isSuccessful()) {
                    BoxOfficeResultBodyVO vo = res.body();
                    BoxOfficeResultVO resultVo = vo.getBoxOfficeResult();
                    List<DailyBoxOfficeVO> list = resultVo.getDailyBoxOfficeList();

                    Log.i("myLog", list.size() + "개");

                    for(DailyBoxOfficeVO item : list) {
                        Log.i("myLog", item.getMovieNm());
                    }
                }
           }

            @Override
            public void onFailure(Call<BoxOfficeResultBodyVO> call, Throwable t) {

            }
        });
    }

    public void clkSearch(View v) {
        int day = dpTargetDt.getDayOfMonth();
        int mon = dpTargetDt.getMonth() + 1;
        int year = dpTargetDt.getYear();

        String date = String.format("%s%02d%02d", year, mon, day);
        network(date);

        Log.i("myLog", date);

    }
}

class DailyBoxofficeAdapter extends RecyclerView.Adapter<DailyBoxofficeAdapter.MyViewHolder> {

    private List<DailyBoxOfficeVO> list;

    public void setList(List<DailyBoxOfficeVO> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_daily_boxoffice, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        DailyBoxOfficeVO vo = list.get(position);
        holder.setItem(vo);

        // holder.setItem(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }


    static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tvTitle;
        private TextView tvAudienceCnt;

        public MyViewHolder(View v) {
            super(v);
            tvTitle = v.findViewById(R.id.tvTitle);
            tvAudienceCnt = v.findViewById(R.id.tvAudienceCnt);
        }

        public void setItem(DailyBoxOfficeVO vo) {
            tvTitle.setText(vo.getMovieNm());
            // TODO 관객수 설정
        }



    }
}

