package br.com.eleonardoro.tictactoe.core;

public class Move {

	private int i;
	private int j;
	
	public Move(String moveStr) throws InvalidMoveException {
		try {
			this.i = Integer.parseInt(moveStr.split(",")[0]);
			this.j = Integer.parseInt(moveStr.split(",")[1]);
		
		}catch(Exception e) {
			throw new InvalidMoveException("A jogada é inválida!");
		}
	}
	
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	
	public int getJ() {
		return j;
	}
	public void setJ(int j) {
		this.j = j;
	}
}
