package karaokelist.material.com.karaokelist.database;

import java.io.IOException; 
import java.util.ArrayList;
import java.util.List;


import android.content.ContentValues;
import android.content.Context; 
import android.database.Cursor; 
import android.database.SQLException; 
import android.database.sqlite.SQLiteDatabase; 
import android.util.Log;

import karaokelist.material.com.karaokelist.object.Obj_bai_hat;
import karaokelist.material.com.karaokelist.object.Obj_yeuthich;
import karaokelist.material.com.karaokelist.utils.Utils;

public class TestAdapter  
{ 
    protected static final String TAG = "DataAdapter"; 
 
    private final Context mContext; 
    private static SQLiteDatabase mDb; 
    private DataBaseHelper mDbHelper; 
 
    public TestAdapter(Context context)  
    { 
        this.mContext = context; 
        mDbHelper = new DataBaseHelper(mContext); 
    } 
 
    public TestAdapter createDatabase() throws SQLException  
    { 
        try  
        { 
            mDbHelper.createDataBase(); 
        }  
        catch (IOException mIOException)  
        { 
            Log.e(TAG, mIOException.toString() + "  UnableToCreateDatabase"); 
            throw new Error("UnableToCreateDatabase"); 
        } 
        return this; 
    } 
 
    public TestAdapter open() throws SQLException  
    { 
        try  
        { 
            mDbHelper.openDataBase(); 
            mDbHelper.close(); 
            mDb = mDbHelper.getReadableDatabase(); 
        }  
        catch (SQLException mSQLException)  
        { 
            Log.e(TAG, "open >>"+ mSQLException.toString()); 
            throw mSQLException; 
        } 
        return this; 
    } 
 
    public void close()  
    { 
        mDbHelper.close(); 
    } 
 
    
    // insert
	public static long Insert_BAI_HAT(Obj_bai_hat BH) {
		ContentValues initVal = new ContentValues();
		initVal.put("MA_BH", BH.MA_BH);
		initVal.put("TEN_BH", BH.TEN_BH);
		initVal.put("LOI_BH", BH.LOI_BH);
		initVal.put("CA_SY", BH.CA_SY);
		return mDb.insert(Utils.TABLE_BAIHAT, null, initVal);
	}
	// object
	public Obj_bai_hat get_BAI_HAT(long MA_BH) {
		Cursor c = mDb.rawQuery("SELECT * FROM "+Utils.TABLE_BAIHAT+" WHERE "+Obj_bai_hat.tag_MA_BH+" = "+  MA_BH,
				null);
			c.moveToFirst();
			Obj_bai_hat MTT=new Obj_bai_hat();
			MTT.SET_OBJECT(c);	
			return MTT;
	}
//	public int get_SL_BH() {
//		Cursor c = null;	
//		c = mDb.rawQuery("SELECT COUNT (*) FROM BAI_HAT",null);
//		c.moveToFirst();
//		int count = c.getInt(0);
//		return count;
//	}

//	public List<Obj_bai_hat> get_ALL_BAI_HAT(int LOAI_BH) {
//		Cursor c = null;
//		c = mDb.rawQuery("SELECT * FROM "+Utils.TABLE_BAIHAT+" where "+Utils.LOAI_BH +" = "+LOAI_BH+" and "+Utils.MA_BH+" <50100 ORDER BY "+Utils.TEN_BH+" ASC", null);		
//		c.moveToFirst();
//		List<Obj_bai_hat> arr_BAI_HAT=new ArrayList<Obj_bai_hat>();
//		while (!c.isAfterLast()) {
//			Obj_bai_hat BH=new Obj_bai_hat();
//			BH.SET_OBJECT(c);
//			arr_BAI_HAT.add(BH);
//			c.moveToNext();
//		}
//		c.close();
//		return arr_BAI_HAT;
//	}
//	public List<Obj_bai_hat> get_more_bai_hat(int LOAI_BH,int start,int end) {
//		Cursor c = null;
//		c = mDb.rawQuery("SELECT * FROM "+Utils.TABLE_BAIHAT+" where "+Utils.LOAI_BH +" = "+LOAI_BH+" and "+Utils.MA_BH+" > "+start+" and "+Utils.MA_BH+" <= "+end+" ORDER BY "+Utils.MA_BH+" ASC", null);		
//		c.moveToFirst();
//		List<Obj_bai_hat> arr_BAI_HAT=new ArrayList<Obj_bai_hat>();
//		while (!c.isAfterLast()) {
//			Obj_bai_hat BH=new Obj_bai_hat();
//			BH.SET_OBJECT(c);
//			arr_BAI_HAT.add(BH);
//			c.moveToNext();
//		}
//		c.close();
//		return arr_BAI_HAT;
//	}
	public List<Obj_bai_hat> get_more_bai_hat(int LOAI_BH,int start,int row_num) {
		Cursor c = null;
		c = mDb.rawQuery("SELECT * FROM "+Utils.TABLE_BAIHAT+" where "+Obj_bai_hat.tag_LOAI_BH +
				" = "+LOAI_BH+" and NGON_NGU = 'vn' ORDER BY "+Obj_bai_hat.tag_TEN_BH+" ASC LIMIT "+
				row_num+" OFFSET "+start, null);		
		c.moveToFirst();
		List<Obj_bai_hat> arr_BAI_HAT=new ArrayList<Obj_bai_hat>();
		while (!c.isAfterLast()) {
			Obj_bai_hat BH=new Obj_bai_hat();
			BH.SET_OBJECT(c);
			arr_BAI_HAT.add(BH);
			c.moveToNext();
		}
		c.close();
		return arr_BAI_HAT;
	}
	public List<Obj_bai_hat> get_search_bai_hat(int LOAI_BH,String key) {
		Cursor c = null;
		c = mDb.rawQuery("SELECT * FROM "+Utils.TABLE_BAIHAT+" where "+Obj_bai_hat.tag_LOAI_BH +
				" = "+LOAI_BH+" and NGON_NGU = 'vn' and TEN_BH_TK like '%"+key+"%' ORDER BY "+Obj_bai_hat.tag_TEN_BH+" ASC", null);		
		c.moveToFirst();
		List<Obj_bai_hat> arr_BAI_HAT=new ArrayList<Obj_bai_hat>();
		while (!c.isAfterLast()) {
			Obj_bai_hat BH=new Obj_bai_hat();
			BH.SET_OBJECT(c);
			arr_BAI_HAT.add(BH);
			c.moveToNext();
		}
		c.close();
		return arr_BAI_HAT;
	}
	
