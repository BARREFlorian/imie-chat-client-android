package calvoitmove.projett;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Horyon on 28/03/2018.
 */
public class MessageAdapter extends RecyclerView.Adapter<MessageViewHolder>
{
        private List<Message> listMessage = null;

        public MessageAdapter(List<Message> listMessage)
        {
            this.listMessage = listMessage;
        }

        @Override
        public MessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
        {
            View viewMessage = LayoutInflater.from(parent.getContext()).inflate(R.layout.messageitem, parent, false);
            return new MessageViewHolder(viewMessage);
        }

        @Override
        public void onBindViewHolder(MessageViewHolder holder, int position)
        {
            holder.getTextViewNomUser().setText(listMessage.get(position).getNomUser());
            holder.getTextViewContentMessage().setText(listMessage.get(position).getContent());
        }

        @Override
        public int getItemCount()
        {
            return listMessage.size();
        }
}
