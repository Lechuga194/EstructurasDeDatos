public class Algoritmos{

     /**
     * Método que ordena un arreglo usando Selection Sort.
     * @param <T>
     * @param conjunto El arreglo de elementos que debe ordenarse.
     * @return conjunto ordenado
     */
    public static <T extends Comparable<T>> T[] selectionSort(T[] conjunto){
        T minValue = null; //Valor minimo
        int minIndex = 0; //Indice del valor minimo

        for(int i = 0; i<conjunto.length; i++){
            minValue = conjunto[i];
            minIndex = i;
            for(int j = i+1; j<conjunto.length; j++){
                //Si el minimo es mas grande que el siguiente entonces cambiamos los valores 
                if(minValue.compareTo(conjunto[j]) >= 0){
                    minValue = conjunto[j];
                    minIndex = j; 
                }
            }

            //Hacemos el swap con el nuevo elemento minimo
            conjunto[minIndex] = conjunto[i]; 
            conjunto[i] = minValue;  
        }
        return conjunto;
    }


    /**
     * Método que ordena un arreglo usando Quick Sort.
     * @param <T>
     * @param conjunto El arreglo de elementos que debe ordenarse.
     */
    public static <T extends Comparable<T>> void quickSort(T[] conjunto){
	//Aquí va tu código.
    }

    /**
     * Método que ordena una lista usando Selection Sort.
     * @param <T> Tipo que tienen los elementos de la lista.
     * @param lista La lista a ordenar.
     * @return Una copia de la lista ordenada.
     */
    public static <T extends Comparable<T>> ListaOrdenable<T> insertionSort(Lista<T> lista){
        ListaOrdenable listaOrdenada = new ListaOrdenable();
        for(T elemento: lista){
            listaOrdenada.agregarOrdenadamente(elemento);
        }
        return listaOrdenada;
    }
}
