//NOME: Raphael dos Santos Souza - RA: 2565951

public class PolegadasMinException extends Exception{
    private ValidNumberException vne = ValidNumberException.geraValidNumberException();
    
    public void impPolegadasMin(){
        System.out.println("\nO minimo de polegadas de uma TV eh 32 polegadas\n");
    }

    public Televisao corPolegadasMin(Televisao tv){
        try {
            tv.setPolegadas((int)vne.getValidNumber("POLEGADAS.: "));
        } catch(PolegadasMinException afe){
            afe.impPolegadasMin();
            tv= afe.corPolegadasMin(tv);
        }
        return tv;
    }
}
