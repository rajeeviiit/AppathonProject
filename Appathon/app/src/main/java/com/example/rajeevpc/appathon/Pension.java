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

public class Pension extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pension);
        ListView listview = (ListView) findViewById(R.id.listView);
        final String items[]=new String[]{"Indira Gandhi National Old Age Pension Scheme (IGNOAPS)"
                ,"Launching Atal Pension Yojana (APY) from June 1, 2015","Indira Gandhi National Widow Pension "
                ,"Indira Gandhi Matritva Sahyog Yojana","Integrated Child Development Services"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(Pension.this,android.R.layout.simple_list_item_1,items);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String clicked = items[position];
                if(clicked=="Indira Gandhi National Old Age Pension Scheme (IGNOAPS)"){
                    Intent j1=new Intent(Pension.this,Pension1.class);
                    startActivity(j1);

                }else if (clicked=="Launching Atal Pension Yojana (APY) from June 1, 2015"){
                    Intent j1=new Intent(Pension.this,Pension2.class);
                    startActivity(j1);

                }
                else if (clicked=="Indira Gandhi National Widow Pension "){
                    Intent j1=new Intent(Pension.this,Pension3.class);
                    startActivity(j1);

                }
                else if (clicked=="Indira Gandhi Matritva Sahyog Yojana"){
                    Intent j1=new Intent(Pension.this,Pension4.class);
                    startActivity(j1);

                }
                else{
                    Intent j1=new Intent(Pension.this,Pension5.class);
                    startActivity(j1);

                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pension, menu);
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
