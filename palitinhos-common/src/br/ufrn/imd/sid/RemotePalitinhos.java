package br.ufrn.imd.sid;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemotePalitinhos extends Remote {

	public void quantPalitinhos(String matricula, int a) throws RemoteException;

	public void totalPalitinhos(String matricula, int a) throws RemoteException;

	public void addJogadores(String matricula) throws RemoteException;

	public void retiraPalito() throws RemoteException;

	public void adicionaPalito() throws RemoteException;

}
