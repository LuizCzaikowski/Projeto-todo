package aula06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;
/**
 *
 * @author Luiz_
 */
public class Aula06 {

    public static void main(String[] args) throws IOException {
        
        Scanner entrada = new Scanner(System.in);
        BufferedReader entrada2 = new BufferedReader(new InputStreamReader(System.in));
        
        int i, u = 1, t, contU = 0, contT = 0;
        LinkedList<Usuario> usuarios = new LinkedList<>();
        LinkedList<Tarefa> tarefas = new LinkedList<>();
        do {
            System.out.println("Digite conforme as opções abaixo: ");
            System.out.println("CRUD Usuario ( 1 )");
            System.out.println("CRUD Tarefa ( 2 )");

            i = entrada.nextInt();
            switch (i) {
                case 1:
                    do {
                        System.out.println("[1] - Cadastrar Usuario");
                        System.out.println("[2] - Editar Usuario");
                        System.out.println("[3] - Lista de Usuarios");
                        System.out.println("[4] - Excluir Usuario");
                        System.out.println("[0] - Voltar para tele inicial");

                        u = entrada.nextInt();
                        switch (u) {
                            case 1:
                                System.out.println("Insira seu nome, email, e cargo, respectivamente em cada linha!");
                                String nome,
                                 email,
                                 cargo;
                                nome = entrada2.readLine();
                                email = entrada.next();
                                cargo = entrada2.readLine();
                                usuarios.add(new Usuario(contU++, nome, email, cargo));
                                System.out.println(usuarios.getLast());
                                break;
                            case 2:
                                System.out.println("Insira o nome de quem gostaria de editar");
                                for (Usuario cada : usuarios) {
                                    if (cada.getNome().equals(entrada.next())) {
                                        System.out.println("Insira seu nome, email, e cargo, respectivamente para alterar esse usuario: " + cada.getNome());
                                        nome = entrada2.readLine();
                                        email = entrada.next();
                                        cargo = entrada2.readLine();
                                        usuarios.set(cada.getId(), new Usuario(cada.getId(), nome, email, cargo));
                                        System.out.println(usuarios.get(cada.getId()));
                                    }
                                }
                                break;
                            case 3:
                                for (Usuario cada : usuarios) {
                                    System.out.println(cada.toString());
                                }
                                break;
                            case 4:
                                System.out.println("Insira o nome do usuario a ser deletado");
                                String excluir = entrada.next();
                                boolean existe = false;
                                for (Usuario cada : usuarios) {
                                    if (cada.getNome().equals(excluir)) {
                                        System.out.println("Usuario com " + usuarios.remove(cada.getId()) + " foi REMOVIDO");
                                        break;
                                    } else {
                                        existe = true;
                                    }
                                }
                                if (existe) {
                                    System.out.println("Usuario nao encontrado!");
                                }
                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("Insira uma opção válida!");
                                break;
                        }
                    } while (u != 0);
                    break;
                case 2:
                    if (usuarios.isEmpty()) {
                        System.out.println("É necessário criar um usuario primeiro!");
                        break;
                    } else {
                        do {
                            System.out.println("[1] - Inserir Tarefa");
                            System.out.println("[2] - Editar Tarefa");
                            System.out.println("[3] - Listar Tarefas");
                            System.out.println("[4] - Concluir Tarefa");
                            System.out.println("[5] - Excluir Tarefa");
                            System.out.println("[0] - Voltar para tele inicial");

                            t = entrada.nextInt();
                            switch (t) {
                                case 1:
                                    System.out.println("Primeiro, qual usuario essa tarefa esta relacionada?");
                                    for (Usuario cada : usuarios) {
                                        System.out.println(cada.toString());
                                    }
                                    System.out.println("Insira o nome do usuario que deseja relacionar!");
                                    String usu = entrada.next();
                                    boolean existe = false;
                                    for (Usuario cada : usuarios) {
                                        if (cada.getNome().equals(usu)) {

                                            String titulo, descri;
                                            System.out.println("Usuario encontrado!\nSegundo, insira o titulo e descrição da tarefa!");
                                            titulo = entrada2.readLine();
                                            descri = entrada2.readLine();
                                            tarefas.add(new Tarefa(contT++, titulo, descri, cada));
                                            System.out.println(tarefas.getLast());
                                            break;
                                        } else {
                                            existe = true;
                                        }
                                    }
                                    if (existe) {
                                        System.out.println("Usuario não encontrado!");
                                    }
                                    break;
                                case 2:
                                    break;
                                case 3:
                                    for (Tarefa tarefa : tarefas) {
                                        System.out.println(tarefa.toString());
                                    }
                                    break;
                                case 4:
                                    break;
                                case 5:
                                    break;
                                case 0:
                                    break;
                                default:
                                    System.out.println("Insira uma opção valida!");
                                    break;
                            }
                        } while (t != 0);
                        break;
                    }
                default:
                    System.out.println("Insira uma opção valida!");
            }

        } while (true);

    }
    
}
