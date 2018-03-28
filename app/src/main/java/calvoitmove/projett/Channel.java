package calvoitmove.projett;

/**
 * Created by Horyon on 28/03/2018.
 */

public class Channel
{

    private String nomChannel = null;

    public Channel(String nomChannel)
    {
        this.nomChannel = nomChannel;
    }

    public String getNomChannel()
    {
        return nomChannel;
    }

    public void setNomChannel(String nomChannel) {
        this.nomChannel = nomChannel;
    }
}
