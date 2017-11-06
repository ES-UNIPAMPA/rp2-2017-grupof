package dominio;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author roliv
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

    public String[] ArraytoString() {
        String[] dados = new String[9];
        dados[0] = this.CaminhoDoArquivo;
        dados[1] = this.titulo;
        dados[2] = this.descricao;
        dados[3] = this.genero;
        dados[4] = this.autores;
        dados[5] = this.idioma;
        dados[6] = this.ano;
        dados[7] = this.duracao;
        dados[8] = this.interpretes;
        return dados;
    }
}
