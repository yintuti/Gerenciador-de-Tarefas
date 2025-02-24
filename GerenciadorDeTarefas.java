import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeTarefas {
    private List<Tarefa> tarefas;
    private List<Categoria> categorias;

    public GerenciadorDeTarefas() {
        this.tarefas = new ArrayList<>();
        this.categorias = new ArrayList<>();
    }

    public void adicionarTarefa(String titulo, String descricao, Integer categoriaIndex) {
        Tarefa novaTarefa = new Tarefa(titulo, descricao);
        tarefas.add(novaTarefa);
        
        if (categoriaIndex != null && categoriaIndex >= 0 && categoriaIndex < categorias.size()) {
            categorias.get(categoriaIndex).adicionarTarefa(novaTarefa);
            System.out.println("Tarefa adicionada à categoria: " + categorias.get(categoriaIndex).getNome());
        } 
    }

    public void adicionarCategoria(String nome, String descricao) {
        categorias.add(new Categoria(nome, descricao));
    }

    public void listarTarefas() {
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada.");
        } else {
            for (int i = 0; i < tarefas.size(); i++) {
                System.out.println((i + 1) + ". " + tarefas.get(i));
            }
        }
    }

    public void listarTarefasConcluidas () {
        boolean encontrou = false;
        for (int i = 0; i < tarefas.size(); i++) {
            if (tarefas.get(i).isConcluida()) {
                System.out.println((i + 1) + ". " + tarefas.get(i));
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nenhuma tarefa concluída.");
        }
    }

    public void listarTarefasNaoConcluidas() {
        boolean encontrou = false;
        for (int i = 0; i < tarefas.size(); i++) {
            if (!tarefas.get(i).isConcluida()) {
                System.out.println((i + 1) + ". " + tarefas.get(i));
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nenhuma tarefa pendente.");
        }
    }

    public void listarCategoriaComTarefas() {
        if (categorias.isEmpty()) {
            System.out.println("Nenhuma categoria cadastrada.");
        } else {
            for (Categoria categoria : categorias) {
                System.out.println("\nCategoria: " + categoria.getNome());
                if (categoria.getTarefas().isEmpty()) {
                    System.out.println("Nenhuma tarefa nesta categoria.");
                } else {
                    for (Tarefa tarefa : categoria.getTarefas()) {
                        System.out.println("  - " + tarefa);
                    }
                }
            }
        }
    }

    public void listarCategorias() {
        if (categorias.isEmpty()) {
            System.out.println("Nenhuma categoria listada.");
        } else {
            for (int i = 0; i < categorias.size(); i++) {
                System.out.println((i + 1) + ". " + categorias.get(i).getNome());
            }
        }
    }

    public void editarTarefa(int indice, String novoTitulo, String novaDescricao) {
        if (indice >= 0 && indice < tarefas.size()) {
            Tarefa tarefa = tarefas.get(indice);
            tarefa.setTitulo(novoTitulo);
            tarefa.setDescricaoTarefa(novaDescricao);
            System.out.println("Tarefa editada com sucesso.");
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public void editarCategoria(int indice, String novoNome, String novaDescricao) {
        if (indice >= 0 && indice < categorias.size()) {
            Categoria categoria = categorias.get(indice);
            categoria.setNome(novoNome);
            categoria.setDescricaoCategoria(novaDescricao);
            System.out.println("Categoria editada com sucesso.");
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public void removerTarefa(int indice) {
        if (indice >= 0 && indice < tarefas.size()) {
            Tarefa tarefaRemovida = tarefas.get(indice);
            tarefas.remove(indice);
            removerTarefaDeCategorias(tarefaRemovida);
            System.out.println("Tarefa removida com sucesso.");
        } else {
            System.out.println("Índice inválido.");
        }
    }

    private void removerTarefaDeCategorias(Tarefa tarefa) {
        for (Categoria categoria : categorias) {
            categoria.getTarefas().remove(tarefa);
        }
    }

    public void removerCategoria(int indice) {
        if (indice >= 0 && indice < categorias.size()) {
            categorias.remove(indice);
            System.out.println("Categoria removida com sucesso.");
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public void concluirTarefa(int indice) {
        if (indice >= 0 && indice < tarefas.size()) {
            tarefas.get(indice).marcarConcluida();
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public Categoria encontrarCategoriaPorTarefa(Tarefa tarefa) {
        for (Categoria categoria : categorias) {
            if (categoria.getTarefas().contains(tarefa)) {
                return categoria;
            }
        }
        return null;
    }

    public void moverTarefaParaCategoria(int indiceTarefa, Categoria categoriaAtual, int novaCategoriaIndex) {
        Tarefa tarefa = tarefas.get(indiceTarefa);

        if (categoriaAtual != null) {
            categoriaAtual.getTarefas().remove(tarefa);
        }

        Categoria novaCategoria = categorias.get(novaCategoriaIndex);
        novaCategoria.adicionarTarefa(tarefa);
    }
}