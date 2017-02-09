package listadoEstructuras3.listaDeLaCompra2;
import java.util.Iterator;

/**
 * ListaDeLaCompra. 
 * 
 * Implementa un programa que gestione una lista de la compra de forma autom�tica. 
 * 
 * Se dispondr� de una lista de art�culos y de sus existencias. 
 * 
 * En el momento en el que la cantidad de art�culos llegue a un l�mite m�nimo, dicho art�culo  aparecer� en la lista de la compra. 
 * 
 * Cada vez que el usuario utilice uno de los art�culos se decrementar�n las existencias de dicho art�culo. 
 * 
 * De igual forma, cada vez que el usuario compre el art�culo, se incrementar�n las existencias de dicho art�culo.
 * 
 * A modo de ejemplo, supongamos que del art�culo "latas de cerveza" se establece a un m�nimo de 10 cervezas. 
 * 
 * Actualmente hay 14 y se consumen de golpe 5 cervezas.
 * 
 * a. Art�culo: [nombre = latas de cerveza, cantidad m�nima= 10, existencias = 14]
 * b. articulo.consumir(5)
 * c. Art�culo: [nombre = latas de cerveza, cantidad m�nima= 10, existencias = 9]
 * d. Como (articulo.getExistencias() <= articulo.getCantidadMin()) hay que comprar latas de cerveza.
 * 
 * Quiz�s sea interesante a�adir un campo c�digo del art�culo para facilitar la gesti�n de la lista. 
 * Este c�digo ha de ser �nico (static...)
 * Para ello, genera un interfaz con el usuario que permita entre otras acciones:
 * 
 * e. A�adir un producto nuevo a la lista.
 * f. Eliminar un elemento de la lista.
 * g. Incrementar las existencias de un art�culo.
 * h. Decrementar las existencias de un art�culo.
 * i. Modificar la cantidad m�nima del art�culo.
 * j. Mostrar la lista de todos los art�culos.
 * k. Mostrar la lista de la compra.
 * 
 * Comienza analizando el dise�o. Piensa en el total de clases que vas a utilizar y
 * aprovecha aquellas clases que puedas.
 * 
 * @author Victoriano Sevillano Vega
 * @version 1.0
 *
 */
public class ListaDeLaCompra {
	/**
	 * ArrayList de articulos
	 */
	static Lista<Articulo> listaArticulos = new Lista<Articulo>();
	
	/**
	 * String para la lista de la compra
	 */
	static String listaCompra = "";

	public static int CANTIDAD_ES_NEGATIVA = -1;
	public static int CANTIDAD_MAYOR_EXISTENCIAS = 2;
	public static int NO_EXISTE = -2;
	
	/**
	 * A�ade un articulo a la lista
	 * @param nombre 
	 * @param cantidadMin 
	 * @param existencias 
	 * @param articulo
	 * @return
	 */
	boolean annadir(String nombre, int cantidadMin, int existencias) {
		return listaArticulos.annadir(new Articulo(nombre, cantidadMin, existencias));
	}

	/**
	 * Elimina un articulo de la lista
	 * 
	 * @param articulo
	 * @return true o false
	 */
	boolean eliminarArticulo(Articulo articulo) {
		if (!listaArticulos.isEmpty() && listaArticulos.contains(articulo))
			return listaArticulos.eliminar(articulo);
		return false;
	}
	
	/**
	 * Incrementa las existencias del art�culo cuyo c�digo es introducido por teclado
	 * @param articulo
	 * @param cantidad
	 * @return un entero con el codigo de error 
	 */
	int incrementarExistencias(Articulo articulo, int cantidad) {
		if (!listaArticulos.isEmpty() && listaArticulos.contains(articulo)) {
			if (cantidad <= 0)
				return CANTIDAD_ES_NEGATIVA; // La cantidad es negativa
			else {
				listaArticulos.get(listaArticulos.indexOf(articulo)).comprar(cantidad);
				return 0; // Compra la cantidad
			}
		} else
			return NO_EXISTE; // No existe
	}

	/**
	 * Decrementa las existencias del art�culo cuyo c�digo es introducido por teclado
	 * @param articulo
	 * @param cantidad
	 * @return un entero con el codigo de error
	 */
	int decrementarExistencias(Articulo articulo, int cantidad) {
		if (!listaArticulos.isEmpty() && listaArticulos.contains(articulo)) {
			if (cantidad <= 0)
				return CANTIDAD_ES_NEGATIVA; // La cantidad es negativa
			else if (cantidad > articulo.getExistencias())
				return CANTIDAD_MAYOR_EXISTENCIAS;
			else {
				listaArticulos.get(listaArticulos.indexOf(articulo)).consumir(cantidad);
				return 0; // Consumo de la cantidad
			}
		} else
			return NO_EXISTE; // No existe
	}

	/**
	 * Modifica la cantidad m�nima del art�culo cuyo c�digo es introducido por teclado
	 * @param articulo
	 * @param cantidad
	 * @return un entero con el codigo de error
	 */
	int modificarMinimo(Articulo articulo, int cantidad) {
		if (!listaArticulos.isEmpty() && listaArticulos.contains(articulo)) {
			if (cantidad <= 0)
				return CANTIDAD_ES_NEGATIVA; // La cantidad es negativa
			else {
				listaArticulos.get(listaArticulos.indexOf(articulo)).setCantidadMin(cantidad);
				return 0; // Consumo de la cantidad
			}
		} else
			return NO_EXISTE; // No existe
	}

	/**
	 * Comprueba las existencias de los art�culos en relaci�n con la cantidad
	 * m�nima y se a�aden los art�culos a la lista de la compra
	 */
	String mostrarListaCompra() {
		Articulo articulo;
		listaCompra = "";
		Iterator<Articulo> iterator = listaArticulos.iterator();
		while (iterator.hasNext()) {
			articulo = iterator.next();
			if (articulo.getExistencias() <= articulo.getCantidadMin())
				listaCompra += articulo + ". Cantidad necesaria: " + (articulo.getCantidadMin() - articulo.getExistencias()) + "\n";
		}
		return listaCompra;
	}
}
