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
            System.out.println("MENU DA LOCADORA");
            System.out.println("1. Adicionar um Jogo");
            System.out.println("2. Listar os Jogos");
            System.out.println("3.Sair");
            System.out.print("Digite a opção desejada: ");
            int opcao = Integer.parseInt(teclado.nextLine());

            if (opcao ==1){
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

            } else if (opcao ==2) {
                for (Jogo c : jogoRepository.findAll()){
                    System.out.println(c.getNome() + "," + c.getDeveloper() + "," + c.getPlataforma() + "," + c.getAno());
                }

            } else if (opcao ==3) {
               break;
            }else {
                System.out.println("Opção Inválida");
            }

            }
        }
        }