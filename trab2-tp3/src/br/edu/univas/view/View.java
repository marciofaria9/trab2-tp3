package br.edu.univas.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import br.edu.univas.vo.Jogo;
import br.edu.univas.vo.LotoFacil;
import br.edu.univas.vo.MegaSena;
import br.edu.univas.vo.Quina;

public class View {

	public void printMenu() {

		System.out.println("\n*******Caixa Econômica Federal*******\n");
		System.out.println("1- Mega-Sena");
		System.out.println("2- Quina");
		System.out.println("3- Lotofácil");
		System.out.println("9- Sair");
	}

	public void printSubMenu() {

		System.out.println("\n1- 5 números que mais saíram");
		System.out.println("2- 5 números que menos saíram");
		System.out.println("3- Gerar números randômicos");
		System.out.println("4- Verificar meu jogo");

	}

	public void printJogoMega(ArrayList<Integer> jogo) {

		Collections.sort(jogo);

		for (Integer a : jogo) {
			System.out.print(a + " ");

		}
		System.out.println();

	}

	public void printJogoQuina(ArrayList<Integer> jogo) {
		Collections.sort(jogo);

		for (Integer a : jogo) {
			System.out.print(a + " ");

		}
		System.out.println();
	}

	public void printJogoLoto(ArrayList<Integer> jogo) {

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
				"No jogo de número " + idx + " do dia " + date + " você teria acertado " + quantidade + " números!");

	}

}
