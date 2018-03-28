package calvoitmove.projett;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Horyon on 28/03/2018.
 */

public class ChannelViewHolder extends RecyclerView.ViewHolder
{
    private TextView textViewNomChannel = null;

    public ChannelViewHolder(View itemView)
    {
        super(itemView);
        textViewNomChannel = (TextView)itemView.findViewById(R.id.channelnameToDisplay);
    }

    public TextView getTextViewNomChannel()
    {
        return textViewNomChannel;
    }

}