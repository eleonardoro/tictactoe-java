package br.com.eleonardoro.tictactoe.core;

import br.com.eleonardoro.tictactoe.Constants;
import br.com.eleonardoro.tictactoe.ui.UI;

public class Board {

	private char[][] matrix = new char[Constants.BOARD_SIZE][Constants.BOARD_SIZE];
	
	public Board() {
		clear();
	}
	
	public void clear() {
		
		for (int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = ' ';
			}
		}
	}
	
	public void print() {
		UI.printNewLine();
		UI.printNewLine();
		
		for (int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				UI.printTextWithNoNewLine(String.valueOf(matrix[i][j]));
				
				if(j < matrix[i].length-1)
					UI.printTextWithNoNewLine(" | ");
			}
			
			UI.printNewLine();
			
			if(i < matrix[i].length-1)
				UI.printText("---------");
			
		}
	}
	
	public boolean isFull() {

		for (int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == ' ')
					return false;
			}
		}
		
		return true;
	}
	
	public boolean play(Player player, Move move) {

		//TODO validar os movimentos
		
		matrix[move.getI()][move.getJ()] = player.getSymbol();

		return checkRows(player) || checkCols(player) || checkFirstDiagonal(player) || checkSecondDiagonal(player);
		
	}
	
	private boolean checkRows (Player player) {
		for (int i = 0; i < Constants.BOARD_SIZE; i++) {
			if(checkRow(i, player))
				return true;
		}
		
		return false;
	}
	
	
	private boolean checkRow(int i, Player player) {
		for(int j = 0; j < Constants.BOARD_SIZE; j++) {
			if(matrix[i][j] != player.getSymbol())
				return false;
		}
		
		return true;
	}
	
	private boolean checkCols (Player player) {
		for (int j = 0; j < Constants.BOARD_SIZE; j++) {
			if(checkCol(j, player))
				return true;
		}
		
		return false;
	}
	
	
	private boolean checkCol(int j, Player player) {
		for(int i = 0; i < Constants.BOARD_SIZE; i++) {
			if(matrix[i][j] != player.getSymbol())
				return false;
		}
		
		return true;
	}
	
	private boolean checkFirstDiagonal(Player player) {
		for (int i = 0; i < Constants.BOARD_SIZE; i++) {
			if(matrix[i][i] != player.getSymbol()) 
				return false;
		}
		
		return true;
	}
	
	private boolean checkSecondDiagonal(Player player) {
		for (int i = Constants.BOARD_SIZE - 1, j = 0; i >= 0 ; i--, j++) {
			if(matrix[i][i] != player.getSymbol()) 
				return false;
		}
		
		return true;
	}
}