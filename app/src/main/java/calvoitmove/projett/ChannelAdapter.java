package calvoitmove.projett;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Horyon on 28/03/2018.
 */

public class ChannelAdapter extends RecyclerView.Adapter<ChannelViewHolder>
{

    private List<Channel> listChannel = null;

    public ChannelAdapter(List<Channel> listChannel)
    {
        this.listChannel = listChannel;
    }

    @Override
    public ChannelViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View viewChannel = LayoutInflater.from(parent.getContext()).inflate(R.layout.channelitem, parent, false);
        return new ChannelViewHolder(viewChannel);
    }

    @Override
    public void onBindViewHolder(ChannelViewHolder holder, int position)
    {
        holder.getTextViewNomChannel().setText(listChannel.get(position).getNomChannel());
    }

    @Override
    public int getItemCount()
    {
        return listChannel.size();
    }
}
