package calvoitmove.projett;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class JoinChannelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_channel);
    }

    public void changeToChannel(View view)
    {
        Intent intent = new Intent(JoinChannelActivity.this, ChannelActivity.class);
        startActivityForResult(intent, 123);
    }
}
