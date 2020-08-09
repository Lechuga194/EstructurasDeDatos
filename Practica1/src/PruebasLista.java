import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * Clase para probar los metodos de Lista
 * 
 * @author Luis Manuel Martinez Damaso <luismanuel@ciencias.unam.mx>
 */
public class PruebasLista {

	/**
	 *
	 * @return
	 */
	public static double pruebaAgregar() {
		System.out.println("***************Prueba agregar ***************");
		try {
			String copia = "[h, o, l, a]";
			Lista<String> lista = new Lista();
			lista.agregar("a");
			lista.agregar("l");
			lista.agregar("o");
			lista.agregar("h");

			String listaString = lista.toString();

			int valor = (listaString.equals(copia)) ? 1 : 0;
			System.out.println("Objetivo:  " + copia);
			System.out.println("Resultado: " + lista);
			if (valor == 1) {
				System.out.println("----Prueba existosa-----");
			} else {
				System.out.println("++++Prueba fallida++++");
			}
			System.out.println("***************Prueba agregar ***************");

			return valor;

		} catch (Exception e) {
			System.out.println("--------------------Error--------------------");
			System.out.println(e);
			System.out.println("--------------------Error--------------------");
			return 0;
		}
	}

	/**
	 *
	 * @return
	 */
	public static double pruebaEliminar() {
		System.out.println("***************Prueba eliminar***************");
		try {
			String copia = "[p, r, u, e, b, a]";
			Lista<String> lista = new Lista();
			lista.agregar("a");
			lista.agregar("b");
			lista.agregar("e");
			lista.agregar("u");
			lista.agregar("r");
			lista.agregar("p");

			double valor = 0;
			System.out.println("Lista:" + lista);
			lista.eliminar("p");
			System.out.println("Objetivo:  " + "[r, u, e, b, a]");
			System.out.println("Resultado: " + lista);
			boolean v1 = lista.toString().equals("[r, u, e, b, a]");

			System.out.println("Lista:" + lista);
			lista.eliminar("e");
			System.out.println("Objetivo:  " + "[r, u, b, a]");
			System.out.println("Resultado: " + lista);
			boolean v2 = lista.toString().equals("[r, u, b, a]");

			System.out.println("Lista:" + lista);
			lista.eliminar("a");
			System.out.println("Objetivo:  " + "[r, u, b]");
			System.out.println("Resultado: " + lista);
			boolean v3 = lista.toString().equals("[r, u, b]");

			if (v1 && v2 && v3) {
				System.out.println("----Prueba existosa-----");
				valor = 1;
			} else {
				System.out.println("++++Prueba fallida++++");
			}
			System.out.println("***************Prueba eliminar***************");

			return valor;

		} catch (Exception e) {
			System.out.println("--------------------Error--------------------");
			System.out.println(e);
			System.out.println("--------------------Error--------------------");
			return 0;
		}
	}

	/**
	 *
	 * @return
	 */
	public static double pruebaContiene() {
		System.out.println("***************Prueba Contiene***************");
		try {
			Lista<String> lista = new Lista();
			lista.agregar("a");
			lista.agregar("b");
			lista.agregar("e");
			lista.agregar("u");
			lista.agregar("r");
			lista.agregar("p");

			double valor = 0;
			System.out.println("Lista:" + lista);
			System.out.println("Buscamos al elemento b:");
			System.out.println("Objetivo:  " + "true");
			System.out.println("Resultado: " + lista.contiene("e"));

			System.out.println("Lista:" + lista);
			System.out.println("Buscamos al elemento l:");
			System.out.println("Objetivo:  " + "false");
			System.out.println("Resultado: " + lista.contiene("l"));

			if (lista.contiene("e") && !(lista.contiene("l"))) {
				System.out.println("----Prueba existosa-----");
				valor = 1;
			} else {
				System.out.println("++++Prueba fallida++++");
			}
			System.out.println("***************Prueba Contiene***************");

			return valor;

		} catch (Exception e) {
			System.out.println("--------------------Error--------------------");
			System.out.println(e);
			System.out.println("--------------------Error--------------------");
			return 0;
		}
	}

