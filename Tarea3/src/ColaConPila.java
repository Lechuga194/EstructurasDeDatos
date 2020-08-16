/**
 * Lechuga Martinez José Eduardo 314325749 joselechuga194@ciencias.unam.mx
 * 
 * EDD | 2020-4
 */

public class ColaConPila<T> {
    protected Pila aux = new Pila();
    protected Pila pila = new Pila();
    protected int longitud = 0;

    public void queue(T elemento) throws IllegalArgumentException {
        if (elemento == null)
            throw new IllegalArgumentException("Elemento no valido");

        // Si es vacia metemos el elemento directamente
        if (this.pila.esVacia()) {
            this.pila.push(elemento);
        } else {
            // Copiamos los elementos a la pila auxiliar
            while (!this.pila.esVacia()) {
                this.aux.push(this.pila.pop());
            }
            // Metemos el nuevo elemento al fondo de la pila
            this.pila.push(elemento);

            // Regresamos los elementos a la pila original
            while (!this.aux.esVacia()) {
                this.pila.push(this.aux.pop());
            }
        }
        this.longitud++;
    }

    public T dequeue() throws IllegalArgumentException {
        if (this.pila.esVacia())
            throw new IllegalArgumentException("La cola es vacia");
        T elemento = (T) pila.pop();
        this.longitud--;
        return elemento;
    }

}