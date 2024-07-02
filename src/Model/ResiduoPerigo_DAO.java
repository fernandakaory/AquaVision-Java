
package Model;

// Classe ResiduoPerigo_DAO que estende a classe Residuo_DAO para adicionar informações sobre resíduos perigoso
public class ResiduoPerigo_DAO extends Residuo_DAO {
    private String perigo;

    public ResiduoPerigo_DAO(int tipo, int quantidade, String localizacao, double peso, String perigo) {
        super(tipo, quantidade, localizacao, peso);
        this.perigo = perigo;
    }

    public String getPerigo() {
        return perigo;
    }

    public void setPerigo(String perigo) {
        this.perigo = perigo;
    }
    
    // Método toString sobrescrito para incluir a descrição do perigo na representação textual do objeto
    // Chama o método toString da classe Residuo_DAO e adiciona a descrição do perigo
    @Override
    public String toString() {
        return super.toString() + ", Perigo: " + perigo;
    }
}
