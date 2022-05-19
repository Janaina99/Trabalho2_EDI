
package projetoedi_emprestimo;

/**
 *
 * @author Janaina
 */
public class Livro {
    private String nome;
    private String autor;
    private int codigo;
    private int Ano;
    private boolean disponivel;    
    private Livro filhoD;
    private Livro filhoE;
    
    public Livro(String nome, String autor, int codigo, int Ano, boolean disponivel) {
        this.nome = nome;
        this.autor = autor;
        this.codigo = codigo;
        this.Ano = Ano;
        this.disponivel = disponivel;
        this.filhoD = null;
        this.filhoE = null;
    }

    public Livro getFilhoD() {
        return filhoD;
    }

    public void setFilhoD(Livro filhoD) {
        this.filhoD = filhoD;
    }

    public Livro getFilhoE() {
        return filhoE;
    }

    public void setFilhoE(Livro filhoE) {
        this.filhoE = filhoE;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

     public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAno() {
        return Ano;
    }

    public void setAno(int Ano) {
        this.Ano = Ano;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
    
    
    
}
