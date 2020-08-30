Para ejecutar el codigo
1.- Abrir una terminal dentro de la carpeta src
2.- Ejecutar "javac *.java"
3.- Ejecutar  "java PruebaArbolOrdenado"

Arbol binario
*Calculo la altura del nodo de forma recursiva, si el nodo es null entonces su altura es 0 en otro caso su altura es el maximo entre sus subarboles izq y der 
*Para los tres recorridos uso metodos auxiliares que recorren el arbol de manera recursiva segun el tipo de recorrido y en cada iteracion añado el elemento correspondiente a la cola
*Equals para arboles uso un recorrido postorder

Arbol binario de busqueda
*Agregar nodos tiene tres casos 
    + cuando el arbol es vacio lo agrega como raiz
    + cuando el elemento es menor al elemento del nodo actual se agrega a la izquierda
    + cuando el elemento es mayo o igual al elemento del nodo actual se agrega a la derecha 
    (En ambos casos se usa recursion para llegar al nodo más izquiedo o más derecho segun sea el caso)

*Eliminar nodos tiene seis casos 
    + Cuando el nodo a eliminar es una hoja
        + cuando esta hoja es la raiz solo vaciamos el arbol
        + cuando el nodo es hijo izq o der de otro nodo, solo borramos las referencias al nodo

    + Cuando el nodo es la raiz y tiene elementos a la izquierda o derecha
    + Cuando el nodo no tiene hijo izquierdo verificamos si es hijo izq o der y subimos el hijo derecho del nodo
    + Cuando el nodo no tiene hijo derecho hacemos lo mismo que el anterior pero subiendo el hijo izquierdo
    + Cuando el nodo si tiene hijo izquierdo
        - buscamos el maximo en el subarbol izquierdo
        - Cambiamos los elementos con el nodo a eliminar
        - Si el maximo en subarbol tiene izquierdo entonces movemos las referencias
        - Si no tiene solo eliminamos la referencia de su padre a el

* BuscaNodo 
    + Si el nodo o el elemento es null regresamos null
    + Si son iguales regresamos el nodo 
    + Si es menor buscamos en el subarbol izquierdo 
    + Si no se encontro entonces buscamos en el subarbol derecho

* Rotaciones Ambas rotaciones funcionan de manera similar 
    - Guardamos referencias a los nodos que vamos a cambiar 
    - Si el nodo a girar es la raiz entonces hacemos a p la nueva raiz (p es el nodo izq o derecho de el nodo a girar )
    - verificamos si es hijo izq o derecho para mover la referencia del padre 
    - movemos la referencia de los nodos 
    - si p tiene subarbol izquierdo entonces movemos su referencia 
