package listadoEstructuras3.listaDeLaCompra2;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Crea una clase genérica Lista. Has de implementar los siguientes métodos:
 * a. Añada al final de la lista
 * b. Inserte un elemento en una determinada posición
 * c. Modifique un elemento reemplazándolo por otro
 * d. Conozca el tamaño de la lista
 * e. Elimine elementos de la lista
 * f. Busque elementos en la lista
 * g. Copie la lista
 * 
 * @author Victoriano Sevillano Vega
 * @version 1.0
 * @param <E>
 */
public class Lista<E> {
	/**
	 * Campo de lista
	 */
	private ArrayList<E> lista;

	/**
	 * Contructor de lista
	 */
	public Lista() {
		if (lista == null)
            lista = new ArrayList<E>();
		else
			this.lista = new ArrayList<E>();
	}

	/**
	 * Añade un elemento al final
	 * @param element
	 */
	boolean annadir(E element) {
		return lista.add(element);
	}

	/**
	 * Añade un elemento en una posicion
	 * @param element
	 * @param index
	 */
	boolean annadir(int index, E element) {
		if (fueraDeRango(index))
			return false;
		lista.add(index, element);
		return true;
	}

	/**
	 * Reemplaza un elemento en una posicion
	 * @param element
	 * @param index
	 * @return
	 */
	public E modificar(E element, int index) {
		if (fueraDeRango(index))
			return null;
		return lista.set(index, element);
	}

	/**
	 * Obtiene el tamaño de la lista
	 * @return
	 */
	public int size() {
		return lista.size();
	}

	/**
	 * Elimina un elemento en una posicion
	 * @param index
	 * @return
	 */
	public E eliminar(int index) {
		if (fueraDeRango(index))
			return null;
		return lista.remove(index);
	}
	
	/**
	 * Elimina un elemento en una posicion
	 * @param index
	 * @return
	 */
	public boolean eliminar(E element) {
		return lista.remove(element);
	}

	/**
	 * Obtiene un elemento dada una posicion valida
	 * @param index
	 * @return
	 */
	public E get(int index) {
		if (fueraDeRango(index))
			return null;
		return lista.get(index);
	}

	/**
	 * Comprueba si contiene el elemento
	 * @param element
	 * @return true o false
	 */
	public boolean contains(E element) {
		return lista.contains(element);
	}

	/**
	 * Controla si la lista esta vacia
	 * @return true o false
	 */
	public boolean isEmpty() {
		return lista.isEmpty();
	}

	/**
	 * Itera sobre la lista
	 * @return Un interador
	 */
	public Iterator<E> iterator() {
		return lista.iterator();
	}

	/**
	 * Copia la lista
	 * @return una lista clonada
	 */
	Object copiar() {
		return lista.clone();
	}

	/**
	 * Obtiene el indice de un elemento
	 * @param articulo
	 * @return
	 */
	public int indexOf(E element) {
		return lista.indexOf(element);
	}
	
	
	/**
	 * Controla que no se salga de rango
	 * @param index
	 * @return
	 */
	private boolean fueraDeRango(int index) {
		if (index < 0 || index > lista.size())
			return true;
		return false;
	}
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String cadena = "";
		for (Iterator<E> iterator = lista.iterator(); iterator.hasNext();) {
			E element = (E) iterator.next();
			cadena += element + "\n";
		}
		return cadena;
	}

	

}