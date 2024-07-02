package Model;

public class Camera_DAO {
    public String imagem;
    public String localizacao;
    
    
    //Método para simular o registro da imagem no sistema
    public void capturarImagem() {
        imagem = "{Imagem}";
        
    }
    
    //Simula o fornecimento da localização
    public void fornecerLocalizacao(){
        localizacao = "{Coordenadas}";
    }
}
