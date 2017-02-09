package listadoEstructuras3.listaDeLaCompra2;
import java.util.Iterator;

/**
 * ListaDeLaCompra. 
 * 
 * Implementa un programa que gestione una lista de la compra de forma automática. 
 * 
 * Se dispondrá de una lista de artículos y de sus existencias. 
 * 
 * En el momento en el que la cantidad de artículos llegue a un límite mínimo, dicho artículo  aparecerá en la lista de la compra. 
 * 
 * Cada vez que el usuario utilice uno de los artículos se decrementarán las existencias de dicho artículo. 
 * 
 * De igual forma, cada vez que el usuario compre el artículo, se incrementarán las existencias de dicho artículo.
 * 
 * A modo de ejemplo, supongamos que del artículo "latas de cerveza" se establece a un mínimo de 10 cervezas. 
 * 
 * Actualmente hay 14 y se consumen de golpe 5 cervezas.
 * 
 * a. Artículo: [nombre = latas de cerveza, cantidad mínima= 10, existencias = 14]
 * b. articulo.consumir(5)
 * c. Artículo: [nombre = latas de cerveza, cantidad mínima= 10, existencias = 9]
 * d. Como (articulo.getExistencias() <= articulo.getCantidadMin()) hay que comprar latas de cerveza.
 * 
 * Quizás sea interesante añadir un campo código del artículo para facilitar la gestión de la lista. 
 * Este código ha de ser único (static...)
 * Para ello, genera un interfaz con el usuario que permita entre otras acciones:
 * 
 * e. Añadir un producto nuevo a la lista.
 * f. Eliminar un elemento de la lista.
 * g. Incrementar las existencias de un artículo.
 * h. Decrementar las existencias de un artículo.
 * i. Modificar la cantidad mínima del artículo.
 * j. Mostrar la lista de todos los artículos.
 * k. Mostrar la lista de la compra.
 * 
 * Comienza analizando el diseño. Piensa en el total de clases que vas a utilizar y
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
	 * Añade un articulo a la lista
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
	 * Incrementa las existencias del artículo cuyo código es introducido por teclado
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
	 * Decrementa las existencias del artículo cuyo código es introducido por teclado
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
	 * Modifica la cantidad mínima del artículo cuyo código es introducido por teclado
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
	 * Comprueba las existencias de los artículos en relación con la cantidad
	 * mínima y se añaden los artículos a la lista de la compra
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
