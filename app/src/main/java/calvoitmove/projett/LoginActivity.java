package calvoitmove.projett;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;


public class LoginActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void changeToLogIn(View view) throws JSONException {
        /*
        *   Récupérer ce que l'user entre
        *   dans les champs de l'activity connexion
        */
        EditText username = findViewById(R.id.username);
        EditText password = findViewById(R.id.password);

        String nom_user = String.valueOf(username.getText());
        String mdp_user = String.valueOf(password.getText());

        /*
        *   Envoyer le username et le password
        *   en chaines de caractères (JSON) au seveur
        */

        JSONObject userJSON = new JSONObject();
        JSONObject infoJSON = new JSONObject();

        infoJSON.put("type","connection");
        infoJSON.put("username", nom_user);
        infoJSON.put("password", mdp_user);

        userJSON.put("user",infoJSON);

        String sendableUser = userJSON.toString();


        /*
        *   Lien avec l'activity join Channel
        * */
        Intent intent = new Intent(LoginActivity.this, SelectChannelActivity.class);
        startActivityForResult(intent, 123);
        /*
        * Ou pas
        * */

    }

    public void changeToRegister(View view)
    {
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivityForResult(intent, 123);
    }

}
