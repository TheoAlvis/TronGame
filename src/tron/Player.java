package tron;

import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Player {
    private static Player playerOne = new Player("Player One");
    private static Player playerTwo = new Player("Player Two");

    private static final int mTrailSize = 10;
    private int mYDistance = 0;
    private int mXDistance = 0;
    private int x;
    private int y;

    private ArrayList<ArrayList<Integer>> mTrail = new ArrayList<>();

    private String mName;

    public Player(String name){
        mName = name;
        mTrail.add(new ArrayList<>());
        mTrail.add(new ArrayList<>());
    }

    public static Player getPlayer(int i){
        ArrayList<Player> players = new ArrayList<>();
        players.add(playerOne);
        players.add(playerTwo);
        return players.get(i);
    }

    public void setTrail(int xPos, int yPos){
        mTrail.get(0).add(xPos);
        mTrail.get(1).add(yPos);
    }

    public boolean colisionDetection(int i) {
        boolean gameEnd = false;
        for(int index = 0; index < getTrail().get(0).size()-1; index++){
            if(getX() == getTrail().get(0).get(index) && getY() == getTrail().get(1).get(index)){
                System.out.println("hit");
                gameEnd = true;
            }

            if(getX() == Player.getPlayer(1).getTrail().get(0).get(index) && getY() == Player.getPlayer(1).getTrail().get(1).get(index)){
                System.out.println("hit");
                gameEnd = true;
            }

            if(Player.getPlayer(1).getX() == Player.getPlayer(1).getTrail().get(0).get(index) && Player.getPlayer(1).getY() == Player.getPlayer(1).getTrail().get(1).get(index)){
                System.out.println("hit");
                gameEnd = true;

            }

            if(Player.getPlayer(1).getX() == getTrail().get(0).get(index) && Player.getPlayer(1).getY() == getTrail().get(1).get(index)){
                System.out.println("hit");
                gameEnd = true;
            }


        }

        if(getX()>600 || Player.getPlayer(1).getX()>600){
            gameEnd = true;
        }
        else if(getX()<0 || Player.getPlayer(1).getX()<0){
            gameEnd = true;
        }
        else if(getY()>600 || Player.getPlayer(1).getY()>600){
            gameEnd = true;
        }
        else if(getY()<0 || Player.getPlayer(1).getY()<0){
            gameEnd = true;
        }

        return gameEnd;
    }

    public ArrayList<ArrayList<Integer>> getTrail() {
        return mTrail;
    }

    public int getYDistance() {
        return mYDistance;
    }

    public static int getTrailSize() {
        return mTrailSize;
    }

    public void setYDistance(int Distance) {
        mYDistance = Distance;
    }

    public void setXDistance(int XDistance) {
        mXDistance = XDistance;
    }

    public int getXDistance() {
        return mXDistance;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getName() {
        return mName;
    }

}
