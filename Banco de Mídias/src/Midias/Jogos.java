/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Midias;

import java.util.Objects;

/**
 *
 * @author roliv
 */
public class Jogos extends Midia {
    String numJogadores;
    String suporteRede;
    String empresa;

    public Jogos(String CaminhoDoArquivo, String titulo, String genero, String idioma, String descricao,
            String autores, String ano, String numJogadores, String suporteRede, String empresa) {
        
        super(CaminhoDoArquivo, titulo, genero, idioma, descricao, autores, ano);
        this.numJogadores = numJogadores;
        this.suporteRede = suporteRede;
        this.empresa = empresa;
    }
    
    public Jogos(String titulo) {
        super(titulo);
    }

    public String getNumJogadores() {
        return numJogadores;
    }

    public void setNumJogadores(String numJogadores) {
        this.numJogadores = numJogadores;
    }

    public String getSuporteRede() {
        return suporteRede;
    }

    public void setSuporteRede(String suporteRede) {
        this.suporteRede = suporteRede;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
    
    @Override
    public String toString() {
        String dados;
        dados = "1. Caminho do Arquivo: " + this.CaminhoDoArquivo + "\n" + "2. Titulo: " + this.titulo + "\n" + "3. Descrição: " + this.descricao + "\n" + "4. Genero: " + this.genero + "\n" + "5. Autores: " + this.autores + "\n" + "6. Idioma: " + this.idioma + "\n" + "7. Número de Jogadores: " + this.numJogadores + "\n" + "8. Suporte de Rede: " + this.suporteRede + "\n" + "9. Empresa: " + this.empresa + "\n" + "10. Ano: " + this.ano;
        return dados;
    }
    
    @Override
    public String toFile() {
        String dados;
        dados = super.toFile() + "\n" + this.numJogadores + "\n" + this.suporteRede + "\n" + this.empresa;
        return dados;
    }
    
    @Override
    public int compareTo(Midia o) {
        return this.titulo.compareToIgnoreCase(o.getTitulo());
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Jogos other = (Jogos) obj;
        if (!Objects.equals(this.empresa, other.empresa)) {
            return false;
        }
        if (!Objects.equals(this.suporteRede, other.suporteRede)) {
            return false;
        }
        if (!Objects.equals(this.numJogadores, other.numJogadores)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.numJogadores);
        hash = 29 * hash + Objects.hashCode(this.suporteRede);
        hash = 29 * hash + Objects.hashCode(this.empresa);
        return hash;
    }
}
