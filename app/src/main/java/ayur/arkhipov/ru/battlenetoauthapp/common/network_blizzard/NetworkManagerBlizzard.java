package ayur.arkhipov.ru.battlenetoauthapp.common.network_blizzard;


import android.content.SharedPreferences;
import android.support.annotation.Nullable;

import com.google.gson.Gson;

import java.io.IOException;

import ayur.arkhipov.ru.battlenetoauthapp.common.log.Log;
import ayur.arkhipov.ru.battlenetoauthapp.common.network_blizzard.api.BlizzardOauthApi;
import okhttp3.Authenticator;
import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public final class NetworkManagerBlizzard {

    private OkHttpClient.Builder okHttpClientBuilder;
    private BlizzardOauthApi blizzardOauthApi;
    private SharedPreferences sharedPreferences;

    public NetworkManagerBlizzard() {
        /*okHttpClient = new OkHttpClient().newBuilder().addNetworkInterceptor(chain -> {

            HttpUrl originalUrl = chain.request().url();

            HttpUrl url = originalUrl.newBuilder()
                    //.addQueryParameter("api_key", mSharedPreferences.getString("api_key", ""))
                    //.addQueryParameter("api_key", API_KEY)
                    //.addQueryParameter("page", mSharedPreferences.getString("page", "1"))
                    .build();
            //Log.d(String.valueOf(url));
            Request.Builder requestBuilder = chain.request().newBuilder()
                    .url(url);
            Request request = requestBuilder.build();

            return chain.proceed(request);
        }).build();*/

        okHttpClientBuilder = new OkHttpClient.Builder();

        okHttpClientBuilder.authenticator((route, response) -> {
            String clientId = "turbu6bcedutvmequfywpkrkvyjrvabg";
            String clientSecret = "6YhGZBPBpT2HQtRrEEZWKAD4hNxGU2xw";
            String credential = Credentials.basic(clientId, clientSecret);
            if (credential.equals(response.request().header("Authorization"))) {
                return null; // If we already failed with these credentials, don't retry.
            }
            return response.request().newBuilder()
                    .header("Authorization", credential)
                    .build();
        });
        //Log.d(okHttpClientBuilder.toString());

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://eu.battle.net")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .client(okHttpClientBuilder.build())
                .build();
        blizzardOauthApi = retrofit.create(BlizzardOauthApi.class);
    }

    public final BlizzardOauthApi getBlizzardOauthApi() {
        return blizzardOauthApi;
    }

}
