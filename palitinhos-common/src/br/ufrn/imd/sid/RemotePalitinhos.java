package br.ufrn.imd.sid;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemotePalitinhos extends Remote {

	public String getEstado() throws RemoteException;

	public void addJogador(String nome, String nick) throws RemoteException;
	
	public String iniciarJogo(String nome, String nick, int opcao) throws RemoteException;
	
	public String darLance(String nome, String nick, int opcao, int mao, int chute)  throws RemoteException;
	
	public String receberResultadoRodada()  throws RemoteException;
	
	public void sairJogo(String nome, String nick)  throws RemoteException;
	
	public int quantosJogadores() throws RemoteException;
}
