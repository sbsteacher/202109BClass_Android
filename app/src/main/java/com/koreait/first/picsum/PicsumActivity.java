package com.koreait.first.picsum;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.koreait.first.R;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PicsumActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picsum);
        network();
    }

    private void network() {

        Retrofit rf = new Retrofit.Builder()
                .baseUrl("https://picsum.photos")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //RetrofitService 인터페이스를 구현한 객체를 리턴해 줍니다.
        RetrofitService service = rf.create(RetrofitService.class);

        Call<List<PicsumVO>> call = service.getList();

        //비동기처리
        call.enqueue(new Callback<List<PicsumVO>>() {
            //응답이 성공한 경우 실행될 내용작성
            @Override
            public void onResponse(Call<List<PicsumVO>> call, Response<List<PicsumVO>> response) {
                if(response.isSuccessful()) {
                    List<PicsumVO> list = response.body();
                    Log.i("myLog", "------ response 성공 -------");
                    for(PicsumVO vo : list) {
                        Log.i("myLog", vo.getAuthor());
                    }
                } else {
                    Log.d("myLog", "response 실패");
                }
            }

            //응답이 실패한 경우 실행될 내용작성
            @Override
            public void onFailure(Call<List<PicsumVO>> call, Throwable t) {
                Log.d("myLog", "통신 실패");
            }
        });

    }
}