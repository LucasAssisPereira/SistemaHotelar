package entities;

import java.util.List;

public class Camareira extends Thread{
	
	public Camareira(String nome) {
		this.setName(nome);
	}

	@Override
	public void run() {
		boolean loop = true;
		int contador = 0;
		while (loop) {
			boolean quartoLimpo = Hotel.quartoLimpo();
			if (quartoLimpo) {
				Hotel.getQuartos().forEach(Quarto::limpar);
				contador++;
			}
			if(contador == 50){
				loop = false;
			}
		}
	}


}
