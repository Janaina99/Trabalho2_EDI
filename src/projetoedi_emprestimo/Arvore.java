
package projetoedi_emprestimo;

/**
 *
 * @author Janaina
 */
public class Arvore {
    private Node raiz;

    public Arvore() {
        this.raiz = null;
    }

    public Node getRaiz() {
        return raiz;
    }

    public void setRaiz(Node raiz) {
        this.raiz = raiz;
    }
    
    public void inserirNo(Node livro, Node root){
            //Livro que estou recebendo é menor que o que está lá
            if(livro.getLivro().getNome().compareToIgnoreCase(root.getLivro().getNome()) > 0){
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
                if(livro.getLivro().getNome().compareToIgnoreCase(root.getLivro().getNome()) < 0){
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
    
    public void exibirLivros(Node root){
        if(root != null){
            exibirLivros(root.getFilhoE());
            System.out.println(root.getLivro().getNome());
            exibirLivros(root.getFilhoD());
        }
    }
    
    public Node buscar(String nome, Node root){
        if(root == null){
            System.out.println("Livro não encontrado.");
        }
        else{
            while(!nome.equalsIgnoreCase(root.getLivro().getNome())){
                //falta terminar
            }
        }
        return root;
        
    }
    
}
