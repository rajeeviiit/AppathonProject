package com.example.rajeevpc.appathon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Job extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job);
        ListView listview = (ListView) findViewById(R.id.listView);
        final String items[]=new String[]{"Tranning and Employment Programme for Women","Mahila Police Volunteer",
                "NARI SHAKTI PURASKAR","GOVERNMENT OF INDIA" ,
                "SWADHAR Greh (A Scheme for Women in Difficult Circumstances)","Working Women Hostel"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(Job.this,android.R.layout.simple_list_item_1,items);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String clicked = items[position];
if(clicked=="Tranning and Employment Programme for Women"){
    Intent j1=new Intent(Job.this,Job1.class);
    startActivity(j1);

}else if (clicked=="Mahila Police Volunteer"){
                    Intent j1=new Intent(Job.this,Job2.class);
                    startActivity(j1);

         }
                else if (clicked=="NARI SHAKTI PURASKAR"){
                    Intent j1=new Intent(Job.this,Job3.class);
                    startActivity(j1);

                }
                else if (clicked=="SWADHAR Greh (A Scheme for Women in Difficult Circumstances)"){
                    Intent j1=new Intent(Job.this,Job4.class);
                    startActivity(j1);

                }
                else{
                    Intent j1=new Intent(Job.this,Job5.class);
                    startActivity(j1);

                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_job, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
