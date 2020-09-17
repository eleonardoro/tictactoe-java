package br.com.eleonardoro.tictactoe.core;

import br.com.eleonardoro.tictactoe.Constants;
import br.com.eleonardoro.tictactoe.ui.UI;

public class Game {

	private Board board = new Board();
	private Player[] players = new Player[Constants.SYMBOL_PLAYERS.length];
	private int currentPlayerIndex = -1;
	
	public void play() {
		
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
				UI.printText("ERRO: " + e.getMessage());
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
		
		String name = UI.readInput("Jogador " + (index + 1) + " => ");
		char symbol = Constants.SYMBOL_PLAYERS[index];
		
		Player player = new Player(
				name, 
				board, 
				symbol);
		
		UI.printText("O jogador '" + name + "' vai usar o símbolo '" + symbol + "'");
		
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
}
