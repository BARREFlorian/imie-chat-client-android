package calvoitmove.projett;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Horyon on 28/03/2018.
 */

public class MessageViewHolder extends RecyclerView.ViewHolder
{
    private TextView textViewNomUser =null;
    private TextView textViewContentMessage=null;

    public MessageViewHolder(View itemView)
    {
        super(itemView);
        textViewNomUser = (TextView) itemView.findViewById(R.id.usernameToDisplay);
        textViewContentMessage = (TextView) itemView.findViewById(R.id.contentToDisplay);
    }

    public TextView getTextViewNomUser()
    {
        return textViewNomUser;
    }
    public TextView getTextViewContentMessage()
    {
        return textViewContentMessage;
    }
}