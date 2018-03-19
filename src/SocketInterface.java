import com.sun.corba.se.pept.encoding.InputObject;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.io.*;

public class SocketInterface implements Runnable{
    private static final int port = 5555;
    private Socket serverSocket;
    private PrintWriter out;
    private BufferedReader in;
    private Player player;
    private ObjectInputStream objectInput;
    private int i;

    public SocketInterface() throws IOException{
        serverSocket = new Socket("localhost", 5555);
        out = new PrintWriter(serverSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));

    }

    public void attach(Player player){
        this.player = player;
        player.attach(this);
    }


    @Override
    public void run() { //init goes here, reading from server
        MessageInterface message = new Message();
        switch(i){
            case 0:
                //throw new BadMessageException();
            case 1:
            case 4:
                player.setGameState(message.getType());
                player.setBalance(Integer.valueOf(message.getContext()));
            case 5:
                System.out.println(message.getContext()); //used to output cards
            case 6:
                System.out.println("It's your turn!");
                player.setGameState(6);
            case 7:
                System.out.println(message.getContext()); //getting other players betting results
            case 8:
                System.out.println(message.getContext()); //Server has revealed 3 cards
            case 9:
                System.out.println(message.getContext()); //Server has revealed 4th card
            case 10:
                System.out.println(message.getContext()); //Server has revealed 5th and final card
            case 11:
                System.out.println(message.getContext()); //Server reveals winner, winning hand, and players new balance.
            case 12:
                System.out.println("Do you want to play next round? ('yes' or 'no')");
                player.setGameState(12);
        }
    }

    public byte[] encrypt(MessageInterface message){
        return null;
    }
    public MessageInterface decrypt(){
        return null;
    }

    public class BadMessageException extends Exception{

    }

}
