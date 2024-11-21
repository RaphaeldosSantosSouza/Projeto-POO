//NOME: Raphael dos Santos Souza - RA: 2565951

public class ResolucaoVazioException extends Exception{
    Leitura l = Leitura.geraLeitura();

    public void impResolucaoVazio(){
        System.out.println("\nA resolucao nao pode ser vazia!\n");
    }

    public Televisao corResolucaoVazio(Televisao tv){
        try{
            tv.setResolucao(l.entDados("RESOLUCAO.: "));
        } catch (ResolucaoVazioException rve){
            rve.impResolucaoVazio();
            tv = rve.corResolucaoVazio(tv);
        }
        return tv;
    }
}
