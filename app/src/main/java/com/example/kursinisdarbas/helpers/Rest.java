package com.example.kursinisdarbas.helpers;

import android.os.Build;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Rest {

    private static BufferedWriter bufferedWriter;
//    private static OutputStream outputStream;


    public static String sendPost(String posturl, String jsonInfo) throws IOException {
        URL url = new URL(posturl);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        //Bendra dalis \/
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setConnectTimeout(20000);
        httpURLConnection.setReadTimeout(20000);
        httpURLConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
//        httpURLConnection.setRequestProperty("Accept", "application/json");
        httpURLConnection.setRequestProperty("Accept", "*/*");
//        httpURLConnection.setRequestProperty("Content-Length");
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true);
        OutputStream outputStream = httpURLConnection.getOutputStream();

        bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write(jsonInfo);

        bufferedWriter.close();
        outputStream.close();
        int code = httpURLConnection.getResponseCode();
        System.out.println("Response code was: " + code);

        if (code == HttpURLConnection.HTTP_OK) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String line;
            StringBuffer response = new StringBuffer();

            while ((line = bufferedReader.readLine()) != null) {
                response.append(line);
            }

            bufferedReader.close();
            return response.toString();
        } else {
            return "error";
        }

    }

}
