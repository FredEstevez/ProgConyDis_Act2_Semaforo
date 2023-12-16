package semaforo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class buffer{
	
	 private static Queue<Integer> Unidades = new LinkedList<Integer>();
	 public static final int BSize = 5;
	 private static Semaphore sReservar= new Semaphore(0, true);
	 private static Semaphore sLiberar = new Semaphore(BSize,true);
	 
	public static Queue<Integer> getUnidades() {
		return Unidades;
	}
	public static Semaphore getsReservar() {
		return sReservar;
	}
	public static Semaphore getsLiberar() {
		return sLiberar;
	}
	
}