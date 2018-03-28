package calvoitmove.projett;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class JoinChannelActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_channel);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.RecyclerListAvailableChannel);
        // à ajouter pour de meilleures performances :
        recyclerView.setHasFixedSize(true);
        // layout manager, décrivant comment les items sont disposés :
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        // contenu d'exemple :
        List<Channel> listChannel= new ArrayList<>();
        listChannel.add(new Channel("exemple"));
        // adapter :
        ChannelAdapter channelAdapter = new ChannelAdapter(listChannel);
        recyclerView.setAdapter(channelAdapter);
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