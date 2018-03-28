package calvoitmove.projett;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class SelectChannelActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_channel);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.RecylerListJoinedClient);
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

    public void goToRelatedChannel(View view)
    {
        Intent intent = new Intent(SelectChannelActivity.this, ChannelActivity.class);
        startActivityForResult(intent, 123);
    }

    public void changeToCreate(View view)
    {
        String userName = getIntent().getStringExtra("EXTRA_USERNAME");
        Log.e("Valeur de nom_user",userName);

        Intent intent = new Intent(SelectChannelActivity.this, CreateChannelActivity.class);
        intent.putExtra("EXTRA_USERNAME", userName);
        startActivityForResult(intent, 123);
    }

    public void changeToJoin(View view)
    {
        Intent intent = new Intent(SelectChannelActivity.this, JoinChannelActivity.class);
        startActivityForResult(intent, 123);
    }
}