//NOME: Raphael dos Santos Souza - RA: 2565951

public class AnoFutException extends Exception{
    private ValidNumberException vne = ValidNumberException.geraValidNumberException();

    public void impAnoFut(){
        System.out.println("\nAno invalido, esse ano nao existe!\n");
    }

    public Eletronico corAnoFut(Eletronico elet){
        try {
            elet.setAno((int)vne.getValidNumber("\nANO: "));
        } catch(AnoFutException afe){
            afe.impAnoFut();
            elet= afe.corAnoFut(elet);
        } catch (AnoAntException aae){
            aae.impAnoAnt();
            elet = aae.corAnoAnt(elet);
        }
        return elet;
    }
    
}
