//NOME: Raphael dos Santos Souza - RA: 2565951

public class ResolVaziaException extends Exception{
    Leitura l = Leitura.geraLeitura();

    public void impResolVazia(){
        System.out.println("\nResolucao nao pode ser vazio!\n");
    }

    public Impressora corResolVazia(Impressora imp){
        try{
            imp.setResolucao(l.entDados("RESOLUCAO.: "));
        } catch (ResolVaziaException rve){
            rve.impResolVazia();
            imp = rve.corResolVazia(imp);
        }
        return imp;
    }
}
