package br.edu.univas.vo;

import java.util.ArrayList;
import java.util.List;

public class Jogo  {
	private String idx;
	private String date;
	private List<String> numbers = new ArrayList();
	
	public String getIdx() {
		return idx;
	}
	public void setIdx(String idx) {
		this.idx = idx;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public List<String> getNumbers() {
		return numbers;
	}
	public void setNumbers(List<String> numbers) {
		this.numbers = numbers;
	}
	

}
