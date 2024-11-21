//NOME: Raphael dos Santos Souza - RA: 2565951

public class Principal{
	private static final int tam = 5;
	private static int id = 1, i;
	private static int posImp=0, posFon=0, posTV=0;
	private static Impressora[] vetImp = new Impressora[tam];
	private static FoneComFio[] vetFon = new FoneComFio[tam];
	private static Televisao[] vetTV = new Televisao[tam];
	private static Leitura l = Leitura.geraLeitura();
	private static ValidNumberException vne = ValidNumberException.geraValidNumberException();

	public static void main(String args[]){
		int opc, opcCad, opcApres, eletCad=0;
		boolean continua = true;
		
		while(continua){
			menu();
			opc=opcCad = (int)vne.getValidNumber("\nEscolha uma opcao: ");
			switch (opc) {
				case 1:
					menuCad();
					opcCad = (int)vne.getValidNumber("\nEscolha uma opcao: ");
					if(posImp < tam || posFon < tam || posTV < tam){
						switch (opcCad) {
							case 1:
								if(posImp > tam){
									System.out.println("Nao eh possivel cadastrar impressora, vetor esta cheio!");
									break;
								}
								vetImp[posImp] = new Impressora();
								posImp = cadEletronico(posImp, opcCad);
								break;
							case 2:
								if(posFon > tam){
									System.out.println("Nao eh possivel cadastrar fone, vetor esta cheio!");
									break;
								}
								vetFon[posFon] = new FoneComFio();
								posFon = cadEletronico(posFon, opcCad);
								break;
							case 3:
								if(posTV > tam){
									System.out.println("Nao eh possivel cadastrar televisao, vetor esta cheio!");
									break;
								}
								vetTV[posTV] = new Televisao();
								posTV = cadEletronico(posTV, opcCad);
								break;
						
							default:
								System.out.println("\nOpcao indisponivel! Tente novamente.\n");
								break;
						}
					} else{
						System.out.println("NAO EH POSSIVEL CADASTRAR NENHUM ELETRONICO, VETORES ESTA CHEIOS!");
					}
					break;
				case 2:
					eletCad = posImp + posFon + posTV;
					if(eletCad > 0){
						menuApres();
						opcApres=opcCad = (int)vne.getValidNumber("\nEscolha uma opcao: ");
						switch (opcApres) {
							case 1:
								System.out.println("\n===============================================\n");
								System.out.println("\t                  ELETRONICOS");
								apresElet(posImp, posFon, posTV);
								break;
							case 2:
								if(posImp > 0){ 
									apresElet(posImp,0,0);
								} else{ 
									System.out.println("\nNenhuma impressora cadastrada!\n");
								}
								break;
							case 3:
								if(posFon > 0){
									apresElet(0,posFon,0);
								} else{
									System.out.println("\nNenhum fone cadastrado!\n");
								}
								break;
							case 4:
								if(posTV > 0){
									apresElet(0,0,posTV);
								} else{
									System.out.println("\nNenhuma televisao cadastrada!\n");
								}
								break;
							default:
								System.out.println("\nOpcao indisponivel! Tente novamente.\n");
								break;
						}
					} else{
						System.out.println("===============================================\n");
						System.err.println("Nenhum eletronico cadastrado!\n");
					}
					break;
				case 3:
					procurarCod();
					break;
				case 4:
					alterarElet();
					break;
				case 5:
					excluirElet();
					break;
				case 6:
					System.out.println("\n===============================================\n");
					System.out.println("\t                  TESTAR PRODUTO");
					testaProd(procurarCod());
					break;
				case 0:
					continua = false;
					break;
				default:
					System.out.println("\nOpcao indisponivel! Tente novamente.\n");
					break;
			}
			
		}
		
	}

