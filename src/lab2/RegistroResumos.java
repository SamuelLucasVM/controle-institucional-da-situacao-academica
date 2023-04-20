/**
 * <h1>Registro de Resumos
 * <li> Funções:
 * <ul> Adicionar resumos;
 * <ul> Receber resumos;
 * <ul> Imprimir resumos;
 * <ul> Contar quantidade de resumos;
 * <ul> Buscar resumos por palavra chave.
 */

package lab2;

import java.util.Arrays;

public class RegistroResumos {
	/**
	  * <l1>Atributos Privados: 
	  * <ul>summariesQuantity : int;
	  * <ul>summaries : String[][];
	  * <ul>currentEmptySummarie : int.
	  * <ul>submitedSummaries : int.
	 */
	
	private int summariesQuantity;
	private String[][] summaries;
	private int currentEmptySummarie;
	private int submitedSummaries;
	
	/**
	 * <h3>Constructor 
	 * @param summariesQuantity - Quantidade de resumos.
	 */
	
	RegistroResumos(int summariesQuantity) {
		this.summariesQuantity = summariesQuantity;
		this.summaries = new String[summariesQuantity][2];
		this.submitedSummaries = 0;
	}
	
	/**
	 * <h3>adiciona
	 * @param theme(String) - Tema do resumo;
	 * @param summarie(String) - Texto do resumo.
	 * <p>Adiciona resumos na lista de resumos.
	 */
	
	void adiciona(String theme, String summarie) {
		if (submitedSummaries == summariesQuantity-1) {
			System.out.println("Quantidade maxima de resumos atingida!");
		}
		
		summaries[currentEmptySummarie][0] = theme;
		summaries[currentEmptySummarie][1] = summarie;
		
		if (currentEmptySummarie + 1 > summariesQuantity) {
			currentEmptySummarie = 0;
		} else {
			currentEmptySummarie++;			
		}
		
		submitedSummaries++;					
	}

	/**
	 * <h3>pegaResumos
	 * @return String[] - Retorna os resumos com temas e textos.
	 */
	
	String[] pegaResumos() {
		String[] formatedSummaries = new String[summariesQuantity];
		for (int i = 0; i < summariesQuantity; i++)
			if (summaries[i][0] == null) {
				break;
			}
			else {
				formatedSummaries[i] = summaries[i][0] + ": " + summaries[i][1]; 
			}
			
		return formatedSummaries;
	}
	
	/**
	 * <h3>imprimeResumos
	 * @return String - Retorna uma string formatada dos resumos com temas e textos, além da quantidade de resumos cadastrados.
	 */

	String imprimeResumos() {
		String themes = prepareThemes();
		
		String response = ("- " + submitedSummaries + " resumo(s) cadastrado(s)\n" +
						   "- " + themes);
		
		return response;
	}
	
	/**
	 * <h3>Conta
	 * @return int - Retorna a quantidade de resumos cadastrados.
	 */
	
	int conta() {
		return submitedSummaries;
	}
	
	/**
	 * <h3>temResumo
	 * @param theme(String) - Tema que será verificado.
	 * @return boolean - Retorna uma resposta se há ou não um resumo com o nome tema pesquisado.
	 */
	
	boolean temResumo(String theme) {
		for (int i = 0; i < summariesQuantity; i++)
			if (summaries[i][0] == null) {
				break;
			} else {
				if (summaries[i][0].equals(theme)) {
					return true;
				}
			}
		
		return false;
	}
	
	/**
	 * <h3>busca
	 * @param key(String) - Palavra chave que será pesquisada nos resumos.
	 * @return String[] - Retorna uma array de resumos em que foi encontrada a palavra chave.
	 */
	
	String[] busca(String key) {
		String[] response = new String[summariesQuantity];
		Arrays.fill(response, "");
		int index = 0;
		
		for (int i = 0; i < summariesQuantity; i++) {
			if (summaries[i][0] == null){
				break;
			}
			if (Arrays.binarySearch(summaries[i][1].split(" "), key) != -1) {
				response[index] = summaries[i][0];
				index += 1;
			}
		}
			
		Arrays.sort(response);
		
		return response;
	}
	
	private String prepareThemes() {
		String response = "";
		
		for (int i = 0; i < summariesQuantity; i++)
			if (summariesQuantity != 1 && summaries[i + 1][0] == null) {
				response += summaries[i][0];
				break;
			} else {
				response += summaries[i][0] + " | " ;
			}
		
		return response;
	}
}
