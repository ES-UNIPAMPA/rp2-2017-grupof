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
public class Ebook extends Midia {

    private String local;
    private String editora;
    private String numPaginas;

    public Ebook(String CaminhoDoArquivo, String titulo, String descricao, String genero,
            String autores, String idioma, String numPaginas, String editora, String local, String ano) {

        super(CaminhoDoArquivo, titulo, genero, idioma, descricao, autores, ano);
        this.local = local;
        this.editora = editora;
        this.numPaginas = numPaginas;
    }

    public Ebook(String titulo) {
        super(titulo);
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(String numPaginas) {
        this.numPaginas = numPaginas;
    }

    @Override
    public String toString() {
        String dados;
        dados = "Caminho do Arquivo: " + this.CaminhoDoArquivo + "\n" + "Titulo: " + this.titulo + "\n" + "Descrição: " + this.descricao + "\n" + "Genero: " + this.genero + "\n" + "Autores: " + this.autores + "\n" + "Idioma: " + this.idioma + "\n" + "Número de Páginas: " + this.numPaginas + "\n" + "Editora: " + this.editora + "\n" + "Local: " + this.local + "\n" + "Ano: " + this.ano;
        return dados;
    }
    
    @Override
    public String toFile() {
        String dados;
        dados =this.CaminhoDoArquivo + "\n" + this.titulo + "\n" +this.descricao + "\n" + this.genero + "\n" + this.autores + "\n" + this.idioma + "\n" + this.numPaginas + "\n" + this.editora + "\n" + this.local + "\n" + this.ano;
        return dados;
    }
    
    public String[] toArrayString() {
        String[] dados = new String[10];
        dados[0] = this.CaminhoDoArquivo;
        dados[1] = this.titulo;
        dados[2] = this.descricao;
        dados[3] = this.genero;
        dados[4] = this.autores;
        dados[5] = this.idioma;
        dados[6] = this.numPaginas;
        dados[7] = this.editora;
        dados[8] = this.local;
        dados[9] = this.ano;

        return dados;

    }

    //substitui o equals para comparar o titulo dos obj
    @Override
    public boolean equals(Object o) {
        Ebook outroEbook = (Ebook) o;
        return this.getTitulo().equals(outroEbook.getTitulo());
    }

}
