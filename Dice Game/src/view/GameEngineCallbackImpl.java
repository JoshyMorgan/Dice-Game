package view;

import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.interfaces.DicePair;
import model.interfaces.Die;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.interfaces.GameEngineCallback;

/**
 * 
 * Skeleton example implementation of GameEngineCallback showing Java logging behaviour
 * 
 * @author Caspar Ryan
 * @see view.interfaces.GameEngineCallback
 * 
 */
public class GameEngineCallbackImpl implements GameEngineCallback
{
   private static final Logger logger = Logger.getLogger(GameEngineCallback.class.getName());

   public GameEngineCallbackImpl()
   {
      // FINE shows rolling output, INFO only shows result
      logger.setLevel(Level.FINE);
   }

   @Override
   public void playerDieUpdate(Player player, Die die, GameEngine gameEngine)
   {
      // intermediate results logged at Level.FINE
      logger.log(Level.FINE, (String.format("%s die %s rolled to %s",player.getPlayerName(),die.getNumber(), die.getValue())));
      // TODO: complete this method to log results

   }

   @Override
   public void playerResult(Player player, DicePair result, GameEngine gameEngine)
   {
      // final results logged at Level.INFO
      player.setResult(result);
      logger.log(Level.INFO, String.format("%s *RESULT* %s", player.getPlayerName(),result.toString()));

   }

   @Override
   public void houseDieUpdate(Die die, GameEngine gameEngine) {
      logger.log(Level.FINE, (String.format("House die %s rolled to %s",die.getNumber(), die.getValue())));

   }

   @Override
   public void houseResult(DicePair result, GameEngine gameEngine) {
      logger.log(Level.INFO, String.format("House *RESULT* %s",result.toString()));
      
      //Next line
      String newline = System.getProperty("line.separator");

      //Get final result and assign it to a string
      String msg ="";
      Collection<Player> playerCollection = gameEngine.getAllPlayers();
      for (Player player: playerCollection) {
    	  msg += player.toString() +newline;
      }
      
      //Log Final Player Result to console
      logger.log(Level.INFO, "FINAL PLAYER RESULT" + newline+ msg );
   }
}
