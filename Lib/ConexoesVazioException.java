//NOME: Raphael dos Santos Souza - RA: 2565951

public class ConexoesVazioException extends Exception{
    private Leitura l = Leitura.geraLeitura();

    public void impConexoesVazio(){
        System.out.println("\nO campo de conexoes deve ser preenchido!\n");
    }

    public Televisao corConexoesVazio(Televisao tv){
        try{
            tv.setConexao(l.entDados("CONEXOES.: "));
        } catch (ConexoesVazioException cxve){
            cxve.impConexoesVazio();
            tv = cxve.corConexoesVazio(tv);
        }
        return tv;
    }
}
