package com.example.calcul_mental;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class CalculateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater= getMenuInflater();
        menuInflater.inflate(R.menu.menu_calculate,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.score_menu_button)
        {
            Intent intent = new Intent(this,ScoreActivity.class);
            startActivity(intent);
        }

        if(item.getItemId()==R.id.back_menu_button)
            finish();

        if(item.getItemId()==R.id.delete_menu_button){
            Toast.makeText(getApplicationContext(),"Historique supprimé",Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }
}