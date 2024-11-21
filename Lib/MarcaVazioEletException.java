//NOME: Raphael dos Santos Souza - RA: 2565951

public class MarcaVazioEletException extends Exception{
    private Leitura l = Leitura.geraLeitura();
    
    public void impMarcaVazioElet(){
        System.out.println("\nMarca nao pode ser vazia!\n");
    }

    public Eletronico corMarcaVazioElet(Eletronico elet){
       try {
            elet.getModelo().setMarca(l.entDados("MARCA.: "));
        } catch (MarcaVazioEletException mave) {
            mave.impMarcaVazioElet();
            elet = mave.corMarcaVazioElet(elet);
        }
        return elet;
    }
}
