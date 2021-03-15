package model;

import model.interfaces.DicePair;
import model.interfaces.Player;

public class SimplePlayer implements Player {
    String playerId;
    String playerName;
    int points;
    int bet;
    DicePair result;

    public SimplePlayer(String playerId, String playerName, int initialPoints){
        this.playerId = playerId;
        this.playerName = playerName;
        this.points = initialPoints;
    }

    @Override
    public String getPlayerName() {
        return this.playerName;
    }

    @Override
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    @Override
    public int getPoints() {
        return this.points;
    }

    @Override
    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public String getPlayerId() {
        return playerId;
    }

    @Override
    public boolean setBet(int bet) {
    	if (bet > 0 && this.points >= bet) {
    		this.bet = bet;
    		return true;
    	}
    	return false;
    }

    @Override
    public int getBet() {
        return bet;
    }

    @Override
    public void resetBet() {
        this.bet = 0;
    }

    @Override
    public DicePair getResult() {
        return this.result;
    }

    @Override
    public void setResult(DicePair rollResult) {
        this.result = rollResult;
    }

    @Override
    public String toString() {
        return "Player: " +
                "Id ='" + playerId + '\'' +
                ", name ='" + playerName + '\'' +
                ", points =" + points +
                ", bet =" + bet +
                ", Result .." + result.toString();
    }
}