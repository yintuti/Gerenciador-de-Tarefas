import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GerenciadorDeTarefas gerenciador = new GerenciadorDeTarefas();

        while (true) {
            System.out.println("\n1. Criar");
            System.out.println("2. Listar");
            System.out.println("3. Editar");
            System.out.println("4. Remover");
            System.out.println("5. Concluir Tarefa");
            System.out.println("6. Sair");
            System.out.print("\nEscolha uma opção: ");
            
            int opcao = scanner.nextInt();
            scanner.nextLine();  

            switch (opcao) {
                case 1:
                    while (true) {
                        System.out.println("\n1. Criar Tarefa");
                        System.out.println("2. Criar Categoria");
                        System.out.println("3. Voltar");
                        System.out.print("\nEscolha uma opção: ");

                        int opcaoCriar = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcaoCriar) {
                            case 1:
                                System.out.print("Título: ");
                                String titulo = scanner.nextLine();
                                System.out.print("Descrição: ");
                                String descricaoTarefa = scanner.nextLine();
        
                                if (gerenciador.getCategorias().isEmpty()) {
                                    System.out.println("Nenhuma categoria cadastrada. A tarefa será adicionada sem categoria.");
                                    gerenciador.adicionarTarefa(titulo, descricaoTarefa, null);
                                } else {
                                    System.out.println("\nEscolha uma categoria: ");
                                    gerenciador.listarCategorias();
                                    System.out.print("\nNúmero da categoria: ");
                                    int categoriaIndex = scanner.nextInt() - 1;
                                    scanner.nextLine();
        
                                    gerenciador.adicionarTarefa(titulo, descricaoTarefa, categoriaIndex);
                                }
                                break;
                            case 2:
                                System.out.print("Categoria: ");
                                String categoria = scanner.nextLine();
                                System.out.print("Descrição: ");
                                String descricaoCategoria = scanner.nextLine();
                                gerenciador.adicionarCategoria(categoria, descricaoCategoria);
                                break;
                            case 3:
                                break;
                            default:
                                System.out.println("Opcao inválida.");
                        }
                        if (opcaoCriar == 3) {
                            break;
                        }
                    }
                    continue;
                case 2:
                    while (true) {
                        System.out.println("\n1. Tarefas");
                        System.out.println("2. Categorias");
                        System.out.println("3. Voltar");
                        System.out.print("\nEscolha uma opção: ");

                        int opcaoListar = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcaoListar) {
                            case 1:
                                while (true) {
                                    System.out.println("\n1. Listar todas as tarefas");
                                    System.out.println("2. Listar tarefas concluídas");
                                    System.out.println("3. Listar tarefas não concluídas");
                                    System.out.println("4. Voltar");
                                    System.out.print("\nEscolha uma opção: ");

                                    int opcaoTarefa = scanner.nextInt();
                                    scanner.nextLine();

                                    switch (opcaoTarefa) {
                                        case 1:
                                            System.out.println("\nTarefas: ");
                                            gerenciador.listarTarefas();
                                            break;
                                        case 2:
                                            System.out.println("\nTarefas Concluídas: ");
                                            gerenciador.listarTarefasConcluidas();
                                            break;
                                        case 3:
                                            System.out.println("\nTarefas Não Concluídas: ");
                                            gerenciador.listarTarefasNaoConcluidas();
                                            break;
                                        case 4:
                                            break;
                                        default:
                                            System.out.println("Opção inválida.");
                                    }
                                    if (opcaoTarefa == 4) break;
                                }
                                break;
                            case 2:
                                while (true) {
                                    System.out.println("\n1. Listar Apenas Categorias");
                                    System.out.println("2. Listar Categorias E Suas Tarefas");
                                    System.out.println("3. Voltar");
                                    System.out.print("\nEscolha uma opção: ");

                                    int opcaoCategoria = scanner.nextInt();
                                    scanner.nextLine();

                                    switch (opcaoCategoria) {
                                        case 1:
                                            System.out.println("\nCategorias: ");
                                            gerenciador.listarCategorias();
                                            break;
                                        case 2:
                                            System.out.println("\nCategorias E Suas Tarefas");
                                            gerenciador.listarCategoriaComTarefas();
                                            break;
                                        case 3:
                                            break;
                                        default:
                                            System.out.println("Opção inválida.");
                                    }
                                    if (opcaoCategoria == 3) break;
                                }
                                break;
                            case 3:
                                break;
                            default:
                                System.out.println("Opcao inválida.");
                        }
                        if (opcaoListar == 3) break;
                    }
                    continue;
                case 3:
                    while (true) {
                        System.out.println("\n1. Editar Tarefa");
                        System.out.println("2. Editar Categoria");
                        System.out.println("3. Voltar");
                        System.out.print("\nEscolha uma opção: ");
                        int opcaoEditar = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcaoEditar) {
                            case 1:
                                if (gerenciador.getTarefas().isEmpty()) {
                                    System.out.println("\nNenhuma tarefa para editar.");
                                } else {
                                    System.out.println("\nTarefas: \n");
                                    gerenciador.listarTarefas();
                                    System.out.print("\nNúmero da tarefa para editar: ");
                                    int opcaoEditarTarefa = scanner.nextInt() - 1;
                                    scanner.nextLine();

                                    if (opcaoEditarTarefa < 0 || opcaoEditarTarefa >= gerenciador.getTarefas().size()) {
                                        System.out.println("Índice inválido.");
                                        break;
                                    }

                                    Tarefa tarefaSelecionada = gerenciador.getTarefas().get(opcaoEditarTarefa);
                                    Categoria categoriaAtual = gerenciador.encontrarCategoriaPorTarefa(tarefaSelecionada);

                                    System.out.print("Novo título: ");
                                    String novoTitulo = scanner.nextLine();
                                    System.out.print("Nova descrição: ");
                                    String novaDescricao = scanner.nextLine();

                                    gerenciador.editarTarefa(opcaoEditarTarefa, novoTitulo, novaDescricao);

                                    if (categoriaAtual != null) {
                                        System.out.println("\nEssa tarefa pertence à categoria: " + categoriaAtual.getNome());
                                    } else {
                                        System.out.println("\nEssa tarefa não pertence a nenhuma categoria.");
                                    }

                                    System.out.print("Deseja editar a categoria da tarefa? (S/N): ");
                                    String resposta = scanner.nextLine().trim().toUpperCase();

                                    if (resposta.equals("S")) {
                                        if (gerenciador.getCategorias().isEmpty()) {
                                            System.out.println("Nenhuma categoria disponível para selecionar.");
                                        } else {
                                            System.out.println("\nCategorias disponíveis: ");
                                            gerenciador.listarCategorias();
                                            System.out.print("\nNúmero da nova categoria: ");
                                            int novaCategoriaIndex = scanner.nextInt() - 1;
                                            scanner.nextLine();

                                            if (novaCategoriaIndex >= 0 && novaCategoriaIndex < gerenciador.getCategorias().size()) {
                                                gerenciador.moverTarefaParaCategoria(opcaoEditarTarefa, categoriaAtual, novaCategoriaIndex);
                                                System.out.println("Tarefa movida para a nova categoria.");
                                            } else {
                                                System.out.println("Índice inválido. Categoria não alterada.");
                                            }
                                        }
                                    }
                                }
                                break;
                            case 2:
                                if (gerenciador.getCategorias().isEmpty()) {
                                    System.out.println("\nNenhuma categoria para editar,");
                                } else {
                                    System.out.println("\nCategorias: \n");
                                    gerenciador.listarCategorias();
                                    System.out.print("\nNúmero da categoria para editar: ");
                                    int indiceEditarCategoria = scanner.nextInt() - 1;
                                    scanner.nextLine();
                                    
                                    if (indiceEditarCategoria < 0 || indiceEditarCategoria >= gerenciador.getCategorias().size()) {
                                        System.out.println("Índice inválido.");
                                        break;
                                    }

                                    System.out.print("Novo nome: ");
                                    String novoNome = scanner.nextLine();
                                    System.out.print("Nova Descrição: ");
                                    String novaDescricaoCategoria = scanner.nextLine();

                                    gerenciador.editarCategoria(indiceEditarCategoria, novoNome, novaDescricaoCategoria);
                                }
                                break;
                            case 3:
                                break;
                            default:
                                System.out.println("Opção inválida.");
                        }
                        if (opcaoEditar == 3) break;
                    }
                    continue;
                case 4:
                    while (true) {
                        System.out.println("\n1. Remover Tarefa");
                        System.out.println("2. Remover Categoria");
                        System.out.println("3. Voltar");
                        System.out.print("\nEscolha uma opção: ");
                        int opcaoRemover = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcaoRemover) {
                            case 1:
                                if (gerenciador.getTarefas().isEmpty()) {
                                    System.out.println("\nNenhuma tarefa para remover.");
                                } else {
                                    System.out.println("\nTarefas: \n");
                                    gerenciador.listarTarefas();
                                    System.out.print("\nNúmero da tarefa para remover: ");
                                    int indiceRemoverTarefa = scanner.nextInt() - 1;
                                    gerenciador.removerTarefa(indiceRemoverTarefa);
                                }
                                break;
                            case 2:
                                if (gerenciador.getCategorias().isEmpty()) {
                                    System.out.println("\nNenhuma categoria para remover.");
                                } else {
                                    System.out.println("\nCategorias: \n");
                                    gerenciador.listarCategorias();
                                    System.out.print("\nNúmero da categoria para remover: ");
                                    int indiceRemoverCategoria = scanner.nextInt() - 1;
                                    gerenciador.removerCategoria(indiceRemoverCategoria);
                                }
                                break;
                            case 3:
                                break;
                            default:
                                System.out.println("Opção inválida.");
                        }
                        if (opcaoRemover == 3) break;
                    }
                    continue;
                case 5:
                    System.out.print("Tarefas não concluídas:\n");
                    List<Tarefa> tarefas = gerenciador.getTarefas();
                    boolean encontrouNaoConcluidas = false;

                    for (int i = 0; i < tarefas.size(); i++) {
                        if (!tarefas.get(i).isConcluida()) {
                            System.out.println((i + 1) + ". " + tarefas.get(i));
                            encontrouNaoConcluidas = true;
                        }
                    }

                    if (!encontrouNaoConcluidas) {
                        System.out.println("Nenhuma tarefa pedente.");
                        break;
                    }

                    System.out.print("\nNúmero da tarefa para concluir: ");
                    int indice = scanner.nextInt() - 1;
                    gerenciador.concluirTarefa(indice);
                    break;
                case 6:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}