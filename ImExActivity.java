package com.example.studybank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class ImExActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imex);

        // Temp main menu button function for homepage
        Button mm = (Button) findViewById(R.id.button3);
        mm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //

    }

    public void exportFile(View view){
        Intent intent = new Intent(Intent.ACTION_CREATE_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("text/*");
        startActivityForResult(intent, 1);
    }

    public void importFile(View view) {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("text/*");
        startActivityForResult(intent, 2);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode ==2){
            if(data != null){
                Uri uri = data.getData();
                String path = uri.getPath();
                    path = path.substring(path.indexOf(":")+1);
                parse_file(uri);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void parse_file(Uri uri){
        BufferedReader br;
        try {
            br = new BufferedReader(new InputStreamReader(getContentResolver().openInputStream(uri)));
            String line = null;
            while ((line = br.readLine()) != null) {
                Log.w("read",line);
                Questions.mc_question new_q = Questions.mc_question.parse_line_to_mc(line);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
