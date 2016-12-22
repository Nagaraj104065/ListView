package com.example.nagaraj.mysql;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView list;
    TaskStackBuilder stackBuilder;
    NotificationManager nManager;
    NotificationCompat.Builder not=new NotificationCompat.Builder(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list=(ListView) findViewById(R.id.listView);
        String data[]={"sathya","sathya2","nagaraj"};
        final ArrayList<String> data2=new ArrayList<String>();
        Intent intent = new Intent(this,Main3Activity.class);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            TaskStackBuilder stack=TaskStackBuilder.create(this);
        }
        for(String val : data){
             data2.add(val);
        }
        data2.add("0101001010");
        try {
            not.setContentTitle("Notification");
            not.setSmallIcon(R.drawable.sathya);
            not.setContentText("this is notification text");
            not.setTicker("this is ticker alert");
            int n = 0;
            not.setNumber(++n);
            Intent inte = new Intent(this, Main3Activity.class);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                stackBuilder = TaskStackBuilder.create(this);
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                stackBuilder.addParentStack(Main3Activity.class);
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                stackBuilder.addNextIntent(inte);
            }
            PendingIntent resultPendingIntent =
                    null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
                resultPendingIntent = stackBuilder.getPendingIntent(
                        0,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );
            }
            not.setContentIntent(resultPendingIntent);
            NotificationManager mManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
      /* Update the existing notification using same notification ID */
            mManager.notify(0, not.build());


        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "erroroooooooooooo" + e, Toast.LENGTH_SHORT).show();
        }
        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,data2);
        list.setAdapter(adapter);
        try {
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    if(position == 1){

                        Toast.makeText(getApplicationContext(), "clickde" + position, Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(getApplicationContext(),Main2Activity.class);
                        startActivity(intent);


                    }
                if(position == 0){
               setContentView(R.layout.activity_main2);
                }
                if(position == 2){
                    try {
                        String  data="sathya i love you";
                        FileOutputStream file=openFileOutput("sathya.txt",MODE_WORLD_READABLE);
                        file.write(data.getBytes());
                        file.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                        Toast.makeText(getApplicationContext(),"data"+e,Toast.LENGTH_SHORT).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                        Toast.makeText(getApplicationContext(),"data"+e,Toast.LENGTH_SHORT).show();
                    }
                }
                if(position == 3) {

                }
            }
        });

        }catch (Exception e){
            TextView t=(TextView) findViewById(R.id.textView);
            t.setText(e.toString());
            Toast.makeText(getApplicationContext(), "clickde" + e, Toast.LENGTH_SHORT).show();
        }

    }

}
