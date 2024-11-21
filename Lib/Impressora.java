//NOME: Raphael dos Santos Souza - RA: 2565951

public class Impressora extends Eletronico implements Imprimir, Conectividade{

	private String tipoPapel;
	private String resolucao;
	private double margemPagina;
	private int voltagem;
	private boolean ligado;
    private boolean conectado;

	public Impressora(){
		tipoPapel = "";
		resolucao = "";
		margemPagina = 0.0;
		voltagem = 0;
		ligado = false;
		conectado = false;
	}

	public void setTipoPapel(String tipoPapel) throws TipoPapVazioException{
        if (tipoPapel.isBlank() || tipoPapel.isEmpty()) {
			throw new TipoPapVazioException();
		} else {
			this.tipoPapel=tipoPapel;
		}
	}

	public void setResolucao(String resolucao) throws ResolVaziaException{
        if (resolucao.isBlank() || resolucao.isEmpty()) {
			throw new ResolVaziaException();
		} else {
			this.resolucao=resolucao;
		}
	}

	public void setMargemPagina(double margemPagina) throws MargemNegException{
        if (margemPagina < 0) {
            throw new MargemNegException();
        } else {
            this.margemPagina=margemPagina;
        }        
	}

	public void setVoltagem(int voltagem) throws VoltErrException{
        if(voltagem == 110 || voltagem == 220) {
		    this.voltagem=voltagem;
        } else{
            throw new VoltErrException();
        }
	}

    public void setLigado(boolean ligado) {
        this.ligado = ligado;
    }

    public void setConectado(boolean conectado) {
        this.conectado = conectado;
    }
	
	public String getTipoPapel(){
		return tipoPapel;
	}

	public String getResolucao(){
		return resolucao;
	}

	public double getMargemPagina(){
		return margemPagina;
	}

	public int getVoltagem(){
		return voltagem;
	}

	public boolean isLigado() {
        return ligado;
    }

	public boolean isConectado() {
        return conectado;
    }

	public void ligar() {
        if (!ligado) {
            ligado = true;
            System.out.println("Impressora ligada.");
        } else {
            System.out.println("A impressora já está ligada.");
        }
    }

    public void desligar() {
        if (ligado) {
            ligado = false;
            System.out.println("Impressora desligada.");
        } else {
            System.out.println("A impressora já está desligada.");
        }
    }

    public void conectar() {
        if (!conectado) {
            conectado = true;
            System.out.println("Impressora conectada.");
        } else {
            System.out.println("A impressora já está conectada.");
        }
    }

    public void desconectar() {
        if (conectado) {
            conectado = false;
            System.out.println("Impressora desconectada.");
        } else {
            System.out.println("A impressora já está desconectada.");
        }
    }

    public void imprimirDocumento(String documento) {
        if (ligado) {
            if (conectado) {
                System.out.println("Imprimindo: " + documento);
            } else {
                System.out.println("Conecte a impressora antes de imprimir.");
            }
        } else {
            System.out.println("Ligue a impressora antes de imprimir.");
        }
    }

	//Metodo sobrescrito
    public void impDados() {
		System.out.println("\n===============================================\n");
		System.out.println("\t                  STATUS");
        System.out.println("IMPRESSORA: \nID: " + getId() + "\nNome: " + getModelo().getNome() + "\nLigado=" + ligado + "\nConectado=" + conectado);
    }
}