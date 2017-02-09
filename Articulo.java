package listadoEstructuras3.listaDeLaCompra2;
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
	 * Nombre del artículo
	 */
	private String nombre;

	/**
	 * Cantidad mínima del artículo
	 */
	private int cantidadMin;

	/**
	 * Existencias del artículo
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
		return "codigo: " + getCodigo() + " nombre: " + getNombre() + ", cantidad mínima: "
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
