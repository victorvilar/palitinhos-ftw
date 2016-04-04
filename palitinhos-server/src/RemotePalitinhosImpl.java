
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import br.ufrn.imd.sid.model.Jogador;
import br.ufrn.imd.sid.model.Jogo;

public class RemotePalitinhosImpl extends UnicastRemoteObject implements RemotePalitinhos {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GameRun game;
	private int quantosResultados = 0;

	public static void main(String[] args) {
		try {
			System.setSecurityManager(new RMISecurityManager());

			Registry r = LocateRegistry.createRegistry(1099);
			r.bind("palitinhos", new RemotePalitinhosImpl());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public RemotePalitinhosImpl() throws RemoteException {
		super();
		Jogo jogo = new Jogo();
		this.game = new GameRun(jogo);
		System.out.println("Servidor: Servidor Rodando e Jogo pronto");
	}

	public String getEstado() throws RemoteException {
		return game.getEstado();
	}

	public void addJogador(String nome, String nick) throws RemoteException {
		Jogador jogador = new Jogador(nome, nick);
		game.addJogador(jogador);
	}

	public String iniciarJogo(String nome, String nick, int opcao) throws RemoteException {
		Jogador jogador = game.acharJogador(nome, nick);
		jogador.setOpcao(opcao);
		game.setEstado();

		if (game.getEstado().equals("ESPERANDO_JOGADORES")) {
			return "ESPERANDO_JOGADORES";
		} else {
			return "ESPERANDO_LANCES";
		}
	}

	public String darLance(String nome, String nick, int opcao, int mao, int chute) throws RemoteException {

		if (quantosResultados == game.getJogo().getJogadores().size()) {
			quantosResultados = 0;
			game.resetarChutes();
			game.resetarTotalPalitosRodada();
			game.resetarMaos();
		}

		if (opcao == 2) {
			Jogador jogador = game.acharJogador(nome, nick);
			jogador.setOpcao(2);
			jogador.setChute(chute);
			jogador.setPalitosMao(mao);
		}
		game.setEstado();

		if (game.getEstado().equals("FIM_RODADA")) {
			game.somarTotalPalitosRodada();
			game.addRodada();

			for (Jogador j : game.procurarGanhadorRodada()) {
				j.setTotalPalitos(j.getTotalPalitos() - 1);
			}
			return "FIM_RODADA";
		} else {
			return game.getEstado();
		}
	}

	public String receberResultadoRodada() throws RemoteException {
		quantosResultados++;
		return game.montarRespostaRodada();
	}

	public void sairJogo(String nome, String nick) throws RemoteException {
		game.removeJogador(game.acharJogador(nome, nick));
	}

	public int quantosJogadores() throws RemoteException {
		return game.getJogo().getJogadores().size();
	}

}
