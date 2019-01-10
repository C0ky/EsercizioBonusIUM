package com.example.coky.eserciziobonus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.Serializable;

public class ResultActivity extends AppCompatActivity {

    /*
     * Variables used by the result activity
     */
    TextView username;
    String givenName;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        /*
         * The variable will reference the widget of the result activity
         * denoted by its ID
         */
        back = (Button) findViewById(R.id.backButton);

        /*
         * An Intent is called to receive the data being sent by the previous activity
         * in this case the username of the user
         */
        Intent intent = getIntent();
        Serializable obj = intent.getSerializableExtra(MainActivity.NOME_EXTRA);

        /*
         * The activity will check if the data being sent by the intent is a String
         * since it's the type of the username. If true the activity will show
         * a welcome message with the username, otherwise it will show an error message
         */
        if (obj instanceof String) {

            givenName = (String) obj;
            username = (TextView) findViewById(R.id.resultText);

            username.setText("Benvenuto " + givenName);
        } else {
            username = (TextView) findViewById(R.id.resultText);

            username.setText("Accesso negato");
            username.setTextColor(this.getResources().getColor(R.color.Red));
        }

        /*
         * The button will finish the current activity, going back to the main one.
         */
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
