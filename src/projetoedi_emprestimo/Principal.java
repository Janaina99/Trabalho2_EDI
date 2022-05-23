/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projetoedi_emprestimo;

import java.util.Scanner;

/**
 *
 * @author Janaina
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        Scanner ler = new Scanner(System.in);
        int op, ano, codigo;
        String nome, autor, cpf;
        Livro l1;
        Node n1;
        Arvore a1 = new Arvore();
        
        do{
            System.out.println("===============================");
            System.out.println("           BEM-VINDO          ");
            System.out.println("===============================");
            System.out.println("    MENU:");
            System.out.println(" 0 - Sair");
            System.out.println(" 1 - Cadastrar livro");
            System.out.println(" 2 - Realizar empréstimo");
            System.out.println(" 3 - Reallizar devolução");
            System.out.println(" 4 - Listar livros");
            System.out.println(" 5 - Buscar livro");
            System.out.println(" 6 - Remover livro");
            System.out.println(" 7 - Listar livros disponíveis");
            System.out.println(" 8 - Listar livros emprestados");
            System.out.println("===============================");
            System.out.println("Digite sua opção:");
            op = ler.nextInt();
            
            switch(op){
                case 0:System.out.println("Encerrando...");
                       break;
                case 1:System.out.println("Informe os dados do livro:");
                       ler.nextLine();
                       System.out.println("Nome:");
                       nome = ler.nextLine();
                       System.out.println("Autor");
                       autor = ler.nextLine();
                       System.out.println("Código:");
                       codigo = ler.nextInt();
                       System.out.println("Ano de publicação:");
                       ano = ler.nextInt();
                       //Instanciando o objeto do tipo Livro e do tipo Node
                       l1 = new Livro(nome, autor, codigo, ano, true);
                       n1 = new Node(l1);
                       //Verifica se a raiz da árvore está nula para ja inserir o nó
                       if(a1.getRaiz()==null){
                           a1.setRaiz(n1);
                           System.out.println("Livro cadastrado.");
                       }else{
                           //Se a raiz não for nula chama a função que insere na posição correta
                           a1.inserirNo(n1, a1.getRaiz());
                       }
                       break;
                case 2:ler.nextLine();
                       System.out.println("Informe o nome do livro:");
                       nome = ler.nextLine();
                       n1 = a1.buscar(nome, a1.getRaiz());
                       if(n1 != null){
                            if(n1.getLivro().isDisponivel()){
                                 n1.getLivro().setDisponivel(false);
                                 System.out.println("Informe o nome da pessoa que deseja realizar o empréstimo:");
                                 nome = ler.nextLine();
                                 System.out.println("Informe o CPF da pessoa que deseja realizar o empréstimo:");
                                 cpf = ler.nextLine();
                                 Pessoa p1 = new Pessoa(nome, cpf);
                                 n1.getLivro().setEmprestado(p1);
                                 System.out.println("Empréstimo realizado:"+n1.getLivro().getNome());
                            }else{
                                System.out.println("Livro não disponível.");
                            }
                       }else{
                            System.out.println("Livro não disponível.");
                       }
                       break;
                case 3:System.out.println("Informe o livro que deseja devolver:");
                       ler.nextLine();
                       nome = ler.nextLine();
                       n1 = a1.buscar(nome, a1.getRaiz());
                       if(n1!=null){
                           System.out.println("Livro emprestado a:" + n1.getLivro().getEmprestado().getNome()); 
                           n1.getLivro().setDisponivel(true);
                           n1.getLivro().setEmprestado(null);
                           System.out.println("Livro devolvido com sucesso.");
                       }else{
                           System.out.println("Livro não encontrado.");
                       }
                       break;
                case 4:System.out.println("====================Livros cadastrados======================");  
                       a1.exibirLivros(a1.getRaiz());
                       break;
                case 5:ler.nextLine();
                       System.out.println("Informe o nome do livro:");
                       nome = ler.nextLine();
                       n1 = a1.buscar(nome, a1.getRaiz());
                       if(n1!=null){
                           System.out.println("Livro encontrado:"+n1.getLivro().getNome());
                       }else{
                           System.out.println("Livro não encontrado");
                       }
                       break;
                case 6:System.out.println("Informe o nome do livro a ser removido:");
                       ler.nextLine();
                       nome = ler.nextLine();
                       n1 = a1.remover(a1.getRaiz(), nome);
                       if(n1==null){
                           System.out.println("Livro removido");
                       }
                       break;
                case 7:System.out.println("===========================Livros disponíveis============================");
                       a1.exibirLivrosDispo(a1.getRaiz());
                       break;
                case 8:System.out.println("==========================Livros indisponíveis==========================");  
                       a1.exibirLivrosIndispo(a1.getRaiz());
                       break;
                default:System.out.println("Opção inválida. Tente novamente!");
                        break;
                                              
            }
        }while(op!=0);
    }
    
}
