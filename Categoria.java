import java.util.ArrayList;
import java.util.List;

public class Categoria {
    private String nome;
    private String descricaoCategoria;
    private List<Tarefa> tarefas;

    public Categoria(String nome, String descricaoCategoria) {
        this.nome = nome;
        this.descricaoCategoria = descricaoCategoria;
        this.tarefas = new ArrayList<>();
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricaoCategoria(String descricaoCategoria) {
        this.descricaoCategoria = descricaoCategoria;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricaoCategoria() {
        return descricaoCategoria;
    }

    public void adicionarTarefa(Tarefa tarefa) {
        tarefas.add(tarefa);
    }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    @Override
    public String toString() {
        return nome + "-" + descricaoCategoria + "(" + tarefas.size() + "tarefas)";
    }
}