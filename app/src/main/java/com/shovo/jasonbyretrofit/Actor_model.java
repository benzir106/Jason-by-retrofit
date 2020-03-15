package com.shovo.jasonbyretrofit;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Actor_model {

    public ArrayList<ActorList> Actors = null;


    public static class ActorList {

        private String name;
        private String age;
        @SerializedName("Born At")
        private String address;
        private String Birthdate;
        private String photo;

        public ActorList(String name, String age, String address,  String birthdate, String photo) {
            this.name = name;
            this.age = age;
            this.address = address;
            this.Birthdate = birthdate;
            this.photo = photo;
        }


        public String getName() {
            return name;
        }

        public String getAge() {
            return age;
        }

        public String getAddress() {
            return address;
        }

        public String getBirthdate() {
            return Birthdate;
        }

        public String getPhoto() {
            return photo;
        }
    }


}




