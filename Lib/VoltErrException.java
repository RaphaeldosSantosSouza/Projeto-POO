//NOME: Raphael dos Santos Souza - RA: 2565951

public class VoltErrException extends Exception{
    private ValidNumberException vne = ValidNumberException.geraValidNumberException();
    
    public void impVoltErr(){
        System.out.println("\nVoltagem tem que ser 110 ou 220 volts!\n");
    }

    public Impressora corVoltErr(Impressora imp){
        try{
            imp.setVoltagem((int)vne.getValidNumber("\nVOLTAGEM: "));
        } catch (VoltErrException vee){
            vee.impVoltErr();
            imp = vee.corVoltErr(imp);
        }
        return imp;
    }
}
