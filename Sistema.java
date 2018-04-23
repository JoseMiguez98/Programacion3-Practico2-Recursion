import java.util.ArrayList;
import java.util.List;

public class Sistema {

	public static void main(String[] args) {
		ArbolBusquedaBinaria arbol = new ArbolBusquedaBinaria();

		arbol.insert(15);
		arbol.insert(6);
		arbol.insert(18);
		arbol.insert(17);
		arbol.insert(20);
		arbol.insert(7);
		arbol.insert(3);
		arbol.insert(4);
		arbol.insert(2);
		arbol.insert(13);
		arbol.insert(9);

		List<Integer> inOrder = arbol.inOrder();
		List<Integer> posOrder = arbol.posOrder();
		List<Integer> preOrder = arbol.preOrder();
		
		System.out.println("En orden:");
		for(int i = 0 ; i<inOrder.size() ; i++) {
			System.out.print(inOrder.get(i) + "\t");
		}
		
		System.out.println("\nPos orden");
		for(int i = 0 ; i<posOrder.size() ; i++) {
			System.out.print(posOrder.get(i) + "\t");
		}
		
		System.out.println("\nPre orden");
		for(int i = 0 ; i<preOrder.size() ; i++) {
			System.out.print(preOrder.get(i) + "\t");
		}
		
		//Le pregunto si tiene el numero 13
		System.out.println("\n" + arbol.hasElement(13));
		//Le pregunto si tiene el numero 24
		System.out.println("\n" + arbol.hasElement(24));
	}


	//Determina si un array esta ordenado recorriendolo de manera recursiva
	/*	1) En el peor de los casos la complejidad de este algoritmo es O(n)
	 	2) El problema que trae la recursividad es que el proceso se hace mas caro/costoso para la memoria
	 * */
	public static boolean isOrdered(int[]_arr, int i) {
		if(i < _arr.length-1) {
			if(_arr[i] <= _arr[i+1]) {
				return isOrdered(_arr, i+1);
			}
			else {
				return false;
			}
		}
		return true;
	}

	public static boolean binarySearch(Integer[]_arr, Integer _x, Integer _s, Integer _e) {
		//Pregunto si el inicio y el fin son iguales para evaluar si tengo un solo numero;
		if(_s.equals(_e)) {
			//Retorno TRUE si el unico numero que tengo es el que estoy buscando;
			return _arr[_s].equals(_x);
		}

		//Obtengo el medio actual;
		int mid = (_s+_e)/2;

		//Pregunto si X es mayor al medio
		if(_x>_arr[mid]) {
			return binarySearch(_arr, _x, mid+1, _e);
		}

		//Pregunto si X es menor al medio
		else if(_x<_arr[mid]) {
			return binarySearch(_arr, _x, _s, mid-1);
		}

		//Si llega aca es por que encontre el numero que estoy buscando
		else {
			return true;
		}
	}
}
