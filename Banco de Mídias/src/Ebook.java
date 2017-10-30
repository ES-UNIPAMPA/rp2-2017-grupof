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
    String genero;
    String local;
    String editora;
    int numPaginas;

    public Ebook(String genero, String local, String editora, int numPaginas, String CaminhoDoArquivo, String titulo, String descricao, String autores, int ano) {
        super(CaminhoDoArquivo, titulo, descricao, autores, ano);
        this.genero = genero;
        this.local = local;
        this.editora = editora;
        this.numPaginas = numPaginas;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
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

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }
    
    
}
