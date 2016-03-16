package br.ufrn.imd.sid;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class RemotePalitinhosImpl extends UnicastRemoteObject implements RemotePalitinhos {

	private int quantPalitinhos;
	private int rodada;
	private int somaPalitinhos;
	private int chutePalitinos;
	private List<String> jogadores;

	protected RemotePalitinhosImpl() throws RemoteException {
		this.quantPalitinhos = 3;
		this.rodada = 1;
		this.jogadores = new ArrayList();
	}
	
	public void addJogadores(String matricula){
		jogadores.add(matricula);
		System.out.println("Novo jogador adicionado. Matricula: " + matricula +
							" Quantidade de jogadores: " + jogadores.size());
	}
	
	public void quantPalitinhos(String matricula, int a) {
		if(rodada == 1 && (a > quantPalitinhos || quantPalitinhos < 1)){
			System.out.println("Voce so possui " + quantPalitinhos + " palitinho(s). Na primeira rodada voce deve colocar pelo menos 1 palito. Tente novamente.");
		}
		else if (a > quantPalitinhos || quantPalitinhos < 0) {
			System.out.println("Voce so possui " + quantPalitinhos + " palitinho(s). Tente novamente.");
		} else {
			System.out.println("Voce escolheu " + a + " palitinho(s)");
		}
	}
	
	public void totalPalitinhos(String matricula, int a){
		
	}
	
	public void retiraPalito(){
		this.quantPalitinhos--;
		System.out.println("Voce possui " + quantPalitinhos + " palitos.");
	}

	public void adicionaPalito(){
		this.quantPalitinhos++;
		System.out.println("Voce possui " + quantPalitinhos + " palitos.");
	}
	
	public static void main(String[] args) {
		try {
			Registry r = LocateRegistry.getRegistry();
			r.bind("palitinhos", new RemotePalitinhosImpl());
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