	public static void menu(){
		System.out.println("===============================================\n");
		System.out.println("\t                  MENU");
		System.out.println("\t1-CADASTRAR");
		System.out.println("\t2-APRESENTAR");
		System.out.println("\t3-PROCURAR POR CODIGO");
		System.out.println("\t4-ALTERAR");
		System.out.println("\t5-EXCLUIR");
		System.out.println("\t6-TESTAR ELETRONICOS");
		System.out.println("\t0-SAIR\n");
		System.out.println("===============================================");
	}

    public static void menuCad(){
		System.out.println("===============================================\n");
		System.out.println("\t                  CADASTRAR");
		System.out.println("\t1-CADASTRAR IMPRESSORA");
		System.out.println("\t2-CADASTRAR FONE DE OUVIDO");
		System.out.println("\t3-CADASTRAR TELEVISAO");
		System.out.println("\t0-SAIR\n");
		System.out.println("===============================================");
	}

	public static void menuApres(){
		System.out.println("===============================================\n");
		System.out.println("\t                  APRESENTAR");
		System.out.println("\t1-APRESENTAR TODOS ELETRONICOS");
		System.out.println("\t2-APRESENTAR IMPRESSORAS");
		System.out.println("\t3-APRESENTAR FONES");
		System.out.println("\t4-APRESENTAR TELEVISOES");
		System.out.println("\t0-SAIR\n");
		System.out.println("===============================================");
	}

	public static int cadEletronico(int ind, int opc){
		Eletronico elet;
		switch (opc) {
			case 1:
				elet = new Impressora();
				break;
			case 2:
				elet = new FoneComFio();
				break;
			case 3:
				elet = new Televisao();
				break;
			default:
				elet=null;//ERRO
		}
		
		elet.setId(id);
		System.out.println("ID.: " + elet.getId());
		
		try{
			elet.getModelo().setNome(l.entDados("MODELO.: "));
		} catch (ModeloVazioEletException move) {
			move.impModeloVazioElet();
			elet = move.corModeloVazioElet(elet);
		}
		try{
			elet.getModelo().setMarca(l.entDados("MARCA.: "));
		}catch (MarcaVazioEletException mave) {
			mave.impMarcaVazioElet();
			elet = mave.corMarcaVazioElet(elet);
		} 
		try{
			elet.setCor(l.entDados("COR.: "));
		} catch (CorVazioException cvee) {
			cvee.impCorVazioElet();
			elet = cvee.corCorVazioElet(elet);
		} 
		try{
			elet.setAno((int)vne.getValidNumber("\nANO: "));
		} catch(AnoFutException afe){
			afe.impAnoFut();
			elet= afe.corAnoFut(elet);
		} catch (AnoAntException aae){
            aae.impAnoAnt();
            elet = aae.corAnoAnt(elet);
        } 
		try{
			elet.setPreco(vne.getValidNumber("\nPRECO: "));
		} catch(PrecoInvalidException pie){
            pie.impPrecoInvalid();
            elet = pie.corPrecoInvalid(elet);
        }
		
		if (opc == 1) {
            vetImp[ind] = new Impressora();
			vetImp[ind] = (Impressora) elet;
			try{
				vetImp[ind].setTipoPapel(l.entDados("TIPO DE PAPEL.: "));
			} catch (TipoPapVazioException tpve){
				tpve.impTipoPapVazio();
				vetImp[ind] = tpve.corTipoPapVazio(vetImp[ind]);
			}
			try{
				vetImp[ind].setResolucao(l.entDados(("RESOLUCAO.: ")));
			} catch (ResolVaziaException rve){
				rve.impResolVazia();
				vetImp[ind] = rve.corResolVazia(vetImp[ind]);
			}
			try{
				vetImp[ind].setMargemPagina(vne.getValidNumber("MARGEM.: "));
			} catch (MargemNegException mne){
				mne.impMargemNeg();
				vetImp[ind] = mne.corMargemNeg(vetImp[ind]);
			}
			try{
				vetImp[ind].setVoltagem((int)vne.getValidNumber("VOLTAGEM.: "));
			} catch(VoltErrException vee){
				vee.impVoltErr();
				vetImp[ind] = vee.corVoltErr(vetImp[ind]);
			}
			
		} else if(opc == 2){
            vetFon[ind] = new FoneComFio();
			vetFon[ind] = (FoneComFio) elet;
			try{
				vetFon[ind].setTipoConexao(l.entDados("CONEXAO.: "));
			} catch (ConexaoVazioException cve){
				cve.impConexaoVazio();
				vetFon[ind] = cve.corConexaoVazio(vetFon[ind]);
			}
			try{
				vetFon[ind].setTipoConcha(l.entDados("CONCHA.: "));
			} catch (ConchaVaziaException chve){
				chve.impConchaVazia();
				vetFon[ind] = chve.corConchaVazia(vetFon[ind]);
			}
			vetFon[ind].setMicrofone(l.entDados("MICROFONE.: "));
			vetFon[ind].setCancelamentoRuido(l.entDados("CANCELAMENTO DE RUIDO.: "));

		} else{
            vetTV[ind] = new Televisao();
			vetTV[ind] = (Televisao) elet;
			try{
				vetTV[ind].setResolucao(l.entDados("RESOLUCAO.: "));
			} catch (ResolucaoVazioException rve){
				rve.impResolucaoVazio();
				vetTV[ind] = rve.corResolucaoVazio(vetTV[ind]);
			}
			try{
				vetTV[ind].setTipoTela(l.entDados("TIPO TELA.: "));
			} catch (TelaVazioException rve){
				rve.impTelaVazio();
				vetTV[ind] = rve.corTelaVazio(vetTV[ind]);
			}
			try{
				vetTV[ind].setConexao(l.entDados("CONEXOES.: "));
			} catch (ConexoesVazioException cxve){
				cxve.impConexoesVazio();
				vetTV[ind] = cxve.corConexoesVazio(vetTV[ind]);
			}
			try {
				vetTV[ind].setPolegadas((int)vne.getValidNumber("POLEGADAS.: "));
			} catch(PolegadasMinException afe){
				afe.impPolegadasMin();
				vetTV[ind]= afe.corPolegadasMin(vetTV[ind]);
			}
		}

		id++;
		ind++;
        return ind;
	}

