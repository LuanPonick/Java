package com.Java.Relacionamentos;

import com.Java.Relacionamentos.model.Profesor;
import com.Java.Relacionamentos.repositories.ProfessorRepository;
import com.Java.Relacionamentos.service.DiciplinaService;
import com.Java.Relacionamentos.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class RelacionamentosApplication implements CommandLineRunner {
	@Autowired
	ProfessorService professorService;
	@Autowired
	DiciplinaService diciplinaService;

	public static void main(String[] args) {
		SpringApplication.run(RelacionamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		boolean isTrue = true;

		do {
			System.out.println("Digite :");
			System.out.println("0 sair");
			System.out.println("1 salvar professore");
			System.out.println("2 atualizar professore");
			System.out.println("3 visualizar professores");
			System.out.println("4 apagar by id professores");
			System.out.println("5 salvar Diciplina");
			System.out.println("6 atualizar Diciplina");
			System.out.println("7 visualizar Diciplina");
			System.out.println("8 apagar by id professores");
			int opcao = scanner.nextInt();

			switch (opcao){
				case 0:
					isTrue = false;
				case 1:
					professorService.fazerCadastroProfessor();
					break;
				case 2:
					professorService.atualizarById();
					break;
				case 3:
					professorService.visualizarTodos();
					break;
				case 4:
					professorService.apagarById();
					break;
				case 5:
					diciplinaService.fazerCadastroDiciplina();
					break;
				case 6:
					diciplinaService.atualizarById();
					break;
				case 7:
					diciplinaService.visualizarTodos();
					break;
				case 8:
					diciplinaService.apagarById();
					break;

			}
		}while (isTrue);
	}
}
