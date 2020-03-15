package com.shovo.jasonbyretrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
//private TextView textView;
private Api_interface api_interface;
private  RecyclerView recyclerView;
private ArrayList<Actor_model.ActorList> actorLists;
    private  Actors_adaptar actors_adaptar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerViewId);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        actorLists =new ArrayList<>();
//        textView=findViewById(R.id.textId);
        api_interface=Apicall.getRetrofit().create(Api_interface.class);



        Call<Actor_model> actor_modelCall =api_interface.getActors();
         actor_modelCall.enqueue(new Callback<Actor_model>() {
             @Override
             public void onResponse(Call<Actor_model> call, Response<Actor_model> response) {

//                 String result ="";
                 List<Actor_model.ActorList> lists =response.body().Actors;
                 for (Actor_model.ActorList actorList:lists){
                     String Name=actorList.getName();
                     String Age=actorList.getAge();
                     String Addrese=actorList.getAddress();
                     String Birthday=actorList.getBirthdate();
                     String Photo=actorList.getPhoto();

                     actorLists.add(new Actor_model.ActorList(Name,Age,Addrese,Birthday,Photo));
                 }

                 actors_adaptar =new Actors_adaptar(MainActivity.this,actorLists);
                 recyclerView.setAdapter(actors_adaptar);
//               textView.setText(result);
             }

             @Override
             public void onFailure(Call<Actor_model> call, Throwable t) {

             }
         });




    }
}
