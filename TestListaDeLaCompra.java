package listadoEstructuras3.listaDeLaCompra2;

import utiles.Menu;
import utiles.Teclado;
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
 * - Quizás sea interesante añadir un campo código del artículo para facilitar la gestión de la lista. 
 * - Este código ha de ser único (static...)
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
public class TestListaDeLaCompra {
	private static ListaDeLaCompra listaArticulos = new ListaDeLaCompra();
	private static int codigo;
	private static Articulo articulo;

	public static void main(String[] args) {
		Menu menuGeneral = new Menu("*** MENU LISTA COMPRA ***",
				new String[] { "Añadir artículo nuevo", "Eliminar artículo", "Incrementar existencias de un artículo",
						"Decrementar existencias de un artículo", "Modificar la cantidad mínima de un artículo",
						"Mostrar todos los artículos", "Mostrar la lista de la compra", "Salir" });

		int opcion;
		do {
			opcion = menuGeneral.gestionar();
			gestionarOpciones(opcion);
		} while (opcion != 8);

	}

	/**
	 * Gestiona las opciones del menu
	 * 
	 * @param opcion
	 *            escogida
	 */
	private static void gestionarOpciones(int opcion) {
		switch (opcion) {
		case 1:
			// Añade un articulo nuevo
			annadirArticulo();
			break;
		case 2:
			// Elimina un articulo
			eliminarArticulo();
			break;
		case 3:
			// Incrementar existencias
			incrementarExistenciasArticulo();
			break;
		case 4:
			// Decrementar existencias
			decrementarExistenciasArticulo();
			break;
		case 5:
			// Modificar cantidad minima
			modificarCantidadMinimaArticulo();
			break;
		case 6:
			// Mostrar articulos
			break;
		case 7:
			// Mostrar lista compra
				System.out.println("Lista de la compra:\n" + listaArticulos.mostrarListaCompra());
			break;
		case 8:
			// Salir
			System.exit(0);
			break;
		}
		mostrarListaArticulos();
	}

	/**
	 * Modifica la cantidad minima de un articulo de la lista
	 */
	private static void modificarCantidadMinimaArticulo() {
		codigo = Teclado.leerEntero("Código del artículo a modificar: ");
		articulo = new Articulo(codigo);
		switch (listaArticulos.modificarMinimo(articulo, Teclado.leerEntero("Nuevo minimo: "))) {
		case -1:
			System.out.println("La cantidad ha de ser positiva.\n");
			break;
		case 0:
			System.out.println("Cambio realizado con exito.\n");
			break;
		case -2:
			System.out.println("El procucto con el codigo " + codigo + " no existe.\n");
			break;
		case 2:
			System.out.println("Cantidad introducida mayor que existencias");
			break;
		}
	}

	/**
	 * Decrementa las existencias de un articulo de la lista
	 */
	private static void decrementarExistenciasArticulo() {
		codigo = Teclado.leerEntero("Código del artículo a consumir: ");
		articulo = new Articulo(codigo);
		switch (listaArticulos.decrementarExistencias(articulo, Teclado.leerEntero("Cantidad a consumir:"))) {
		case -1:
			System.out.println("La cantidad ha de ser positiva\n");
			break;
		case 0:
			System.out.println("Consumo realizado con exito\n");
			break;
		case -2:
			System.out.println("El procucto con el codigo " + codigo + " no existe");
			break;
		case 2:
			System.out.println("Cantidad introducida mayor que existencias");
			break;
		}
	}

	/**
	 * Incrementa las existencias de un articulo
	 */
	private static void incrementarExistenciasArticulo() {
		codigo = Teclado.leerEntero("Código del artículo a comprar:");
		articulo = new Articulo(codigo);
		switch (listaArticulos.incrementarExistencias(articulo, Teclado.leerEntero("Cantidad comprada:"))) {
		case -1:
			System.out.println("La cantidad ha de ser positiva.\n");
			break;
		case 0:
			System.out.println("Compra realizada con exito\n");
			break;
		case -2:
			System.out.println("El procucto con el codigo " + codigo + " no existe\n");
			break;
		}
	}

	/**
	 * Elimina un articulo de la lista de articulos
	 */
	private static void eliminarArticulo() {
		codigo = Teclado.leerEntero("Código del artículo a eliminar: ");

		articulo = new Articulo(codigo);
		if (!listaArticulos.eliminarArticulo(articulo))
			System.out.println("No se pudo eliminar");
	}

	/**
	 * Añade un articulo a la lista de articulos
	 */
	private static void annadirArticulo() {
		if (listaArticulos.annadir(Teclado.leerCadena("Nombre del articulo:"),
				Teclado.leerEntero("Minimo de existencias:"), Teclado.leerEntero("Existencias actuales:"))) {
			System.out.println("Articulo añadido con exito\n");
		} else
			System.out.println("Error al añadir el producto.\n");
	}

	/**
	 * Muestra la lista de articulos
	 */
	private static void mostrarListaArticulos() {
		if (!ListaDeLaCompra.listaArticulos.isEmpty())
			System.out.println("\nLista de artículos:\n" + ListaDeLaCompra.listaArticulos);
		else
			System.out.println("La lista está vacía.");
	}

}
