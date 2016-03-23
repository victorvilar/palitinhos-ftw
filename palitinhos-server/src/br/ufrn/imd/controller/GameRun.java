package br.ufrn.imd.controller;

import br.ufrn.imd.sid.model.Jogador;
import br.ufrn.imd.sid.model.Jogo;

public class GameRun {

	private Jogo jogo;
	
	public GameRun(Jogo jogo){
		this.jogo = jogo;
	}
	
	public void addJogador(Jogador j){
		jogo.getJogadores().add(j);
		j.setId(jogo.getJogadores().indexOf(j));
	}
	
	public void removeJogador(Jogador j){
		jogo.getJogadores().remove(j);
	}
	
	public void addRodada(){
		jogo.setRodada(jogo.getRodada() + 1);
	}
	
}
