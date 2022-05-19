
package projetoedi_emprestimo;

/**
 *
 * @author Janaina
 */
public class Arvore {
    private Livro raiz;

    public Arvore() {
        this.raiz = null;
    }

    public Livro getRaiz() {
        return raiz;
    }

    public void setRaiz(Livro raiz) {
        this.raiz = raiz;
    }
    
    public void inserirNo(Livro livro, Livro root){
            //Livro que estou recebendo é menor que o que está lá
            if(livro.getNome().compareToIgnoreCase(root.getNome()) > 0){
                //Verifica se já tem filho na direita
                if(root.getFilhoD() != null){
                    inserirNo(livro, root.getFilhoD());
                }else{
                    //Não tem filho da direita
                    root.setFilhoD(livro);
                    System.out.println("Livro inserido no filho direito.");
                }
            }else{
                //Livro que estou recebendo é maior que o que está lá
                if(livro.getNome().compareToIgnoreCase(root.getNome()) < 0){
                    //Verifica se já tem filho na esquerda
                    if(root.getFilhoE() != null){
                        inserirNo(livro, root.getFilhoE());
                    }else{
                        root.setFilhoE(livro);
                        System.out.println("Livro inserido no filho esquerdo.");
                    }
                }else{
                    System.out.println("Livro não pode ser inserido, pois já está cadastrado!");
                }
            }
    }
    
    public void exibirLivros(Livro root){
        if(root != null){
            exibirLivros(root.getFilhoE());
            System.out.println(root.getNome());
            exibirLivros(root.getFilhoD());
        }
    }
    
    public void buscar(String nome, Livro root){
        if(root == null){
            System.out.println("Livro não encontrado.");
        }
        else{
            while(!nome.equalsIgnoreCase(root.getNome())){
                
            }
        }
        
    }
    
}
