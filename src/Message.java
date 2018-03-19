import java.io.Serializable;
public class Message implements MessageInterface, Serializable{
    private int type;
    private String context;
    public Message(){
        type = 0;
        context = "";
    }
    @Override
    public int getType(){
        return type;
    }
    @Override

    public void setType(int type){
        this.type = type;
    }
    @Override

    public String getContext(){
        return context;
    }
    @Override
    public void setContext(String context){
        this.context = context;
    }
}
