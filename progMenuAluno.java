package EstruturaHeterogenea;

import java.util.Scanner;

public class progMenuAluno {

	public static void menu() {
		Scanner s = new Scanner(System.in);
		System.out.println("=========== Bem-vindo(a) ============");
		System.out.println("Selecione uma opção abaixo: ");
		System.out.println("1 - Cadastrar alunos: ");
		System.out.println("2 - Cadastrar disciplinas: ");
		System.out.println("3 - Sair do sistema: ");

		int opcao = s.nextInt();

		switch (opcao) {
		case 1:
			progMenuAluno.cadastrarAluno();
			break;
		case 2:
			progMenuAluno.cadastrarDisciplinas();
			break;
		case 3:
			progMenuAluno.sairDoSistema();
			break;
		default:
			progMenuAluno.opcaoInvalida();

		}
		s.close();
	}

	private static void opcaoInvalida() {
		Scanner sc = new Scanner(System.in);
		int opcao = 0;
		while (opcao != 1 && opcao != 2 && opcao != 3) {
			System.out.println("Informe uma opção válida: ");
			opcao = sc.nextInt();
		}
		if (opcao == 1) {
			cadastrarAluno();
		} else if (opcao == 2) {
			cadastrarDisciplinas();
		} else if (opcao == 3) {
			sairDoSistema();
		}
		sc.close();

	}

	private static void sairDoSistema() {

		System.out.println("***Obrigada por utilizar nosso sistema!***");

	}

	private static void cadastrarDisciplinas() {

		Scanner sc = new Scanner(System.in);

		Disciplinas[] disc = new Disciplinas[1];
		System.out.println("======CADASTRO DE DISCIPLINAS:====== ");

		for (int i = 0; i < disc.length; i++) {
			disc[i] = new Disciplinas();

			System.out.println("Informe a " + (i + 1) + " º disciplina: ");
			disc[i].d1 = sc.nextLine();
			System.out.println("Informe a " + (i + 2) + " º disciplina: ");
			disc[i].d2 = sc.nextLine();
			System.out.println("Informe a " + (i + 3) + " º disciplina: ");
			disc[i].d3 = sc.nextLine();
			System.out.println("Informe a " + (i + 4) + " º disciplina: ");
			disc[i].d4 = sc.nextLine();
			System.out.println("Existe disciplina opcional? S - sim ou N - não ");
			char y = sc.next().charAt(0);
			if (y == 'S' || y == 's') {
				sc.nextLine();
				for (int j = 0; j < disc[i].dOpc.length; j++) {
					System.out.println("Informe a " + (j + 1) + " º disciplina Opcional");
					disc[i].dOpc[j] = sc.nextLine();
				}

			} else if (y == 'N' || y == 'n') {
				System.out.println("Ok! Disciplinas Opcionais não cadastradas...");

			}
		}
		System.out.println("Deseja imprimir o relatório das disciplinas? Digite '1' - SIM ou '2' - NÃO");
		int rel = sc.nextInt();
		while (rel != 1 && rel != 2) {
			System.out.println("Informe uma opção válida: ");
			rel = sc.nextInt();

		}
		if (rel == 1) {
			for (int i1 = 0; i1 < disc.length; i1++) {
				System.out.println("Disciplina 1 - " + disc[i1].d1);
				System.out.println("Disciplina 2 - " + disc[i1].d2);
				System.out.println("Disciplina 3 - " + disc[i1].d3);
				System.out.println("Disciplina 4 - " + disc[i1].d4);
				for (int i2 = 0; i2 < disc[i1].dOpc.length; i2++) {
					if (disc[i1].dOpc[i2] != null) {
						System.out.println((i2 + 1) + " º Disciplina Opcional: " + disc[i1].dOpc[i2]);
					}
				}
				System.out.println("Deseja retornar ao menu principal? S - SIM ou N - NÃO ");
				char x = sc.next().charAt(0);
				while ((x != 'S' && x != 's') && (x != 'N' && x != 'n')) {
					System.out.println("Informe uma opção válida: ");
					x = sc.next().charAt(0);

				}
				if (x == 'S' || x == 's') {
					progMenuAluno.menu();

				} else if (x == 'N' || x == 'n') {
					sairDoSistema();

				}

			}

		} else if (rel == 2) {
			System.out.println("Relatório não impresso...");
			sairDoSistema();
		}

		sc.close();
	}

	public static void cadastrarAluno() {

		Scanner s = new Scanner(System.in);

		System.out.println("======CADASTRO DE ALUNO======");

		Aluno[] aluno = new Aluno[1];

		for (int j = 0; j < aluno.length; j++) {
			aluno[j] = new Aluno();
			aluno[j].en = new Endereco();
			System.out.println("Informe o nome do aluno: ");
			aluno[j].nome = s.nextLine();
			System.out.println("Informe semestre: ");
			aluno[j].semestre = s.nextByte();
			System.out.println("Informe o número da sala: ");
			aluno[j].sala = s.nextInt();
			System.out.println("Informe o curso: ");
			s.nextLine();
			aluno[j].curso = s.nextLine();
			System.out.println("======ENDEREÇO======");
			System.out.println("Rua: ");
			aluno[j].en.rua = s.nextLine();
			System.out.println("Bairro: ");
			aluno[j].en.bairro = s.nextLine();
			System.out.println("CEP: ");
			aluno[j].en.cep = s.nextInt();
			System.out.println("Cidade: ");
			s.nextLine();
			aluno[j].en.cidade = s.nextLine();
			System.out.println("Estado: ");
			aluno[j].en.estado = s.nextLine();
			System.out.println("======Notas======");
			for (int i = 0; i < aluno[j].notas.length; i++) {
				System.out.println("Digite a  " + (i + 1) + "º nota: ");
				aluno[j].notas[i] = s.nextDouble();
			}

		}
		System.out.println("Deseja imprimir o relatório? Digite '1' - SIM ou '2' - NÃO");
		int rel = s.nextInt();
		while (rel != 1 && rel != 2) {
			System.out.println("Informe o dígito correto:");
			rel = s.nextInt();
		}
		if (rel == 1) {
			for (int j = 0; j < aluno.length; j++) {
				System.out.println("Nome: " + aluno[j].nome);
				System.out.println("Semestre: " + aluno[j].semestre);
				System.out.println("Sala: " + aluno[j].sala);
				System.out.println("Curso: " + aluno[j].curso);
				System.out.println("Rua: " + aluno[j].en.rua);
				System.out.println("Bairro: " + aluno[j].en.bairro);
				System.out.println("CEP: " + aluno[j].en.cep);
				System.out.println("Cidade: " + aluno[j].en.cidade);
				System.out.println("Estado: " + aluno[j].en.estado);
				for (int i = 0; i < aluno[j].notas.length; i++) {
					System.out.println("Nota " + (i + 1) + ": " + aluno[j].notas[i]);
				}

			}

		} else if (rel == 2) {
			System.out.println("Relatório não impresso...");
		}

		System.out.println("Deseja cadastrar mais alunos? Digite '1' - SIM ou '2' - NÃO");
		int n = s.nextInt();
		while (n != 1 && n != 2) {
			System.out.println("Informe uma opção válida:");
			n = s.nextInt();
		}
		if (n == 1) {
			progMenuAluno.cadastrarAluno();

		} else if (n == 2) {
			System.out.println("Deseja retornar ao menu principal? S - SIM ou N - NÃO ");
			char x = s.next().charAt(0);
			if (x == 'S' || x == 's') {
				progMenuAluno.menu();

			} else {
				sairDoSistema();

			}

		}
		s.close();

	}

}
