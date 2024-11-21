//NOME: Raphael dos Santos Souza - RA: 2565951

public class AnoAntException extends Exception{
    private ValidNumberException vne = ValidNumberException.geraValidNumberException();
    
    public void impAnoAnt(){
        System.out.println("\nAno invalido, produtos eletronicos comecaram a serem construidos apos de 1944!\n");
    }

    public Eletronico corAnoAnt(Eletronico elet){
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
