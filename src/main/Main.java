package main;

import Model.Camera_DAO;
import Model.SistemaColeta_DAO;
import javax.swing.JOptionPane;


//Recebe a opção escolhida na função escolherOpcao() e chama o método correspondente
public class Main {

    public static void main(String[] args) {
       
        SistemaColeta_DAO sistema = new SistemaColeta_DAO();
        Camera_DAO camera = new Camera_DAO();
        
        int opcao = 0;
        do {
            opcao = View.Menu_GUI.escolherOpcao();
            
            switch (opcao) {
                case 1:
                    sistema.adicionarInformacoes(sistema);
                    break;
                case 2:
                    sistema.analisarResiduos();
                    break;
                case 3:
                    String lista = sistema.listarResiduos();
                    JOptionPane.showMessageDialog(null, lista);
                    break;
                case 4:
                    String mensagem = sistema.consultarImagens(camera);
                    JOptionPane.showMessageDialog(null, mensagem);
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Encerrando sistema...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida! Digite um número inteiro de 1 a 5.");;
            }
        } while(opcao != 5);
    }
    }
