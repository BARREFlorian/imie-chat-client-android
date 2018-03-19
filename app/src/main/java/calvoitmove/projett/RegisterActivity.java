package calvoitmove.projett;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void changeToLogin(View view) throws JSONException {
        /*
        *   Récupérer ce que l'user entre
        *   dans les champs de l'activity register
        */
        EditText username = findViewById(R.id.namenewuser);
        EditText password = findViewById(R.id.pwnewuser);
        EditText mail = findViewById(R.id.mailnewuser);

        String nom_user = String.valueOf(username.getText());
        String mdp_user = String.valueOf(password.getText());
        String email_user = String.valueOf(mail.getText());

        /*
        *   Envoyer le username, le password et le mail
        *   en chaines de caractères (JSON) au seveur
        */

        JSONObject userJSON = new JSONObject();
        JSONObject infoJSON = new JSONObject();

        infoJSON.put("type","inscription");
        infoJSON.put("username", nom_user);
        infoJSON.put("password", mdp_user);
        infoJSON.put("mail", email_user);

        userJSON.put("user",infoJSON);

        String sendableUser = userJSON.toString();



        /*
        * Change activity vers le login ou il peut utiliser le compte qu'il viens d'utiliser
        * */
        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivityForResult(intent, 123);
        /*
        * Ou pas
        * */

    }
}
