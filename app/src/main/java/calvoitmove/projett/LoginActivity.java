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


public class LoginActivity extends AppCompatActivity
{
    private OkHttpClient client;
    private Retour retour = new Retour();
    private User user = new  User();
//    private String retourServer="";
//    private String apiKey ="";


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
            retour.setContent(text);
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
        public void onFailure(WebSocket webSocket, Throwable t, Response response)
        {
            Log.e("Error : ","" + t.getMessage());
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        client = new OkHttpClient();
    }

    public void changeToLogIn(View view) throws JSONException
    {
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

        JSONObject infoJSON = new JSONObject();

        infoJSON.put("type","connexion");
        infoJSON.put("userName", nom_user);
        infoJSON.put("userPassword", mdp_user);

        String sendableUser = infoJSON.toString();
        Log.e("ce que l'on envois :",""+sendableUser);
        start(sendableUser);

        user.setNom_user(nom_user);

        /*
        *  if/else a implémenter pour gérer le retour serveur
        */

//        if(apiKey.equals(""))
//       {
            /*
            *   Lien avec l'activity join Channel
            **/
//            Toast.makeText(this, "Mauvais inputs", Toast.LENGTH_LONG).show();
//        }
//       else
//        {
            /*
            *  Ou pas
            **/
            Intent intent = new Intent(LoginActivity.this, SelectChannelActivity.class);
            Log.e("Valeur de nom_user",nom_user);
            intent.putExtra("EXTRA_USERNAME", nom_user);
            startActivityForResult(intent, 123);
//        }
    }

    public void changeToRegister(View view)
    {
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivityForResult(intent, 123);
    }

    private void start(String toSend)
    {
        Request request = new Request.Builder().url("ws://10.0.2.2:8083").build();
        EchoWebSocketListener listener = new EchoWebSocketListener();
        WebSocket ws = client.newWebSocket(request, listener);
        ws.send(toSend);

        /*
        * Retour server a faire une fois que le listener est maitriser
        */

//        retourServer = retour.getContent();
//        Log.e("Retour server content",""+retourServer);
//
//        JSONObject sentByServer = null;
//        try {
//            sentByServer = new JSONObject(retourServer);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        Log.e("JSONED server content",""+sentByServer);
//
//        try {
//            apiKey = sentByServer.getString("apiKey");
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }

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