package calvoitmove.projett;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class JoinChannelActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_channel);
    }

    public void changeToChannel(View view)
    {
        boolean replyServer =false;

        if(replyServer)
        {
            /*
            * Change activity vers le login ou il peut utiliser le compte qu'il viens d'utiliser
            * */
            Intent intent = new Intent(JoinChannelActivity.this, ChannelActivity.class);
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