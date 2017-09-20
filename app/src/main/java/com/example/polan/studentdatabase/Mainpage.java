package com.example.polan.studentdatabase;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by polan on 19-09-2017.
 */

public class Mainpage extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainpage);
        Button buttond = (Button) findViewById(R.id.InstructionSubmit);
        buttond.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent numbersIntent = new Intent(Mainpage.this, Inputpage.class);
                startActivity(numbersIntent);
            }
        });
    }
}
