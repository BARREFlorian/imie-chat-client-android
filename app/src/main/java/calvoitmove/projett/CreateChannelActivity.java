package calvoitmove.projett;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

public class CreateChannelActivity extends AppCompatActivity
{
    private OkHttpClient client;

    private final class EchoWebSocketListener extends WebSocketListener
    {
        @Override
        public void onOpen(WebSocket webSocket, Response response)
        {
            //String gotReponsed = response.body().toString();
            //Log.e("Response ",""+gotReponsed);
            webSocket.close(1001, "Goodbye !");
        }

        @Override
        public void onMessage(WebSocket webSocket, String text)
        {
            Log.e("Receiving : ","" + text);
        }

        @Override
        public void onMessage(WebSocket webSocket, ByteString bytes) {
            Log.e("Receiving bytes : ", ""+ bytes.hex());
        }

        @Override
        public void onClosing(WebSocket webSocket, int code, String reason) {
            webSocket.close(4999, null);
            Log.e("Closing : ", ""+ code + " / " + reason);
        }

        @Override
        public void onFailure(WebSocket webSocket, Throwable t, Response response) {
            Log.e("Error : ","" + t.getMessage());
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_channel);

        client = new OkHttpClient();
    }

    public void changeToChannel(View view) throws JSONException {
        /*
        * recupérer nom channel depuis le edit text
        * */

        EditText channelName = findViewById(R.id.champ_nom_salle);
        String nom_channel = String.valueOf(channelName.getText());
        String userName = getIntent().getStringExtra("EXTRA_USERNAME");
        Log.e("Valeur de nom_user",userName);

        /*
        *   Envoyer le username, le password et le mail
        *   en chaines de caractères (JSON) au seveur
        */

        JSONObject infoJSON = new JSONObject();

        infoJSON.put("type", "creer");
        infoJSON.put("channelName", nom_channel);

        Log.e("Valeur de nom_user",userName);

        infoJSON.put("nom_user", userName);

        String sendableChannel = infoJSON.toString();

        Log.e("Val sendable_channel",sendableChannel);

        start(sendableChannel);

        boolean creationOk = true;

        if (creationOk) {
            /*
            * passer a la view de listes de tous les channels
            * avec celle qui viens d'être créer
            * */
            Intent intent = new Intent(CreateChannelActivity.this, ChannelActivity.class);
            startActivityForResult(intent, 123);
            Toast.makeText(this, "Creation channel ok", Toast.LENGTH_LONG).show();
        } else {
            /*
            * Ou pas
            * */
        }
    }
        private void start(String toSend)
        {
            Request request = new Request.Builder().url("ws://10.0.2.2:8083").build();
            CreateChannelActivity.EchoWebSocketListener listener = new CreateChannelActivity.EchoWebSocketListener();
            WebSocket ws = client.newWebSocket(request, listener);
            //listener.onOpen(ws, reponse);
            ws.send(toSend);
            client.dispatcher().executorService().shutdown();
        }

//    private void output(final String txt)
//    {
//        runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//                output.setText(output.getText().toString() + "\n\n" + txt);
//            }
//        });
//    }
}
