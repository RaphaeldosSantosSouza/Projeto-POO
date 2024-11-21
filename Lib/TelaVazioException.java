//NOME: Raphael dos Santos Souza - RA: 2565951

public class TelaVazioException extends Exception{
    Leitura l = Leitura.geraLeitura();

    public void impTelaVazio(){
        System.out.println("\nA tela nao pode ser vazia!\n");
    }

    public Televisao corTelaVazio(Televisao tv){
        try{
            tv.setTipoTela(l.entDados("TIPO TELA.: "));
        } catch (TelaVazioException rve){
            rve.impTelaVazio();
            tv = rve.corTelaVazio(tv);
        }
        return tv;
    }
}
