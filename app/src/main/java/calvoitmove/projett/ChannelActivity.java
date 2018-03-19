package calvoitmove.projett;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

public class ChannelActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        String channelName = "temp";
        setTitle(channelName);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_channel);
    }

    public void SendText(View view) throws JSONException
    {
        /*
        *   Récupérer ce que l'user entre
        *   dans les champs de l'activity connexion
        */
        EditText message= findViewById(R.id.messageBox);

        String contenu_message= String.valueOf(message.getText());
        String username= null;
        String channel= null;

        /*
        *   Envoyer le username et le password
        *   en chaines de caractères (JSON) au seveur
        */

        JSONObject messageJSON = new JSONObject();
        JSONObject infoJSON = new JSONObject();

        infoJSON.put("type","affichage");
        infoJSON.put("username", contenu_message);
        infoJSON.put("contenu", contenu_message);
        infoJSON.put("channelname", contenu_message);

        messageJSON.put("message",infoJSON);

        String sendableMessage = messageJSON.toString();
    }
}
