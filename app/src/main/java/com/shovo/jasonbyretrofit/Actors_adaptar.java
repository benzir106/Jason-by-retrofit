package com.shovo.jasonbyretrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class Actors_adaptar extends RecyclerView.Adapter<Actors_adaptar.ExampleViewHolder> {
    
    Context context;
    private ArrayList<Actor_model.ActorList> arrylist;

    public Actors_adaptar(Context context, ArrayList<Actor_model.ActorList> arrylist) {
        this.context = context;
        this.arrylist = arrylist;
        
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        
        View view =LayoutInflater .from(context).inflate(R.layout.activity_profile,parent,false);
        return  new Actors_adaptar.ExampleViewHolder(view);
        
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {

       Actor_model.ActorList currentPosition = arrylist.get(position);
       String name = currentPosition.getName();
       String age = currentPosition.getAge();
       String birthday = currentPosition.getBirthdate();
       String addres = currentPosition.getAddress();
       String img = currentPosition.getPhoto();

       holder.name.setText(name + " ("+age+")");
       holder.address.setText(addres);
       holder.birth.setText(birthday );

       Picasso.get().load(img).into(holder.profileImg);


    }

    @Override
    public int getItemCount() {
        return arrylist.size();
    }


    public class ExampleViewHolder extends RecyclerView.ViewHolder{
        CircleImageView profileImg;
        TextView name,birth,address ;

        
        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            profileImg= itemView.findViewById(R.id.avaterId);
            name= itemView.findViewById(R.id.nameId);
            birth= itemView.findViewById(R.id.birthId);
            address= itemView.findViewById(R.id.addressId);


        }
    }
}


