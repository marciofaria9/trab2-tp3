package br.edu.univas.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import br.edu.univas.vo.ContadorN;
import br.edu.univas.vo.Jogo;
import br.edu.univas.vo.LotoFacil;
import br.edu.univas.vo.MegaSena;
import br.edu.univas.vo.Quina;

public class View {

	public void printMenu() {

		System.out.println("\n*******Caixa Econ�mica Federal*******\n");
		System.out.println("1- Mega-Sena");
		System.out.println("2- Quina");
		System.out.println("3- Lotof�cil");
		System.out.println("9- Sair");
	}

	public void printSubMenu() {

		System.out.println("\n1- 5 n�meros que mais sa�ram");
		System.out.println("2- 5 n�meros que menos sa�ram");
		System.out.println("3- Gerar n�meros rand�micos");
		System.out.println("4- Verificar meu jogo");

	}

	public void printJogoMega(ArrayList<Integer> jogo) {
		System.out.println("Seu jogo:");
		Collections.sort(jogo);

		for (Integer a : jogo) {
			System.out.print(a + " ");

		}
		System.out.println();

	}

	public void printJogoQuina(ArrayList<Integer> jogo) {
		System.out.println("Seu jogo:");
		Collections.sort(jogo);

		for (Integer a : jogo) {
			System.out.print(a + " ");

		}
		System.out.println();
	}

	public void printJogoLoto(ArrayList<Integer> jogo) {
		System.out.println("Seu jogo:");

		Collections.sort(jogo);

		for (Integer a : jogo) {
			System.out.print(a + " ");

		}
		System.out.println();
	}

	public void printSolicitaJogo() {
		System.out.println("Digite seu jogo");
	}

	public void printConferirJogo() {

		System.out.println("Conferir jogo:");

	}

	public void printMsgAcertos(String idx, String date, int quantidade) {

		System.out.println(
				"No jogo de n�mero " + idx + " do dia " + date + " voc� teria acertado " + quantidade + " n�meros!");

	}

	public void printCincoMaisMega(List<ContadorN> valores) {

		
		
		System.out.println("Os Cinco n�mero que mais sa�ram s�o:\n");
		for (int i = 0; i <= 4; i++) {

			System.out.print(valores.get(i).getNum() + " ");

		}

		System.out.println("");

	}
public void printCincoMenosMega(List<ContadorN> valores) {

		
		
		System.out.println("Os Cinco n�mero que menos sa�ram s�o:\n");
		for (int i = 55; i <= 59; i++) {

			System.out.print(valores.get(i).getNum() + " ");

		}

		System.out.println("");

	}
public void printCincoMaisQuina(List<ContadorN> valores) {

	
	
	System.out.println("Os Cinco n�mero que mais sa�ram s�o:\n");
	for (int i = 0; i <= 4; i++) {

		System.out.print(valores.get(i).getNum() + " ");

	}

	System.out.println("");

}
public void printCincoMenosQuina(List<ContadorN> valores) {

	
	
	System.out.println("Os Cinco n�mero que menos sa�ram s�o:\n");
	for (int i = 75; i <= 79; i++) {

		System.out.print(valores.get(i).getNum() + " ");

	}

	System.out.println("");

}
public void printCincoMaisLoto(List<ContadorN> valores) {

	
	
	System.out.println("Os Cinco n�mero que mais sa�ram s�o:\n");
	for (int i = 0; i <= 4; i++) {

		System.out.print(valores.get(i).getNum() + " ");

	}

	System.out.println("");

}
public void printCincoMenosLoto(List<ContadorN> valores) {

	
	
	System.out.println("Os Cinco n�mero que menos sa�ram s�o:\n");
	for (int i = 20; i <= 24; i++) {

		System.out.print(valores.get(i).getNum() + " ");

	}

	System.out.println("");

}

}
