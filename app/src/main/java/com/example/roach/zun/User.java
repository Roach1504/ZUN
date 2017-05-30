package com.example.roach.zun;


import android.app.Application;
import android.content.res.Resources;

import java.util.HashMap;

public final class User extends Application {
    private User ourInstance = new User();

    private HashMap<String, String> answer = new HashMap<>();
    @Override
    public void onCreate() {
        super.onCreate();
        Resources u = this.getResources();
    }
    private User getInstance() {
        return ourInstance;
    }

    public void saveAnswer(String keyQuestion, String question){
        answer.put(keyQuestion, question);
    }

    public HashMap<String, String> getanswer(){
        return this.answer;
    }
}
