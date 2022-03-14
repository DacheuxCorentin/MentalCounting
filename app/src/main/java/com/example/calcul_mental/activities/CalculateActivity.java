package com.example.calcul_mental.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.calcul_mental.R;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class CalculateActivity extends AppCompatActivity {

    private int firstValue;
    private int secondValue;
    private String operator;

    private TextView editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);
        editText=findViewById(R.id.calculate_textView);
        this.editText.setText(generateOperation());
        
        Button buttonSubmit=findViewById(R.id.submit_button);
        buttonSubmit.setOnClickListener(view -> onClick());

    }

    private void onClick() {
        View myTextView = findViewById(R.id.answer_submit);
        String answer = myTextView.toString();
        switch(operator){
            case "+":
                checkAnswer(firstValue+secondValue==Integer.parseInt(answer));
                break;
            case "-":
                checkAnswer(firstValue-secondValue==Integer.parseInt(answer));
                break;
            case "*":
                checkAnswer(firstValue*secondValue==Integer.parseInt(answer));
                break;
            case "/":
                checkAnswer(firstValue/secondValue==Integer.parseInt(answer));
                break;
        }
    }

    private void checkAnswer(boolean answer){
        TextView myTextView;
        if(answer){
            myTextView = findViewById(R.id.correct_answer);
        }
        else{
            myTextView = findViewById(R.id.wrong_answer);
        }
        myTextView.setVisibility(View.VISIBLE);

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

    public String generateOperation(){

        Random random=new Random();
        this.firstValue=random.nextInt(10);
        this.secondValue=random.nextInt(10);
        List<String> operators= Arrays.asList("+","-","*","/");
        if(firstValue==0 || secondValue==0)
            operator=operators.get(random.nextInt(3));
        else
            operator=operators.get(random.nextInt(4));

        return getString(firstValue)+" "+operator+" "+getString(secondValue)+" "+"=";
    }
}