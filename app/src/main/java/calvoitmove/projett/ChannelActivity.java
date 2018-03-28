package calvoitmove.projett;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ChannelActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        String channelName = "exemple";
        setTitle(channelName);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_channel);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.RecyclerViewMessageChat);
        // à ajouter pour de meilleures performances :
        recyclerView.setHasFixedSize(true);
        // layout manager, décrivant comment les items sont disposés :
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        // contenu d'exemple :
        List<Message> listMessage= new ArrayList<>();
        listMessage.add(new Message("Hobbes", "Hi"));
        listMessage.add(new Message("Calvin", "What's up"));
        listMessage.add(new Message("Hobbes", "Nothing much, how's school ?"));
        listMessage.add(new Message("Calvin", "The usual, bad"));
        // adapter :
        MessageAdapter messageAdapter = new MessageAdapter(listMessage);
        recyclerView.setAdapter(messageAdapter);
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
        infoJSON.put("userName", username);
        infoJSON.put("contenuMessage", contenu_message);
        infoJSON.put("channelName", channel);

        messageJSON.put("action",infoJSON);

        String sendableMessage = messageJSON.toString();
    }
}
