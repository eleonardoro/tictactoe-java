package br.com.eleonardoro.tictactoe.score;

import java.io.IOException;

import br.com.eleonardoro.tictactoe.core.Player;

public interface ScoreManager {

	public Integer getScore(Player player);
	
	public void saveScore(Player player) throws IOException;
}