	public static void apresElet(int posImp, int posFon, int posTV){
		if(posImp > 0){
			System.out.println("\n\t                  IMPRESSORAS");
			for(i = 0; i < posImp; i++){
				System.out.println("\n-----------------------------------------------\n");
				apresImp(vetImp[i]);
			}
		}
		if(posFon > 0){
			System.out.println("\n\t                  FONES");
			for(i = 0; i < posFon; i++){
				System.out.println("\n-----------------------------------------------\n");
				apresFon(vetFon[i]);
			}
		}
		if(posTV > 0){
			System.out.println("\n\t                  TELEVISOES");
			for(i = 0; i < posTV; i++){
				System.out.println("\n-----------------------------------------------\n");
				apresTV(vetTV[i]);
			}
		}

	}

	public static void apresImp(Impressora imp){
		System.out.println("ID: " + imp.getId());
		System.out.println("MODELO: " + imp.getModelo().getNome());
		System.out.println("MARCA: " + imp.getModelo().getMarca());
		System.out.println("COR: " + imp.getCor());
		System.out.println("ANO: " + imp.getAno());
		System.out.printf("PRECO: R$%.2f \n", imp.getPreco());
		System.out.println("TIPO DE PAPEL: " + imp.getTipoPapel());
		System.out.println("RESOLUCAO: " + imp.getResolucao());
		System.out.printf("MARGEM DA PAGINA: %.2fcm \n", imp.getMargemPagina());
		System.out.println("VOLTAGEM: " + imp.getVoltagem() + "v");
		System.out.println();
	}

