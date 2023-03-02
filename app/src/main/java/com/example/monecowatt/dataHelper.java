package com.example.monecowatt;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class dataHelper extends AppCompatActivity {
    public static final String SHARED_PREFS = "MySharedPref";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    public void savedata(Context context, ArrayList<String> todtab, ArrayList<String> tomtab, ArrayList<String> afttomtab){
        SharedPreferences sharedPreferences= context.getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("todtab",todtab.toString());
        editor.putString("tomtab",tomtab.toString());
        editor.putString("afttomtab",afttomtab.toString());
        editor.apply();
    }
    public void refreshData(Context context) throws MalformedURLException {
        Thread thread = new Thread( () -> {
            String baseUrl = "http://isis.unice.fr/~ga103969/ext/saejava/.dump/";
            ArrayList<String> todtab = new ArrayList<>(), tomtab = new ArrayList<>(), afttomtab = new ArrayList<>();

                for (int i = 0; i <= 3; i++) {
                    for (int j = 1; j <= 24; j++) {
                        String finalUrl = baseUrl + i + "_LastVars/" + j + "h";
                        URL u = null;
                        try {
                            u = new URL(finalUrl);
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                        try {
                            Scanner s = new Scanner(u.openStream());
                            switch(i){
                                case 0:
                                    todtab.add(s.nextLine());
                                    break;
                                case 1:
                                    tomtab.add(s.nextLine());
                                    break;
                                case 2:
                                    afttomtab.add(s.nextLine());
                                    break;
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }


                    }
                }
                runOnUiThread(() -> Toast.makeText(context, "Data refreshed !", Toast.LENGTH_SHORT).show());
            savedata(context, todtab, tomtab, afttomtab);

        }
        );
        thread.start();
    }
}
