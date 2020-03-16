package com.example.asuno;

import com.example.asuno.Classes.GetSessionId.SessionJson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
//инициализация Retrofit'а и объекта интерфейса
public class NetworkService {

    private static NetworkService mInstance;
    private Retrofit mRetrofit;

    private NetworkService() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl("http://system.matrixit.ru")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static NetworkService Instance() {
        if (mInstance == null) {
            mInstance = new NetworkService();
        }
        return mInstance;
    }
    public mxApi mxApi() {
        return mRetrofit.create(mxApi.class);
    }
}



