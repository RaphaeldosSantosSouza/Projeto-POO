//NOME: Raphael dos Santos Souza - RA: 2565951

public class ConexaoVazioException extends Exception{
    private Leitura l = Leitura.geraLeitura();

    public void impConexaoVazio(){
        System.out.println("\nTipo de conexao nao pode ser vazio!\n");
    }

    public FoneComFio corConexaoVazio(FoneComFio fon){
        try{
            fon.setTipoConexao(l.entDados("CONEXAO.: "));
        } catch (ConexaoVazioException cve){
            cve.impConexaoVazio();
            fon = cve.corConexaoVazio(fon);
        }
        return fon;
    }
}
