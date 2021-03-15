package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import model.interfaces.DicePair;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.interfaces.GameEngineCallback;

public class GameEngineImpl implements GameEngine {
    Collection<Player> playerCollection = new ArrayList<>();
    Collection<GameEngineCallback> callbacks = new ArrayList<>();
    private DicePairImpl dp1;
    private DicePairImpl dp2;

    @Override
    public void rollPlayer(Player player, int initialDelay1, int finalDelay1, int delayIncrement1, int initialDelay2, int finalDelay2, int delayIncrement2) {
        /*Throw exception if there is an invalid argument*/
        if (initialDelay1 < 0 || initialDelay2 <0 || finalDelay1 < 0 || finalDelay2 <0
                || finalDelay1 < initialDelay1 || finalDelay2 < initialDelay2 || delayIncrement1 > (finalDelay1 - initialDelay1)
                || delayIncrement2 > (finalDelay2 - initialDelay2)){
            throw new IllegalArgumentException();
        }
        
        //delay
        while(initialDelay1 <= finalDelay1){
        	try {
        		Thread.sleep(initialDelay1);
        	}
        	catch (InterruptedException e) {
        		
        	}	
        	initialDelay1 += delayIncrement1;
        	
        	dp1 = new DicePairImpl();
        	
			for(GameEngineCallback cb : callbacks) {
        	 	cb.playerDieUpdate(player, dp1.getDie1(), this);
        	 	cb.playerDieUpdate(player, dp1.getDie2(), this);
			}
        }
        

        //player result
        for (GameEngineCallback cb : callbacks) {
        	cb.playerResult(player, dp1, this);
        }
        
        player.setResult(dp1);
    }

    @Override
    public void rollHouse(int initialDelay1, int finalDelay1, int delayIncrement1, int initialDelay2, int finalDelay2, int delayIncrement2) {
        /*Throw exception if there is an invalid argument*/
        if (initialDelay1 < 0 || initialDelay2 <0 || finalDelay1 < 0 || finalDelay2 <0
        || finalDelay1 < initialDelay1 || finalDelay2 < initialDelay2 || delayIncrement1 > (finalDelay1 - initialDelay1)
        || delayIncrement2 > (finalDelay2 - initialDelay2)){
            throw new IllegalArgumentException();
        }
        
        while(initialDelay1 <= finalDelay1){
        	try {
        		Thread.sleep(initialDelay1);
        	}
        	catch (InterruptedException e) {
        		
        	}	
        	initialDelay1 += delayIncrement1;
        	dp2 = new DicePairImpl(); 

        	for(GameEngineCallback cb : callbacks) {
        	 	cb.houseDieUpdate(dp2.getDie1(), this);
        	 	cb.houseDieUpdate(dp2.getDie2(), this);
			}
        }
        

        /*After rolling*/
        for (Player player: playerCollection){
            applyWinLoss(player,dp2);
        }
        //Log result of house dice and final result of players.
        for (GameEngineCallback cb : callbacks) {
        	cb.houseResult(dp2, this);
        }
        
    }

    @Override
    public void applyWinLoss(Player player, DicePair houseResult) {
    	//implement case draw
    	if (player.getResult().compareTo(houseResult) == 0) {
    		player.setPoints(player.getPoints());    	
		}
    	// if player dice total is smaller or equal to house dice
        if (player.getResult().compareTo(houseResult) < 0){
            player.setPoints(player.getPoints() - player.getBet());
        }
        // if player dice total is bigger than house dice
        else if (player.getResult().compareTo(houseResult)> 0){
            player.setPoints(player.getPoints() + player.getBet());
        }

    }

    @Override
    public void addPlayer(Player player) {
        playerCollection.removeIf(player1 -> player1.getPlayerId().equals(player.getPlayerId()));
        playerCollection.add(player);
    }

    @Override
    public Player getPlayer(String id) {
        for (Player player1:playerCollection) {
            if (player1.getPlayerId().equals(id)){
                return player1;
            }
        }
        return null;
    }

    @Override
    public boolean removePlayer(Player player) {
        for (Player player1:playerCollection) {
            if (player1.equals(player)){
                playerCollection.remove(player);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean placeBet(Player player, int bet) {
        return (player.setBet(bet));
    }

   
    //add to collection
    @Override
    public void addGameEngineCallback(GameEngineCallback gameEngineCallback) {
    	callbacks.add(gameEngineCallback);
    }
    
    //remove from collection
    @Override
    public boolean removeGameEngineCallback(GameEngineCallback gameEngineCallback) {
        return callbacks.remove(gameEngineCallback);
    }

    @Override
    public Collection<Player> getAllPlayers() {
    	return Collections.unmodifiableCollection(playerCollection);
//    	return playerCollection;
    }
}
