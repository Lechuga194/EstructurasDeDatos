import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * <p> Clase concreta para modelar la estructura de datos Lista</p>
 * <p>Esta clase implementa una Lista genérica, es decir que es homogénea pero
 * puede tener elementos de cualquier tipo.
 * @author Luis Manuel Martinez Damaso <luismanuel@ciencias.unam.mx>
 * @version 1.0
 * @param <T>
 */
public class Lista<T> implements Listable<T>{

    /* Clase interna para construir la estructura */
    protected class Nodo{
        /* Referencias a los nodos anterior y siguiente */
        public Nodo anterior, siguiente;
        /* El elemento que almacena un nodo */
        public T elemento;

        /* Unico constructor de la clase */
        public Nodo(T elemento){
	    //Aquí va tu código.
            //Inicializamos los elementos del nodo
            this.elemento = elemento;
            this.anterior = null;
            this.siguiente = null;
        }
        public boolean equals(Nodo n){
            //Aquí va tu código.
            //Comparamos los elementos 
            return n.elemento == this.elemento;
        }
    }

    
    private class IteradorLista implements Iterator<T>{
        /* La lista a recorrer*/
        /* Elementos del centinela que recorre la lista*/
        private Lista<T>.Nodo siguiente;

        public IteradorLista(){
            //El iterador va a iniciar en la cabeza
            this.siguiente = cabeza;
        }

        @Override
        public boolean hasNext() {
            return siguiente != null;
        }

