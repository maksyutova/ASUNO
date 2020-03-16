package com.example.asuno.Classes;

import android.content.Context;
import android.widget.ListView;

import com.example.asuno.Classes.GetSessionId.SessionJson;
import com.example.asuno.Classes.RowCache.RowCache;
import com.example.asuno.Classes.RowCache.RowFromRowCache;
import com.example.asuno.Message;
import com.example.asuno.NetworkService;
import com.example.asuno.Poll;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.internal.Util;
import retrofit2.Call;
import retrofit2.Response;

public class ApiQuery {

    private static ApiQuery Instance = new ApiQuery();

    public static ApiQuery Instance() {
        return Instance;
    }

    Gson gson = new Gson();
    String gSessionId = "";
    RowFromRowCache[] rows1;
    ListView listView;

    public void GetSession() {
        SessionJson msgSession = new SessionJson();
        msgSession.setWhat("auth-by-login");
        msgSession.setLoginPassword("admin", "7472ee515fd6610cf741dccee9abef5a");
        String json = gson.toJson(msgSession);
        Call<SessionJson> call = NetworkService.Instance().mxApi().getSessionId(json);

        try {
            Response<SessionJson> response = call.execute(); // Синхронный звпрос
            SessionJson sessionJson = response.body();
            gSessionId = sessionJson.getBody().getSessionId();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Message MessageExecute(String what, Object body, ApiQuery context) {
        Message message = new Message();
        Message answerMessage = new Message();
        if (gSessionId == null || gSessionId == "") {
            return answerMessage;//isGetSession(context);
        }
        message.setHead(what, gSessionId);
        message.setBody(body);
        String json = gson.toJson(message);
        Call<Message> call = NetworkService.Instance().mxApi().message(json);
        try {
            Response<Message> response = call.execute();
            if (!response.isSuccessful()) return null;
            answerMessage = response.body();
        } catch (IOException e) {

        }
        return answerMessage;

    }

    public RowFromRowCache[] RowCache() {
        RowCache rowCache = new RowCache();
        rowCache.setFolderId("341d083e-6d83-48dd-8033-3aaeb5970ddb");
        Message message = MessageExecute("rows-get-2", rowCache, this);
        String json1 = gson.toJson(message.getBody());
        RowCache rowCache1 = gson.fromJson(json1, RowCache.class);
        RowFromRowCache[] row = rowCache1.getRows();
        return row;
    }

    public void Poll(String objectId, String cmd, String components, Context context) {
        Poll poll = new Poll();
        poll.setPoll1(new String[]{objectId}, cmd, components);
        Message answer = MessageExecute("poll", poll, this);
        String what = answer.getHead().getWhat();
        if (what.equals("poll-accepted")) {
            String tmp = what;
        }
    }
 }
