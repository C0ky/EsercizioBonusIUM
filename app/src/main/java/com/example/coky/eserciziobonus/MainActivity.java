package com.example.coky.eserciziobonus;

import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    /*
     * Variables used by the main activity
     */
    EditText username, password;
    TextView signUp;
    Button login;


    public static final String NOME_EXTRA = "com.example.coky.eserciziobonus";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
         * The variables will reference the widget of the main activity
         * denoted by their ID
         */
        username = (EditText) findViewById(R.id.usernameForm);
        password = (EditText) findViewById(R.id.passwordForm);
        signUp = (TextView) findViewById(R.id.fakeSignup);
        login = (Button) findViewById(R.id.loginButton);

        //The signup link will have an underline to mimic a real link
        signUp.setPaintFlags(signUp.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);


        /*
         * The login button will call a new activity when touched
         */
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*
                 * If the user input is correct, as in the username and password are present
                 * in the user factory, it will display a new activity that will have the username
                 * of the person who just logged in.
                 * In case of incorrect username or password, the new activity won't bring over
                 * the user data but will show a message of error since it won't have anything else
                 * to display
                 */
                if (checkInput()) {

                    Intent ResultActivity = new Intent(MainActivity.this, com.example.coky.eserciziobonus.ResultActivity.class);

                    if (UserFactory.getInstance().login(username.getText().toString(), password.getText().toString())) {

                        ResultActivity.putExtra(NOME_EXTRA, username.getText().toString());
                        startActivity(ResultActivity);
                    } else
                        startActivity(ResultActivity);

                }
            }
        });
    }


    /*
     * Method that checks if both the username and password fields have been filled in.
     * Otherwise it will show an error message
     */
    private boolean checkInput() {

        int errors = 0;

        if (username.getText() == null || username.getText().length() == 0) {
            username.setError("Inserire lo Username");
            errors++;
        } else
            username.setError(null);

        if (password.getText() == null || password.getText().length() == 0) {
            password.setError("Inserire la password");
            errors++;
        } else
            password.setError(null);

        return errors == 0;
    }
}
