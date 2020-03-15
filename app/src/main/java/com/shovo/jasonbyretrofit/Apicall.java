package com.shovo.jasonbyretrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Apicall {


    public static final String BASEURL ="http://api.myjson.com/bins/";
    public  static Retrofit retrofit= null;
    public  static Retrofit getRetrofit(){

        if (retrofit==null){
            retrofit =new Retrofit.Builder().baseUrl(BASEURL).addConverterFactory(GsonConverterFactory.create()).build();

        }
        return retrofit;
    }
}


