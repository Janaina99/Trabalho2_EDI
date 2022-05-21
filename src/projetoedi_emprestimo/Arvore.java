
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
            //Livro que estou recebendo é maior que o que está lá
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
                //Livro que estou recebendo é menor que o que está lá
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
            System.out.println(root.getLivro().getNome() + " Disponível:" + root.getLivro().isDisponivel());
            exibirLivros(root.getFilhoD());
        }
    }
    
     public void exibirLivrosDispo(Node root){
        if(root != null){
            if(root.getLivro().isDisponivel()){
                System.out.println(root.getLivro().getNome());
            }
            exibirLivros(root.getFilhoE());
            exibirLivros(root.getFilhoD());
        }
    }
     
     public void exibirLivrosIndispo(Node root){
        if(root != null){
            if(!(root.getLivro().isDisponivel())){
                System.out.println(root.getLivro().getNome());
            }
            exibirLivros(root.getFilhoE());
            exibirLivros(root.getFilhoD());
        }
    }
    
    public Node buscar(String nome, Node root){
        if(root != null){
            if(nome.equalsIgnoreCase(root.getLivro().getNome())){
                return root;
            }else{
                if(nome.compareToIgnoreCase(root.getLivro().getNome()) < 0){
                    return buscar(nome, root.getFilhoE());
                }else{
                    return buscar(nome, root.getFilhoD());
                }
            }
        }
        System.out.println("Livro não encontrado.");
        return null;      
    }
    
    
    public Node remover(Node root, String nome){
        if(root!=null){
            if(root.getLivro().getNome().equalsIgnoreCase(nome)){
                //Remove no folha
                if(root.getFilhoD()==null && root.getFilhoE()==null){
                    return null;                   
                    
                }else{
                    //No com os dois filhos
                    if(root.getFilhoD()!=null && root.getFilhoE()!=null){
                        Node aux = root.getFilhoE();
                        while(aux.getFilhoD()!=null){
                            aux = aux.getFilhoD();
                        }
                        Livro copia = aux.getLivro();
                        aux.setLivro(root.getLivro());
                        root.setLivro(copia);
                        System.out.println("Elemento trocado");
                        root.setFilhoE(remover(root.getFilhoE(), nome));
                        return root;
                    }else{
                        //No com apenas um filho
                        Node aux;
                        if(root.getFilhoE()!=null){
                            aux = root.getFilhoE();                                 
                        }else{
                            aux = root.getFilhoD();
                        }
                        root = null;
                        return aux;
                    }
                }
            }else{
                if(nome.compareToIgnoreCase(root.getLivro().getNome()) < 0){
                    root.setFilhoE(remover(root.getFilhoE(), nome));
                }else{
                    root.setFilhoD(remover(root.getFilhoD(), nome));
                }
                return root;
            }
        }else{
           System.out.println("Livro não encontrado.");
        }
        return null;
    }
}
