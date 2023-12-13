package com.example.kursinisdarbas;

import static com.example.kursinisdarbas.helpers.Constants.GET_ALL_PRODUCTS;
import static com.example.kursinisdarbas.helpers.Constants.UPDATE_CUSTOMER;
import static com.example.kursinisdarbas.helpers.Constants.UPDATE_MANAGER;

import static com.example.kursinisdarbas.helpers.Constants.VALIDATE_USER;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kursinisdarbas.helpers.Rest;
import com.example.kursinisdarbas.model.Customer;
import com.example.kursinisdarbas.model.Manager;
import com.example.kursinisdarbas.model.Product;
import com.example.kursinisdarbas.model.User;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ProductsActivity extends AppCompatActivity {
    User connectedUser=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            System.out.println("EXTRAS PASSED: "+extras.getString("UserResponse"));
            String userInfoJson=extras.getString("UserResponse");

            Gson userGson = new Gson ();
            connectedUser = userGson. fromJson (userInfoJson, User.class);
            System.out.println(connectedUser.toString());

            TextView greet=findViewById(R.id.greeting);
            greet.append(" "+connectedUser.getName());
        }

        Executor executor = Executors.newSingleThreadExecutor();
        Handler handler =new Handler(Looper.getMainLooper());


        executor.execute(()->{
            try {
                String response = Rest.sendGet(GET_ALL_PRODUCTS);
                System.out.println("response:"+response);
                handler.post(()->{
                    try {
                        System.out.println(response);
                        if(!response.equals("")){

                            Gson productsGson = new Gson ();

                            Type productListType = new TypeToken<List<Product>>() {
                            }.getType();
                            List<Product> listOfProductsFromJson = productsGson.fromJson (response, productListType);


                            ListView productListElement = findViewById(R.id.productListView);
                            ArrayList<String> listOfProducts = new ArrayList<>();
                            ArrayAdapter adapter = new ArrayAdapter( this, android. R.layout.simple_list_item_1, listOfProductsFromJson);
                            productListElement.setAdapter (adapter);
                            productListElement.setOnItemClickListener((parent, view, position, id) -> {
//veiksmai I
                            });


                        }else{
                            CharSequence text = "Neteisingi prisijungimo duomenys!";
                            int duration = Toast.LENGTH_SHORT;

                            Toast toast = Toast.makeText(this, text, duration);
                            toast.show();
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                        CharSequence text = "Kažkas ne taip :/";
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(this, text, duration);
                        toast.show();
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        });




    }

    public void putMethod(View view) {

        Gson gson = new Gson();
        System.out.println("Ar customeris: "+connectedUser.isCustomer());
        String sendRequest="";
        if(connectedUser.isCustomer()){
            sendRequest=UPDATE_CUSTOMER;
        }else{
            sendRequest=UPDATE_MANAGER;
        }
        TextView newName = findViewById(R.id.newNameField);
        JsonObject jsonObject =new JsonObject();
        jsonObject.addProperty("id", connectedUser.getId());
        jsonObject.addProperty("name", newName.getText().toString());

        String info = gson.toJson(jsonObject);


        Executor executor = Executors.newSingleThreadExecutor();
        Handler handler =new Handler(Looper.getMainLooper());


        String finalSendRequest = sendRequest;
        executor.execute(()->{
            try {
                String response = Rest.sendPut(finalSendRequest,info);
                System.out.println("response:"+response);
                handler.post(()->{
                    try {
                        System.out.println(response);
                        if(!response.equals("")){
                            CharSequence text = "Naujas vardas: "+newName.getText();
                            int duration = Toast.LENGTH_SHORT;

                            Toast toast = Toast.makeText(this, text, duration);
                            toast.show();






                        }else{
                            CharSequence text = "Neteisingi prisijungimo duomenys!";
                            int duration = Toast.LENGTH_SHORT;

                            Toast toast = Toast.makeText(this, text, duration);
                            toast.show();
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                        CharSequence text = "Kažkas ne taip :/";
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(this, text, duration);
                        toast.show();
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        });


    }

    public void deleteMethod(View view) {

    }




}