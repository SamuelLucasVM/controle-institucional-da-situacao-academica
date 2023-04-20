/**
 * <h1>Disciplina
 * <li> Funções:
 * <ul> Cadastrar horas;
 * <ul> Cadastrar notas;
 * <ul> Verificar aprovação;
 */

package lab2;

import java.util.Arrays;

public class Disciplina {
	/**
	  * <l1>Atributos Privados: 
	  * <ul>subject : String;
	  * <ul>scores : double[];
	  * <ul>studiedHours : int;
	  * <ul>average : double;
	  * <ul>scoreQuantity : int;
	  * <ul>scoreWeights : int.
	 */

	private String subject;
	private double[] scores;
	private int studiedHours;
	private double average;
	private int scoreQuantity;
	private int[] scoreWeights;
	
	/**
	 * <h3>Constructor - Passando todos os parâmetros 
	 * @param subject(String) - Matéria que irá alterar;
	 * @param scoreQuantity(int) - Quantidade de notas da matéria;
	 * @param scoreWeights(int) - Pesos das notas.
	 */
	
	Disciplina(String subject, int scoreQuantity, int[] scoreWeights) {
		this.subject = subject;
		this.scoreQuantity = scoreQuantity;
		this.scores = new double[scoreQuantity];
		this.scoreWeights = scoreWeights;
	}

	/**
	 * <h3>Constructor - Passando matéria e quantidade de notas
	 * @param subject(String) - Matéria que irá alterar;
	 * @param scoreQuantity(int) - Quantidade de notas da matéria.
	 */
	
	Disciplina(String subject, int scoreQuantity) {
		this(subject, scoreQuantity, new int[scoreQuantity]);
	}

	/**
	 * <h3>Constructor - Passando apenas matéria 
	 * @param subject(String) - Matéria que irá alterar.
	 */
	
	Disciplina(String subject) {
		this(subject, 4, new int[4]);
		Arrays.fill(scoreWeights, 1);
	}
	
	/**
	 * <h3>cadastraHoras
	 * @param hours(int) - Horas que serão adicionadas para horas estudadas da matéria.
	 * <p>Cadastra horas estudadas na matéria.
	 */
	
	void cadastraHoras(int hours) {
		studiedHours += hours;
	}
	
	/**
	 * <h3>cadastraNota
	 * @param score(int) - Indica a nota que ira cadastrar;
	 * @param scoreValue(double) - Indica o valor da nota que irá alterar.
	 * <p>Cadastra notas na matéria.
	 */
	
	void cadastraNota(int score, double scoreValue) {
		scores[score - 1] = scoreValue;
	}
	
	/**
	 * <h3>aprovado
	 * @return boolean - Retorna uma resposta se o aluno ja está aprovado ou não na disciplina.
	 */
	
	boolean aprovado() {
		getMedia();
		
		if (average >= 7.0) {
			return true;		
		} else {
			return false;
		}
	}
	
	/**
	 * <h3>toString
	 * @return String - Retorna uma string com informações da matéria, horas estudadas, médias e notas.
	 */
	
	@Override
	public String toString() {
		getMedia();
		String response;
		
		response = subject + " " + studiedHours + " " + average + " " + Arrays.toString(scores);
		return response;
	}
	
	private void getMedia() {
		double sum = 0;
		double weights = 0;
		for (int i = 0; i < scoreQuantity; i++) {
			sum += scores[i] * scoreWeights[i];
			weights += scoreWeights[i];
		}
		
		
		average = (sum/weights);
	}
}
