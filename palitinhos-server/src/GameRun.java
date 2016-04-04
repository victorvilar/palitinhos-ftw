
import java.util.ArrayList;

import br.ufrn.imd.sid.model.Jogador;
import br.ufrn.imd.sid.model.Jogo;

public class GameRun {

	private Jogo jogo;

	public GameRun(Jogo jogo) {
		this.jogo = jogo;
	}

	public void addJogador(Jogador j) {
		if (acharJogador(j.getNome(), j.getNick()) == null) {
			jogo.getJogadores().add(j);
		}
	}

	public void removeJogador(Jogador j) {
		jogo.getJogadores().remove(j);
		jogo.getJogadoresDesistentes().add(j);
	}

	public void addRodada() {
		jogo.setRodada(jogo.getRodada() + 1);
	}

	public Jogador acharJogador(String nome, String nick) {
		for (Jogador j : jogo.getJogadores()) {
			if (j.getNome().equals(nome) && j.getNick().equals(nick)) {
				return j;
			}
		}
		return null;
	}

	public ArrayList<Jogador> procurarGanhadorRodada() {
		ArrayList<Jogador> jogs = new ArrayList<Jogador>();
		for (Jogador j : jogo.getJogadores()) {
			if (j.getChute() == jogo.getTotalPalitosRodada()) {
				j.setTotalPalitos(j.getTotalPalitos() - 1);
				jogs.add(j);
			}
		}
		return jogs;
	}

	public void resetarChutes() {
		for (Jogador j : jogo.getJogadores()) {
			j.setChute(-1);
		}
	}

	public void resetarMaos() {
		for (Jogador j : jogo.getJogadores()) {
			j.setPalitosMao(-1);
		}
	}

	public void somarTotalPalitosRodada() {
		jogo.setTotalPalitosRodada(0);
		for (Jogador j : jogo.getJogadores()) {
			jogo.setTotalPalitosRodada(jogo.getTotalPalitosRodada() + j.getPalitosMao());
		}
	}

	public void resetarTotalPalitosRodada() {
		jogo.setTotalPalitosRodada(-1);
	}

	public ArrayList<Jogador> procurarGanhadorJogo() {
		ArrayList<Jogador> jogs = new ArrayList<Jogador>();
		for (Jogador j : jogo.getJogadores()) {
			if (j.getTotalPalitos() == 0) {
				jogs.add(j);
			}
		}
		return jogs;
	}

	public void setEstado() {
		/*
		 * Estados validos ESPERANDO_JOGADORES, ESPERANDO_LANCES, FIM_RODADA,
		 * FIM_JOGO
		 */
		if ((jogo.getJogadores().size() < 2) || !todosProntos()) {
			jogo.setEstado("ESPERANDO_JOGADORES");
		} else if (todosProntos()) {
			if (todosComMaoeLance()) {
				if (quemVenceu() != null) {
					jogo.setEstado("FIM_JOGO");
				}
				jogo.setEstado("FIM_RODADA");
			} else {
				jogo.setEstado("ESPERANDO_LANCES");
			}
		}
	}

	public String getEstado() {
		return jogo.getEstado();
	}

	public boolean todosProntos() {
		for (Jogador j : jogo.getJogadores()) {
			if (j.getOpcao() == -1) {
				return false;
			}
		}
		return true;
	}

	public boolean todosComMaoeLance() {
		for (Jogador j : jogo.getJogadores()) {
			if (j.getChute() == -1 || j.getPalitosMao() == -1) {
				return false;
			}
		}
		return true;
	}

	public Jogador quemVenceu() {
		for (Jogador j : jogo.getJogadores()) {
			if (j.getTotalPalitos() == 0) {
				return j;
			}
		}
		return null;
	}

	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}

	public String montarRespostaRodada() {
		ArrayList<Jogador> jogadores = new ArrayList<Jogador>();
		jogadores = procurarGanhadorRodada();
		String resposta = new String();
		String vencedoresRodada = new String("Vencedores da rodada: \n");
		resposta = "Rodada numero: " + jogo.getRodada() + "\n";

		for (Jogador j : jogadores) {
			vencedoresRodada = vencedoresRodada + "\t " + j.getNome() + " - " + j.getNick() + "\n";
		}
		resposta = resposta + vencedoresRodada;

		if (getEstado().equals("FIM_JOGO")) {
			String vencedoresJogo = new String("Vencedor(es) do jogo: \n");
			for (Jogador j : procurarGanhadorJogo()) {
				vencedoresJogo = vencedoresJogo + "\t " + j.getNome() + " - " + j.getNick() + "\n";
			}
			resposta = resposta + vencedoresJogo;
		}

		return resposta;
	}
}
