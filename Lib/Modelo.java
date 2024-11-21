//NOME: Raphael dos Santos Souza - RA: 2565951

public class Modelo{

	private String nome;
	private String marca;

	public Modelo(){
		nome = "";
		marca = "";
	}

	public void setNome(String nome) throws ModeloVazioEletException {
		if (nome.isBlank() || nome.isEmpty()) {
			throw new ModeloVazioEletException();
		} else {
			this.nome=nome;
		}
	}

	public void setMarca(String marca)throws MarcaVazioEletException {
		if (marca.isBlank() || marca.isEmpty()) {
			throw new MarcaVazioEletException();
		} else {
			this.marca=marca;
		}
	}
	
	public String getNome(){
		return nome;
	}

	public String getMarca(){
		return marca;
	}
}