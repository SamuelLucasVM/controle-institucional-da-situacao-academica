/**
 * <h1>Registro de Tempo Online
 * <li> Funções:
 * <ul> Adicionar tempo online;
 * <ul> Verificar se atingiu meta de tempo online;
 */

package lab2;

public class RegistroTempoOnline {
	/**
	  * <l1>Atributos Privados: 
	  * <ul>subject : String;
	  * <ul>goalHours : int;
	  * <ul>onlineHours : int.
	 */
	
	private String subject;
	private int goalHours;
	private int onlineHours;
	
	/**
	 * <h3>Constructor - Passando todos os parâmetros 
	 * @param subject - Matéria que irá registrar o tempo online;
	 * @param goalHours - Quantidade de horas para ser atingida.
	 */
	
	RegistroTempoOnline(String subject, int goalHours) {
		this.subject = subject;
		this.goalHours = goalHours;		
	}

	/**
	 * <h3>Constructor - Passando apenas a matéria.
	 * @param subject - Matéria que irá registrar o tempo online.
	 */
	
	RegistroTempoOnline(String subject) {
		this(subject, 120);
	}
	
	/**
	 * <h3>adicionaTempoOnline
	 * @param time(int) - Tempo que será adicionado.
	 * <p>Adiciona o tempo que o aluno ficou online.
	 */
	
	void adicionaTempoOnline(int time) {
		onlineHours += time;
	}
	
	/**
	 * <h3>atingiuMetaTempoOnline
	 * @return boolean - Retorna uma resposta se o aluno atingiu a meta de tempo online ou não.
	 */
	
	boolean atingiuMetaTempoOnline() {
		if (goalHours - onlineHours > 0) {
			return false;
		} else {
			return true;			
		}
	}
	
	/**
	 * <h3>toString
	 * @return String - Retorna uma string com informações da matéria, horas online e da meta de horas.
	 */
	
	@Override
	public String toString() {
		String response;
		response = subject + " " + Integer.valueOf(onlineHours) + "/" + Integer.valueOf(goalHours);
		return response;
	}
}
