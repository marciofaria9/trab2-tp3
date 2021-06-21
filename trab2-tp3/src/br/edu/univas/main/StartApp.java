package br.edu.univas.main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;


import java.util.List;

import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;


import br.edu.univas.view.View;
import br.edu.univas.vo.Jogo;
import br.edu.univas.vo.LotoFacil;
import br.edu.univas.vo.MegaSena;
import br.edu.univas.vo.Quina;

public class StartApp {

	List<Jogo> ListSena = new ArrayList<>();
	List<Jogo> ListLoto = new ArrayList<>();
	List<Jogo> ListQuina = new ArrayList<>();

	public static void main(String[] args) {

		StartApp app = new StartApp();
		app.runner();

	}

	public void runner() {
		Scanner scanner = new Scanner(System.in);
		View view = new View();

		ListSena = readMega();

		ListQuina = readQuina();

		ListLoto = readLoto();

		int choice = 0;

		do {

			view.printMenu();
			choice = readInt(scanner);
			if (choice != 1 && choice != 2 && choice != 3 && choice != 9) {
				System.out.println("Digite um número válido!\n");
				continue;
			}

			if (choice == 1) { // mega
				view.printSubMenu();
				choice = readInt(scanner);
				if (choice != 1 && choice != 2 && choice != 3 && choice != 4) {
					System.out.println("Digite um número válido!\n");
					continue;
				}

				if (choice == 1) {
					cincoMais(ListSena, view);
				}

				if (choice == 2) {

				}

				if (choice == 3) {
					gerarJogoMega(view);
					continue;
				}

				if (choice == 4) {
					view.printConferirJogo();
					conferiJogoSena(ListSena, view, scanner);
					continue;
				}

			}

			if (choice == 2) { // quina
				view.printSubMenu();
				choice = readInt(scanner);
				if (choice != 1 && choice != 2 && choice != 3 && choice != 4) {
					System.out.println("Digite um número válido!\n");
					continue;
				}

				if (choice == 1) {

				}

				if (choice == 2) {

				}

				if (choice == 3) {
					gerarJogoQuina(view);
					continue;
				}

				if (choice == 4) {
					view.printConferirJogo();
					conferiJogoQuina(ListQuina, view, scanner);
					continue;
				}

			}

			if (choice == 3) { // loto
				view.printSubMenu();
				choice = readInt(scanner);
				if (choice != 1 && choice != 2 && choice != 3 && choice != 4) {
					System.out.println("Digite um número válido!\n");
					continue;
				}

				if (choice == 1) {

				}

				if (choice == 2) {

				}

				if (choice == 3) {
					gerarJogoLoto(view);
					continue;
				}

				if (choice == 4) {
					view.printConferirJogo();
					conferiJogoLoto(ListLoto, view, scanner);
					continue;
				}

			}

		} while (choice != 9);

	}

