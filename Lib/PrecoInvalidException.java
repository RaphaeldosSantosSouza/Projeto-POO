//NOME: Raphael dos Santos Souza - RA: 2565951

public class PrecoInvalidException extends Exception{
    private ValidNumberException vne = ValidNumberException.geraValidNumberException();
    
    public void impPrecoInvalid(){
        System.out.println("\nPreco invalido!\n");
    }

    public Eletronico corPrecoInvalid(Eletronico elet){
       try {
            elet.setPreco(vne.getValidNumber("\nPRECO: "));
        } catch(PrecoInvalidException pie){
            pie.impPrecoInvalid();
            elet = pie.corPrecoInvalid(elet);
        }
        return elet;
    }
}
