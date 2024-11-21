//NOME: Raphael dos Santos Souza - RA: 2565951

public class ModeloVazioEletException extends Exception{
    private Leitura l = Leitura.geraLeitura();
    
    public void impModeloVazioElet(){
        System.out.println("\nModelo nao pode ser vazio!\n");
    }

    public Eletronico corModeloVazioElet(Eletronico elet){
       try {
            elet.getModelo().setNome(l.entDados("MODELO.: "));
        } catch (ModeloVazioEletException move) {
            move.impModeloVazioElet();
            elet = move.corModeloVazioElet(elet);
        } 
        return elet;
    }
}
