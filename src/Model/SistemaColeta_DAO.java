package Model;

import javax.swing.JOptionPane;

public class SistemaColeta_DAO {
    private Residuo_DAO[] residuos;
    private int contador = 0;
    
    // Construtor da classe inicializa o vetor de resíduos com 10 posições
    public SistemaColeta_DAO() {
        this.residuos = new Residuo_DAO[10]; // Alocação inicial de espaço para 10 resíduos
    }
    
    // Método para criar e adicionar o novo resíduo não perigoso ao vetor de resíduos.
    //Retorna uma mensagem que indica que o resíduo foi armazenado ou se não há armazenamento suficiente.
    //Sobrecarga
    public String adicionarResiduo(int tipo, int quantidade, String localizacao, double peso) {
        String mensagem = "";
        Residuo_DAO residuo = new Residuo_DAO(tipo, quantidade, localizacao,peso);
         if (contador == residuos.length) {
            mensagem =  "Sem espaço para armazenamento!";
        } else {
            residuos[contador++] = residuo;
            mensagem =  "Resíduo adicionado com sucesso!";
         }
        return mensagem;
    }
    
    // Método para criar e adicionar o novo resíduo perigoso ao vetor de resíduos.
    //Retorna uma mensagem que indica que o resíduo foi armazenado ou se não há armazenamento suficiente.
    //Sobrecarga
    public String adicionarResiduo(int tipo, int quantidade, String localizacao, double peso, String perigo) {
        String mensagem = "";
        ResiduoPerigo_DAO residuo = new ResiduoPerigo_DAO(tipo, quantidade, localizacao, peso, perigo);
         if (contador == residuos.length) {
            mensagem =  "Sem espaço para armazenamento!";
        } else {
            residuos[contador++] = residuo;
            mensagem =  "Resíduo adicionado com sucesso!";
         }
        return mensagem;
    }

    //Método para coletar as informações fornecidas pelo usuário sobre um resíduo novo que está sendo adicionado ao sistema
    //Armazena as informações e chama adicionarResiduo() para a criação do objeto.
    //Verifica o tipo de resíduo inserido para realizar a sobrecarga do método adicionarResiduo()
    public static void adicionarInformacoes(SistemaColeta_DAO sistema) {
        String x = JOptionPane.showInputDialog(null, "Peso do resíduo (kg): " );
        double peso  = Double.parseDouble(x);

        x = JOptionPane.showInputDialog(null, "Quantidade de resíduo: " );
        int quantidade = Integer.parseInt(x);

        String localizacao = JOptionPane.showInputDialog(null, "Localização do resíduo: " );

        x = JOptionPane.showInputDialog(null, "Informe o tipo de resíduo: \n1 - Reciclável\n2 - Não reciclável\n3 - Tóxico" );
        int tipo = Integer.parseInt(x);

        String mensagem = "";
            if (tipo == 3) {
                String perigo = JOptionPane.showInputDialog(null, "Descrição do perigo: ");
                mensagem = sistema.adicionarResiduo(tipo, quantidade, localizacao, peso, perigo);
            } else if (tipo == 1 || tipo == 2) {
                mensagem = sistema.adicionarResiduo(tipo, quantidade, localizacao, peso);
            } else {
                mensagem = "Opção inválida. Digite um número inteiro de 1 a 3.";
            }
            JOptionPane.showMessageDialog(null, mensagem);
    }

    //Método para analisar os residuos existentes no sistema
    //Compara o peso total com os pesos de cada tipo para verificar qual é predominante
    //Exibe mensagem informando qual tipo está predominante
    public void analisarResiduos() {
        double pesoTotal = 0;
        double pesoReciclavel = 0;
        double pesoNaoReciclavel = 0;
        double pesoToxico = 0;
        
        for (int cont = 0; cont < contador; cont++) {
            Residuo_DAO residuo = residuos[cont];
            pesoTotal += residuo.getPeso();
            switch (residuo.getTipo()) {
                case 1:
                    pesoReciclavel += residuo.getPeso();
                    break;
                case 2:
                    pesoNaoReciclavel += residuo.getPeso();
                    break;
                case 3:
                    pesoToxico += residuo.getPeso();
                    break;
                default:
                    break;
            }
        }
	JOptionPane.showMessageDialog(null, "Análise de resíduos:\nPeso total dos resíduos: " + pesoTotal + " kg\nPeso de resíduos recicláveis: " + pesoReciclavel + " kg\nPeso de resíduos não recicláveis: " + pesoNaoReciclavel + " kg\nPeso de resíduos tóxicos: " + pesoToxico + " kg");
        String mensagem = "";
        if (pesoReciclavel > pesoNaoReciclavel && pesoReciclavel > pesoToxico) {
            mensagem = "A maioria dos resíduos é reciclável.";
        } else if (pesoNaoReciclavel > pesoReciclavel && pesoNaoReciclavel > pesoToxico) {
            mensagem = "A maioria dos resíduos é não reciclável.";
        } else if (pesoToxico > pesoReciclavel && pesoToxico > pesoNaoReciclavel) {
            mensagem = "A maioria dos resíduos é tóxico.";
        } else {
            mensagem = "Os resíduos estão bem distribuídos.";
        }
        JOptionPane.showMessageDialog(null, mensagem);
    }

    //Método para listar todos os resíduos armazenados no vetor
    //Retorna uma string com todos os itens
    public String listarResiduos() {
        String total = "Lista de resíduos:\n";
        for (int cont = 0; cont < contador; cont++) {
            total += residuos[cont] + "\n";
        }
        return total;
    }

    //Simula a consulta de imagens capturadas e das localizações fornecidas
    public String consultarImagens(Camera_DAO camera){
        camera.capturarImagem();
        camera.fornecerLocalizacao();
   
        return "Imagem capturada: " + camera.imagem + "\nLocalização da câmera: " + camera.localizacao;
    }
}