	/**
	 *
	 * @return
	 */
	public static double pruebaConstructorCopia() {
		System.out.println("**********Prueba constructor copia **********");
		try {

			Lista<String> lista = new Lista();
			lista.agregar("a");
			lista.agregar("l");
			lista.agregar("o");
			lista.agregar("h");
			Lista<String> copia = new Lista(lista);

			String listaString = lista.toString();

			int valor = (lista.toString().equals(copia.toString())) ? 1 : 0;
			System.out.println("Objetivo:  " + lista);
			System.out.println("Resultado: " + copia);
			if (valor == 1) {
				System.out.println("----Prueba existosa-----");
			} else {
				System.out.println("++++Prueba fallida++++");
			}
			System.out.println("**********Prueba constructor copia **********");
			return valor;

		} catch (Exception e) {
			System.out.println("--------------------Error--------------------");
			System.out.println(e);
			System.out.println("--------------------Error--------------------");
			return 0;
		}
	}

	/**
	 *
	 * @return
	 */
	public static double pruebaConstructorIterable() {
		System.out.println("*********Prueba constructor Iterable*********");
		try {
			Integer[] conjunto = { 3, 2, 1, 4, 5 };
			Iterable<Integer> c = Arrays.asList(conjunto);
			Lista<Iterable<Integer>> lista = new Lista(c);
			String s = "[5, 4, 1, 2, 3]";

			int valor = (lista.toString().equals(s)) ? 1 : 0;
			System.out.println("Objetivo:  " + s);
			System.out.println("Resultado: " + lista);
			if (valor == 1) {
				System.out.println("----Prueba existosa-----");
			} else {
				System.out.println("++++Prueba fallida++++");
			}
			System.out.println("*********Prueba constructor Iterable*********");

			return valor;

		} catch (Exception e) {
			System.out.println("--------------------Error--------------------");
			System.out.println(e);
			System.out.println("--------------------Error--------------------");
			return 0;
		}
	}

	/**
	 *
	 * @return
	 */
	public static double pruebaEsVacia() {

		System.out.println("***************Prueba es Vacia***************");
		try {
			double calificacion = 0;
			Lista<String> lista = new Lista();
			boolean v1 = true;
			System.out.println("Lista Vacia: " + lista);
			System.out.println("Objetivo:    " + v1);
			System.out.println("Resultado:   " + lista.esVacia());
			calificacion += (v1 == lista.esVacia()) ? 0.5 : 0;
			lista.agregar("l");
			boolean v2 = false;
			System.out.println("Lista no vacia: " + lista);
			System.out.println("Objetivo:       " + v2);
			System.out.println("Resultado:      " + lista.esVacia());
			calificacion += (v2 == lista.esVacia()) ? 0.5 : 0;

			if (calificacion == 1.0) {
				System.out.println("----Prueba existosa-----");
			} else {
				System.out.println("++++Prueba fallida++++");
			}
			System.out.println("***************Prueba es Vacia***************");

			return calificacion;

		} catch (Exception e) {
			System.out.println("--------------------Error--------------------");
			System.out.println(e);
			System.out.println("--------------------Error--------------------");
			return 0;
		}
	}

	/**
	 *
	 * @return
	 */
	public static double pruebaVaciar() {

		System.out.println("****************Prueba vaciar****************");
		try {
			double calificacion = 0;
			Lista<String> lista = new Lista();
			lista.agregar("h");
			lista.agregar("o");
			lista.agregar("l");
			lista.agregar("a");
			System.out.println("Lista: " + lista);
			lista.vaciar();
			System.out.println("Objetivo:    " + "[]");
			System.out.println("Resultado:   " + lista);
			calificacion += (lista.getTamanio() == 0) ? 1 : 0;

			if (calificacion == 1) {
				System.out.println("----Prueba existosa-----");
			} else {
				System.out.println("++++Prueba fallida++++");
			}
			System.out.println("****************Prueba vaciar****************");

			return calificacion;

		} catch (Exception e) {
			System.out.println("--------------------Error--------------------");
			System.out.println(e);
			System.out.println("--------------------Error--------------------");
			return 0;
		}
	}