	public List<Jogo> readMega() {

		List<Jogo> ListMega = new ArrayList<>();

		String arquivoCSV = "File\\mega.csv";
		BufferedReader br = null;
		String linha = "";
		String csvDivisor = ",";
		try {

			br = new BufferedReader(new FileReader(arquivoCSV));
			while ((linha = br.readLine()) != null) {

				MegaSena mega = new MegaSena();

				String[] lineArray = linha.split(csvDivisor);
				mega.setIdx(lineArray[0]);
				mega.setDate(lineArray[1]);

				for (int i = 2; i < lineArray.length; i++) {

					mega.getNumbers().add(lineArray[i]);

				}

				ListMega.add(mega);

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return ListMega;
	}

	public List<Jogo> readQuina() {

		List<Jogo> ListQuina = new ArrayList<>();

		String arquivoCSV = "File\\quina.csv";
		BufferedReader br = null;
		String linha = "";
		String csvDivisor = ",";
		try {

			br = new BufferedReader(new FileReader(arquivoCSV));
			while ((linha = br.readLine()) != null) {

				Quina quina = new Quina();

				String[] lineArray = linha.split(csvDivisor);
				quina.setIdx(lineArray[0]);
				quina.setDate(lineArray[1]);

				for (int i = 2; i < lineArray.length; i++) {

					quina.getNumbers().add(lineArray[i]);

				}

				ListQuina.add(quina);

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return ListQuina;

	}

	public List<Jogo> readLoto() {
		List<Jogo> ListLoto = new ArrayList<>();

		String arquivoCSV = "File\\lotofacil.csv";
		BufferedReader br = null;
		String linha = "";
		String csvDivisor = ",";
		try {

			br = new BufferedReader(new FileReader(arquivoCSV));
			while ((linha = br.readLine()) != null) {

				LotoFacil loto = new LotoFacil();

				String[] lineArray = linha.split(csvDivisor);
				loto.setIdx(lineArray[0]);
				loto.setDate(lineArray[1]);

				for (int i = 2; i < lineArray.length; i++) {

					loto.getNumbers().add(lineArray[i]);

				}

				ListLoto.add(loto);

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return ListLoto;
	}

	public int readInt(Scanner scanner) {

		int x = scanner.nextInt();
		scanner.nextLine();

		return x;

	}

	public void gerarJogoMega(View view) {

		TreeSet tset = new TreeSet();

		Random random = new Random();
		ArrayList<Integer> jogo = new ArrayList<>();

		for (int i = 0; i < 6; i++) {

			int RandNum = random.nextInt((60 - 1) + 1) + 1;

			for (;;) {
				if (tset.add(RandNum))
					break;
				RandNum = random.nextInt((60 - 1) + 1) + 1;
				;
			}

			jogo.add(RandNum);

		}

		view.printJogoMega(jogo);

	}

	private void gerarJogoLoto(View view) {

		TreeSet tset = new TreeSet();

		Random random = new Random();
		ArrayList<Integer> jogo = new ArrayList<>();

		for (int i = 0; i < 15; i++) {

			int RandNum = random.nextInt((25 - 1) + 1) + 1;

			for (;;) {
				if (tset.add(RandNum))
					break;
				RandNum = random.nextInt((25 - 1) + 1) + 1;
				;
			}

			jogo.add(RandNum);

		}

		view.printJogoLoto(jogo);

	}

	private void gerarJogoQuina(View view) {

		TreeSet tset = new TreeSet();

		Random random = new Random();
		ArrayList<Integer> jogo = new ArrayList<>();

		for (int i = 0; i < 5; i++) {

			int RandNum = random.nextInt((80 - 1) + 1) + 1;

			for (;;) {
				if (tset.add(RandNum))
					break;
				RandNum = random.nextInt((80 - 1) + 1) + 1;
				;
			}

			jogo.add(RandNum);

		}

		view.printJogoQuina(jogo);

	}

	public void conferiJogoSena(List<Jogo> listSena, View view, Scanner scanner) {

		int total = 6;

		view.printSolicitaJogo();
		DecimalFormat format = new DecimalFormat("00");
		List<String> gameUsuario = new ArrayList<>();

		for (int i = 0; i < 6; i++) {
			int num = readInt(scanner);
			String formatted = format.format(num);
			gameUsuario.add(formatted);

		}

		for (Jogo jogo : listSena) {

			int contador = 0;

			contador = counter(jogo, gameUsuario, contador, total);

			if (contador >= 4) {

				String idx = jogo.getIdx();
				String date = jogo.getDate();

				view.printMsgAcertos(idx, date, contador);

			}

			contador = 0;

		}

	}

	public void conferiJogoQuina(List<Jogo> listQuina, View view, Scanner scanner) {
		int total = 5;

		view.printSolicitaJogo();
		DecimalFormat format = new DecimalFormat("00");
		List<String> gameUsuario = new ArrayList<>();

		for (int i = 0; i < 5; i++) {
			int num = readInt(scanner);
			String formatted = format.format(num);
			gameUsuario.add(formatted);

		}

		for (Jogo jogo : listQuina) {

			int contador = 0;

			contador = counter(jogo, gameUsuario, contador, total);

			if (contador >= 2) {

				String idx = jogo.getIdx();
				String date = jogo.getDate();

				view.printMsgAcertos(idx, date, contador);

			}

			contador = 0;

		}

	}

	public void conferiJogoLoto(List<Jogo> listLoto, View view, Scanner scanner) {

		int total = 15;

		view.printSolicitaJogo();
		DecimalFormat format = new DecimalFormat("00");
		List<String> gameUsuario = new ArrayList<>();

		for (int i = 0; i < 15; i++) {
			int num = readInt(scanner);
			String formatted = format.format(num);
			gameUsuario.add(formatted);

		}

		for (Jogo jogo : listLoto) {

			int contador = 0;

			contador = counter(jogo, gameUsuario, contador, total);

			if (contador >= 11) {

				String idx = jogo.getIdx();
				String date = jogo.getDate();

				view.printMsgAcertos(idx, date, contador);

			}

			contador = 0;

		}

	}

	private int counter(Jogo jogo, List<String> gameUsuario, int contador, int total) {

		for (String current : jogo.getNumbers()) {

			for (int i = 0; i < total; i++) {

				if (gameUsuario.get(i).equals(current)) {

					contador++;

				}

			}

		}

		return contador;

	}

	public void cincoMais(List<Jogo> listSena, View view) {

		DecimalFormat formatter = new DecimalFormat("00");
		List<String> formated = new ArrayList<>();
		int total = 0;

		List<String> valores = new ArrayList<>();

		for (Jogo jogo : ListSena) {

			for (int i = 0; i < jogo.getNumbers().size(); i++) {

				valores.add(jogo.getNumbers().get(i));

			}

		}

		for (int i = 0; i < 60; i++) {

			String string = formatter.format(i + 1);
			String aux = string;
			valores.add(aux);

		}

		for (Jogo jogo : listSena) {

			for (String a : jogo.getNumbers()) {

				for (int i = 0; i < 60; i++) {

					if (a.equals(valores.get(i))) {
						
						
					

					}

				}

			}

		}

	}

}
