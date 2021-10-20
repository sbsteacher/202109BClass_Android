package com.koreait.first.picsum;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.koreait.first.R;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PicsumActivity extends AppCompatActivity {

    private RecyclerView rvList;
    private PicsumAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picsum);

        rvList = findViewById(R.id.rvList);
        adapter = new PicsumAdapter();

        rvList.setAdapter(adapter);

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

                    Log.i("myLog", "------ response 성공 -------");
                    List<PicsumVO> list = response.body();
                    adapter.setList(list);
                    adapter.notifyDataSetChanged();

                } else {
                    Log.d("myLog", "에러 발생");
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

class PicsumAdapter extends RecyclerView.Adapter<PicsumAdapter.PicsumViewHolder> {

    private List<PicsumVO> list;

    public void setList(List<PicsumVO> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public PicsumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_picsum, parent, false);
        return new PicsumViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PicsumViewHolder holder, int position) {
        PicsumVO vo = list.get(position);
        holder.setItem(vo);
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    static class PicsumViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivImg;
        private TextView tvAuthor;
        private View v;

        public PicsumViewHolder(View v) {
            super(v);
            this.v = v;
            ivImg = v.findViewById(R.id.ivImg);
            tvAuthor = v.findViewById(R.id.tvAuthor);
        }

        public void setItem(PicsumVO vo) {
            Glide.with(v).load(vo.getDownload_url()).into(ivImg);
            tvAuthor.setText(vo.getAuthor());
        }
    }
}

