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


public class RegisterActivity extends AppCompatActivity
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
        setContentView(R.layout.activity_register);

        client = new OkHttpClient();
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

//        JSONObject action = new JSONObject();
        JSONObject infoJSON = new JSONObject();

        infoJSON.put("type", "inscription");
        infoJSON.put("userName", nom_user);
        infoJSON.put("userPassword", mdp_user);
        infoJSON.put("userEmail", email_user);

//        action.put(infoJSON);

        String sendableUser = infoJSON.toString();

        Log.e("Ce que l'on envois",""+sendableUser);
        start(sendableUser);

        Toast.makeText(this, "You good fam", Toast.LENGTH_SHORT).show();
        /*
        * Change activity vers le login ou il peut utiliser le compte qu'il viens d'utiliser
        * */
        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivityForResult(intent, 123);
        /*
        * Ou pas
        * */
        Toast.makeText(this, "Inscription complete", Toast.LENGTH_LONG).show();
    }

    private void start(String toSend)
    {
        Request request = new Request.Builder().url("ws://10.0.2.2:8083").build();
        EchoWebSocketListener listener = new EchoWebSocketListener();
        WebSocket ws = client.newWebSocket(request, listener);
        //listener.onOpen(ws, reponse);
        ws.send(toSend);
        client.dispatcher().executorService().shutdown();
    }

//    private void output(final String txt)
//    {
//        runOnUiThread(new Runnable()
//        {
//            @Override
//            public void run()
//            {
//                output.setText(output.getText().toString() + "\n\n" + txt);
//            }
//        });
//    }
}