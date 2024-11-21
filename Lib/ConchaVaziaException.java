//NOME: Raphael dos Santos Souza - RA: 2565951

public class ConchaVaziaException extends Exception{
    private Leitura l = Leitura.geraLeitura();

    public void impConchaVazia(){
        System.out.println("\nTipo de concha nao pode ser vazio!\n");
    }

    public FoneComFio corConchaVazia(FoneComFio fon){
        try{
            fon.setTipoConcha(l.entDados("CONCHA.: "));
        } catch (ConchaVaziaException chve){
            chve.impConchaVazia();
            fon = chve.corConchaVazia(fon);
        }
        return fon;
    }
}
