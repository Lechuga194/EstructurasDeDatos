Para ejecutar el codigo
1.- Abrir una terminal dentro de la carpeta src
2.- Ejecutar "javac *.java"
3.- Ejecutar  "java TestTarea3"

Ejercicio 1 - 
Creamos una pila e iteramos la expresion pasada
*si encontramos un '(' lo agregamos a la pila
*si encontramos un ')' hacemos pop, si intentamos hacer pop y la lista es vacia regresamos false
Al terminar de procesar la cadena regresa true indicando que los parentesis estan balanceados o 
si la cadena no tiene parentesis

Ejericio 4 - 
Creamos una nueva clase llamada ColaConPilas
creamos dos pilas y un entero para la longitud

*Queue verificamos si la pila esvacia metemos directamente el elemento a la pilasi no es vacia
entonces copiamos todos los elementos de la pila a la auxiliar, luego agregamos el elemento nuevo
al fondo de la pila y finalmente regresamos los elementos de el aux a la pila original 
esto hace que el nuevo elemento quede al final de la cola 

*Dequeue funciona igual que en la implementacion original de colas 