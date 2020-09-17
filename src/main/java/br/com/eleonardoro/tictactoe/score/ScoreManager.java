package br.com.eleonardoro.tictactoe.score;

import br.com.eleonardoro.tictactoe.core.Player;

public interface ScoreManager {

	public Integer getScore(Player player);
	
	public void saveScore(Player player);
}
