package entities;

import java.util.Random;

public class Hospede extends Thread{

	private boolean hospedado = false;
	private Quarto quarto = null;
	
	public Hospede(String nome) {
		this.setName(nome);
	}
	
	@Override
	public void run() {
		while (!hospedado) {
			try {
				System.out.println(this.getName() + " - Não consegui um quarto, vou passear...");
				Thread.sleep(4000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		Random random = new Random();
		int saida = random.nextInt(2);
		
		if (hospedado) {
			if (saida == 1) {
				System.out.println("Saindo do quarto - " + quarto.getNumero());
				quarto.sair();
				System.out.println("Entrando no quarto - " + quarto.getNumero());
				quarto.entrar();
			}
		}
		
		System.out.println("Acabou a estadia no quarto - " + quarto.getNumero());
		quarto.liberar();
		this.quarto = null;
		this.hospedado = false;
	}

	public void hospedar(Quarto quarto) {
		this.setQuarto(quarto);
		this.hospedado = true;
	}

	public Quarto getQuarto() {
		return quarto;
	}

	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}
	
	
}

