package com.example.kursinisdarbas;

import static com.example.kursinisdarbas.helpers.Constants.VALIDATE_USER;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;

import com.example.kursinisdarbas.helpers.Rest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void validateUser(View view) {
        //susirinkti duomenys
        TextView login = findViewById(R.id.loginField);
        TextView password = findViewById(R.id.passwordField);
        //Susikurti jsona login,pw
        //Gal reiks GsonBuilder build = new GsonBuilder();

        Gson gson = new Gson();
        JsonObject jsonObject =new JsonObject();
        jsonObject.addProperty("login", login.getText().toString());
        jsonObject.addProperty("password", password.getText().toString());

        String info = gson.toJson(jsonObject);
        System.out.println(info);
        //isiusti



        Executor executor = Executors.newSingleThreadExecutor();
        Handler handler =new Handler(Looper.getMainLooper());
        Intent intent = new Intent(MainActivity.this,ProductsActivity.class);
//        startActivity(intent);
        executor.execute(()->{
            try {
                String response = Rest.sendPost(VALIDATE_USER,info);
                handler.post(()->{
                    try {
                        System.out.println(response);
                        if(!response.equals("Error")){
                            startActivity(intent);
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        });


    }


}