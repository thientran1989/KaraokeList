package karaokelist.material.com.karaokelist.object;


import android.database.Cursor;

import karaokelist.material.com.karaokelist.utils.Utils;

public class Obj_yeuthich {
	
	public int id_likephone;
	public int id_likeserver;
	public int ma_baihat;
	public int sync;

	public Obj_yeuthich(int id_likephone, int id_likeserver, int ma_baihat,
			int sync) {
		super();
		this.id_likephone = id_likephone;
		this.id_likeserver = id_likeserver;
		this.ma_baihat = ma_baihat;
		this.sync = sync;
	}
	public Obj_yeuthich(){
		
	}
	public void SET_OBJECT(Cursor cur){
		id_likephone = cur.getInt(cur.getColumnIndex(Utils.id_likephone));
		id_likeserver = cur.getInt(cur.getColumnIndex(Utils.id_likeserver));
		ma_baihat = cur.getInt(cur.getColumnIndex(Utils.ma_baihat));
		sync = cur.getInt(cur.getColumnIndex(Utils.sync));
	}
	
	public int getId_likephone() {
		return id_likephone;
	}
	public void setId_likephone(int id_likephone) {
		this.id_likephone = id_likephone;
	}
	public int getId_likeserver() {
		return id_likeserver;
	}
	public void setId_likeserver(int id_likeserver) {
		this.id_likeserver = id_likeserver;
	}
	public int getMa_baihat() {
		return ma_baihat;
	}
	public void setMa_baihat(int ma_baihat) {
		this.ma_baihat = ma_baihat;
	}
	public int getSync() {
		return sync;
	}
	public void setSync(int sync) {
		this.sync = sync;
	}
	
	

}
