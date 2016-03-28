package br.ufrn.imd.sid.model;

public class Jogador {

	private String nome;
	private String nick;
	private String opcao;
	private int totalPalitos;
	private int chute;
	private int palitosMao;
	
	public Jogador(String nome){
		this.nome = nome;
	}
	
	public Jogador(){
		
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

	public String getOpcao() {
		return opcao;
	}

	public void setOpcao(String opcao) {
		this.opcao = opcao;
	}
	
	
}
