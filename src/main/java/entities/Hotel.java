package entities;

import java.util.List;
import java.util.Queue;

public class Hotel {

	private static List<Quarto> quartos;
	private static Queue<Hospede> filaEspera;

	
	public static void adicionarHospedes(Queue<Hospede> filaEspera) {
		Hotel.filaEspera = filaEspera;
	}
	
	public static void adicionarQuartos(List<Quarto> quartos) {
		Hotel.quartos = quartos;
	}
	
	public static Quarto quartoDisponivel() {
		for (Quarto quarto : quartos) {
			if (!quarto.isReservado()) {
				return quarto;
			}
		}
		
		return null;
	}
	
	public static boolean quartoLimpo() {
		for (Quarto quarto : quartos) {
			return quarto.isLimpo();
			
		}
		
		return false;
	}
	
	public static synchronized Hospede getHospede(){
		return filaEspera.poll();
	}

	public static Queue<Hospede> getFilaEspera() {
		return filaEspera;
	}

	public static List<Quarto> getQuartos() {
		return quartos;
	}

}
