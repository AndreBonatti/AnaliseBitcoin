package Util;


public class Conversao {

	public static final String ARN = "ARN";
	public static final String B2U = "B2U";
	public static final String BAS = "BAS";
	public static final String BIV = "BIV";
	public static final String BSQ = "BSQ";
	public static final String FLW = "FLW";
	public static final String FOX = "FOX";
	public static final String LOC = "LOC";
	public static final String MBT = "MBT";
	public static final String NEG = "NEG";
	public static final String PAX = "PAX";

	public static String getCorretora(String codigo) {

		switch (codigo.toUpperCase()) {
		case ARN:
			return Corretora_Enum.ARN.getNome();
		case B2U:
			return Corretora_Enum.B2U.getNome();
//		case BAS:
//			return Corretora_Enum.BAS.getNome();
//		case BIV:
//			return Corretora_Enum.BIV.getNome();
//		case BSQ:
//			return Corretora_Enum.BSQ.getNome();
//		case FLW:
//			return Corretora_Enum.FLW.getNome();
		case FOX:
			return Corretora_Enum.FOX.getNome();
		case LOC:
			return Corretora_Enum.LOC.getNome();
		case MBT:
			return Corretora_Enum.MBT.getNome();
		case NEG:
			return Corretora_Enum.NEG.getNome();
//		case PAX:
//			return Corretora_Enum.PAX.getNome();
		default:
			return "Não Catalogado";
		}		
	}

}