	public static void apresFon(FoneComFio fon){
		System.out.println("ID: " + fon.getId());
		System.out.println("MODELO: " + fon.getModelo().getNome());
		System.out.println("MARCA: " + fon.getModelo().getMarca());
		System.out.println("COR: " + fon.getCor());
		System.out.println("ANO: " + fon.getAno());
		System.out.printf("PRECO: R$%.2f \n", fon.getPreco());
		System.out.println("CONEXAO: " + fon.getTipoConexao());
		System.out.println("TIPO DA CONCHA: " + fon.getTipoConcha());
		System.out.println("MICROFONE: " + fon.getMicrofone());
		System.out.println("CANCELAMENTO DE RUIDO: " + fon.getCancelamentoRuido());
		System.out.println();
	}

	public static void apresTV(Televisao tv){
		System.out.println("ID: " + tv.getId());
		System.out.println("MODELO: " + tv.getModelo().getNome());
		System.out.println("MARCA: " + tv.getModelo().getMarca());
		System.out.println("COR: " + tv.getCor());
		System.out.println("ANO: " + tv.getAno());
		System.out.printf("PRECO: R$%.2f \n", tv.getPreco());
		System.out.println("RESOLUCAO: " + tv.getResolucao());
		System.out.println("TIPO DA TELA: " + tv.getTipoTela());
		System.out.println("CONEXOES: " + tv.getConexao());
		System.out.printf("POLEGADAS: " + tv.getPolegadas());
		System.out.println();
	}

	public static Eletronico procurarCod(){
		System.out.println("\n===============================================\n");
		System.out.println("\t                  PROCURAR");
		if (posImp != 0 || posFon != 0 || posTV != 0) {
			int cod = (int)vne.getValidNumber("\nEscolha uma opcao: ");
			System.out.println();
			for(i = 0; i < posImp; i++){
				if(cod == vetImp[i].getId()){
					System.out.println("\n-----------------------------------------------\n");
					System.out.println("\t                  IMPRESSORA");
					apresImp(vetImp[i]);
					return vetImp[i];
				}
			}
			for(i = 0; i < posFon; i++){
				if(cod == vetFon[i].getId()){
					System.out.println("\n-----------------------------------------------\n");
					System.out.println("\t                  FONE");
					apresFon(vetFon[i]);
					return vetFon[i];
				}
			}
			for(i = 0; i < posTV; i++){
				if(cod == vetTV[i].getId()){
					System.out.println("\n-----------------------------------------------\n");
					System.out.println("\t                  TELEVISAO");
					apresTV(vetTV[i]);
					return vetTV[i];
				}
			}
			System.out.println("\nEletronico nao encontrado!\n");
		} else {
			System.out.println("\nNenhum eletronico cadastrado!\n");
		}
		return null;
	}

