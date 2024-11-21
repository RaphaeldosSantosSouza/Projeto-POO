//NOME: Raphael dos Santos Souza - RA: 2565951

class ValidNumberException extends Exception{

    private Leitura l = Leitura.geraLeitura();
    private static ValidNumberException vneUnic = new ValidNumberException();

    private ValidNumberException(){}

    public static ValidNumberException geraValidNumberException(){
        if(vneUnic == null){
            vneUnic = new ValidNumberException();
        }
        return vneUnic;
    }

    public double getValidNumber(String frase) {
        String input = l.entDados(frase);

        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida! Por favor, digite um número válido.");
            return getValidNumber(frase);
        }
    }

}
