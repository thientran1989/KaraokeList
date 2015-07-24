package karaokelist.material.com.karaokelist.object;


import android.database.Cursor;

import java.io.Serializable;

public class Obj_bai_hat implements Serializable {
	public int MA_BH;
	public String TEN_BH;
	public String TEN_BH_TK;
	public String CHAR_START;
	public int LOAI_BH;
	public String NGON_NGU;
	public String LOI_RG;
	public String LOI_BH;
	public String TAC_GIA;
	public String TAC_GIA_TK;
	public String LINK;	
	public int VOL;
	public String CA_SY;
	public int YEU_THICH;
	public int SL_XEM;


	public int getMA_BH() {
		return MA_BH;
	}

	public void setMA_BH(int MA_BH) {
		this.MA_BH = MA_BH;
	}

	public String getTEN_BH() {
		return TEN_BH;
	}

	public void setTEN_BH(String TEN_BH) {
		this.TEN_BH = TEN_BH;
	}

	public String getTEN_BH_TK() {
		return TEN_BH_TK;
	}

	public void setTEN_BH_TK(String TEN_BH_TK) {
		this.TEN_BH_TK = TEN_BH_TK;
	}

	public String getCHAR_START() {
		return CHAR_START;
	}

	public void setCHAR_START(String CHAR_START) {
		this.CHAR_START = CHAR_START;
	}

	public int getLOAI_BH() {
		return LOAI_BH;
	}

	public void setLOAI_BH(int LOAI_BH) {
		this.LOAI_BH = LOAI_BH;
	}

	public String getNGON_NGU() {
		return NGON_NGU;
	}

	public void setNGON_NGU(String NGON_NGU) {
		this.NGON_NGU = NGON_NGU;
	}

	public String getLOI_RG() {
		return LOI_RG;
	}

	public void setLOI_RG(String LOI_RG) {
		this.LOI_RG = LOI_RG;
	}

	public String getLOI_BH() {
		return LOI_BH;
	}

	public void setLOI_BH(String LOI_BH) {
		this.LOI_BH = LOI_BH;
	}

	public String getTAC_GIA() {
		return TAC_GIA;
	}

	public void setTAC_GIA(String TAC_GIA) {
		this.TAC_GIA = TAC_GIA;
	}

	public String getTAC_GIA_TK() {
		return TAC_GIA_TK;
	}

	public void setTAC_GIA_TK(String TAC_GIA_TK) {
		this.TAC_GIA_TK = TAC_GIA_TK;
	}

	public String getLINK() {
		return LINK;
	}

	public void setLINK(String LINK) {
		this.LINK = LINK;
	}

	public int getVOL() {
		return VOL;
	}

	public void setVOL(int VOL) {
		this.VOL = VOL;
	}

	public String getCA_SY() {
		return CA_SY;
	}

	public void setCA_SY(String CA_SY) {
		this.CA_SY = CA_SY;
	}

	public int getYEU_THICH() {
		return YEU_THICH;
	}

	public void setYEU_THICH(int YEU_THICH) {
		this.YEU_THICH = YEU_THICH;
	}

	public int getSL_XEM() {
		return SL_XEM;
	}

	public void setSL_XEM(int SL_XEM) {
		this.SL_XEM = SL_XEM;
	}

	public void SET_OBJECT(Cursor cur){
		MA_BH = cur.getInt(cur.getColumnIndex(tag_MA_BH));
		TEN_BH = cur.getString(cur.getColumnIndex(tag_TEN_BH));
		TEN_BH_TK = cur.getString(cur.getColumnIndex(tag_TEN_BH_TK));
		CHAR_START = cur.getString(cur.getColumnIndex(tag_CHAR_START));
		LOAI_BH = cur.getInt(cur.getColumnIndex(tag_LOAI_BH));
		NGON_NGU = cur.getString(cur.getColumnIndex(tag_NGON_NGU));
		LOI_RG = cur.getString(cur.getColumnIndex(tag_LOI_RG));
		LOI_BH = cur.getString(cur.getColumnIndex(tag_LOI_BH));
		TAC_GIA = cur.getString(cur.getColumnIndex(tag_TAC_GIA));
		TAC_GIA_TK = cur.getString(cur.getColumnIndex(tag_TAC_GIA_TK));
		LINK = cur.getString(cur.getColumnIndex(tag_LINK));		
		VOL = cur.getInt(cur.getColumnIndex(tag_VOL));
		CA_SY = cur.getString(cur.getColumnIndex(tag_CA_SY));
		YEU_THICH = cur.getInt(cur.getColumnIndex(tag_YEU_THICH));
		SL_XEM = cur.getInt(cur.getColumnIndex(tag_SL_XEM));
	}
	
	public static final String tag_MA_BH = "ma_bh";
	public static final String tag_TEN_BH = "TEN_BH";
	public static final String tag_TEN_BH_TK = "TEN_BH_TK";
	public static final String tag_CHAR_START = "CHAR_START";
	public static final String tag_LOAI_BH= "LOAI_BH";
	public static final String tag_NGON_NGU = "NGON_NGU";
	public static final String tag_LOI_RG = "LOI_RG";
	public static final String tag_LOI_BH= "LOI_BH";
	public static final String tag_TAC_GIA = "TAC_GIA";
	public static final String tag_TAC_GIA_TK = "TAC_GIA_TK";
	public static final String tag_LINK = "LINK";
	public static final String tag_VOL = "VOL";
	public static final String tag_CA_SY= "CA_SY";
	public static final String tag_YEU_THICH = "YEU_THICH";
	public static final String tag_SL_XEM= "SL_XEM";

}
