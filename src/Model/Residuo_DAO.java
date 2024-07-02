

package Model;

public class Residuo_DAO {
    private int tipo;
    private int quantidade;
    private String localizacao;
    private double peso;
    
     public Residuo_DAO(int tipo, int quantidade, String localizacao, double peso) {
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.localizacao = localizacao;
        this.peso = peso;
    }
     public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }
    
    public double getPeso() {
        return peso;
    }

    public void setTipo(double peso) {
        this.peso = peso;
    }

    //Método para representação do objeto de forma textual
    @Override
    public String toString() {
        return "Tipo: " + tipo + ", Quantidade: " + quantidade + ", Localização: " + localizacao + ",Peso: " +peso;
    }
}

