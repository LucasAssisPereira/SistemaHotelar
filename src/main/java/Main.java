import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

	private final static int NUMERO_QUARTOS = 10;
	private final static int NUMERO_HOSPEDES = 50;
	private final static int NUMERO_RECEPCIONISTAS = 5;
	private final static int NUMERO_CAMAREIRAS = 10;
	
	public static void main(String[] args) {
		
		List<Quarto> quartos = new ArrayList<>();
		List<Recepcionista> recepcionistas = new ArrayList<>();
		List<Camareira> camareiras = new ArrayList<>();
		Queue<Hospede> hospedes = new LinkedList<>();
		
		Hotel.adicionarQuartos(quartos);
		Hotel.adicionarHospedes(hospedes);
		
		for (int i = 0; i < NUMERO_QUARTOS; i++) {
			Quarto quarto = new Quarto("Quarto: " + (100 + i));
			quartos.add(quarto);
		}
		
		for (int i = 0; i < NUMERO_HOSPEDES; i++) {
			Hospede hospede = new Hospede("Hospede: " + i);
			hospedes.add(hospede);
			hospede.start();
		}
		
		for (int i = 0; i < NUMERO_RECEPCIONISTAS; i++) {
			Recepcionista recepcionista = new Recepcionista("Recepcionista: " + i);
			recepcionistas.add(recepcionista);
			recepcionista.start();
		}
		
		for (int i = 0; i < NUMERO_CAMAREIRAS; i++) {
			Camareira camareira = new Camareira("Camareira: " + i);
			camareiras.add(camareira);
			camareira.start();
		}
		
		
		
	}
}
