package com.example.retrofit2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.retrofit2.client.RetrofitClient;
import com.example.retrofit2.databinding.ActivityMainBinding;
import com.example.retrofit2.entity.Message;
import com.example.retrofit2.service.RetrofitApiService;

import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends Activity {

    private TextView mTextView;
    private Button mButton;
    private ActivityMainBinding binding;
    private RetrofitApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initValues();
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
                getMessage(random.nextInt(3));
            }
        });


    }
    private void initView(){
        mTextView=findViewById(R.id.text);
        mButton=findViewById(R.id.button);
    }
    private void initValues(){
        apiService= RetrofitClient.getApiService();
    }
    private void getMessage (int id){
        apiService.getMessageId(id).enqueue(new Callback<Message>() {
            @Override
            public void onResponse(Call<Message> call, Response<Message> response) {
                Message message=response.body();
                mTextView.setText(message.toString());
            }

            @Override
            public void onFailure(Call<Message> call, Throwable t) {
                mTextView.setText(t.getMessage());
            }
        });
    }

}