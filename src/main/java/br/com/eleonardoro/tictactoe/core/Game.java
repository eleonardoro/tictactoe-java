package br.com.eleonardoro.tictactoe.core;

import br.com.eleonardoro.tictactoe.Constants;
import br.com.eleonardoro.tictactoe.ui.UI;

public class Game {

	Board board = new Board();
	Player[] players = new Player[Constants.SYMBOL_PLAYERS.length];
	private int currentPlayerIndex = 0;
	
	public void play() {
		
		UI.printGameTitle();
		
		for(int i = 0; i < players.length; i++) {
			players[i] = createPlayer(i);
		}
		
		board.print();
		
		//UI.readInput("Nome do Jogador:");
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
		
		return players[currentPlayerIndex];
		 */
		
		return players[(currentPlayerIndex + 1) % players.length];
	}
}
