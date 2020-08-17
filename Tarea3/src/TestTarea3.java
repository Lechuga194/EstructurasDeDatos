/**
 * Lechuga Martinez José Eduardo
 * 314325749
 * joselechuga194@ciencias.unam.mx
 * 
 * EDD | 2020-4
 */

/**
 * Clase para probar los metodos de Lista
 * 
 * @author Luis Manuel Martinez Damaso <luismanuel@ciencias.unam.mx>
 */
public class TestTarea3 {

	public static void main(String[] args) {

		balanceoTest();
		colaConPilaTest();

	}

	public static void balanceoTest(){
		System.out.println("------------------------Balanceo de expresiones-------------------------------------");
		
		String test = "((((asdasdasd(())))))(((())))()()()()";
		System.out.println( test + " esta balanceado? " + Balanceo.verificaBalanceo(test)); //TRUE

		test = "Hola!";
		System.out.println( test + " esta balanceado? " + Balanceo.verificaBalanceo(test)); //TRUE

		test = "((";
		System.out.println( test + " esta balanceado? " + Balanceo.verificaBalanceo(test)); //FALSE

		test = "(()))";
		System.out.println( test + " esta balanceado? " + Balanceo.verificaBalanceo(test)); //FALSE

		System.out.println("Vacio esta balanceado? " + Balanceo.verificaBalanceo("")); //FALSE
	}

	public static void colaConPilaTest() {
		System.out.println("----------------------------------Cola con pilas---------------------------------------");

		System.out.println("Creamos la cola");
		ColaConPila a = new ColaConPila();
		System.out.println(a.longitud);

		System.out.println("Agregamos elementos [1,2,3,4,5,6]");
		a.queue(1);
		a.queue(2);
		a.queue(3);
		a.queue(4);
		a.queue(5);
		a.queue(6);

		System.out.println("Longitud: " + a.longitud);

		System.out.println("Hacemos dequeue 1");
		int elemento = (int) a.dequeue();
		System.out.println(elemento);

		System.out.println("Agregamos elementos [2,3,4,5,6,7,8]");
		a.queue(7);
		a.queue(8);

		System.out.println("Hacemos dequeue 2");
		elemento = (int) a.dequeue();
		System.out.println(elemento + " fue retirado");

		System.out.println("Hacemos dequeue 3");
		elemento = (int) a.dequeue();
		System.out.println(elemento + " fue retirado");

		System.out.println("Hacemos dequeue 4");
		elemento = (int) a.dequeue();
		System.out.println(elemento + " fue retirado");

		System.out.println("Hacemos dequeue 5");
		elemento = (int) a.dequeue();
		System.out.println(elemento + " fue retirado");

		System.out.println("Agregamos elementos [6,7,8,9,10]");
		a.queue(9);
		a.queue(10);

		System.out.println("Hacemos dequeue 6 ");
		elemento = (int) a.dequeue();
		System.out.println(elemento + " fue retirado");

		System.out.println("Scamos los restantes [7,8,9,10]");
		while(a.longitud > 0){
			System.out.println(a.dequeue());
		}

	}
}
