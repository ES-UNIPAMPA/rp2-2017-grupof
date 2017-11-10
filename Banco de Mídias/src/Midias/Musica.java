package Midias;

/**
 *
 * @author Matheus Montanha
 */
public class Musica extends Midia {

    private String interpretes;
    private String duracao;

    public Musica(String CaminhoDoArquivo, String titulo, String genero, String idioma, String descricao, String autores, String ano, String interpretes, String duracao) {
        super(CaminhoDoArquivo, titulo, genero, idioma, descricao, autores, ano);
        this.interpretes = interpretes;
        this.duracao = duracao;
    }

    public Musica(String titulo) {
        super(titulo);
    }

    public String getInterpretes() {
        return interpretes;
    }

    public void setInterpretes(String interpretes) {
        this.interpretes = interpretes;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    @Override
    public String toString() {
        String dados;
        dados = "Caminho do Arquivo: " + this.CaminhoDoArquivo + "\n" + "Titulo: " + this.titulo + "\n" + "Genero: " + this.genero + "\n" + "Idioma: " + this.idioma + "\n" + "Descrição: " + this.descricao + "\n" + "Autores: " + this.autores + "\n" + "Ano: " + this.ano + "\n" + "Interpretes: " + this.interpretes + "\n" + "Duração: " + this.duracao;
        return dados;
    }

    public String[] ArraytoString() {
        String[] dados = new String[9];
        dados[0] = this.CaminhoDoArquivo;
        dados[1] = this.titulo;
        dados[2] = this.genero;
        dados[3] = this.idioma;
        dados[4] = this.descricao;
        dados[5] = this.autores;
        dados[6] = this.ano;
        dados[7] = this.interpretes;
        dados[8] = this.duracao;
        return dados;
    }
}
