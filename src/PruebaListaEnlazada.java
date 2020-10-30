import java.util.LinkedList;


class Nodo{
	private int dato;
	private Nodo nodoSiguiente;
	
	
	public Nodo() {}
	public Nodo(int dato) {
		this.dato = dato;
	}
	public int getDato() {
		return dato;
	}
	public void setDato(int dato) {
		this.dato = dato;
	}
	public Nodo getNodoSiguiente() {
		return nodoSiguiente;
	}
	public void setNodoSiguiente(Nodo nodoSiguiente) {
		this.nodoSiguiente = nodoSiguiente;
	}
	@Override
	public String toString() {
		return "Nodo [dato=" + dato + ", nodoSiguiente=" + nodoSiguiente + "]";
	}
	
}

/*
 * Operaciones basicas de las listas enlazadas
 * 1) Creación
 * 2) Verificar Lista vacia
 * 3) Agregar elemento
 * 		2a) Al inicio
 * 		2b) Al final
 * 		2c) En un lugar específico (opcional)
 * 4) Eliminar elemento
 * 		3a) AL inicio
 * 		3b) Al final
 * 		3c) En un lugar específico (opcional)
 * 5) Recorrer lista (mostrar elementos)
 * 6) Mostrar cantidad de elementos
 */
class ListaEnlazada{
	Nodo nodoInicio;
	Nodo nodoFin;
	
	//1) Creacion
	public ListaEnlazada() {
		nodoInicio = nodoFin = null;
	}
	//2)Verificar lista vacia
	public boolean verificarListaVacia() {

		return (nodoInicio == null) ? true : false;
	}
	
	//3) Insertar o agregar elemento al inicio
	public void agregarElementoAlInicio(int dato) {
		
		Nodo nuevoNodo = new Nodo(dato);
		
		if(nodoInicio == null) {
			nodoInicio = nodoFin = nuevoNodo;
			//lista está vacía
		}else {
			nuevoNodo.setNodoSiguiente(nodoInicio);
			nodoInicio = nuevoNodo;
		}
	}
	
	public void agregarElementoAlFinal(int dato) {
		Nodo nodoNuevo = new Nodo(dato);
		
		if(verificarListaVacia()) {
			nodoInicio = nodoFin = nodoNuevo;
		}else {
			nodoFin.setNodoSiguiente(nodoNuevo);
			nodoFin = nodoNuevo;
		}
	}
	
	//4)Eliminar elemento (inicio)
	public void eliminarElementoAlInicio() {
		
		if(verificarListaVacia()) {
			System.out.println("No hay elementos para eliminar");
		}else if(nodoInicio == nodoFin) {
			nodoInicio = nodoFin = null;
		}else{
			nodoInicio = nodoInicio.getNodoSiguiente();
		}
	}
	
	//4) eliminar elemento (final)
	public void eliminarElementoAlFinal() {
		Nodo nodoActual = nodoInicio;
		int cont = 0;
		if(verificarListaVacia()) {
			System.out.println("No hay elementos para eliminar");
		}else if(nodoInicio == nodoFin) {
			nodoInicio = nodoFin = null;
		}else{
			while(cont < mostrarCantidadElementos()-2) {
				nodoActual = nodoActual.getNodoSiguiente();
				cont++;
			}
			nodoActual.setNodoSiguiente(null);
			nodoFin = nodoActual;
		}
	}
	
	//4c) eliminar dato específico
	public int eliminarDatoEspecifico(int dato) {
		
		if(nodoInicio == null) {// caso 1: lista vacia 
			return -1;
		}else if(nodoInicio == nodoFin && nodoInicio.getDato() == dato) { //caso 2: Hay un solo nodo
			System.out.println("encontrado en el primero NODO");
			int n = nodoInicio.getDato();
			nodoInicio = nodoFin = null;
			return n;
		}else { // caso 3: hay mas de un nodo y el dato puede estar en alguno de ellos
			Nodo nodoAnterior, nodoSiguiente;
			nodoAnterior = nodoInicio;
			nodoSiguiente = nodoInicio.getNodoSiguiente();
			
			while(nodoSiguiente != null && nodoSiguiente.getDato() != dato) {
				nodoAnterior = nodoAnterior.getNodoSiguiente();
				nodoSiguiente = nodoSiguiente.getNodoSiguiente();
			}
			
			if(nodoSiguiente != null && nodoSiguiente.getDato() == dato) {
				int n = nodoSiguiente.getDato();
				nodoAnterior.setNodoSiguiente(nodoSiguiente.getNodoSiguiente());
				nodoSiguiente = nodoSiguiente.getNodoSiguiente();
				
				return n;
			}else {
				return -2;
			}
		}
		
		
	}//Metodo eliminarDatoEspecifico
	
	
	//5) Recorrer lista (mostrar elementos)
	public void mostrarElementos() {
		Nodo nodoActual = nodoInicio;
		
		while(nodoActual != null) {
			System.out.print("[" + nodoActual.getDato() + "]---> " );
			nodoActual = nodoActual.getNodoSiguiente();
		}
	}
	 //6) Mostrar cantidad de elementos
	public int mostrarCantidadElementos() {
		Nodo nodoActual = nodoInicio;
		int cont = 0;
		while(nodoActual!=null) {
			
			cont++;
			
			nodoActual = nodoActual.getNodoSiguiente();
		}
		return cont;
	}
	
	
}//clae listaEnlazada

public class PruebaListaEnlazada {

	public static void main(String[] args) {
		
		LinkedList<Integer> le = new LinkedList<Integer>();
		
		ListaEnlazada miLe = new ListaEnlazada();
		
		/*miLe.agregarElementoAlInicio(8);
		miLe.agregarElementoAlInicio(9);
		miLe.agregarElementoAlInicio(6);
		miLe.agregarElementoAlInicio(3);		
		miLe.agregarElementoAlInicio(2);
		miLe.agregarElementoAlInicio(1);*/
		
		miLe.mostrarElementos();
		
		int num = miLe.eliminarDatoEspecifico(9);
		
		if(num == -1)
			System.out.println("Lista vacia");
		else if(num == -2)
			System.out.println("No se encontró el dato");
		else
			System.out.println("Se eliminó el " + num + " correctamente");
		
		//System.out.println(num == -1? "Lista Vacia" : "Se elimino " + num + " correctamente");

		miLe.mostrarElementos();
		
		miLe.eliminarElementoAlInicio();
		System.out.println();
		miLe.mostrarElementos();
		miLe.eliminarElementoAlFinal();
		System.out.println();
		miLe.mostrarElementos();
		
		miLe.agregarElementoAlInicio(7);
		System.out.println();
		miLe.mostrarElementos();
		miLe.agregarElementoAlFinal(20);
		System.out.println();
		miLe.mostrarElementos();
		
		System.out.println("\n\nCantidad de elementos: " + miLe.mostrarCantidadElementos()+"\n");
		
	}

}
