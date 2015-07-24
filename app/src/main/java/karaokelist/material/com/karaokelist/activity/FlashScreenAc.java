package karaokelist.material.com.karaokelist.activity;


import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;

import java.util.List;

import karaokelist.material.com.karaokelist.R;
import karaokelist.material.com.karaokelist.database.TestAdapter;
import karaokelist.material.com.karaokelist.object.Obj_bai_hat;
import karaokelist.material.com.karaokelist.object.Obj_yeuthich;

public class FlashScreenAc extends Activity{

	TestAdapter mdb;
	CountDownTimer mcountdown;
	final int time_connnect=60000;
	public static List<Obj_bai_hat> my_list =null;
	

	@Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flashscreen);
        mdb = new TestAdapter(this);
        
        new Load_Dulieu().execute();
    }
    
   
	class Load_Dulieu extends AsyncTask<String, String, String> {

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			mcountdown = new CountDownTimer(time_connnect, 1000) {

				public void onTick(long millisUntilFinished) {

				}
				public void onFinish() {
					finish();
				}
			}.start();
			
		}
		protected String doInBackground(String... args) {
			mdb.createDatabase();  
	    	mdb.open();
//	        ARR_MTT = mDbHelper.get_more_bai_hat(1, Utils.first_code, Utils.first_code+Utils.add_code);
//	        Utils.first_code = Utils.first_code+Utils.add_code;
//	        ARR_MTT_6 = mDbHelper.get_ALL_BAI_HAT(2);
			my_list = mdb.get_ALL_BH_VN();
			return null;
		}
		protected void onPostExecute(String file_url) {
			mcountdown.cancel();
			runOnUiThread(new Runnable() {
				public void run() {
					  Intent intent = new Intent(FlashScreenAc.this, MainActivity.class);
			          startActivity(intent);
			          finish();
				}
			});

		}
	}


	@Override
	public void onBackPressed() {
		
	}
	


}
