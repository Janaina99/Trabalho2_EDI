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
        String nome, autor;
        Livro l1;
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
                       l1 = new Livro(nome, autor, codigo, ano, true);
                       if(a1.getRaiz()==null){
                           a1.setRaiz(l1);
                           System.out.println("Livro inserido na raiz.");
                       }else{
                           a1.inserirNo(l1, a1.getRaiz());
                       }
                       break;
                case 2:
                       break;
                case 3: 
                       break;
                case 4:a1.exibirLivros(a1.getRaiz());
                       break;
                case 5: 
                       break;
                default:System.out.println("Opção inválida. Tente novamente!");
                        break;
                                              
            }
        }while(op!=0);
    }
    
}
