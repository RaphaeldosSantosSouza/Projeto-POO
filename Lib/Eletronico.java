//NOME: Raphael dos Santos Souza - RA: 2565951

public abstract class Eletronico{

	private int id;
	private String cor;
	private int ano;
	private double preco;
	private Modelo model;

	public Eletronico(){
		id = 0;
		cor = "";
		ano = 0;
		preco = 0.0;
		model = new Modelo();
	}

	public void setId(int id) {
		this.id=id;
	}

	public void setCor(String cor) throws CorVazioException {
		if (cor.isBlank() || cor.isEmpty()) {
			throw new CorVazioException();
		} else {
			this.cor=cor;
		}
	}

	public void setAno(int ano) throws AnoFutException, AnoAntException{
		if(ano < 1945 || ano > 2024){
			if (ano<1945) {
				throw new AnoAntException();
			} else {
				throw new AnoFutException();
			}
		}
		else{
			this.ano=ano;
		}
	}

	public void setPreco(double preco) throws PrecoInvalidException{
		if (preco <=0) {
			throw new PrecoInvalidException();
		} else {
			this.preco=preco;
		}
	}

	public void setModelo(Modelo model){
		this.model = model;
	}
	
	public int getId(){
		return id;
	}

	public String getCor(){
		return cor;
	}
	
	public int getAno(){
		return ano;
	}

	public double getPreco(){
		return preco;
	}
	
	public Modelo getModelo(){
		return model;
	}

	public abstract void impDados();
		
}