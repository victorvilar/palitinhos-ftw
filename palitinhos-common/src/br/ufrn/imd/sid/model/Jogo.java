package br.ufrn.imd.sid.model;

import java.util.ArrayList;

public class Jogo {
	
	private ArrayList<Jogador> jogadores;
	private int rodada;
	private int totalPalitosRodada;
	
	/* Estados validos	ESPERANDO_JOGADORES, 
	 * 					ESPERANDO_LANCES, 
	 * 					FIM_RODADA,
	 * 					FIM_JOGO
	 * */
	private String estado; 
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Jogo(){
		jogadores = new ArrayList<Jogador>();
		this.rodada = 0;
		this.totalPalitosRodada = -1;
	}
	
	public ArrayList<Jogador> getJogadores() {
		return jogadores;
	}
	
	public void setJogadores(ArrayList<Jogador> jogadores) {
		this.jogadores = jogadores;
	}
	
	public int getRodada() {
		return rodada;
	}
	
	public void setRodada(int rodada) {
		this.rodada = rodada;
	}
	
	public int getTotalPalitosRodada() {
		return totalPalitosRodada;
	}
	
	public void setTotalPalitosRodada(int totalPalitosRodada) {
		this.totalPalitosRodada = totalPalitosRodada;
	}
	
	
}