	/**
	 *
	 * @return
	 */
	public static double pruebaGetTamanio() {

		System.out.println("**************Prueba getTamanio**************");
		try {
			double calificacion = 0;
			Lista<String> lista = new Lista();
			lista.agregar("h");
			lista.agregar("o");
			lista.agregar("l");
			lista.agregar("a");
			System.out.println("Lista: " + lista);
			System.out.println("Objetivo:    " + 4);
			System.out.println("Resultado:   " + lista.getTamanio());
			calificacion += (lista.getTamanio() == 4) ? 0.5 : 0;
			lista.eliminar("l");
			System.out.println("Lista despues de eliminar a l: " + lista);
			System.out.println("Objetivo:                      " + 3);
			System.out.println("Resultado:                     " + lista.getTamanio());
			calificacion += (lista.getTamanio() == 3) ? 0.5 : 0;

			if (calificacion == 1.0) {
				System.out.println("----Prueba existosa-----");
			} else {
				System.out.println("++++Prueba fallida++++");
			}
			System.out.println("**************Prueba getTamanio**************");

			return calificacion;

		} catch (Exception e) {
			System.out.println("--------------------Error--------------------");
			System.out.println(e);
			System.out.println("--------------------Error--------------------");
			return 0;
		}
	}

	/**
	 *
	 * @return
	 */
	public static double pruebaAgregarAlFinal() {

		System.out.println("***********Prueba agregar al final***********");
		try {
			double calificacion = 0;
			Lista<String> lista = new Lista();
			lista.agregarAlFinal("h");
			lista.agregarAlFinal("o");
			lista.agregarAlFinal("l");
			lista.agregarAlFinal("a");
			System.out.println("Objetivo:    " + "[h, o, l, a]");
			System.out.println("Resultado:   " + lista);
			calificacion += (lista.toString().equals("[h, o, l, a]")) ? 1 : 0;

			if (calificacion == 1) {
				System.out.println("----Prueba existosa-----");
			} else {
				System.out.println("++++Prueba fallida++++");
			}
			System.out.println("***********Prueba agregar al final***********");

			return calificacion;

		} catch (Exception e) {
			System.out.println("--------------------Error--------------------");
			System.out.println(e);
			System.out.println("--------------------Error--------------------");
			return 0;
		}
	}

	/**
	 *
	 * @return
	 */
	public static double pruebaGetPrimero() {

		System.out.println("**************Prueba getPrimero**************");
		try {
			double calificacion = 0;
			Lista<String> lista = new Lista();
			lista.agregarAlFinal("h");
			lista.agregarAlFinal("o");
			lista.agregarAlFinal("l");
			lista.agregarAlFinal("a");
			System.out.println("Lista:       " + lista);
			System.out.println("Objetivo:    " + "h");
			System.out.println("Resultado:   " + lista.getPrimero());
			calificacion += (lista.getPrimero().equals("h")) ? 1 : 0;

			if (calificacion == 1) {
				System.out.println("----Prueba existosa-----");
			} else {
				System.out.println("++++Prueba fallida++++");
			}
			System.out.println("**************Prueba getPrimero**************");

			return calificacion;

		} catch (IllegalArgumentException | NoSuchElementException e) {
			System.out.println("--------------------Error--------------------");
			System.out.println(e);
			System.out.println("--------------------Error--------------------");
			return 0;
		}
	}

