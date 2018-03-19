package calvoitmove.projett;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

public class CreateChannelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_channel);
    }

    public void changeToChannel(View view) throws JSONException {
        /*
        * recupérer nom channel depuis le edit text
        * */

        EditText channelName = findViewById(R.id.champ_nom_salle);
        String nom_channel = String.valueOf(channelName.getText());

        /*
        *   Envoyer le username, le password et le mail
        *   en chaines de caractères (JSON) au seveur
        */

        JSONObject channelJSON = new JSONObject();
        JSONObject infoJSON = new JSONObject();

        infoJSON.put("type", "selection");
        infoJSON.put("username", nom_channel);
        channelJSON.put("channel",infoJSON);

        String sendableChannel = channelJSON.toString();



        /*
        * passer a la view de listes de tous les channels
        * avec celle qui viens d'être créer
        * */
        Intent intent = new Intent(CreateChannelActivity.this, ChannelActivity.class);
        startActivityForResult(intent, 123);
        /*
        * Ou pas
        * */

    }
}
