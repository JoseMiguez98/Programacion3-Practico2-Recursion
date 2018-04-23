import java.util.ArrayList;
import java.util.List;

public class ArbolBusquedaBinaria {
	private Nodo raiz;

	public ArbolBusquedaBinaria() {
		this.raiz = new Nodo();
	}

	public ArbolBusquedaBinaria(Integer _o) {
		this.raiz.setInfo(_o);
	} 

	public Object getRoot() {
		return this.raiz.getInfo();
	}

	//Auxiliar para comenzar el recorrido recursivo antes de insertar
	public boolean insert(Integer _o) {
		return this.insert(this.raiz, _o);
	}

	//Inserta un elemento en el ABB, retorna TRUE si la operacion fue exitosa
	public boolean insert(Nodo _n, Integer _o) {
		//Si el nodo es desigual a nulo comienzo a recorrer el arbol para determinar donde insertar el elemento
		if(_n != null) {
			//Si _n.info es desigual a nulo comienzo a preguntar para ver donde inserto el elemento
			if(_n.getInfo() != null) {
				//Si el elemento ya existe en el ABB retorno FALSE
				if(_n.getInfo().equals(_o)) {
					return false;
				}
				//Si el elemento que quiero insertar es menor al actual entro recursivamente con el sub-arbol izquierdo
				else if(_o.compareTo(_n.getInfo()) < 0) {
					//Si mi izquierdo es nulo inserto el elemento
					if(_n.getIzq() == null) {
						_n.setIzq(new Nodo(_o));
						return true;
					}
					//Si no llamo recursivamente a la función con el sub-arbol derecho
					else {
						return insert(_n.getIzq(), _o);
					}
				}
				//Si el elemento que quiero insertar es mayor al actual entro recursivamente con el sub-arbol derecho
				else {
					//Si el nodo derecho es nulo inserto el elemento
					if(_n.getDer() == null) {
						_n.setDer(new Nodo(_o));
						return true;
					}
					//Si no llamo recursivamente a la funcion
					else {
						return insert(_n.getDer(), _o);
					}
				}
			}
			//Si el nodo no tiene info inserto el elemento en esta posición  
			else {
				_n.setInfo(_o);
				return true;
			}
		}
		//Si llegue a un nodo nulo lo instancio con la info pasada por parametro
		else {
			_n = new Nodo(_o);
			return true;
		}
	}

	//Auxiliar para comenzar la busqueda recursiva
	public boolean hasElement(Integer _o) {
		return this.hasElement(this.raiz, _o);
	}

	//Retorna TRUE si un elemento dado existe en el ABB
	public boolean hasElement(Nodo _n, Integer _o) {
		//Si _n es desigual a nulo comienzo a preguntar
		if (_n != null) {
			//Si encontre el elemento que estoy buscando retorno true
			if(_n.getInfo().equals(_o)) {
				return true;
			}
			//Si el elemento que estoy buscando es mayor al actual entro recursivamente con el sub-arbol izquierdo
			else if (_o.compareTo(_n.getInfo()) < 0) {
				return hasElement(_n.getIzq(), _o);
			}
			//Si el elemento que estoy buscando es menor que el actual entro recursivamente con el sub-arbol derecho
			else {
				return hasElement(_n.getDer(), _o);
			}
		}

		//Si _n es nulo retorno false
		return false;
	}

	//Metodo auxiliar para comenzar la busqueda en pre-orden
	public List<Integer> preOrder() {
		return preOrder(this.raiz);
	}

	//Retorna una lista con el recorrido de los elementos en pre-orden
	private List<Integer> preOrder(Nodo _n) {
		List <Integer> retorno = new ArrayList<Integer>();

		//Checkeo que el arbol no este vacio
		if(_n.getInfo() != null) {
			//Agrego la raiz a la lista de retorno
			retorno.add(_n.getInfo());
			//Si tengo nodo izquierdo agrego su info a la lista
			if(_n.getIzq() != null) {
				retorno.addAll(preOrder(_n.getIzq()));
			}
			//Si tengo nodo derecho agrego su info a la lista
			if(_n.getDer() != null) {
				retorno.addAll(preOrder(_n.getDer()));
			}
			//Retorno la lista de elementos en pre-orden
			return retorno;
		}
		return null;
	}

	public List<Integer> posOrder(){
		return posOrder(this.raiz);
	}

	private List<Integer> posOrder(Nodo _n){
		List<Integer> retorno = new ArrayList<Integer>();

		if(_n.getInfo() != null) {
			if(_n.getIzq() != null) {
				retorno.addAll(posOrder(_n.getIzq()));
			}
			if(_n.getDer() != null) {
				retorno.addAll(posOrder(_n.getDer()));
			}
			retorno.add(_n.getInfo());

			return retorno;
		}

		return null;
	}

	public List<Integer> inOrder(){
		return inOrder(this.raiz);
	}

	private List<Integer> inOrder(Nodo _n){
		List<Integer> retorno = new ArrayList<Integer>();

		if(_n.getInfo() != null) {
			if(_n.getIzq() != null) {
				retorno.addAll(inOrder(_n.getIzq()));
			}

			retorno.add(_n.getInfo());

			if(_n.getDer() != null) {
				retorno.addAll(inOrder(_n.getDer()));
			}

			return retorno;
		}

		return null;
	}
}

