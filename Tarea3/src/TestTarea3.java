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
		System.out.println("----------------------------------Balanceo de expresiones------------------------------------------------------");
		
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
		System.out.println(
				"----------------------------------Cola con pilas------------------------------------------------------");

		System.out.println("Creamos la cola");
		ColaConPila a = new ColaConPila();
		System.out.println(a.longitud);
		System.out.println(a);

		System.out.println("Agregamos elementos");
		a.queue(1);
		a.queue(2);
		a.queue(3);
		a.queue(4);
		a.queue(12);
		a.queue(6);
		System.out.println("Longitud: " + a.longitud);

		int deberiaser1 = (int) a.dequeue();
		System.out.println(deberiaser1);

		a.queue(5);

		int deberiaser2 = (int) a.dequeue();
		System.out.println(deberiaser2);

		int deberiaser3 = (int) a.dequeue();
		System.out.println(deberiaser3);

		int deberiaser4 = (int) a.dequeue();
		System.out.println(deberiaser4);

		int deberiaser5 = (int) a.dequeue();
		System.out.println(deberiaser5);

		a.queue(6);

		int deberiaser6 = (int) a.dequeue();
		System.out.println(deberiaser6);

	}
}
