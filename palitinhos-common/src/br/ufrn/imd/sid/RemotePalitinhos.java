package br.ufrn.imd.sid;

import java.rmi.Remote;
import java.rmi.RemoteException;

import br.ufrn.imd.sid.model.Jogador;

public interface RemotePalitinhos extends Remote {

	public String getEstado(Jogador jogador) throws RemoteException;

	public void addJogador(Jogador jogador) throws RemoteException;
	
	public void iniciarJogo(Jogador jogador) throws RemoteException;
	
	public void darLance(Jogador jogador)  throws RemoteException;
	
	public String receberResultadoRodada()  throws RemoteException;
	
	public void sairJogo()  throws RemoteException;
}
