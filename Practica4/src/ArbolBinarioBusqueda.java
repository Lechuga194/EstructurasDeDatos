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
            if (raiz == null)
                throw new IllegalArgumentException("La raiz es nula!");
            pila = new Pila<>();
            pila.push(raiz);
            while (pila.top().izquierdo != null) {
                pila.push(pila.top().izquierdo);
            }
        }

        /* Nos dice si hay un elemento siguiente. */
        @Override
        public boolean hasNext() {
            return !pila.esVacia();
        }

        /* Regresa el siguiente elemento en orden DFS in-order. */
        @Override
        public T next() {
            Nodo topePila = pila.pop();
            if (topePila.derecho != null) {
                pila.push(topePila.derecho);
                while (pila.top().izquierdo != null) {
                    pila.push(pila.top().izquierdo);
                }
            }
            return topePila.elemento;
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
    protected void agregaNodo(Nodo n, Nodo nuevo) throws IllegalArgumentException {

        if (nuevo.elemento == null)
            throw new IllegalArgumentException("No puedes insertar nulos!");
        if (this.esVacia()) {
            this.raiz = nuevo;
            this.tamanio++;
            return;
        }
        if (nuevo.elemento.compareTo(n.elemento) < 0) {
            if (n.hayIzquierdo())
                agregaNodo(n.izquierdo, nuevo);
            else {
                nuevo.padre = n;
                n.izquierdo = nuevo;
                this.tamanio++;
            }
        }

        if (nuevo.elemento.compareTo(n.elemento) >= 0) {
            if (n.hayDerecho())
                agregaNodo(n.derecho, nuevo);
            else {
                nuevo.padre = n;
                n.derecho = nuevo;
                this.tamanio++;
            }
        }

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

        // Caso para Hojas
        if (!n.hayIzquierdo() && !n.hayDerecho()) {
            // Caso para arboles de un solo elemento
            if (n == raiz)
                this.vaciar();
            else {
                if (this.esHijoIzquierdo(n))
                    n.padre.izquierdo = null;
                else
                    n.padre.derecho = null;
                n.padre = null;
            }
            this.tamanio--;
            return n;
        }

        // Caso para cuando el nodo n no tiene hijo izquierdo
        if (!n.hayIzquierdo()) {
            if (n != raiz) {
                if (this.esHijoIzquierdo(n))
                    n.padre.izquierdo = n.derecho; // Sabemos que hay derecho por que no es hoja y no hay izquierdo
                if (this.esHijoDerecho(n))
                    n.padre.derecho = n.derecho;
            } else {
                raiz = n.derecho;
            }
            n.derecho.padre = n.padre;
            this.tamanio--;
            return n;
        }

        // Caso para cuando el nodo si tiene hijo izquierdo
        if (n.hayIzquierdo()) {

            // Obtenemos el mayor en el subarbol izquierdo
            Nodo maxIzq = maximoEnSubarbolIzquierdo(n);
            n.elemento = maxIzq.elemento;

            if (maxIzq.hayIzquierdo()) {
                Nodo izqDelMaximo = maxIzq.izquierdo;
                izqDelMaximo.padre = maxIzq.padre;
                maxIzq.padre.derecho = izqDelMaximo;
                maxIzq.izquierdo = null;
            } else {

                if (!maxIzq.padre.hayIzquierdo()) {
                    maxIzq.padre.izquierdo = null;
                    maxIzq.padre.derecho = null;
                }

                if (this.esHijoDerecho(maxIzq))
                    maxIzq.padre.derecho = null;

                if (this.esHijoIzquierdo(maxIzq))
                    maxIzq.padre.izquierdo = null;

            }

            this.tamanio--;
            return n;
        }
        return n;
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
     * Método que encuentra el elemento máximo en el subárbol izquierdo En caso de
     * que no exista subarbol izquierdo regresa null
     **/
    private Nodo maximoEnSubarbolIzquierdo(Nodo n) {
        if (!n.hayIzquierdo())
            return null;

        Nodo maximo = n.izquierdo;
        while (maximo.hayDerecho())
            maximo = maximo.derecho;
        return maximo;
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

        if (n == null || elemento == null)
            return null;

        if (elemento.equals(n.elemento))
            return n;

        if (elemento.compareTo(n.elemento) < 0)
            return buscaNodo(n.izquierdo, elemento);

        return buscaNodo(n.derecho, elemento);

    }

    /**
     * Rota el árbol a la derecha sobre el nodo recibido. Si el nodo no tiene hijo
     * izquierdo, el método no hace nada.
     *
     * @param nodo el nodo sobre el que vamos a rotar.
     */
    protected void rotacionDerecha(Nodo nodo) {

        if (nodo == null || !nodo.hayIzquierdo())
            return;

        Nodo padre = nodo.padre;
        Nodo p = nodo.izquierdo;
        Nodo beta = (p.hayDerecho()) ? p.derecho : null;

        if (nodo == raiz) {
            nodo.padre = p;
            raiz = p;
        }

        if (esHijoDerecho(nodo))
            padre.derecho = p;

        if (esHijoIzquierdo(nodo))
            padre.izquierdo = p;

        if (nodo != raiz)
            nodo.padre = p;

        p.derecho = nodo;
        p.padre = padre;
        if (beta != null) {
            beta.padre = nodo;
            nodo.izquierdo = beta;
        } else
            nodo.izquierdo = null;
    }

    /**
     * Rota el árbol a la izquierda sobre el nodo recibido. Si el nodo no tiene hijo
     * derecho, el método no hace nada.
     *
     * @param nodo el nodo sobre el que vamos a rotar.
     */
    protected void rotacionIzquierda(Nodo nodo) {
        if (nodo == null || !nodo.hayDerecho())
            return;

        Nodo padre = nodo.padre;
        Nodo p = nodo.derecho;
        Nodo beta = (p.hayIzquierdo()) ? p.izquierdo : null;

        if (nodo == raiz) {
            nodo.padre = p;
            raiz = p;
        }

        if (esHijoDerecho(nodo))
            padre.derecho = p;

        if (esHijoIzquierdo(nodo))
            padre.izquierdo = p;

        if (nodo != raiz)
            nodo.padre = p;

        p.izquierdo = nodo;
        p.padre = padre;
        if (beta != null) {
            beta.padre = nodo;
            nodo.derecho = beta;
        } else
            nodo.derecho = null;

    }

    public void pruebaRotacionIzquierda(T elemento) {
        Nodo nodo = this.buscaNodo(raiz, elemento);
        this.rotacionIzquierda(nodo);
    }

    public void pruebaRotacionDerecha(T elemento) {
        Nodo nodo = this.buscaNodo(raiz, elemento);
        this.rotacionDerecha(nodo);
    }

    /**
     * Metodo para saber si un nodo es hijo derecho de su padre
     * 
     * @param nodo el nodo a comprobar
     * @return si es hijo derecho true, false en otro caso
     */
    private boolean esHijoDerecho(Nodo nodo) {
        if (nodo == raiz || nodo == null || nodo.padre.derecho == null)
            return false;
        return nodo.padre.derecho == nodo;
    }

    /**
     * Metodo para saber si un nodo es hijo izquierdo de su padre
     * 
     * @param nodo el nodo a comprobar
     * @return si es hijo derecho true, false en otro caso
     */
    private boolean esHijoIzquierdo(Nodo nodo) {
        if (nodo == raiz || nodo == null || nodo.padre.izquierdo == null)
            return false;
        return nodo.padre.izquierdo == nodo;
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
