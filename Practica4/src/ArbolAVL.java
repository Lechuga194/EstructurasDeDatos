/**
 * <p>
 * Clase para árboles AVL.
 * </p>
 *
 * <p>
 * Un árbol AVL cumple que para cada uno de sus nodos, la diferencia entre la
 * áltura de sus subárboles izquierdo y derecho está entre -1 y 1.
 * </p>
 *
 * @param <T>
 */
public class ArbolAVL<T extends Comparable<T>> extends ArbolBinarioBusqueda<T> {

    /**
     * Clase interna protegida para nodos de árboles AVL. La única diferencia con
     * los nodos de árbol binario, es que tienen una variable de clase para la
     * altura del nodo.
     */
    protected class NodoAVL extends ArbolBinario.Nodo {

        /**
         * La altura del nodo.
         */
        protected int altura;

        /**
         * Constructor único que recibe un elemento.
         *
         * @param elemento el elemento del nodo.
         */
        public NodoAVL(T elemento) {
            // Aquí va su código.
            super(elemento);
            this.altura = 0;
        }

        /**
         * Recomendamos usar este método auxiliar para que en el método público hagas el
         * cast del objeto o, a NodoAVL y dejar el trabajo a este método. Si no quieres
         * usarlo, siéntete libre de eliminar esta firma.
         */
        private boolean equals(NodoAVL v, NodoAVL v2) {

            if (v.hayIzquierdo())
                return equalsAux(nodoAVL(v.izquierdo), nodoAVL(v2.izquierdo));

            if (v.hayDerecho())
                return equalsAux(nodoAVL(v.derecho), nodoAVL(v2.derecho));

            return v.elemento == v2.elemento;
        }

        /**
         * Compara el nodo con otro objeto. La comparación es <em>recursiva</em>.
         *
         * @param o el objeto con el cual se comparará el nodo.
         * @return <code>true</code> si el objeto es instancia de la clase
         *         {@link NodoAVL}, su elemento es igual al elemento de éste nodo, los
         *         descendientes de ambos son recursivamente iguales, y las alturas son
         *         iguales; <code>false</code> en otro caso.
         */
        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            @SuppressWarnings("unchecked")
            NodoAVL nodo = (NodoAVL) o;
            if (this.altura != nodo.altura)
                return false;
            return equals(this, nodo);
        }

        @Override
        public String toString() {
            String s = super.toString();
            return s += " [alt => " + altura + "]";
        }
    }

    public ArbolAVL() {

    }

    public ArbolAVL(Coleccionable<T> coleccion) {
        super(coleccion);
    }

    private void actualizaAltura(NodoAVL v) {
        if (v == null)
            return;
        int izquierdo = v.hayIzquierdo() ? nodoAVL(v.izquierdo).altura : 0;
        int derecho = v.hayDerecho() ? nodoAVL(v.derecho).altura : 0;
        v.altura = Math.max(izquierdo, derecho) + 1;

    }

    private void rebalancea(NodoAVL nodo) {
        if (nodo == null)
            return;

        NodoAVL izq = nodoAVL(nodo.izquierdo);
        NodoAVL der = nodoAVL(nodo.derecho);
        int balance = getAltura(izq) - getAltura(der);

        if (balance == 2) {
            if (getAltura(nodoAVL(izq.izquierdo)) - getAltura(nodoAVL(izq.derecho)) == -1) {
                System.out.println("*");
                rotacionIzquierda(izq);
                actualizaAltura(izq);
            }
            System.out.println("*");
            rotacionDerecha(nodo);
        }

        if (balance == -2) {
            if (getAltura(nodoAVL(der.izquierdo)) - getAltura(nodoAVL(der.derecho)) == 1) {
                System.out.println("*");
                rotacionDerecha(der);
                actualizaAltura(der);
            }
            System.out.println("*");
            rotacionIzquierda(nodo);
        }

        actualizaAltura(nodo);
        rebalancea(nodoAVL(nodo.padre));

    }

    /**
     * Agrega un nuevo elemento al árbol. El método invoca al método
     * {@link ArbolBinarioBusqueda#agrega}, y después balancea el árbol girándolo
     * como sea necesario. La complejidad en tiempo del método es <i>O</i>(log
     * <i>n</i>) garantizado.
     *
     * @param elemento el elemento a agregar.
     */
    @Override
    public void agregar(T elemento) {
        NodoAVL nodo = new NodoAVL(elemento);
        agregaNodo(raiz, nodo);
        rebalancea((NodoAVL) nodo);
    }

    /**
     * Elimina un elemento del árbol. El método elimina el nodo que contiene el
     * elemento, y gira el árbol como sea necesario para rebalancearlo. La
     * complejidad en tiempo del método es <i>O</i>(log <i>n</i>) garantizado.
     *
     * @param elemento el elemento a eliminar del árbol.
     */
    @Override
    public void eliminar(T elemento) {
        NodoAVL nodo = nodoAVL(buscaNodo(raiz, elemento));
        nodo = (NodoAVL) eliminaNodo(nodo);
        rebalancea(nodo);
    }

    private int getAltura(Nodo nodo) {
        if (nodo == null)
            return 0;
        NodoAVL n = (NodoAVL) nodo;
        return n.altura;
    }

    /**
     * Convierte el nodo (visto como instancia de {@link Nodo}) en nodo (visto como
     * instancia de {@link NodoAVL}). Método auxililar para hacer este cast en un
     * único lugar.
     *
     * @param nodo el nodo de árbol binario que queremos como nodo AVL.
     * @return el nodo recibido visto como nodo AVL.
     */
    protected NodoAVL nodoAVL(Nodo nodo) {
        return (NodoAVL) nodo;
    }
}
