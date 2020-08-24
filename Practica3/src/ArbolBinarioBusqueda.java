import java.util.Iterator;

/**
 * <p>
 * Clase para modelar árboles binarios de búsqueda genéricos.
 * </p>
 *
 * <p>
 * Un árbol instancia de esta clase siempre cumple que:
 * </p>
 * <ul>
 * <li>Cualquier elemento en el árbol es mayor o igual que todos sus
 * descendientes por la izquierda.</li>
 * <li>Cualquier elemento en el árbol es menor o igual que todos sus
 * descendientes por la derecha.</li>
 * </ul>
 *
 * @param <T>
 */
public class ArbolBinarioBusqueda<T extends Comparable<T>> extends ArbolBinario<T> {

    /* Clase privada para iteradores de árboles binarios ordenados. */
    private class Iterador implements Iterator<T> {

        /* Pila para recorrer los nodos por profundidad (DFS). */
        private Pila<Nodo> pila;

        /* Construye un iterador con el nodo recibido. */
        public Iterador() {
            // TODO

        }

        /* Nos dice si hay un elemento siguiente. */
        @Override
        public boolean hasNext() {
            // Aquí va su código.
            return false;
        }

        /* Regresa el siguiente elemento en orden DFS in-order. */
        @Override
        public T next() {
            // Aquí va tu código
            return null;
        }
    }

    /**
     * Constructor que no recibe parámeteros. {@link ArbolBinario}.
     */
    public ArbolBinarioBusqueda() {

    }

    /**
     * Construye un árbol binario ordenado a partir de una colección. El árbol
     * binario ordenado tiene los mismos elementos que la colección recibida.
     *
     * @param coleccion la colección a partir de la cual creamos el árbol binario
     *                  ordenado.
     */
    public ArbolBinarioBusqueda(Coleccionable<T> coleccion) {
        super(coleccion);
    }

    /**
     * Método recursivo auxiliar que agrega un elemento contenido en el nodo nuevo.
     * Comienza las comparaciones desde el nodo n.
     *
     **/
    protected void agregaNodo(Nodo n, Nodo nuevo) {
        if (this.esVacia())
            this.raiz = nuevo;

        if (nuevo.elemento.compareTo(this.raiz.elemento) < 0) {
            // if (n.hayIzquierdo()) {
            // agregaNodo(n.izquierdo, nuevo);
            // n.izquierdo = nuevo;
            // }
            this.raiz.izquierdo = nuevo;
        }

        if (nuevo.elemento.compareTo(this.raiz.elemento) >= 0) {
            // if (n.hayIzquierdo()) {
            // agregaNodo(n.izquierdo, nuevo);
            // n.izquierdo = nuevo;
            // }
            this.raiz.derecho = nuevo;
        }

        this.tamanio++;
    }

    /**
     * Agrega un nuevo elemento al árbol. El árbol conserva su orden in-order.
     *
     * @param elemento el elemento a agregar.
     */
    @Override
    public void agregar(T elemento) {
        Nodo nuevo = nuevoNodo(elemento);
        agregaNodo(raiz, nuevo);
    }

    /**
     * Método auxiliar que elimina el nodo n. Notemos que en este punto ya tenemos
     * una referencia al nodo que queremos eliminar.
     **/
    protected Nodo eliminaNodo(Nodo n) {
        // Aquí va tu código
        return null;
    }

    /**
     * Elimina un elemento. Si el elemento no está en el árbol, no hace nada; si
     * está varias veces, elimina el primero que encuentre (in-order). El árbol
     * conserva su orden in-order.
     *
     * @param elemento el elemento a eliminar.
     */
    @Override
    public void eliminar(T elemento) {
        Nodo n = buscaNodo(raiz, elemento);
        eliminaNodo(n);
    }

    /**
     * Método que encuentra el elemento máximo en el subárbol izquierdo
     **/
    private Nodo maximoEnSubarbolIzquierdo(Nodo n) {
        // Aquí va tu código
        return null;
    }

    /**
     * Nos dice si un elemento está contenido en el arbol.
     *
     * @param elemento el elemento que queremos verificar si está contenido en la
     *                 arbol.
     * @return <code>true</code> si el elemento está contenido en el arbol,
     *         <code>false</code> en otro caso.
     */
    @Override
    public boolean contiene(T elemento) {
        return buscaNodo(raiz, elemento) != null;
    }

    /**
     * Método que busca un a elemento en el árbol desde el nodo n
     **/
    protected Nodo buscaNodo(Nodo n, T elemento) {
        // Aquí va tu código
        return null;
    }

    /**
     * Rota el árbol a la derecha sobre el nodo recibido. Si el nodo no tiene hijo
     * izquierdo, el método no hace nada.
     *
     * @param nodo el nodo sobre el que vamos a rotar.
     */
    protected void rotacionDerecha(Nodo nodo) {
        // Aquí va tu código
    }

    /**
     * Rota el árbol a la izquierda sobre el nodo recibido. Si el nodo no tiene hijo
     * derecho, el método no hace nada.
     *
     * @param nodo el nodo sobre el que vamos a rotar.
     */
    protected void rotacionIzquierda(Nodo nodo) {
        // Aquí va tu código
    }

    /**
     * Regresa un iterador para iterar el árbol. El árbol se itera en orden.
     *
     * @return un iterador para iterar el árbol.
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterador();
    }

}
