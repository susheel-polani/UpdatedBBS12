package com.example.polan.studentdatabase;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.ListView;

/**
 * Created by polan on 19-09-2017.
 */

public class Inputpage extends AppCompatActivity {

    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        isFirstTime();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page2);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        Button buttond2 = (Button) findViewById(R.id.botton2);
        buttond2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent numbersIntent2 = new Intent(Inputpage.this, Displaypage.class);
                startActivity(numbersIntent2);
            }
        });
        spinner = (Spinner) findViewById(R.id.spinnerTest);
        adapter = ArrayAdapter.createFromResource(this,R.array.semesterlist,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getBaseContext(),adapterView.getItemIdAtPosition(i)+" selected",Toast.LENGTH_SHORT);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuoptions,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {


            case R.id.backbutton:
                Intent numbersIntent3 = new Intent(Inputpage.this, Mainpage.class);
                startActivity(numbersIntent3);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    private boolean isFirstTime() {
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        boolean ranBefore = preferences.getBoolean("RanBefore", false);
        if (!ranBefore) {
            //show dialog if app never launch
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("RanBefore", true);
            editor.commit();
            Intent numbersIntent2 = new Intent(Inputpage.this, Mainpage.class);
            startActivity(numbersIntent2);
        }
        return !ranBefore;
    }
}
