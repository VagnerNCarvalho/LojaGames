package com.vagnercarvalho.lojagames;

import com.vagnercarvalho.lojagames.entidades.Jogo;
import com.vagnercarvalho.lojagames.repositorios.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class LojaGamesApplication implements CommandLineRunner {
    @Autowired
    private JogoRepository jogoRepository;

    public static void main(String[] args) {
        SpringApplication.run(LojaGamesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner teclado = new Scanner(System.in);

        while (true) {
            System.out.println("#########################################");
            System.out.println("#          SISTEMA LOJA GAMES           #");
            System.out.println("#########################################");
            System.out.println("1. Adicionar um Jogo");
            System.out.println("2. Listar os Jogos");
            System.out.println("3. Atualizar um Jogo");
            System.out.println("4. Excluir um Jogo");
            System.out.println("5. Sair do sistema");
            System.out.println("-----------------------------------------");
            System.out.print("Digite a opção desejada: ");
            int opcao = Integer.parseInt(teclado.nextLine());

            if (opcao == 1) {
                System.out.print("Digite o nome do jogo: ");
                String nome = teclado.nextLine();
                System.out.print("Digite a produtora do jogo: ");
                String developer = teclado.nextLine();
                System.out.print("Digite a plataforma do jogo: ");
                String plataforma = teclado.nextLine();
                System.out.print("Digite o ano do jogo: ");
                String ano = teclado.nextLine();

                Jogo novo = new Jogo();
                novo.setNome(nome);
                novo.setDeveloper(developer);
                novo.setPlataforma(plataforma);
                novo.setAno(ano);

                jogoRepository.save(novo);

            } else if (opcao == 2) {
                System.out.println("Código do jogo | Nome | Produtora | Plataforma | Ano");
                for (Jogo c : jogoRepository.findAll()) {
                    System.out.println(c.getId() + " - " + c.getNome() + ", " + c.getDeveloper() + ", " + c.getPlataforma() + ", " + c.getAno());
                }

            } else if (opcao == 3) {
                System.out.print("Digite o código do jogo que deseja atualizar: ");
                Long id = Long.parseLong(teclado.nextLine());
                if (jogoRepository.existsById(id)) {
                    Jogo jogoParaAtualizar = jogoRepository.findById(id).get();
                    System.out.print("Digite o novo nome do jogo: ");
                    String novoNome = teclado.nextLine();
                    System.out.print("Digite a nova produtora do jogo: ");
                    String novaProdutora = teclado.nextLine();
                    System.out.print("Digite a nova plataforma do jogo: ");
                    String novaPlataforma = teclado.nextLine();
                    System.out.print("Digite o novo ano do jogo: ");
                    String novoAno = teclado.nextLine();

                    jogoParaAtualizar.setNome(novoNome);
                    jogoParaAtualizar.setDeveloper(novaProdutora);
                    jogoParaAtualizar.setPlataforma(novaPlataforma);
                    jogoParaAtualizar.setAno(novoAno);

                    jogoRepository.save(jogoParaAtualizar);
                    System.out.println("Jogo atualizado com sucesso!");
                } else {
                    System.out.println("Jogo não encontrado.");
                }
            } else if (opcao == 4) {
                System.out.print("Digite o código do jogo que deseja excluir: ");
                Long id = Long.parseLong(teclado.nextLine());
                if (jogoRepository.existsById(id)) {
                    jogoRepository.deleteById(id);
                    System.out.println("Jogo excluído com sucesso!");
                } else {
                    System.out.println("Jogo não encontrado.");
                }

            } else if (opcao == 5) {
                break;
            } else {
                System.out.println("Opção Inválida!");
            }
        }
    }
}
