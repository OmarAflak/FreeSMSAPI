package me.aflak.libraries;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Omar on 21/02/2018.
 */

public interface API {
    String base_url = "https://smsapi.free-mobile.fr";

    @POST("sendmsg")
    Call<ResponseBody> sendMessage(@Body Data data);
}
