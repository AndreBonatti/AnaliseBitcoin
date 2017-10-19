package Util;


public enum Corretora_Enum {
	
	ARN(Conversao.ARN, "Arena Bitcoin"), 
	B2U(Conversao.B2U, "BitcoinToYou"), 
//	BAS(Conversao.BAS, "Basebit"), 
//	BIV(Conversao.BIV, "Bitinvest"), 
//	BSQ(Conversao.BSQ, "Bitsquare"), 
//	FLW(Conversao.FLW, "flowBTC"), 
	FOX(Conversao.FOX, "FoxBit"), 
	LOC(Conversao.LOC, "LocalBitcoins"), 
	MBT(Conversao.MBT, "Mercado Bitcoin"), 
	NEG(Conversao.NEG, "Negocie Coins"); 
//	PAX(Conversao.PAX, "Paxful");

	private final String codigo;
	private final String nome;
	
	private Corretora_Enum(String codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}

	public final String getCodigo() {
		return codigo;
	}

	public final String getNome() {
		return nome;
	}
}
