/*
 * Copyright 2015 Rudson Lima
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package karaokelist.material.com.karaokelist.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.pnikosis.materialishprogress.ProgressWheel;

import java.util.ArrayList;
import java.util.List;

import karaokelist.material.com.karaokelist.R;
import karaokelist.material.com.karaokelist.activity.FlashScreenAc;
import karaokelist.material.com.karaokelist.adapter.Adapter_BAIHAT;
import karaokelist.material.com.karaokelist.object.Obj_bai_hat;


public class BaiHat_Fragment extends Fragment {

    private boolean mSearchCheck;
    private static final String TEXT_FRAGMENT = "TEXT_FRAGMENT";
    Adapter_BAIHAT mAdapter=null;
    RecyclerView recList;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mReAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    List<Obj_bai_hat> list_baihat =null;
    List<Obj_bai_hat> list_baihat_search =null;

	public static BaiHat_Fragment newInstance(String text){
		BaiHat_Fragment mFragment = new BaiHat_Fragment();
//		Bundle mBundle = new Bundle();
//		mBundle.putString(TEXT_FRAGMENT, text);
//		mFragment.setArguments(mBundle);
		return mFragment;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub		
		View rootView = inflater.inflate(R.layout.fragment_baihat, container, false);
        try{
            recList = (RecyclerView) rootView.findViewById(R.id.cardList);
            recList.setHasFixedSize(true);
            LinearLayoutManager llm = new LinearLayoutManager(getActivity());
            llm.setOrientation(LinearLayoutManager.VERTICAL);
            recList.setLayoutManager(llm);
        }catch(Exception e){
            Toast.makeText(getActivity().getApplicationContext(), "loi giao dien :\n"+e.toString(), Toast.LENGTH_LONG).show();
        }
//        TextView mTxtTitle = (TextView) rootView.findViewById(R.id.txtTitle);
//        mTxtTitle.setText(getArguments().getString(TEXT_FRAGMENT));
        if(list_baihat==null){
            if(FlashScreenAc.my_list!=null){
                try {
                    list_baihat = new ArrayList<Obj_bai_hat>(FlashScreenAc.my_list);
                } catch(Exception e){
                    Toast.makeText(getActivity().getApplicationContext(), "loi "+e.toString(),Toast.LENGTH_LONG).show();
                }
            }
        }
        try {
            if(list_baihat!=null){
                mAdapter = new Adapter_BAIHAT(getActivity(),list_baihat);
            }
        } catch(Exception e){
            Toast.makeText(getActivity().getApplicationContext(), "loi "+e.toString(),Toast.LENGTH_LONG).show();
        }
        if(mAdapter!=null){
            recList.setAdapter(mAdapter);
        }
		rootView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT ));		
		return rootView;		
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		setHasOptionsMenu(true);
	}
	
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu, inflater);
		inflater.inflate(R.menu.menu, menu);
        
        //Select search item
        final MenuItem menuItem = menu.findItem(R.id.menu_search);
        menuItem.setVisible(true);

        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint(this.getString(R.string.search));

        ((EditText) searchView.findViewById(R.id.search_src_text))
                .setHintTextColor(getResources().getColor(R.color.nliveo_white));
        searchView.setOnQueryTextListener(onQuerySearchView);

		menu.findItem(R.id.menu_add).setVisible(true);

		mSearchCheck = false;	
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		
		switch (item.getItemId()) {

		case R.id.menu_add:
//            Toast.makeText(getActivity(), R.string.add, Toast.LENGTH_SHORT).show();
			break;

		case R.id.menu_search:
			mSearchCheck = true;
//            Toast.makeText(getActivity(), R.string.search, Toast.LENGTH_SHORT).show();
			break;
		}
		return true;
	}	

   private SearchView.OnQueryTextListener onQuerySearchView = new SearchView.OnQueryTextListener() {
       @Override
       public boolean onQueryTextSubmit(String s) {
           return false;
       }

       @Override
       public boolean onQueryTextChange(String s) {
           if (mSearchCheck){
               // implement your search here
               mAdapter.get_search(s);
           }
           return false;
       }
   };

}
