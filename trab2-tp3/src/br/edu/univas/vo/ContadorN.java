package br.edu.univas.vo;

public class ContadorN implements Comparable<ContadorN> {

	private String num;
	private int contador;

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public int getContador() {
		return contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}

	@Override
	public int compareTo(ContadorN o) {

		return (o.contador - this.contador);
	}

	public void contar() {

		this.contador++;

	}
}
