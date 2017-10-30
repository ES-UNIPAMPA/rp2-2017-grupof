/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author roliv
 */
public class Midia {
    String CaminhoDoArquivo;
    String titulo;
    String descricao;
    String autores;
    int ano;

    public Midia(String CaminhoDoArquivo, String titulo, String descricao, String autores, int ano) {
        this.CaminhoDoArquivo = CaminhoDoArquivo;
        this.titulo = titulo;
        this.descricao = descricao;
        this.autores = autores;
        this.ano = ano;
    }

    public String getCaminhoDoArquivo() {
        return CaminhoDoArquivo;
    }

    public void setCaminhoDoArquivo(String CaminhoDoArquivo) {
        this.CaminhoDoArquivo = CaminhoDoArquivo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

}
