public class Nodo {
	private Integer info;
	private Nodo der;
	private Nodo izq;

	public Nodo() {
		info = null;
		der = null;
		izq = null;
	}

	public Nodo(Integer o) {
		setInfo(o);
		izq = null;
		der = null;
	}
	public void setInfo(Integer o) {
		info = o;
	}

	public void setIzq(Nodo n) {
		this.izq = n;
	}

	public void setDer(Nodo n) {
		this.der = n;
	}
	public Integer getInfo() {
		return info;
	}
	public Nodo getDer() {
		return der;
	}
	public Nodo getIzq() {
		return izq;
	}
}