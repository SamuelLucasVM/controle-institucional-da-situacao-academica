/**
 * <h1>Classe Descanso
 * <l1>Funcionalidades: 
 * <ul>Define horas de descanso;
 * <ul>Define numeros da semana;
 * <ul>Receber status geral;
 * <ul>Definir Emoji;
 */

package lab2;

public class Descanso {
	/**
	  * <l1>Atributos Privados: 
	  * <ul>status : String;
	  * <ul>emoji : String;
	  * <ul>hours : int;
	  * <ul>weeks : int.
	 */
	
	private String status;
	private String emoji;
	private int hours;
	private int weeks;
	
	/**
	 * <h3>Constructor
	 * <p>Quando criado, o objeto descanso define suas horas descansadas como 0 e a quantidade de semanas como 1.
	 */
	
	Descanso() {
		hours = 0;
		weeks = 1;
	}
	
	/**
	 * <h3>defineHorasDescanso
	 * @param hours(int) - Horas em que o aluno descansou.
	 * <p>Define a horas de descanso.
	 */
	
	void defineHorasDescanso(int hours) {
		this.hours = hours;
	}
	
	/**
	 * <h3>defineNumeroSemanas
	 * @param weeks(int) - Semanas passadas desde a criação do objeto.
	 * <p>Define o número de semanas passadas.
	 */
	
	void defineNumeroSemanas(int weeks) {
		this.weeks = weeks;
	}
	
	/**
	 * <h3>defineNumeroSemanas
	 * @return String - Status do usuário como cansado ou descansado contendo (ou não) emoji.
	 */
	
	String getStatusGeral() {
		String response = "";
		VerificaCansado(hours, weeks);
		
		if (emoji == "") {
			response = status;
		} else {
			response = status + " - " + emoji;
		}
		
		return response;
	}
	
	/**
	 * <h3>definirEmoji
	 * @param emoji(String) - emoji que define como o usuário está.
	 * <p>Define um emoji para o estado do usuário.
	 */
	
	void definirEmoji(String emoji) {
		this.emoji = emoji;
	}
	
	private void VerificaCansado(int hours, int weeks) {
		String previousStatus = status;
		if (hours / weeks >= 26) {
			status = "descansado";
		}
		else {
			status = "cansado";
		}
		
		if (previousStatus != status) {
			emoji = "";
		}
	}
}