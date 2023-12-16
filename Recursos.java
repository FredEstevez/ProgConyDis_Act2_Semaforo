package semaforo;

import java.util.Random;

public class Recursos extends Thread {
	
	public Recursos() {
		start();
	}
	
	private void recurso() {
		
		Random rnNum = new Random();
		int sleepTime = rnNum.nextInt( 250 - 25 + 1) +25;
		
		try {
			sleep(sleepTime);			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//recursos en uso
		int NumRecursos = buffer.getUnidades().poll();
		System.out.println("El recurso número :" + NumRecursos + "ha sido asignado.");
		
	}
	
	@Override
	public void run() {
		
		while(true ) {
			if(buffer.getUnidades().size() == 0) {
				  System.out.println(" Recursos libres , esperando a ser asignados");
			  }
			  try {
			       buffer.getsReservar().acquire();
			       } catch (InterruptedException e) {
					 e.printStackTrace();
				   }
			  recurso();
			  buffer.getsLiberar().release();
			
		}
		
	}
	
} 
