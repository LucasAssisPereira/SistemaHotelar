package hotel_system;

public class Recepcionista extends Thread{
	
	public Recepcionista(String nome){
		setName(nome);
	}
	
	@Override
	public void run() {
		while (!Hotel.getFilaEspera().isEmpty()) {
			Quarto quarto = Hotel.quartoDisponivel();
			if (quarto != null) {
				if (quarto.reservar()) {
					Hospede hospede = Hotel.getHospede();
					if (hospede != null) {
						System.out.println("Hospedando cliente: " + hospede.getName() + " -  quarto: " + quarto.getNumero());
						hospede.hospedar(quarto);
					}
					
				}
			}
		}
		
		System.out.println("Acabou turno recepcionista");
	}
}
