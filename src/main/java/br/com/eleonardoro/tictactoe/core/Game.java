package br.com.eleonardoro.tictactoe.core;

import br.com.eleonardoro.tictactoe.Constants;
import br.com.eleonardoro.tictactoe.score.ScoreManager;
import br.com.eleonardoro.tictactoe.ui.UI;

public class Game {

	private Board board = new Board();
	private Player[] players = new Player[Constants.SYMBOL_PLAYERS.length];
	private int currentPlayerIndex = -1;
	private ScoreManager scoreManager;
	
	public void play() {
		scoreManager = createScoreManager();
		
		UI.printGameTitle();
		
		for(int i = 0; i < players.length; i++) {
			players[i] = createPlayer(i);
		}
		
		boolean gameEnded = false;
		Player winner = null;
		Player currentPlayer = nextPlayer();
		
		while(!gameEnded) {
			board.print();
			
			boolean sequenceFound;
			
			try {
				sequenceFound = currentPlayer.play();
			} catch (InvalidMoveException e) {
				UI.printNewLine();
				UI.printText("ERROR: " + e.getMessage());
				continue;
			}
			
			if(sequenceFound) {
				gameEnded = true;
				winner = currentPlayer;
			}else if(board.isFull()){
				gameEnded = true;
			}else {
				currentPlayer = nextPlayer();
			}
		}
		
		UI.printNewLine();
		UI.printNewLine();
		if(winner == null) {
			UI.printText("It's a Duce!");
		} else {
			UI.printText("The Player '" + winner.getName() + "' won the Game!");
			
			scoreManager.saveScore(winner);
		}
		
		UI.printNewLine();
		UI.printNewLine();
		board.print();
		UI.printNewLine();
		UI.printNewLine();
		UI.printText("End of the Game!");
		
		
	}
	
	private Player createPlayer(int index) {
		UI.printNewLine();
		
		String name = UI.readInput("Player " + (index + 1) + " => ");
		char symbol = Constants.SYMBOL_PLAYERS[index];
		Player player = new Player(name, board, symbol);
		
		Integer score = scoreManager.getScore(player);
		
		if(score != null) {
			UI.printNewLine();
			UI.printText("The player '" + name + "' already have " + score + " victories");
		}
		
		UI.printText("The Player '" + name + "' uses the symbol '" + symbol + "'");
		
		return player;
	}
	
	private Player nextPlayer() {
		/*
		 * currentPlayerIndex++;
		
		if(currentPlayerIndex >= players.length)
			currentPlayerIndex = 0;
		 */
		
		currentPlayerIndex = (currentPlayerIndex + 1) % players.length;
		return players[currentPlayerIndex];
	}
	
	private ScoreManager createScoreManager() {
		return null;
	}
}
