package br.ufrn.imd.sid.model;

public class Jogador {

	private String nome;
	private String nick;
	private int opcao;
	private int totalPalitos;
	private int chute;
	private int palitosMao;
	
	public Jogador(String nome, String nick){
		this.nome = nome;
		this.nick = nick;
		this.opcao = -1;
		this.chute = -1;
		this.totalPalitos = 3;
		this.palitosMao = -1;
	}
	
	public Jogador(){
		this.opcao = -1;
		this.chute = -1;
		this.totalPalitos = 3;
		this.palitosMao = -1;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNick() {
		return nick;
	}
	
	public void setNick(String nick) {
		this.nick = nick;
	}
	
	public int getTotalPalitos() {
		return totalPalitos;
	}
	
	public void setTotalPalitos(int totalPalitos) {
		this.totalPalitos = totalPalitos;
	}
	
	public int getChute() {
		return chute;
	}
	
	public void setChute(int chute) {
		this.chute = chute;
	}
	
	public int getPalitosMao() {
		return palitosMao;
	}
	
	public void setPalitosMao(int palitosMao) {
		this.palitosMao = palitosMao;
	}

	public int getOpcao() {
		return opcao;
	}

	public void setOpcao(int opcao) {
		this.opcao = opcao;
	}
	
	
}