	public static void alterarElet(){
		System.out.println("\n===============================================\n");
		System.out.println("\t                  ALTERAR");
		if (posImp != 0 || posFon != 0 || posTV != 0) {
			Eletronico elet = procurarCod();
			if(elet!=null){
				System.out.println("ID.: " + elet.getId());
				try{
					elet.getModelo().setNome(l.entDados("MODELO.: "));
				} catch (ModeloVazioEletException move) {
					move.impModeloVazioElet();
					elet = move.corModeloVazioElet(elet);
				} 
				try{
					elet.getModelo().setMarca(l.entDados("MARCA.: "));
				}catch (MarcaVazioEletException mave) {
					mave.impMarcaVazioElet();
					elet = mave.corMarcaVazioElet(elet);
				} 
				try{
					elet.setCor(l.entDados("COR.: "));
				} catch (CorVazioException cvee) {
					cvee.impCorVazioElet();
					elet = cvee.corCorVazioElet(elet);
				} 
				try{
					elet.setAno((int)vne.getValidNumber("\nANO: "));
				} catch(AnoFutException afe){
					afe.impAnoFut();
					elet= afe.corAnoFut(elet);
				} catch (AnoAntException aae){
					aae.impAnoAnt();
					elet = aae.corAnoAnt(elet);
				} try{
					elet.setPreco(vne.getValidNumber("\nPRECO: "));
				} catch(PrecoInvalidException pie){
					pie.impPrecoInvalid();
					elet = pie.corPrecoInvalid(elet);
				}
				
				if (elet instanceof Impressora) {
					Impressora imp = (Impressora) elet;
					imp = (Impressora) imp;
					try{
						imp.setTipoPapel(l.entDados("TIPO DE PAPEL.: "));
					} catch (TipoPapVazioException tpve){
						tpve.impTipoPapVazio();
						imp = tpve.corTipoPapVazio(imp);
					}
					try{
						imp.setResolucao(l.entDados("RESOLUCAO.: "));
					} catch (ResolVaziaException rve){
						rve.impResolVazia();
						imp = rve.corResolVazia(imp);
					}
					try{
						imp.setMargemPagina(vne.getValidNumber("MARGEM.: "));
					} catch (MargemNegException mne){
						mne.impMargemNeg();
						imp = mne.corMargemNeg(imp);
					}
					try{
						imp.setVoltagem((int)vne.getValidNumber("VOLTAGEM.: "));
					} catch(VoltErrException vee){
						vee.impVoltErr();
						imp = vee.corVoltErr(imp);
					}
					
				} else if(elet instanceof FoneComFio){
					FoneComFio fon = (FoneComFio) elet;
					fon = (FoneComFio) elet;
					try{
						fon.setTipoConexao(l.entDados("CONEXAO.: "));
					} catch (ConexaoVazioException cve){
						cve.impConexaoVazio();
						fon = cve.corConexaoVazio(fon);
					}
					try{
						fon.setTipoConcha(l.entDados("CONCHA.: "));
					} catch (ConchaVaziaException chve){
						chve.impConchaVazia();
						fon = chve.corConchaVazia(fon);
					}
					fon.setMicrofone(l.entDados("MICROFONE.: "));
					fon.setCancelamentoRuido(l.entDados("CANCELAMENTO DE RUIDO.: "));
				} else{
					Televisao tv = (Televisao) elet;
					tv = (Televisao) elet;
					try{
						tv.setResolucao(l.entDados("RESOLUCAO.: "));
					} catch (ResolucaoVazioException rve){
						rve.impResolucaoVazio();
						tv = rve.corResolucaoVazio(tv);
					}
					try{
						tv.setTipoTela(l.entDados("TIPO TELA.: "));
					} catch (TelaVazioException rve){
						rve.impTelaVazio();
						tv = rve.corTelaVazio(tv);
					}
					try{
						tv.setConexao(l.entDados("CONEXOES.: "));
					} catch (ConexoesVazioException cxve){
						cxve.impConexoesVazio();
						tv = cxve.corConexoesVazio(tv);
					}
					try {
						tv.setPolegadas((int)vne.getValidNumber("POLEGADAS.: "));
					} catch(PolegadasMinException afe){
						afe.impPolegadasMin();
						tv= afe.corPolegadasMin(tv);
					}
				}
			} else{
				System.out.println("\nEletronico nao encontrado");
			}
			
		} else {
			System.out.println("\nNenhum eletronico cadastrado!\n");
		}

	}

