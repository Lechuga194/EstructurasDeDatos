/**
 * Lechuga Martinez José Eduardo
 * 314325749
 * joselechuga194@ciencias.unam.mx
 * 
 * EDD | 2020-4
 */


public class ColaConPila<T>{
    protected Pila aux = new Pila();
    protected Pila pila = new Pila();
    protected int longitud = 0;
    
    public void queue(T elemento) throws IllegalArgumentException{
        if(elemento == null)
            throw new IllegalArgumentException("Elemento no valido");
        this.aux.push(elemento);
        this.longitud++;
    }

    public T dequeue() throws IllegalArgumentException{
        //Pasamos los elementos para que se acomoden como cola
        while(!this.aux.esVacia()){
            this.pila.push(this.aux.pop());
        }
        if(this.pila.esVacia())
            throw new IllegalArgumentException("La cola es vacia");
        T elemento = (T)pila.pop();
        this.longitud--;
        return elemento;
    }

    //Es destructivo, solo lo use para pruebas
    @Override
    public String toString(){
        while(!aux.esVacia()){
            pila.push(aux.pop());
        }
        String s = "[";
        while(!pila.esVacia()){
            if(pila.longitud==1){
                s+=pila.pop();
            }else{
                s+=pila.pop();
                s+=", ";
            }
        }
        s+="]";
        return s;
    }

}