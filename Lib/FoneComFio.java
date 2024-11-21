//NOME: Raphael dos Santos Souza - RA: 2565951

public class FoneComFio extends Eletronico implements Conectividade, VolumeControl{

	private String tipoConexao;
	private String tipoConcha;
	private String microfone;
	private String cancelamentoRuido;
	private boolean conectado;
    private int volume;

	public FoneComFio(){
		tipoConexao = "";
		tipoConcha = "";
		microfone = "nao";
		cancelamentoRuido = "nao";
		conectado = false;
		volume = 0;
	}

	public void setTipoConexao(String tipoConexao) throws ConexaoVazioException{
		if (tipoConexao.isBlank() || tipoConexao.isEmpty()) {
			throw new ConexaoVazioException();
		} else {
			this.tipoConexao=tipoConexao;
		}
	}

	public void setTipoConcha(String tipoConcha) throws ConchaVaziaException{
		if (tipoConcha.isBlank() || tipoConcha.isEmpty()) {
			throw new ConchaVaziaException();
		} else {
			this.tipoConcha=tipoConcha;
		}
	}

	public void setMicrofone(String microfone){
		this.microfone=microfone;
	}
	
	public void setCancelamentoRuido(String cancelamentoRuido){
		this.cancelamentoRuido=cancelamentoRuido;
	}

	public void setConectado(boolean conectado){
		this.conectado=conectado;
	}

	public void setVolume(int volume){
		this.volume=volume;
	}
	
	public String getTipoConexao(){
		return tipoConexao;
	}

	public String getTipoConcha(){
		return tipoConcha;
	}

	public String getMicrofone(){
		return microfone;
	}

	public String getCancelamentoRuido(){
		return cancelamentoRuido;
	}

	public boolean isConectado(){
		return conectado;
	}

	public int getVolume(){
		return volume;
	}

	public void conectar() {
        if (!conectado) {
            conectado = true;
            System.out.println("\nFone conectado.");
        } else {
            System.out.println("O fone já está conectado.");
        }
    }

    public void desconectar() {
        if (conectado) {
            conectado = false;
            System.out.println("Fone desconectado.\n");
        } else {
            System.out.println("O fone já está desconectado.\n");
        }
    }

    public void aumentarVolume() {
        if (conectado) {
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

    public void diminuirVolume() {
        if (conectado) {
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
        System.out.println("FONE: \nID: " + getId() + "\nNome: " + getModelo().getNome() + "\nConectado: " + conectado + "\nVolume: " + volume);
    }
}