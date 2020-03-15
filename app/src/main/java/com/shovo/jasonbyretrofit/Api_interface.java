package com.shovo.jasonbyretrofit;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api_interface {
@GET("bn99m")
    Call<Actor_model> getActors();



}
