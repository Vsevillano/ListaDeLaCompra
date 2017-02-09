package listadoEstructuras3.listaDeLaCompra2;

import utiles.Menu;
import utiles.Teclado;
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
 * - Quiz�s sea interesante a�adir un campo c�digo del art�culo para facilitar la gesti�n de la lista. 
 * - Este c�digo ha de ser �nico (static...)
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
public class TestListaDeLaCompra {
	private static ListaDeLaCompra listaArticulos = new ListaDeLaCompra();
	private static int codigo;
	private static Articulo articulo;

	public static void main(String[] args) {
		Menu menuGeneral = new Menu("*** MENU LISTA COMPRA ***",
				new String[] { "A�adir art�culo nuevo", "Eliminar art�culo", "Incrementar existencias de un art�culo",
						"Decrementar existencias de un art�culo", "Modificar la cantidad m�nima de un art�culo",
						"Mostrar todos los art�culos", "Mostrar la lista de la compra", "Salir" });

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
			// A�ade un articulo nuevo
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
		codigo = Teclado.leerEntero("C�digo del art�culo a modificar: ");
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
		codigo = Teclado.leerEntero("C�digo del art�culo a consumir: ");
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
		codigo = Teclado.leerEntero("C�digo del art�culo a comprar:");
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
		codigo = Teclado.leerEntero("C�digo del art�culo a eliminar: ");

		articulo = new Articulo(codigo);
		if (!listaArticulos.eliminarArticulo(articulo))
			System.out.println("No se pudo eliminar");
	}

	/**
	 * A�ade un articulo a la lista de articulos
	 */
	private static void annadirArticulo() {
		if (listaArticulos.annadir(Teclado.leerCadena("Nombre del articulo:"),
				Teclado.leerEntero("Minimo de existencias:"), Teclado.leerEntero("Existencias actuales:"))) {
			System.out.println("Articulo a�adido con exito\n");
		} else
			System.out.println("Error al a�adir el producto.\n");
	}

	/**
	 * Muestra la lista de articulos
	 */
	private static void mostrarListaArticulos() {
		if (!ListaDeLaCompra.listaArticulos.isEmpty())
			System.out.println("\nLista de art�culos:\n" + ListaDeLaCompra.listaArticulos);
		else
			System.out.println("La lista est� vac�a.");
	}

}
