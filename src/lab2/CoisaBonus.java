/**
 * <h1>Trabalho LP2 - COISA - Bonus
 * @author Samuel Lucas Veira Matos
 * <p>Programa que complementa o gerenciamento de status acadêmico do aluno.
 * <li>Funções: 
 * <ul> Cadastrar uma quantidade de notas personalizada e seus pesos - Disciplina;
 * <ul> Buscar resumos por palavras chaves - Registro de Resumos;
 * <ul> Comentar sua rotina de descanso por emoji - Descanso;
 */

package lab2;

public class CoisaBonus {

	public static void main(String[] args) {
		System.out.println("Exercitando novas funcionalidades de Disciplina: \n");
		exercicioDisciplina();
		System.out.println("\n-------------------- \n");
		System.out.println("Exercitando novas funcionalidades de Busca: \n");
		exercicioBusca();
		System.out.println("\n-------------------- \n");
		System.out.println("Exercitando novas funcionalidades de Emotes: \n");
		exercicioEmotes();
	}
	
	private static void exercicioDisciplina() {
		int[] array = {1,2,3};
		Disciplina prog2 = new Disciplina("PROGRAMACAO 2", 3, array);
		
		prog2.cadastraHoras(4);
	    prog2.cadastraNota(1, 5.0);
	    prog2.cadastraNota(2, 6.0);
	    System.out.println(prog2.aprovado());
	    prog2.cadastraNota(3, 10.0);
	    System.out.println(prog2.aprovado());
	    System.out.println(prog2);
	}
	
	private static void exercicioEmotes() {
		Descanso descanso = new Descanso();
		System.out.println(descanso.getStatusGeral());
		descanso.definirEmoji(":/");
		System.out.println(descanso.getStatusGeral());
		descanso.defineHorasDescanso(27);
		System.out.println(descanso.getStatusGeral());
		descanso.definirEmoji("<(^-^<)");
		System.out.println(descanso.getStatusGeral());
		descanso.defineNumeroSemanas(2);
		System.out.println(descanso.getStatusGeral());
	}
	
	private static void exercicioBusca() {
		RegistroResumos meusResumos = new RegistroResumos(100);
		meusResumos.adiciona("Classes", "Classes definem um tipo e a base de código para criação de objetos.");
		meusResumos.adiciona("Tipo", "Identifica a semântica (operações e significados) de um conjunto de dados.");
		
	    String[] resumosFiltrados = meusResumos.busca("Classes");
		for (String resumo : resumosFiltrados) {
			if (!resumo.equals("")) {
				System.out.println(resumo);				
			}
		}
	}
}
