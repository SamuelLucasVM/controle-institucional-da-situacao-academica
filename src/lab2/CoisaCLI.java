/**
 * <h1>Trabalho LP2 - COISA Cli 
 * @author Samuel Lucas Veira Matos
 * <p>Programa que implementa as funcionalidades do COISA e COISA bonus com interface do usuário.
 */

package lab2;

import java.util.Scanner;

public class CoisaCLI {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int command;	
		System.out.println("\nOlá, voce está no sistema COISA\n"
				+ "\n" + "Para acessar as funcionalidades digite os seguintes comandos:\n"
				+ " - Descanso(1)\n"
				+ " - Disciplina(2)\n"
				+ " - Registro de Resumos(3)\n"
				+ " - Registro de Tempo Online(4)\n"
				+ "(Digite algum desses menus (por numeros) para entrar)\n");
	
		command = sc.nextInt();
		sc.nextLine();

		switch (command){
		case 1:
			MenuDescanso();
			break;
			
		case 2:
			MenuDisciplina();
			break;
			
		case 3:
			MenuRegistroDeResumos();
			break;
			
		case 4:
			MenuRegistroDeTempoOnline();
			break;
			
		default:
			System.out.println("Comando inválido, tente novamente.\n");
		}
		
		System.out.println("Programa Encerrado, obrigado por conferir o COISA!");
		sc.close();
	}	

	private static void MenuDescanso() {
		Scanner sc = new Scanner(System.in);
		
		Descanso descanso = new Descanso();
		
		System.out.println("\n---Descanso---\n"
				+ "As funcionalidades de descanso são:\n"
				+ " - Definir horas de descanso(1)\n"
				+ " - Definir numeros de semanas(2)\n"
				+ " - Exibir status geral(3)\n"
				+ " - Definir emoji de humor(4)\n"
				+ "(Digite algum desses comandos (por números) ou 0 para encerrar o programa!)\n");
		
		boolean exit = false;
		int command;
		while (true) {			
			
			command = sc.nextInt();
			sc.nextLine();
			
			switch (command) {
			case 0:
				exit = true;
				break;
				
			case 1:
				System.out.print("\nDigite o número de horas de descanso: ");
				int hours = sc.nextInt();
				sc.nextLine();
				
				descanso.defineHorasDescanso(hours);
				break;
				
			case 2:
				System.out.print("\nDigite o número de semanas: ");
				int weeks = sc.nextInt();
				sc.nextLine();
				
				descanso.defineNumeroSemanas(weeks);
				break;
				
			case 3:
				System.out.println("\nStatus : " + descanso.getStatusGeral() + "\n");;
				break;
				
			case 4:
				System.out.print("\nRepresente seu humor em um emoji: ");
				String emoji = sc.nextLine();
				
				descanso.definirEmoji(emoji);
				
				System.out.println("\nVocê está " + emoji);
				break;
			
			default:
				System.out.println("\nComando inválido tente novamente\n");
				break;
			
			}
			
			if (exit) {
				sc.close();
				break;
			} else {
				System.out.print("✓\n");	
			}	
		}
	}
	
	private static void MenuDisciplina() {
		Scanner sc = new Scanner(System.in);

		System.out.println("\n---Disciplina---\n"
				+ "Digite o nome da disciplina que você quer registrar!\n");
		
		String summarie = sc.nextLine();
		
		System.out.println("\nAgora digite a quantidade de notas que você irá ter!\n"
				+ "(Escreva 0 se quiser passar a quantidade padrão de notas(4))\n");
		
		int scores = sc.nextInt();
		sc.nextLine();
		
		Disciplina disciplina;
		if (scores != 0) {
			System.out.println("\nAgora digite os pesos das notas separadas por espaço!\n"
					+ "(Escreva 0 se não quiser passar pesos diferentes às notas)\n");
			
			String[] scoreWeightsString = sc.nextLine().split(" ");
			
			if (scoreWeightsString[0].equals("0")) {
				int[] scoreWeights = new int[scores];
				for (int i = 0; i < scores; i++) {
					scoreWeights[i] = Integer.parseInt(scoreWeightsString[i]);
				}				
				disciplina = new Disciplina(summarie, scores, scoreWeights);
			} else {
				disciplina = new Disciplina(summarie, scores);
			}
		} else {
			disciplina = new Disciplina(summarie);
		}
		
		System.out.println("\n---" + summarie + "---\n"
				+ "As funcionalidades de disciplina são: \n\n"
				+ " - Cadastrar horas(1)\n"
				+ " - Cadastrar notas(2)\n"
				+ " - Verificar aprovação(3)\n"
				+ " - Receber informações da disciplina(4)\n"
				+ "\n(Digite algum desses comandos (por números) ou 0 para encerrar o programa!)\n");
		
		int command;
		boolean exit = false;
		while (true) {
			command = sc.nextInt();
			sc.nextLine();
			
			switch (command) {
				case 0:
					exit = true;
					break;
					
				case 1:
					System.out.print("\nDigite o número de horas: ");
					int hours = sc.nextInt();
					sc.nextLine();
					
					disciplina.cadastraHoras(hours);
					break;
					
				case 2:
					System.out.print("\nDigite a qual das suas notas: ");
					int score = sc.nextInt();
					System.out.print("\nDigite a qual o valor da sua nota: ");
					int scoreValue = sc.nextInt();
					sc.nextLine();
					
					disciplina.cadastraNota(score, scoreValue);
					break;
					
				case 3:
					System.out.print("\nSituação de aprovação - " + disciplina.aprovado() + "\n");
					break;
					
				case 4:
					System.out.print("\n" +disciplina + "\n");
					break;
					
				default:
					System.out.println("\nComando inválido tente novamente\n");
					break;	
			}
			
			if (exit) {
				sc.close();
				break;
			} else {
				System.out.print("✓\n");	
			}
		}
	}

	private static void MenuRegistroDeResumos() {
		Scanner sc = new Scanner(System.in);

		System.out.println("---Registro de Resumos---\n "
				+ "Digite a quantidade de resumos que você deseja anotar! \n");
		
		int summariesQuantity = sc.nextInt();

		RegistroResumos meusResumos = new RegistroResumos(summariesQuantity);
		
		System.out.println("\n---Registro de Resumos---\n"
				+ "As funcionalidades de registro de resumos são: \n\n"
				+ " - Adicionar resumo(1)\n"
				+ " - Imprimir resumos(2)\n"
				+ " - Verificar se tem resumos sobre um tema(3)\n"
				+ " - Buscar resumos através de palavras chaves(4)\n"
				+ "\n(Digite algum desses comandos (por números) ou 0 para encerrar o programa!)\n");
		
		int command;
		boolean exit = false;
		while (true) {
			command = sc.nextInt();
			sc.nextLine();
			
			switch (command) {
				case 0:
					exit = true;
					break;
					
				case 1:
					System.out.print("\nDigite o tema do resumo: ");
					String registerTheme = sc.nextLine();
					System.out.print("\nDigite o resumo: ");
					String registerSummarie = sc.nextLine();
					
					meusResumos.adiciona(registerTheme, registerSummarie);
					break;
					
				case 2:
					System.out.println(meusResumos.imprimeResumos());
					break;
					
				case 3:
					System.out.print("\nDigite o tema do resumo: ");
					String findTheme = sc.nextLine();
					
					System.out.println(meusResumos.temResumo(findTheme));
					break;
					
				case 4:
					System.out.print("\nDigite a palavra chave que você deseja buscar: ");
					String key = sc.nextLine();
					
					String[] summaries = meusResumos.busca(key);
					for (String summarie : summaries) {
						if (summarie != "") {
							System.out.println(summarie);
						}
					}
					break;
					
				default:
					System.out.println("\nComando inválido tente novamente\n");
					break;
			}
			
			if (exit) {
				sc.close();
				break;
			} else {
				System.out.print("✓\n");	
			}
		}
	}

	private static void MenuRegistroDeTempoOnline() {
		Scanner sc = new Scanner(System.in);

		System.out.println("\n---Registro de Tempo Online---\n "
				+ "Digite o nome da disciplina que você quer registrar! \n");
		
		String subject = sc.nextLine();
		
		System.out.println("\nAgora digite a quantidade de horas que devem ser realizadas\n"
				+ "para atingir a meta de tempo online!\n"
				+ "(Digite 0 se quiser colocar 120 como quantidade de hora)\n");
		
		int goalHour = sc.nextInt();
		
		RegistroTempoOnline tempoDisciplina = new RegistroTempoOnline(subject, goalHour);

		System.out.println("\n---Registro de Tempo Online(" + subject + ")---\n "
				+ "As funcionalidades de registro de tempo online são: \n\n"
				+ " - Adicionar tempo online(1)\n"
				+ " - Verificar se atingiu a meta(2)\n"
				+ "\n(Digite algum desses comandos (por números) ou 0 para encerrar o programa!)\n");
		
		int command;
		boolean exit = false;
		while (true) {
			command = sc.nextInt();
			sc.nextLine();
			
			switch (command) {
				case 0:
					exit = true;
					break;
					
				case 1:
					System.out.print("\nDigite a quantidade de tempo online que você deseja adicionar: ");
					int hour = sc.nextInt();
					sc.nextLine();
					
					tempoDisciplina.adicionaTempoOnline(hour);
					
					break;
					
				case 2:
					System.out.println(tempoDisciplina.atingiuMetaTempoOnline());
					break;
					
				default:
					System.out.println("\nComando inválido tente novamente\n");
					break;
			}
			
			if (exit) {
				sc.close();
				break;
			} else {
				System.out.print("✓\n");	
			}
		}
	}
}
