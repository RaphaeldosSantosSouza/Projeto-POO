//NOME: Raphael dos Santos Souza - RA: 2565951

public class MargemNegException extends Exception{
    private ValidNumberException vne = ValidNumberException.geraValidNumberException();
    
    public void impMargemNeg(){
        System.out.println("\nA margem nao pode ser negativa!\n");
    }

    public Impressora corMargemNeg(Impressora imp){
        try{
            imp.setMargemPagina(vne.getValidNumber("MARGEM.: "));
        } catch (MargemNegException mne){
            mne.impMargemNeg();
            imp = mne.corMargemNeg(imp);
        }
        return imp;
    }
}
