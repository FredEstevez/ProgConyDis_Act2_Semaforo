package semaforo;


import java.util.Random;

	public class Procesos extends Thread{

		  public Procesos() {
			  start();
		  }
		  
		  private void proceso() {
			  
			  Random rdnum = new Random();
			  int numP = rdnum.nextInt( 9 ) + 1;
			  int sleepTime = rdnum.nextInt( 250 - 25 + 1 )+ 25;//rango (max - min + 1) + min
			  try {
				sleep(sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			  System.out.println("Se ha generado un nuevo proceso, número: " + numP );
			  
			  //Añadimos al buffer
			  buffer.getUnidades().add(numP);
			  
		  }
		  
		  @Override
		  public void run() {
			  
			  	while(true ) {
				  
				  if(buffer.getUnidades().size() == buffer.BSize) {
					  System.out.println(" Todos los hilos están ocupados");
				  }
				  try {
				       buffer.getsLiberar().acquire();
				       } catch (InterruptedException e) {
						 e.printStackTrace();
					   }
				  proceso();
				  buffer.getsReservar().release();
			  }
			  
		  }

	}

