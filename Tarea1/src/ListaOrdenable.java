/**
 * Lechuga Martinez José Eduardo
 * 314325749
 * joselechuga194@ciencias.unam.mx
 * 
 * Practica 1 | EDD | 2020-4
 */

/**
 * Clase para listas ordenables 
 * @author Alejandro Hernández Mora <alejandrohmora@ciencias.unam.mx>
 * @param <T>
 */
public class ListaOrdenable<T extends Comparable<T>> extends Lista<T> {

    /**
     * Metodo que agrega ordenadamente
     * @params elemento elemento a agregar
     */
    public void agregarOrdenadamente(T elemento) throws IllegalArgumentException{
        
        if (elemento == null)
            throw new IllegalArgumentException("Elemento no valido");


        if(this.esVacia()){
            this.agregar(elemento);
            return;
        }

        Nodo nodoActual = this.cabeza;

        while(nodoActual != null){

            //Caso en el que el elemento sea menor a el primer elemento de la lista 
            if(nodoActual.equals(this.cabeza) && elemento.compareTo(nodoActual.elemento) <= 0){
                this.agregar(elemento);
                return;
            }

            //Caso en que el elemento sea mayor a todos los de la lista
            if(nodoActual.equals(this.cola) && elemento.compareTo(nodoActual.elemento) > 0){
                this.agregarAlFinal(elemento);
                return;
            }

            //Caso en que se agregue entre dos nodos
            if(elemento.compareTo(nodoActual.elemento) <= 0){
                Nodo nodoNuevo = new Nodo(elemento);
                nodoNuevo.siguiente = nodoActual;
                nodoNuevo.anterior = nodoActual.anterior;
                nodoActual.anterior.siguiente = nodoNuevo;
                nodoActual.anterior = nodoNuevo;
                this.longitud++;
                return; 
            }

            //Cambiamos de nodo
            nodoActual = nodoActual.siguiente;
        }     
    }

}
