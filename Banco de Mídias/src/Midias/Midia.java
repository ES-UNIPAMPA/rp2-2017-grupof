package Midias;

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

    protected String CaminhoDoArquivo;
    protected String titulo;
    protected String genero;
    protected String idioma;
    protected String descricao;
    protected String autores;
    protected String ano;

    public Midia(String CaminhoDoArquivo, String titulo, String genero, String idioma, String descricao, String autores, String ano) {
        this.CaminhoDoArquivo = CaminhoDoArquivo;
        this.titulo = titulo;
        this.genero = genero;
        this.idioma = idioma;
        this.descricao = descricao;
        this.autores = autores;
        this.ano = ano;
    }

    public Midia(String titulo) {
        this.titulo = titulo;
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
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

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    @Override
    public boolean equals(Object o) {
        Midia outraMidia = (Midia) o;
        return this.getTitulo().equals(outraMidia.getTitulo());
    }
    public String toFile(){
        return "";
    }
}
