package calvoitmove.projett;

/**
 * Created by Horyon on 28/03/2018.
 */

public class Message
{
    String nomUser =null;
    String content = null;

    public Message(String nomUser, String content)
    {
        this.nomUser = nomUser;
        this.content = content;
    }

    public String getNomUser()
    {
        return nomUser;
    }

    public void setNomUser(String nomUser)
    {
        this.nomUser = nomUser;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
