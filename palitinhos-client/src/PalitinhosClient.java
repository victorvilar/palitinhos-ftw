

import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.util.Scanner;

import br.ufrn.imd.sid.model.Jogador;

public class PalitinhosClient {

	private static Jogador jogador;

	/*
	 * Opcoes validas 0 - sair do jogo 1 - iniciar jogo 2 - dar lance
	 */
	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		jogador = new Jogador();
		dadosJogador(ler);
		try {

			/**
			 * parte de conexao com o servidor...
			 */
			System.setSecurityManager(new RMISecurityManager());

			RemotePalitinhos palitos = (RemotePalitinhos) Naming.lookup("rmi://localhost/palitinhos");
			palitos.addJogador(jogador.getNome(), jogador.getNick());

			System.out.println("Digite 1 se estiver pronto e quiser iniciar o jogo.");
			int controle = Integer.valueOf(ler.nextLine());

			while (controle != 0) {
				if (palitos.getEstado().equals("ESPERANDO_JOGADORES")) {
					Thread.sleep(5000);
				} else if (palitos.getEstado().equals("ESPERANDO LANCE") && controle == 1) {
					controle = 2;
					System.out.println("Digite o numero de palitos para mao(entre 0 e 3): ");
					jogador.setPalitosMao(Integer.valueOf(ler.nextLine()));
					System.out.println("\t Jogadores ativos: " + palitos.quantosJogadores());

					System.out.println("Digite seu chute: ");
					jogador.setChute(Integer.valueOf(ler.nextLine()));

					palitos.darLance(jogador.getNome(), jogador.getNick(), 2, jogador.getPalitosMao(),
							jogador.getChute());

					if (palitos.getEstado().equals("FIM_RODADA")) {
						controle = 1;
					} else if (palitos.getEstado().equals("FIM_JOGO")) {
						controle = 0;
					}
					System.out.println(palitos.receberResultadoRodada());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void dadosJogador(Scanner e) {
		System.out.println("Digite seu nome: ");
		jogador.setNome(new String(e.nextLine()));

		System.out.println("Digite seu nickName: ");
		jogador.setNick(new String(e.nextLine()));
	}
}
