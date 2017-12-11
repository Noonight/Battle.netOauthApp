package ayur.arkhipov.ru.battlenetoauthapp.common.network;


import com.google.gson.Gson;

import ayur.arkhipov.ru.battlenetoauthapp.common.log.Log;
import ayur.arkhipov.ru.battlenetoauthapp.common.network.api.BlizzardApi;
import ayur.arkhipov.ru.battlenetoauthapp.common.network_blizzard.model.AccessToken;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkManager {
    private BlizzardApi blizzardApi;
    private OkHttpClient okHttpClient;

    public NetworkManager(AccessToken accessToken) {
        okHttpClient = new OkHttpClient().newBuilder().addNetworkInterceptor(chain -> {
            HttpUrl originalUrl = chain.request().url();
            HttpUrl url = originalUrl.newBuilder()
                    .addQueryParameter("access_token", accessToken.getAccess_token())
                    .build();
            Log.d(String.valueOf(url));
            Request.Builder requestBuilder = chain.request().newBuilder()
                    .url(url);
            Request request = requestBuilder.build();
            return chain.proceed(request);
        }).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://eu.api.battle.net")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .client(okHttpClient)
                .build();
        blizzardApi = retrofit.create(BlizzardApi.class);
    }

    public BlizzardApi getBlizzardApi() {
        return blizzardApi;
    }
}