	/**
	 *
	 * @return
	 */
	public static double pruebaGetUltimo() {

		System.out.println("**************Prueba getUltimo **************");
		try {
			double calificacion = 0;
			Lista<String> lista = new Lista();
			lista.agregarAlFinal("h");
			lista.agregarAlFinal("o");
			lista.agregarAlFinal("l");
			lista.agregarAlFinal("a");
			System.out.println("Lista:       " + lista);
			System.out.println("Objetivo:    " + "a");
			System.out.println("Resultado:   " + lista.getUltimo());
			calificacion += (lista.getUltimo().equals("a")) ? 1 : 0;

			if (calificacion == 1) {
				System.out.println("----Prueba existosa-----");
			} else {
				System.out.println("++++Prueba fallida++++");
			}
			System.out.println("**************Prueba getUltimo **************");

			return calificacion;

		} catch (IllegalArgumentException | NoSuchElementException e) {
			System.out.println("--------------------Error--------------------");
			System.out.println(e);
			System.out.println("--------------------Error--------------------");
			return 0;
		}
	}

	/**
	 *
	 * @return
	 */
	public static double pruebaEliminarUltimo() {

		System.out.println("***********Prueba eliminar ultimo************");
		try {
			double calificacion = 0;
			Lista<String> lista = new Lista();
			lista.agregarAlFinal("h");
			lista.agregarAlFinal("o");
			lista.agregarAlFinal("l");
			lista.agregarAlFinal("a");
			System.out.println("Lista:       " + lista);
			lista.eliminarUltimo();
			System.out.println("Objetivo:    " + "[h, o, l]");
			System.out.println("Resultado:   " + lista);
			calificacion += (lista.toString().equals("[h, o, l]")) ? 1 : 0;

			if (calificacion == 1) {
				System.out.println("----Prueba existosa-----");
			} else {
				System.out.println("++++Prueba fallida++++");
			}
			System.out.println("***********Prueba eliminar ultimo************");

			return calificacion;

		} catch (IllegalArgumentException | NoSuchElementException e) {
			System.out.println("--------------------Error--------------------");
			System.out.println(e);
			System.out.println("--------------------Error--------------------");
			return 0;
		}
	}

	/**
	 *
	 * @return
	 */
	public static double pruebaIndiceDe() {

		System.out.println("**************Prueba indice de***************");
		try {
			double calificacion = 0;
			Lista<String> lista = new Lista();
			lista.agregarAlFinal("h");
			lista.agregarAlFinal("o");
			lista.agregarAlFinal("l");
			lista.agregarAlFinal("a");
			System.out.println("Lista:       " + lista);
			System.out.println("Indice de l:");
			System.out.println("Objetivo:    " + 2);
			System.out.println("Resultado:   " + lista.indiceDe("l"));
			calificacion += (lista.indiceDe("l") == 2) ? 1 : 0;
			System.out.println("Indice de z:");
			System.out.println("Objetivo:    " + "-1");
			System.out.println("Resultado:   " + lista.indiceDe("z"));
			calificacion += (lista.indiceDe("z") == -1) ? 0 : -1;

			if (calificacion == 1) {
				System.out.println("----Prueba existosa-----");
			} else {
				System.out.println("++++Prueba fallida++++");
			}
			System.out.println("**************Prueba indice de***************");

			return calificacion;

		} catch (IllegalArgumentException | NoSuchElementException e) {
			System.out.println("--------------------Error--------------------");
			System.out.println(e);
			System.out.println("--------------------Error--------------------");
			return 0;
		}
	}

