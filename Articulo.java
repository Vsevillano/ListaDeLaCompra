package listadoEstructuras3.listaDeLaCompra2;
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
public class Articulo {

	/**
	 * Codigo unico univoco
	 */
	private static int generarCodigo = 1;
	
	/**
	 * Codigo del articulo
	 */
	private int codigo;
	
	/**
	 * Nombre del art�culo
	 */
	private String nombre;

	/**
	 * Cantidad m�nima del art�culo
	 */
	private int cantidadMin;

	/**
	 * Existencias del art�culo
	 */
	private int existencias;

	/**
	 * Constructor del articulo
	 * 
	 * @param nombre
	 * @param cantidadMin
	 * @param existencias
	 */
	public Articulo(String nombre, int cantidadMin, int existencias) {
		setNombre(nombre);
		setCantidadMin(cantidadMin);
		setExistencias(existencias);
		setCodigo();
	}
	
	/**
	 * Constructor solo con codigo
	 * @param codigo
	 */
	public Articulo(int codigo) {
		this.codigo = codigo;
	}


	/**
	 * Obtiene el codigo
	 * @return
	 */
	private int getCodigo() {
		return codigo;
	}
	
	/**
	 * Modifica el codigo identificador
	 * @param nombre
	 */
	private void setCodigo() {
		this.codigo = generarCodigo++;
	}

	/**
	 * Obtiene el nombre del articulo
	 * @return
	 */
	private String getNombre() {
		return nombre;
	}
	
	/**
	 * Modifica el nombre del articulo
	 * @param nombre
	 */
	private void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Obtiene la cantidad minima
	 * @return
	 */
	 int getCantidadMin() {
		return cantidadMin;
	}
	
	/**
	 * Modifica la cantidad minima
	 * @param cantidadMin
	 */
	boolean setCantidadMin(int cantidadMin) {
		if (cantidadMin < 0)
			return false;
		this.cantidadMin = cantidadMin;
		return true;
	}
	
	/**
	 * Obtiene el numero de existencias
	 * @return
	 */
	 int getExistencias() {
		return existencias;
	}

	/**
	 * Modifica el valor de existencias
	 * @param existencias
	 */
	private boolean setExistencias(int existencias) {
		if (existencias <= 0)
			return false;
		this.existencias = existencias;
		return true;
	}

	/**
	 * Aumenta el numero de existencias
	 * @param cantidad a comprar
	 */
	boolean comprar(int cantidad) {
		 if (cantidad <= 0)
			return false;
		setExistencias(getExistencias() + cantidad);
		return true;
	}
	
	 /**
	  * Aumenta el numero de existencias
	  * @param cantidad a comprar
	  */
	 boolean consumir(int cantidad) {
		 if (cantidad <= 0)
			return false;
		setExistencias(getExistencias() - cantidad);
		return true;
	 }
	 
	 /*
	  * (non-Javadoc)
	  * @see java.lang.Object#toString()
	  */
	 @Override
	 public String toString() {
		return "codigo: " + getCodigo() + " nombre: " + getNombre() + ", cantidad m�nima: "
					+ getCantidadMin() + ", existencias: " + getExistencias();
	 }

	 /*
	  * (non-Javadoc)
	  * @see java.lang.Object#hashCode()
	  */
	 @Override
	 public int hashCode() {
		 final int prime = 31;
		 int result = 1;
		 result = prime * result + codigo;
		 return result;
	 }

	 /*
	  * (non-Javadoc)
	  * @see java.lang.Object#equals(java.lang.Object)
	  */
	 @Override
	 public boolean equals(Object obj) {
		 if (this == obj)
			 return true;
		 if (obj == null)
			 return false;
		 if (getClass() != obj.getClass())
			 return false;
		 Articulo other = (Articulo) obj;
		 if (codigo != other.codigo)
			 return false;
		 return true;
	 }

}
