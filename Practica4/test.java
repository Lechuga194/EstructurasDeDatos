public class PruebaArbolOrdenado {

	public static void main(String[] args) throws Exception {
		System.out.println("------------------Creacion--------------------");
		ArbolBinarioBusqueda<Integer> a = new ArbolBinarioBusqueda<>();
		ArbolBinarioBusqueda<Integer> b = new ArbolBinarioBusqueda<>();
		ArbolBinarioBusqueda<Integer> c = new ArbolBinarioBusqueda<>();
		ArbolBinarioBusqueda<Integer> d = new ArbolBinarioBusqueda<>();
		ArbolBinarioBusqueda<Integer> e = new ArbolBinarioBusqueda<>();

		System.out.println("------------------Agrega y elimina--------------------");
		a.agregar(5);
		a.agregar(2);
		a.agregar(8);
		a.agregar(1);
		a.agregar(3);
		a.agregar(10);
		a.agregar(7);
		a.agregar(20);
		a.agregar(9);
		a.agregar(4);
		// a.agregar(null);

		System.out.println(a);

		System.out.println("------------------Recorridos--------------------");

		Lista<Integer> inOrden = a.inOrden();
		System.out.println("inOrder: " + inOrden);

		Lista<Integer> preOrden = a.preOrden();
		System.out.println("preOrder: " + preOrden);

		Lista<Integer> postOrden = a.postOrden();
		System.out.println("postOrder: " + postOrden);

		System.out.println("------------------Busqueda Contiene--------------------");

		System.out.println("Contiene 2?: " + a.contiene(2));
		System.out.println("Contiene 6?: " + a.contiene(6));
		System.out.println("Contiene 10?: " + a.contiene(10));
		System.out.println("Contiene 2?: " + a.contiene(null));

		b.agregar(5);
		b.agregar(2);
		b.agregar(8);
		b.agregar(1);
		b.agregar(3);
		b.agregar(10);
		b.agregar(7);

		System.out.println(b.buscaNodo(b.raiz, 7));
		b.eliminar(7);
		System.out.println("Contiene 7?: " + b.contiene(7));

		System.out.println("------------------Giros--------------------");

		System.out.println("Arbol c original");
		c.agregar(10);
		c.agregar(5);
		c.agregar(1);
		c.agregar(7);
		c.agregar(11);
		System.out.println(c);

		System.out.println("**** GIROS ****");
		c.rotacionDerecha(c.buscaNodo(c.raiz, 10));
		c.rotacionIzquierda(c.buscaNodo(c.raiz, 5));
		System.out.println(c);

		System.out.println("------------------EQUALS--------------------");
		System.out.println("El arbol a es igual al b? " + a.equals(b));
		System.out.println("El arbol a es igual al a? " + a.equals(a));

		System.out.println("------------------Eliminar--------------------");

	}

}

// /**
// * Rota el árbol a la derecha sobre el nodo recibido. Si el nodo no tiene hijo
// * izquierdo, el método no hace nada.
// *
// * @param nodo el nodo sobre el que vamos a rotar.
// */
// protected void rotacionDerecha(Nodo nodo) {

// if (!nodo.hayIzquierdo())
// return;

// Nodo padre = nodo.padre; // q.padre
// Nodo p = nodo.izquierdo; // q.izquierdo
// Nodo beta = (p.hayDerecho()) ? p.derecho : null;

// if (nodo.equals(this.raiz)) {
// nodo.padre = p;
// raiz = p;
// }

// if (padre == null)
// raiz = p;
// else {
// if (esHijoDerecho(nodo))
// padre.derecho = p;
// if (esHijoIzquierdo(nodo))
// padre.izquierdo = p;
// }
// p.padre = padre;
// p.derecho = nodo;
// nodo.padre = p;
// if (beta != null) {
// beta.padre = nodo;
// nodo.izquierdo = beta;
// }
// }