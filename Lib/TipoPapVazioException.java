//NOME: Raphael dos Santos Souza - RA: 2565951

public class TipoPapVazioException extends Exception{
    Leitura l = Leitura.geraLeitura();

    public void impTipoPapVazio(){
        System.out.println("\nTipo de papel nao pode ser vazio!\n");
    }

    public Impressora corTipoPapVazio(Impressora imp){
        try{
            imp.setTipoPapel(l.entDados("TIPO DE PAPEL.: "));
        } catch (TipoPapVazioException tpve){
            tpve.impTipoPapVazio();
            imp = tpve.corTipoPapVazio(imp);
        }
        return imp;
    }
}