	/**
	 *
	 * @return
	 */
	public static double pruebaGetElemento() {

		System.out.println("**************Prueba indice de***************");
		try {
			double calificacion = 0;
			Lista<String> lista = new Lista();
			lista.agregarAlFinal("h");
			lista.agregarAlFinal("o");
			lista.agregarAlFinal("l");
			lista.agregarAlFinal("a");
			System.out.println("Lista:       " + lista);
			System.out.println("Elemento con el indice 2:");
			System.out.println("Objetivo:    " + "l");
			System.out.println("Resultado:   " + lista.getElemento(2));
			calificacion += (lista.getElemento(2).equals("l")) ? 1 : 0;

			if (calificacion == 1) {
				System.out.println("----Prueba existosa-----");
			} else {
				System.out.println("++++Prueba fallida++++");
			}
			System.out.println("**************Prueba indice de***************");

			return calificacion;

		} catch (Exception e) {
			System.out.println("--------------------Error--------------------");
			System.out.println(e);
			System.out.println("--------------------Error--------------------");
			return 0;
		}
	}

	/**
	 *
	 * @return
	 */
	public static double pruebaReversa() {

		System.out.println("***************Prueba reversa****************");
		try {
			double calificacion = 0;
			Lista<String> lista = new Lista();
			lista.agregarAlFinal("h");
			lista.agregarAlFinal("o");
			lista.agregarAlFinal("l");
			lista.agregarAlFinal("a");
			System.out.println("Lista:       " + lista);
			System.out.println("Objetivo:    " + "[a, l, o, h]");
			System.out.println("Resultado:   " + lista.reversa());
			calificacion += (lista.reversa().toString().equals("[a, l, o, h]")) ? 1 : 0;

			if (calificacion == 1) {
				System.out.println("----Prueba existosa-----");
			} else {
				System.out.println("++++Prueba fallida++++");
			}
			System.out.println("***************Prueba reversa****************");

			return calificacion;

		} catch (Exception e) {
			System.out.println("--------------------Error--------------------");
			System.out.println(e);
			System.out.println("--------------------Error--------------------");
			return 0;
		}
	}

	/**
	 *
	 * @return
	 */
	public static double pruebaCopia() {

		System.out.println("****************Prueba copia*****************");
		try {
			double calificacion = 0;
			Lista<String> lista = new Lista();
			lista.agregarAlFinal("h");
			lista.agregarAlFinal("o");
			lista.agregarAlFinal("l");
			lista.agregarAlFinal("a");
			System.out.println("Lista:       " + lista);
			System.out.println("Objetivo:    " + lista);
			System.out.println("Resultado:   " + lista.copia());
			calificacion += (lista.copia().toString().equals(lista.toString())) ? 1 : 0;

			if (calificacion == 1) {
				System.out.println("----Prueba existosa-----");
			} else {
				System.out.println("++++Prueba fallida++++");
			}
			System.out.println("****************Prueba copia*****************");

			return calificacion;

		} catch (Exception e) {
			System.out.println("--------------------Error--------------------");
			System.out.println(e);
			System.out.println("--------------------Error--------------------");
			return 0;
		}
	}

	/**
	 *
	 * @return
	 */
	public static double pruebaEquals() {

		System.out.println("****************Prueba copia*****************");
		try {
			double calificacion = 0;
			Lista<String> lista1 = new Lista();
			lista1.agregarAlFinal("h");
			lista1.agregarAlFinal("o");
			lista1.agregarAlFinal("l");
			lista1.agregarAlFinal("a");

			Lista<String> lista2 = new Lista();
			lista2.agregarAlFinal("h");
			lista2.agregarAlFinal("o");
			lista2.agregarAlFinal("l");
			lista2.agregarAlFinal("a");
			System.out.println("Lista 1:       " + lista1);
			System.out.println("Lista 2:       " + lista2);
			System.out.println("Objetivo:    " + "true");
			System.out.println("Resultado:   " + lista1.equals(lista2));
			calificacion += (lista1.equals(lista2)) ? 1 : 0;
			lista2.eliminar("l");
			System.out.println("Lista 1:       " + lista1);
			System.out.println("Lista 2:       " + lista2);
			System.out.println("Objetivo:    " + "false");
			System.out.println("Resultado:   " + lista1.equals(lista2));
			calificacion += (lista1.equals(lista2)) ? 0 : 1;

			calificacion = (calificacion == 2) ? 1 : 0;

			if (calificacion == 1) {
				System.out.println("----Prueba existosa-----");
			} else {
				System.out.println("++++Prueba fallida++++");
			}
			System.out.println("****************Prueba copia*****************");
			return calificacion;

		} catch (IllegalArgumentException | NoSuchElementException e) {
			System.out.println("--------------------Error--------------------");
			System.out.println(e);
			System.out.println("--------------------Error--------------------");
			return 0;
		}
	}

