//NOME: Raphael dos Santos Souza - RA: 2565951

public class CorVazioException extends Exception{
    private Leitura l = Leitura.geraLeitura();
    
    public void impCorVazioElet(){
        System.out.println("\nCor nao pode ser vazia!\n");
    }

    public Eletronico corCorVazioElet(Eletronico elet){
       try {
            elet.setCor(l.entDados("COR.: "));
        } catch (CorVazioException cvee) {
            cvee.impCorVazioElet();
            elet = cvee.corCorVazioElet(elet);
        } 
        return elet;
    }
}
