/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetoedi_emprestimo;

/**
 *
 * @author Janaina
 */
public class Node {
    private Livro livro;
    private Node filhoE;
    private Node filhoD;
    
    public Node(Livro livro){
        this.livro = livro;
        this.filhoD = null;
        this.filhoE = null;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Node getFilhoE() {
        return filhoE;
    }

    public void setFilhoE(Node filhoE) {
        this.filhoE = filhoE;
    }

    public Node getFilhoD() {
        return filhoD;
    }

    public void setFilhoD(Node filhoD) {
        this.filhoD = filhoD;
    }
    
    
    
}