	public static void main(String[] args) {

		double calificacion = 0;
		calificacion += pruebaAgregar();
		calificacion += pruebaConstructorCopia();
		calificacion += pruebaConstructorIterable();
		calificacion += pruebaEsVacia();
		calificacion += pruebaVaciar();
		calificacion += pruebaGetTamanio();
		calificacion += pruebaEliminar();
		calificacion += pruebaContiene();
		calificacion += pruebaAgregarAlFinal();
		calificacion += pruebaGetPrimero();
		calificacion += pruebaGetUltimo();
		calificacion += pruebaEliminarUltimo();
		calificacion += pruebaIndiceDe();
		calificacion += pruebaGetElemento();
		calificacion += pruebaReversa();
		calificacion += pruebaCopia();
		calificacion += pruebaEquals();

		System.out.println("Pruebas pasadas: " + calificacion + " de 17");

		// Integer[] conjunto = { 3, 2, 1, 4, 5 };
		// Lista d = new Lista();
		// for (Integer a : conjunto) {
		// d.agregarAlFinal(a);
		// }

		// d.agregarAlFinal(null);

		// System.out.println(d);

		/*
		 * System.out.println("--------------Creando Lista vacia----------------");
		 * Lista a = new Lista(); System.out.println(a.cabeza);
		 * System.out.println(a.cola); System.out.println(a.esVacia()); a.vaciar();
		 * System.out.println(a.getTamanio());
		 * 
		 * System.out.
		 * println("--------------Agrega elem cuando es vacia----------------");
		 * a.agregar(1); System.out.println(a.cabeza); System.out.println(a.cola);
		 * System.out.println(a.esVacia());
		 * 
		 * System.out.
		 * println("--------------Agrega elem cuando no es vacia----------------");
		 * a.agregar(33); a.agregar(45); System.out.println(a);
		 * 
		 * System.out.
		 * println("-------------- B Agrega elem al final cuando es vacia----------------"
		 * ); Lista b = new Lista(); b.agregarAlFinal(5); System.out.println(b);
		 * 
		 * System.out.
		 * println("-------------- B Agrega elem al final cuando no es vacia----------------"
		 * ); b.agregarAlFinal(8); b.agregarAlFinal(10); System.out.println(b);
		 * 
		 * System.out.
		 * println("--------------Obtenemos el primer elemento de la lista----------------"
		 * ); Lista d = new Lista(); // Esto da excepcion cuando intentamos obtener
		 * elementos de una lista vacia // System.out.println(d.getPrimero()); //
		 * System.out.println(d.getUltimo());
		 * 
		 * Integer c = (Integer) a.getPrimero(); System.out.println(c); c = (Integer)
		 * b.getPrimero(); System.out.println(c);
		 * 
		 * System.out.
		 * println("--------------Obtenemos el ULTIMO elemento de la lista----------------"
		 * ); c = (Integer) a.getUltimo(); System.out.println(c); c = (Integer)
		 * b.getUltimo(); System.out.println(c);
		 * 
		 * System.out.println("--------------Verificacion de la lista ----------------"
		 * ); System.out.println(a); System.out.println(a.cabeza);
		 * System.out.println(a.cola); System.out.println(a.esVacia());
		 * System.out.println("Longitud de la lista a: " + a.getTamanio());
		 * System.out.println("................Vaciando a....."); a.vaciar();
		 * System.out.println(a); System.out.println(a.cabeza);
		 * System.out.println(a.cola); System.out.println(a.esVacia());
		 * System.out.println("Longitud de la lista a: " + a.getTamanio());
		 * System.out.println("................AGREGANDO a......"); a.agregar(3);
		 * System.out.println(a); System.out.println(a.cabeza);
		 * System.out.println(a.cola); System.out.println(a.esVacia());
		 * System.out.println("Longitud de la lista a: " + a.getTamanio());
		 * 
		 * System.out.println("--------------Contiene de listas----------------");
		 * System.out.println(a + " Contiene " + 3 + "? " + a.contiene(3));
		 * System.out.println(a + " Contiene " + 5 + "? " + a.contiene(5));
		 * System.out.println(a + " Contiene " + 1 + "? " + a.contiene(1));
		 * 
		 * System.out.println(b + " Contiene " + 3 + "? " + b.contiene(3));
		 * System.out.println(b + " Contiene " + 5 + "? " + b.contiene(5));
		 * System.out.println(b + " Contiene " + 1 + "? " + b.contiene(1));
		 * 
		 * System.out.println(d + " Contiene " + 3 + "? " + d.contiene(3));
		 * 
		 * System.out.println("--------------Elimina de listas----------------");
		 * d.agregar(1); d.agregar(2); d.agregar(3); d.agregar(4); d.agregar(5);
		 * d.agregar(7); System.out.println("Esta es la lista d: " + d); d.eliminar(1);
		 * d.eliminar(5); d.eliminar(7); d.eliminar(2);
		 * System.out.println("Esta es la lista d: " + d);
		 * 
		 * System.out.println(
		 * "+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++--------------Indice en listas----------------"
		 * );
		 * 
		 * List test = new Lista(); System.out.println(d);
		 * System.out.println("Indice de 2 en a es: " + d.indiceDe(4));
		 * System.out.println("Indice de 1 en a es: " + d.indiceDe(1));
		 * System.out.println("Indice de 5 en a es: " + d.indiceDe(3));
		 * 
		 * System.out.println(
		 * "++++++++++++++++++++++++++++++++++++++++++++++++++++++--------------regresa elem en index----------------"
		 * ); System.out.println(d); System.out.println("elem en index 0 es: " +
		 * d.getElemento(0)); System.out.println("elem en index 1 es: " +
		 * d.getElemento(1)); System.out.println("elem en index 2 es: " +
		 * d.getElemento(2));
		 * 
		 * System.out.println("--------------Copia una lista en reversa----------------"
		 * ); Lista m = new Lista(); System.out.println("Lista a: " + a);
		 * System.out.println("Lista b: " + b); System.out.println("Lista m: " + m);
		 * System.out.println("Lista d: " + d); b = m.reversa(); m = d.reversa();
		 * System.out.println("Lista b: " + b); System.out.println("Lista m: " + m);
		 * 
		 * System.out.println("--------------Copia una lista----------------"); Lista t
		 * = new Lista(); System.out.println("Lista b: " + b);
		 * System.out.println("Lista m: " + m); System.out.println("Lista t: " + t); t =
		 * b.copia(); b = m.copia(); System.out.println("Lista b: " + b);
		 * System.out.println("Lista t: " + t);
		 * 
		 * System.out.println("--------------EQUALS----------------");
		 * System.out.println("Lista a: " + a); System.out.println("Lista b: " + b);
		 * System.out.println("Lista d: " + d); System.out.println("Lista m: " + m);
		 * System.out.println("Lista t: " + t);
		 * 
		 * System.out.println("_____COmparamos a con todas_____"); Lista dummy =
		 * a.copia(); System.out.println("a y a " + a.equals(a));
		 * System.out.println("a y b " + a.equals(b)); System.out.println("a y d " +
		 * a.equals(d)); System.out.println("a y m " + a.equals(m));
		 * System.out.println("a y t " + a.equals(t)); System.out.println("a y dummy " +
		 * a.equals(dummy));
		 */

	}
}
