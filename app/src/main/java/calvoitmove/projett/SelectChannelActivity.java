package calvoitmove.projett;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SelectChannelActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_channel);
    }

    public void changeToCreate(View view)
    {
        Intent intent = new Intent(SelectChannelActivity.this, CreateChannelActivity.class);
        startActivityForResult(intent, 123);
    }

    public void changeToJoin(View view)
    {
        Intent intent = new Intent(SelectChannelActivity.this, JoinChannelActivity.class);
        startActivityForResult(intent, 123);
    }
}