/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula06;

/**
 *
 * @author Luiz_
 */
public class Tarefa {
    
    private int id;
    private char status;
    private String titulo;
    private String descricao;
    private Usuario tarefa_usuario;
    
   public Tarefa(int i, String titulo, String descri, Usuario usu) {
        this.id = i;
        this.status = 'N';
        this.tarefa_usuario = usu;
        this.titulo = titulo;
        this.descricao = descri;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
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
    
     @Override
    public String toString() {
        return "Titulo " + this.titulo + " Descricao " + this.descricao + " | Usuario " + this.tarefa_usuario.toString();
    }
    
}
