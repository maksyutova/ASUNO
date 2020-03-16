package com.example.asuno;

import com.example.asuno.Classes.GetSessionId.SessionJson;
import com.example.asuno.Classes.RowCache.RowCache;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface mxApi {
    @GET("api/transport")
    Call<SessionJson>getSessionId(@Query("message")String message);

    @GET("api/transport")
    Call<RowCache>getRowCache(@Query("message")String message);

    @GET("api/transport")
    Call<Message> message(@Query("message") String message);
}
