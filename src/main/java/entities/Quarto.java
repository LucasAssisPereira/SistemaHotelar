package entities;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Quarto {

	private boolean reservado = false;
	private boolean chaveRecepcao = true;
	private boolean limpo = true;
	private String numero;
	private ReentrantLock lock = new ReentrantLock();
	private Condition entrada = lock.newCondition();

	public Quarto(String numero){
		this.setNumero(numero);
	}



	public boolean reservar() {
		boolean acesso = lock.tryLock();
		
		if (acesso && !reservado) {
			this.reservado = true;
			lock.unlock();
			return true;
		}
		
		return false;
	}
	
	public void entrar() {
		try {
			lock.lock();
			while (!chaveRecepcao || !limpo) {
				System.out.println("Esperando a limpeza do quarto - " + this.getNumero());
				entrada.await();
			}
			this.chaveRecepcao = false;
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	public void sair() {
		try {
			this.chaveRecepcao = true;
			this.limpo = false;
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void limpar() {
		boolean acesso = lock.tryLock();
		
		if (acesso) {
			try {
				this.chaveRecepcao = false;
				System.out.println("Limpando quarto - " + this.getNumero());
				Thread.sleep(4000);
				this.limpo = true;
				this.entrada.signal();
				this.chaveRecepcao = true;
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				this.lock.unlock();
			}
		}
	}
	
	public void liberar() {
		this.reservado = false;
		this.chaveRecepcao = true;
		this.limpo = false;
	}

	public boolean isReservado() {
		return reservado;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public boolean isLimpo() {
		return limpo;
	}

}
