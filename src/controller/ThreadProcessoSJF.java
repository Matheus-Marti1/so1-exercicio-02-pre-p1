package controller;

import java.util.concurrent.Semaphore;

public class ThreadProcessoSJF extends Thread {

	private Semaphore semaforo;
	private int id;
	private int duracao;

	public ThreadProcessoSJF(int id, Semaphore semaforo, int duracao) {
		this.id = id;
		this.semaforo = semaforo;
		this.duracao = duracao;
	}

	@Override
	public void run() {
		try {
			semaforo.acquire();
			System.out.println(
					"Processo #" + id + " está em execução com duração de " + duracao + " segundos. Aguarde...");
			sleep(duracao * 1000);
			System.out.println("Processo #" + id + " terminou a execução.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
	}

}
