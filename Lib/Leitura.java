//NOME: Raphael dos Santos Souza - RA: 2565951

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Leitura{

	private static Leitura leituraUnic = new Leitura();

	private Leitura(){}

	public static Leitura geraLeitura(){
		if (leituraUnic==null) {
			leituraUnic = new Leitura();
		} 
		return leituraUnic;
	}

	public String entDados(String rotulo){
		System.out.println(rotulo);

		InputStreamReader teclado = new InputStreamReader(System.in);
		BufferedReader buff = new BufferedReader(teclado);

		String ret = "";
		
		try{
			ret = buff.readLine();
		}
		catch(IOException ioe){
			System.out.println("\nERRO");
		}
		return ret;
	}

}