	public static void excluirElet(){
		System.out.println("\n===============================================\n");
		System.out.println("\t                  EXCLUIR");
		if (posImp != 0 || posFon != 0 || posTV != 0) {
			int cod = (int)vne.getValidNumber("\nDigite o codigo: ");
			int j;
			for(i = 0; i < posImp; i++){
				if(cod == vetImp[i].getId()){
					vetImp[i] = null;
					for(j = i; j < posImp - 1; j++){
						vetImp[j] = vetImp[j + 1];
					}
					posImp--;
					vetImp[posImp] = null;
					System.out.println("\nImpressora excluida com sucesso!\n");
				}
			}
			for(i = 0; i < posFon; i++){
				if(cod == vetFon[i].getId()){
					vetFon[i] = null;
					for(j = i; j < posFon - 1; j++){
						vetFon[j] = vetFon[j + 1];
					}
					posFon--;
					vetFon[posFon] = null;
					System.out.println("\nFone excluido com sucesso!\n");
				}
			}
			for(i = 0; i < posTV; i++){
				if(cod == vetTV[i].getId()){
					vetTV[i] = null;
					for(j = i; j < posTV - 1; j++){
						vetTV[j] = vetTV[j + 1];
					}
					posTV--;
					vetTV[posTV] = null;
					System.out.println("\nTelevisao excluida com sucesso!\n");
				}
			}
		} else {
			System.out.println("\nNenhum eletronico cadastrado!\n");
		}
	}

	public static void testaProd(Eletronico elet){
		int opc;
		boolean continua = true;
		if(elet!=null){
			while(continua){
				if(elet instanceof Impressora){
					Impressora imp = (Impressora) elet;
					if(!imp.isLigado()){
						System.out.println("\nPara ligar digite 1.");
					} else{
						System.out.println("\nPara conectar digite 2.");
						System.out.println("Para imprimir digite 3.");
						System.out.println("Para desligar digite 4.");
					}
					System.out.println("Para apresentar status digite 5.");
					System.out.println("Para sair digite 0.");
					opc = (int)vne.getValidNumber("\nEscolha uma opcao: ");
					switch (opc) {
						case 1:
							imp.ligar();
							break;
						case 2:
							imp.conectar();
							break;
						case 3:
							imp.imprimirDocumento(l.entDados("\t\nDigite o arquivo para impressao: "));
							break;
						case 4:
							imp.desligar();
							break;
						case 5:
							imp.impDados();
							break;
						case 0:
							continua = false;
							break;
						default:
							System.out.println("\nOpcao indisponivel! Tente novamente.\n");
							break;
					}
				} else if(elet instanceof FoneComFio){
					FoneComFio fon = (FoneComFio) elet;
					
					if(!fon.isConectado()){
						System.out.println("Para conectar digite 1.");
					} else{
						System.out.println("\nPara aumentar o volume digite 2.");
						System.out.println("Para diminuir o volume digite 3.");
						System.out.println("Para desconectar digite 4.");
					}
					System.out.println("Para apresentar status digite 5.");
					System.out.println("Para sair digite 0.");
					opc = (int)vne.getValidNumber("\nEscolha uma opcao: ");
					switch (opc) {
						case 1:
							fon.conectar();
							break;
						case 2:
							fon.aumentarVolume();
							break;

						case 3:
							fon.diminuirVolume();
							break;
						case 4:
							fon.desconectar();
							break;
						case 5:
							fon.impDados();
							break;
						case 0:
							continua = false;
							break;
						default:
							System.out.println("\nOpcao indisponivel! Tente novamente.\n");
							break;
					}
					
				} else{
					Televisao tv = (Televisao) elet;
					
					if(!tv.isLigado()){
						System.out.println("\nPara ligar digite 1.");
					} else{
						System.out.println("\nPara aumentar o volume digite 2.");
						System.out.println("Para diminuir o volume digite 3.");
						System.out.println("Para desligar digite 4.");
					}
					System.out.println("Para apresentar status digite 5.");
					System.out.println("Para sair digite 0.");
					opc = (int)vne.getValidNumber("\nEscolha uma opcao: ");
					switch (opc) {
						case 1:
							tv.ligar();
							break;
						case 2:
							tv.aumentarVolume(5);
							break;
						case 3:
							tv.diminuirVolume();
							break;
						case 4:
							tv.desligar();
							break;
						case 5:
							tv.impDados();
							break;
						case 0:
							continua = false;
							break;
						default:
							System.out.println("\nOpcao indisponivel! Tente novamente.\n");
							break;
					}
					
				}
			}
		} 
	}
}