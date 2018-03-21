package calvoitmove.projett;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import org.java_websocket.client.WebSocketClient;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }


    public void changeToLogin(View view) throws JSONException
    {
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
        infoJSON.put("userName", nom_user);
        infoJSON.put("userPassword", mdp_user);
        infoJSON.put("userEmail", email_user);

        userJSON.put("action",infoJSON);

        String sendableUser = userJSON.toString();

        boolean replyServer =false;

        if(replyServer)
        {
            Toast.makeText(this, "You good fam", Toast.LENGTH_SHORT).show();
            /*
            * Change activity vers le login ou il peut utiliser le compte qu'il viens d'utiliser
            * */
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivityForResult(intent, 123);
        }
        else
        {
            /*
            * Ou pas
            * */
            Toast.makeText(this, "Erreur serveur", Toast.LENGTH_LONG).show();
        }
    }
}