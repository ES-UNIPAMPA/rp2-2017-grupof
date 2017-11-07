package dominio;

import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author roliv
 */
public abstract class Catalogo {

    protected List<Midia> listaMidias;

    abstract public boolean adicionar(String[] dados);

    abstract public boolean remover(String nome);

    abstract public boolean editar(String[] dados, String tituloOriginal);

    abstract public boolean carregar();

    abstract protected boolean salvar();

    abstract protected Midia buscar(String [] dados, String titulo);
}