        @Override
        public T next() {
            T elemento = siguiente.elemento; //Guardamos el elemento
            siguiente = siguiente.siguiente; //Avanzamos el nodo
            return elemento;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    
    /* Atributos de la lista */
    protected Nodo cabeza, cola;
    protected int longitud;

    /**
     *  Constructor por omisión de la clase, no recibe parámetros.
     *  Crea una nueva lista con longitud 0.
     **/
    public Lista(){
        this.cabeza = this.cola = null;
        this.longitud = 0;
    }

    /**
     *  Constructor copia de la clase. Recibe una lista con elementos.
     *  Crea una nueva lista exactamente igual a la que recibimos como parámetro.
     * @param l
     **/
    public Lista(Lista<T> l){
        IteradorLista iterador = (IteradorLista)l.iterator();
        while(iterador.hasNext()){
            this.agregarAlFinal(iterador.next());
        }
    }

    /**
     *  Constructor de la clase que recibe parámetros.
     *  Crea una nueva lista con los elementos de la estructura iterable que recibe como parámetro.
     * @param iterable
     **/
    public Lista(Iterable<T> iterable){
        //Aquí va tu código.
    }
    
    /**
     * Método que nos dice si las lista está vacía.
     * @return <code>true</code> si el conjunto está vacío, <code>false</code>
     * en otro caso.
     */
    @Override
    public boolean esVacia(){
        return this.longitud == 0;
    }
    
    /**
     * Método para eliminar todos los elementos de una lista
     */
    @Override
    public void vaciar(){
        this.cabeza = this.cola = null;
        this.longitud = 0;
        System.out.println("Todos los elementos de la lista se han eliminado");
    }
    
    /**
     * Método para obtener el tamaño de la lista
     * @return tamanio Número de elementos de la lista.
     **/
    @Override
    public int getTamanio(){
        return this.longitud;
    }
    
    /**
     * Método para agregar un elemento a la lista.
     * @param elemento Objeto que se agregará a la lista.
     */
    @Override
    public void agregar(T elemento){
        Nodo nuevoNodo = new Nodo(elemento); //Creamos el nodo con el elemento

        //Si la lista es vacia la cabeza y cola son el nuevo nodo
        if(this.esVacia()){
            this.cabeza = this.cola = nuevoNodo;
        }else{
            //Por defecto agregamos al inicio de la lista
            this.cabeza.anterior = nuevoNodo;
            nuevoNodo.siguiente = this.cabeza;
            this.cabeza = nuevoNodo;
        }
        this.longitud++;
    }
    
    /**
     * Método para agregar al final un elemento a la lista.
     * @param elemento Objeto que se agregará al inicio de la lista.
     */
    public void agregarAlFinal(T elemento) throws IllegalArgumentException {
        
        /* Si queremos agregar al final y la lista es vacia, entonces 
        llamamos  al metodo agrega ya que tiene el mismo comportamiento*/ 
        if(this.esVacia()){
            this.agregar(elemento);
        }else{
            Nodo nuevoNodo = new Nodo(elemento); //Creamos el nodo con el elemento
            this.cola.siguiente = nuevoNodo;
            nuevoNodo.anterior = this.cola;
            this.cola = nuevoNodo;
            longitud++;
        }
    }

    /**
     * Método para obtener el primer elemento.
     */
    @Override
    public T getPrimero() throws NoSuchElementException { //-----------------PREGUNTAR QUE PASA SI ES VACIA
        // if(this.esVacia()){
        //     return null;
        // }
        return this.cabeza.elemento;
    }

    /**
     * Método para obtener el último elemento.
     */
    public T getUltimo() throws NoSuchElementException { //-----------------PREGUNTAR QUE PASA SI ES VACIA
        // if(this.esVacia()){
        //     return null;
        // }
        return this.cola.elemento;
    }

    /**
     * Método auxiliar para obtener una referencia a un nodo con un elemento
     * @param elem Objeto que se va a buscar en la lista.
     * @return Nodo que contiene al elemento (primer aparicion) o null si no existe
     */
    private Nodo getNodo(T elem) throws NoSuchElementException {
        IteradorLista iterador = new IteradorLista();
        Nodo nodoElemento;
        while(iterador.hasNext()){
            /*Dado que next() guarda el elemento y luego cambia de nodo
            asignamos a nodoElemento antes de cambiar de nodo */
            nodoElemento = iterador.siguiente;
            if(iterador.next() == elem){
                return nodoElemento;
            }
        }
        return null;
    }
    
    /**
     * Método para verificar si un elemento pertenece a la lista.
     * @param elemento Objeto que se va a buscar en la lista.
     * @return <code>true</code> si el elemento esta en el lista y false en otro caso.
     */
    @Override
    public boolean contiene(T elemento) throws NoSuchElementException {
            return this.getNodo(elemento) != null;
    }

    /**
     * Método para eliminar un elemento de la lista.
     * @param elemento Objeto que se eliminara de la lista.
     * todo
     */
    @Override
    public void eliminar(T elemento) throws NoSuchElementException {
        Nodo nodoElem = this.getNodo(elemento);

        if(nodoElem == null)
            return;
        
        if(nodoElem == this.cabeza){
            this.eliminarPrimero();
            return;
        }

        if(nodoElem == this.cola){
            this.eliminarUltimo();
            return;
        }

        nodoElem.anterior.siguiente = nodoElem.siguiente;
        nodoElem.siguiente.anterior = nodoElem.anterior;
        longitud--;
    }

    /**
     * Método para eliminar el primer elemento de la lista.
     */
    @Override
    public void eliminarPrimero() throws NoSuchElementException { //-----------------PREGUNTAR QUE PASA SI ES VACIA
        // if(this.esVacia()){
        //     return;
        // }
        this.cabeza = this.cabeza.siguiente;
        this.cabeza.anterior = null;
        longitud--;
    }

    /**
     * Método para eliminar el primer elemento de la lista.
     */
    public void eliminarUltimo() throws NoSuchElementException { //-----------------PREGUNTAR QUE PASA SI ES VACIA
        // if(this.esVacia()){
        //     return;
        // }
        this.cola = this.cola.anterior;
        this.cola.siguiente = null;
        longitud--;
    }

    /**
     * Método que devuelve la posición en la lista que tiene la primera
     * aparición del <code> elemento</code>.
     * @param elemento El elemento del cuál queremos saber su posición.
     * @return i la posición del elemento en la lista, -1, si no se encuentra en ésta.
     */
    @Override
    public int indiceDe(T elemento) throws NoSuchElementException {
        IteradorLista iterador = new IteradorLista();
        int i = 0;
        while(iterador.hasNext()){
            if(iterador.next() == elemento)
                return i;
            i++;
        }
        return -1;
    }

    /**
     * Método que nos devuelve el elemento que esta en la posición i
     * @param i La posición cuyo elemento deseamos conocer.
     * @return <code> elemento </code> El elemento que contiene la lista,
     * <code>null</code> si no se encuentra
     * @throws IndexOutOfBoundsException Si el índice es < 0 o >longitud()
     */
    @Override
    public T getElemento(int i)throws IndexOutOfBoundsException{
        T elemento = null;
        IteradorLista iterador = new IteradorLista();
        for(int j = 0; j<=i; j++){
            if(iterador.hasNext()){
                elemento = iterador.next();
                if (j == i)
                    return elemento;
            }
        }
        return elemento;
    }

    /**
     * Método que devuelve una copia de la lista, pero en orden inverso
     * @return Una copia con la lista l revés.
     */
    @Override
    public Lista<T> reversa(){
        Lista<T> lista = new Lista<>();
        Nodo nodoActual = this.cola;
        while(nodoActual != null){
            lista.agregarAlFinal(nodoActual.elemento);
            nodoActual = nodoActual.anterior;
        }
        return lista;
    }

    /**
     * Método que devuelve una copia exacta de la lista
     * @return la copia de la lista.
     */
    @Override
    public Lista<T> copia(){
        Lista<T> lista = new Lista<>();
        IteradorLista iterador = new IteradorLista();
        while(iterador.hasNext()){
            lista.agregarAlFinal(iterador.next());
        }
        return lista;
    }

    /**
     * Método que nos dice si una lista es igual que otra.
     * @param o objeto a comparar con la lista.
     * @return <code>true</code> si son iguales, <code>false</code> en otro caso.
     */
    @Override
    public boolean equals(Object o){
        @SuppressWarnings("unchecked") Lista<T> lista = (Lista<T>) o;
        
        //Verificamos con null
        if(o == null)
            return false;

        //Verificamos direcciones de memoria
        if(this == o)
            return true;

        //Verificamos si son del mismo tipo
        if(!(o instanceof Lista))
            return false;

        //Verificamos longitudes
        if(this.longitud != lista.longitud)
            return false;

        IteradorLista iteradorOriginal = new IteradorLista();
        IteradorLista iteradorObjeto = (IteradorLista)lista.iterator();

        //Verificamos elemento a elemento
        while(iteradorOriginal.hasNext()){
            if(iteradorOriginal.next() != iteradorObjeto.next())
                return false;
        }
        return true;
    }

    /**
     * Método que devuelve un iterador sobre la lista
     * @return java.util.Iterador -- iterador sobre la lista
     */
    @Override
    public java.util.Iterator<T> iterator(){
        return new IteradorLista();
    }


    @Override
    public String toString() {
        if (esVacia()) {
            return "[]";
        }
        Nodo nodo = cabeza;
        String cad = "[" + nodo.elemento;
        while (nodo.siguiente != null) {
            nodo = nodo.siguiente;
            cad += ", " + nodo.elemento;
        }
        return cad + "]";
    }

}
