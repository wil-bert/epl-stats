package com.moringaschool.eplstats.network;

import com.moringaschool.eplstats.BuildConfig;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.moringaschool.eplstats.Constants.FOOTBALL_API_KEY;
import static com.moringaschool.eplstats.Constants.FOOTBALL_BASE_URL;

public class FootballClient {

    private static Retrofit retrofit = null;

    public static FootballApi getClient() {

        if (retrofit == null) {
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(new Interceptor() {

                @Override
                public Response intercept( Chain chain) throws IOException {
                    Request request = chain.request().newBuilder()
                            .addHeader("api_key", FOOTBALL_API_KEY)
                            .build();
                    return chain.proceed(request);

                }
            }).build();
//            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
//            httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);

//            OkHttpClient.Builder okHttpClient = new okhttp3.OkHttpClient.Builder();
//            okHttpClient
//                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(FOOTBALL_BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(FootballApi.class);
    }
}
