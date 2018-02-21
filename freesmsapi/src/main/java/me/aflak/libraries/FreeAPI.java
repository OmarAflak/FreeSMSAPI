package me.aflak.libraries;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Omar on 21/02/2018.
 */

public class FreeAPI {
    private static API api;
    private String user;
    private String pass;

    private final String error400 = "Un des paramètres obligatoires est manquant.";
    private final String error402 = "Trop de SMS ont été envoyés en trop peu de temps.";
    private final String error403 = "Le service n\'est pas activé sur l\'espace abonné, ou login / clé incorrect.";
    private final String error500 = "Erreur côté serveur. Veuillez réessayer ultérieurement.";

    public FreeAPI(String user, String pass) {
        this.user = user;
        this.pass = pass;
        api = getApi();
    }

    private static API getApi(){
        if(api != null){
            return api;
        }
        else{
            return new Retrofit.Builder()
                .baseUrl(API.base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(API.class);
        }
    }

    public void sms(String message, final FreeCallback callback){
        api.sendMessage(new Data(user, pass, message)).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(callback!=null){
                    switch (response.code()){
                        case 200:
                            callback.onSuccess();
                            break;
                        case 400:
                            callback.onFailure(error400);
                            break;
                        case 402:
                            callback.onFailure(error402);
                            break;
                        case 403:
                            callback.onFailure(error403);
                            break;
                        case 500:
                            callback.onFailure(error500);
                            break;
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                if(callback!=null){
                    callback.onFailure(t.getLocalizedMessage());
                }
            }
        });
    }

    public void sms(String message){
        sms(message, null);
    }
}
