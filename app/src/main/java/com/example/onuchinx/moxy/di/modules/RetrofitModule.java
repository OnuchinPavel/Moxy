package com.example.onuchinx.moxy.di.modules;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import rx.schedulers.Schedulers;

/**
 * Created by onuchinx on 21/04/2017.
 */
@Module
public class RetrofitModule {
    @Provides
    @Singleton
    public Retrofit provideRetrofit(Retrofit.Builder builder){
        return  builder.baseUrl("https://api.github.com").build();


    }

    @Provides
    @Singleton
    public  Retrofit.Builder provideRetrofitBuilder(Converter.Factory converterFactory){
        return  new Retrofit.Builder().addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()))
                .addConverterFactory(converterFactory);
    }

    @Provides
    @Singleton
    public Converter.Factory provideConverterFactory(Gson gson){
        return GsonConverterFactory.create(gson);

    }

    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setFieldNamingStrategy(new CustomFieldNamingPolicy())
                .setPrettyPrinting()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .serializeNulls()
                .create();


    }
    private static class CustomFieldNamingPolicy implements FieldNamingStrategy {

        @Override
        public String translateName(java.lang.reflect.Field f) {
            String name = FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES.translateName(f);
            name = name.substring(2, name.length()).toLowerCase();
            return name;
        }
    }
}
