package com.example.user.dialog2sharon;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.provider.CalendarContract;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    AlertDialog.Builder adb;
    Button b1; Button b2; Button b3;
    LinearLayout ll;
    int [] color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        ll = findViewById(R.id.ll);
    }

    String [] colors = {"Red", "Green", "Blue"};
    public void openDialog(View view) {//choose one color
        color = new int[]{0,0,0};
        adb = new AlertDialog.Builder(this);
        adb.setIcon(R.drawable.click);
        adb.setTitle("Choose one color");
        adb.setItems(colors, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                color[which] = 255;
                ll.setBackgroundColor(Color.rgb(color[0], color[1], color[2]));
            }
        });
        adb.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog ad = adb.create();
        ad.show();
    }

    public void openDialog2(View view) {//choose color combinations
        color = new int[]{0, 0, 0};
        adb = new AlertDialog.Builder(this);
        adb.setIcon(R.drawable.click);
        adb.setTitle("Choose color combination");
        adb.setMultiChoiceItems(colors, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if (isChecked) color[which] = 255;
                else if (color[which] == 255) color[which] = 0;
            }
        });
        adb.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ll.setBackgroundColor(Color.rgb(color[0], color[1], color[2]));
            }
        });
        adb.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog ad = adb.create();
        ad.show();
    }

    public void toWhite(View view) {//resets background color to white
        ll.setBackgroundColor(Color.WHITE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        startActivity(new Intent(MainActivity.this, Credits.class));
        return super.onOptionsItemSelected(item);
    }
}