	public List<Obj_bai_hat> get_ALL_BH_VN() {
		Cursor c = null;
		c = mDb.rawQuery("SELECT * FROM "+Utils.TABLE_BAIHAT+" where "+Obj_bai_hat.tag_LOAI_BH +
                        " = "+1+" and NGON_NGU = 'vn'", null);
		c.moveToFirst();
		List<Obj_bai_hat> arr_BAI_HAT=new ArrayList<Obj_bai_hat>();
		while (!c.isAfterLast()) {
			Obj_bai_hat BH=new Obj_bai_hat();
			BH.SET_OBJECT(c);
			arr_BAI_HAT.add(BH);
			c.moveToNext();
		}
		c.close();
		return arr_BAI_HAT;
	}
    public List<Obj_bai_hat> get_ALL_BH() {
        Cursor c = null;
        c = mDb.rawQuery("SELECT * FROM "+Utils.TABLE_BAIHAT, null);
        c.moveToFirst();
        List<Obj_bai_hat> arr_BAI_HAT=new ArrayList<Obj_bai_hat>();
        while (!c.isAfterLast()) {
            Obj_bai_hat BH=new Obj_bai_hat();
            BH.SET_OBJECT(c);
            arr_BAI_HAT.add(BH);
            c.moveToNext();
        }
        c.close();
        return arr_BAI_HAT;
    }
//	public List<Obj_yeuthich> get_baihat_yeuthich_not_sync() {
//		Cursor c = null;
//		c = mDb.rawQuery("SELECT * FROM "+Utils.TABLE_YEUTHICH +" where "+Utils.sync+" = "+Utils.NOT_SYNC, null);	
//		c.moveToFirst();
//		List<Obj_yeuthich> arr_BAI_HAT=new ArrayList<Obj_yeuthich>();
//		while (!c.isAfterLast()) {
//			Obj_yeuthich BH=new Obj_yeuthich();
//			BH.SET_OBJECT(c);
//			arr_BAI_HAT.add(BH);
//			c.moveToNext();
//		}
//		c.close();
//		return arr_BAI_HAT;
//	}
	public List<Obj_yeuthich> get_all_baihat_yeuthich() {
		Cursor c = null;
		c = mDb.rawQuery("SELECT * FROM "+Utils.TABLE_BAIHAT+" where "+Obj_bai_hat.tag_YEU_THICH+"=1", null);	
		c.moveToFirst();
		List<Obj_yeuthich> arr_BAI_HAT=new ArrayList<Obj_yeuthich>();
		while (!c.isAfterLast()) {
			Obj_yeuthich BH=new Obj_yeuthich();
			BH.SET_OBJECT(c);
			arr_BAI_HAT.add(BH);
			c.moveToNext();
		}
		c.close();
		return arr_BAI_HAT;
	}
	
	// moi
	
//	public long update_LOI_BH_TK(int MA_BH, String LOI_BH_TK) {
//		ContentValues initVal = new ContentValues();
//		initVal.put("LOI_BH_TK", LOI_BH_TK);
//		return mDb.update("BAI_HAT", initVal, "MA_BH=?",
//				new String[] { String.valueOf(MA_BH) });
//	}
} 

