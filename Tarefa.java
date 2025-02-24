public class Tarefa {
    private String titulo;
    private String descricaoTarefa;
    private boolean concluida;

    public Tarefa(String titulo, String descricaoTarefa) {
        this.titulo = titulo;
        this.descricaoTarefa = descricaoTarefa;
        this.concluida = false;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescricaoTarefa(String descricaoTarefa) {
        this.descricaoTarefa = descricaoTarefa;
    }

    public void marcarConcluida() {
        this.concluida = true;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricaoTarefa() {
        return descricaoTarefa;
    }

    public boolean isConcluida() {
        return concluida;
    }

    @Override
    public String toString() {
        return "[ " + (concluida ? "X" : " ") + " ] " + titulo + ": " + descricaoTarefa;
    }
}