package ayur.arkhipov.ru.battlenetoauthapp;

import android.content.Context;

import com.google.gson.Gson;

import java.io.IOException;

import javax.inject.Singleton;

import ayur.arkhipov.ru.battlenetoauthapp.common.Constants;
import ayur.arkhipov.ru.battlenetoauthapp.common.network.api.BlizzardApi;
import dagger.Module;
import dagger.Provides;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import ayur.arkhipov.ru.battlenetoauthapp.utils.Config;

@Module
public class AppModule {
    private App app;

    public AppModule(App app) {
        this.app = app;
    }

    @Singleton
    @Provides
    public Context provideContext() {
        return app.getApplicationContext();
    }

    @Singleton
    @Provides
    public Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(Constants.API_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .client(okHttpClient)
                .build();
    }

    @Singleton
    @Provides
    public OkHttpClient provideOkHttpClient(Config shConfig) {
        return new OkHttpClient().newBuilder().addNetworkInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                HttpUrl originalUrl = chain.request().url();
                HttpUrl url = originalUrl.newBuilder()
                        .addQueryParameter(Constants.ACCESS_TOKEN, shConfig.getAccessToken())
                        .build();
                Request.Builder requestBuilder = chain.request().newBuilder().url(url);
                Request request = requestBuilder.build();
                return chain.proceed(request);
            }
        }).build();
    }

    @Singleton
    @Provides
    public BlizzardApi provideBlizzardApi(Retrofit retrofit) {
        return retrofit.create(BlizzardApi.class);
    }

    @Singleton
    @Provides
    public Config getShConfig(Context context) {
        return new Config(context);
    }

}
