//NOME: Raphael dos Santos Souza - RA: 2565951

public class Televisao extends Eletronico implements ControleRemoto, VolumeControl{

	private String resolucao;
	private String tipoTela;
	private String conexao;
	private int polegadas;
	private boolean ligado;
    private int volume;

	public Televisao(){
		resolucao = "";
		tipoTela = "";
		conexao = "";
		polegadas = 0;
		ligado = false;
		volume = 50;
	}

	public void setResolucao(String resolucao) throws ResolucaoVazioException{
		if (resolucao.isBlank() || resolucao.isEmpty()) {
			throw new ResolucaoVazioException();
		} else {
			this.resolucao=resolucao;
		}
	}

	public void setTipoTela(String tipoTela) throws TelaVazioException{
		if (tipoTela.isBlank() || tipoTela.isEmpty()) {
			throw new TelaVazioException();
		} else {
			this.tipoTela=tipoTela;
		}
	}

	public void setConexao(String conexao) throws ConexoesVazioException{
		if (conexao.isBlank() || conexao.isEmpty()) {
			throw new ConexoesVazioException();
		} else {
			this.conexao=conexao;
		}
	}

	public void setPolegadas(int polegadas) throws PolegadasMinException{
		if (polegadas < 32) {
			throw new PolegadasMinException();
		} else {
			this.polegadas=polegadas;
		}
	}

	public void setLigado(boolean ligado){
		this.ligado=ligado;
	}

	public void setVolume(int volume){
		this.volume=volume;
	}

	public String getResolucao(){
		return resolucao;
	}
	
	public String getTipoTela(){
		return tipoTela;
	}

	public String getConexao(){
		return conexao;
	}

	public int getPolegadas(){
		return polegadas;
	}

	public boolean isLigado(){
		return ligado;
	}

	public int getVolume(){
		return volume;
	}

	public void ligar() {
        if (!ligado) {
            ligado = true;
            System.out.println("TV ligada.");
        } else {
            System.out.println("A TV já está ligada.");
        }
    }

    public void desligar() {
        if (ligado) {
            ligado = false;
            System.out.println("TV desligada.");
        } else {
            System.out.println("A TV já está desligada.");
        }
    }

    public void ajustarVolume(int volume) {
        if (ligado) {
            setVolume(volume);
            System.out.println("Volume ajustado para: " + this.volume);
        } else {
            System.out.println("Ligue a TV antes de ajustar o volume.");
        }
    }

	public void aumentarVolume() {
        if (ligado) {
			if(this.volume + 10 <= 100){
				setVolume(this.volume + 10);
           	 	System.out.println("Volume aumentado para: " + this.volume);
			} else{
				System.out.println("Volume está no máximo!");
			}
            
        } else {
            System.out.println("Conecte o fone antes de ajustar o volume!");
        }
    }

	//Metodo sobrecarregado
	public void aumentarVolume(int incremento) {
        if (ligado) {
            setVolume(this.volume + incremento);
            System.out.println("\nVolume aumentado em " + incremento + " unidades, agora o volume é: " + this.volume);
        } else {
            System.out.println("Ligue a TV antes de ajustar o volume.");
        }
    }

    public void diminuirVolume() {
        if (ligado) {
			if(this.volume - 10 >= 0){
				setVolume(this.volume - 10);
				System.out.println("Volume diminuído para: " + this.volume);
			} else{
				System.out.println("Volume já está no mínimo!");
			}
        } else {
            System.out.println("Conecte o fone antes de ajustar o volume.");
        }
    }

	//Metodo sobrescrito
	public void impDados() {
		System.out.println("\n===============================================\n");
		System.out.println("\t                  STATUS");
        System.out.println("TELEVISAO: \nID: " + getId() + "\nNome: " + getModelo().getNome() + "\nLigado: " + ligado + "\nVolume: " + volume);
    }

}