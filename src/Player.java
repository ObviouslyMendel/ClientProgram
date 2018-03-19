import java.io.IOException;

public class Player {
    private SocketInterface socketInterface;
    private int gameState;
    private double balance = 0;

    public void attach(SocketInterface socketInterface){
        this.socketInterface = socketInterface;
    }

    public void connect(){
        try {
            new SocketInterface().attach(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getGameState() {
        return gameState;
    }

    public void setGameState(int gameState) {
        this.gameState = gameState;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }



}

