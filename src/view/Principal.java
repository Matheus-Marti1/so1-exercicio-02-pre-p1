package view;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

import controller.ThreadProcessoSJF;

public class Principal {

	public static void main(String[] args) {
		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);
		List<Integer> threadSJFduracao = new ArrayList<>();
		for (int i = 0; i < 20; i++) {
			int duracao = (int) (Math.random() * 117) + 4;
			threadSJFduracao.add(duracao);
		}

		threadSJFduracao.sort(null);
		System.out.println(threadSJFduracao);
		int id = 1;
		for (int duracao : threadSJFduracao) {
			Thread tProcesso = new ThreadProcessoSJF(id, semaforo, duracao);
			tProcesso.start();
			id++;
		}
	}
}
