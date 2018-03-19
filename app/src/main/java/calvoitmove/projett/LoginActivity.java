package calvoitmove.projett;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class LoginActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void changeToLogIn(View view)
    {
        /*
        *   Récupérer ce que l'user entre
        *   dans les champs de l'activity connexion
        */
        EditText username = findViewById(R.id.username);
        EditText password = findViewById(R.id.password);

        String enteredUsername = String.valueOf(username.getText());
        String enteredPassword = String.valueOf(password.getText());

        /*
        *   Envoyer le username et le password
        *   en chaines de caractères (JSON) au seveur
        */



        /*
        *   Lien avec l'activity join Channel
        * */
        Intent intent = new Intent(LoginActivity.this, SelectChannelActivity.class);
        startActivityForResult(intent, 123);
    }

    public void changeToRegister(View view)
    {
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivityForResult(intent, 123);
    }

}
