package br.ufrn.imd.sid;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.util.Scanner;

import br.ufrn.imd.sid.model.Jogador;

public class PalitinhosClient {
	
	
	private static Jogador jogador;
	private static String menu = new String("Digite a opção desejada: \n"
											+ "1 - Inscrever-se	em uma mesa \n"
											+ "2 - Iniciar jogo \n"
											+ "\"qualquer valor\" - Seu lance");
	
	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		jogador = new Jogador();
		dadosJogador(ler);
		try {
			System.setSecurityManager(new RMISecurityManager());
			RemotePalitinhos jogoPalitinhos = (RemotePalitinhos)Naming.lookup("rmi://localhost/palitinhos");
			
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
	
	public static void dadosJogador(Scanner e){
		System.out.println("Digite seu nome: ");
		jogador.setNome(new String(e.nextLine()));
		
		System.out.println("Digite seu nickName: ");
		jogador.setNick(new String(e.nextLine()));
	}
}
