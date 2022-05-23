
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
                    System.out.println("Livro cadastrado.");
                }
            }else{
                //Livro que estou recebendo é menor que o que está lá
                if(livro.getLivro().getNome().compareToIgnoreCase(root.getLivro().getNome()) < 0){
                    //Verifica se já tem filho na esquerda
                    if(root.getFilhoE() != null){
                        inserirNo(livro, root.getFilhoE());
                    }else{
                        root.setFilhoE(livro);
                        System.out.println("Livro cadastrado.");
                    }
                }else{
                    System.out.println("Livro não pode ser cadastrado, pois já está cadastrado!");
                }
            }
    }
    //Nesta função usamos o caminhamento in-ordem, assim são exibidos os nomes dos livros em ordem alfabetica
    public void exibirLivros(Node root){
        if(root != null){
            exibirLivros(root.getFilhoE());
            System.out.println("Nome:"+root.getLivro().getNome() + "   Autor:" + root.getLivro().getAutor() + "  Ano:" + root.getLivro().getAno());
            exibirLivros(root.getFilhoD());
        }
    }
    
     public void exibirLivrosDispo(Node root){
        if(root != null){            
            exibirLivrosDispo(root.getFilhoE());
            if(root.getLivro().isDisponivel()){
                System.out.println("Nome:"+root.getLivro().getNome() + "   Autor:" + root.getLivro().getAutor() + "  Ano:" + root.getLivro().getAno());
            }
            exibirLivrosDispo(root.getFilhoD());
        }
    }
     
     public void exibirLivrosIndispo(Node root){
        if(root != null){            
            exibirLivrosIndispo(root.getFilhoE());
            if(!root.getLivro().isDisponivel()){
                System.out.println("Nome:"+root.getLivro().getNome() + "   Autor:" + root.getLivro().getAutor() + "  Ano:" + root.getLivro().getAno());
                System.out.println("Emprestado para:" + root.getLivro().getEmprestado().getNome());
            }
            exibirLivrosIndispo(root.getFilhoD());
        }
    }
    //Função que busca o no com livro de mesmo nome que é recebido
    public Node buscar(String nome, Node root){
        if(root != null){
            //Verifica se é igual, se for retorna o no
            if(nome.equalsIgnoreCase(root.getLivro().getNome())){
                return root;
            }else{
                //Se o nome não for igual verifica se vem antes ou depois
                //Chama a função novamento passando o filho da esquerda ou direita
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
            //Verifica se o no é igual ao que estamos buscando
            if(root.getLivro().getNome().equalsIgnoreCase(nome)){
                //Se for igual, testa se é um nó folha e o remove
                if(root.getFilhoD()==null && root.getFilhoE()==null){
                    return null;                   
                    
                }else{
                    //No com os dois filhos
                    //A partir da subarvore esquerda, percorre pelos filhos direitos até o último
                    if(root.getFilhoD()!=null && root.getFilhoE()!=null){
                        Node aux = root.getFilhoE();
                        while(aux.getFilhoD()!=null){
                            aux = aux.getFilhoD();
                        }
                        //Troca as informações do último nó, com o nó que queremos remover
                        Livro copia = aux.getLivro();
                        aux.setLivro(root.getLivro());
                        root.setLivro(copia);
                        System.out.println("Elemento trocado");
                        //Chama a função novamente passando a raiz da subárvore esquerda, buscando o nó que agora é folha
                        root.setFilhoE(remover(root.getFilhoE(), nome));
                        return root;
                    }else{
                        //No com apenas um filho
                        //O nó auxiliar recebe o nó filho, libera o nó que quer excluir e retorna para o lugar dele o auxiliar
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
                //Se o nome não for igual, verifica se vai percorrer a subarvore direita ou esquerda
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
