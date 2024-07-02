package View;
import javax.swing.JOptionPane;

//Exibe o menu de opções e retorna a opção escolhida
public class Menu_GUI {
    public static int escolherOpcao() {
        String x = JOptionPane.showInputDialog(null, "ESCOLHA UMA OPÇÃO: \n1 - Adicionar resíduo\n2 - Analisar resíduo\n3 - Listar resíduos\n4 - Consultar imagens\n5 - Encerrar sistema" );
        int op = Integer.parseInt(x);
        return op;
    }
}
