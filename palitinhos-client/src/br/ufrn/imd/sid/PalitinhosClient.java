package br.ufrn.imd.sid;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.util.Scanner;

public class PalitinhosClient {
	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		int palitinhos;
		String matricula;
		
		try {
			System.setSecurityManager(new RMISecurityManager());
			RemotePalitinhos jogoPalitinhos = (RemotePalitinhos)Naming.lookup("rmi://localhost/palitinhos");
			System.out.println("Digite sua matricula: ");
			matricula = ler.nextLine();
			
			//Envia matricula pro servidor
			jogoPalitinhos.addJogadores(matricula);
			
			while(true){
				System.out.println("Escolha a quantidade de palitinhos: ");
				palitinhos = ler.nextInt();
				jogoPalitinhos.quantPalitinhos(matricula, palitinhos);
				
				System.out.println("Qual seu chute para quantidade de palitinhos em jogo?");
				palitinhos = ler.nextInt();
								
				//Se o cliente ganhar o servidor retorna informando e retira o participante do jogo
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
