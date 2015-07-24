package karaokelist.material.com.karaokelist.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import com.afollestad.materialdialogs.MaterialDialog;

import karaokelist.material.com.karaokelist.R;
import karaokelist.material.com.karaokelist.effect.Activity_Loibaihat;
import karaokelist.material.com.karaokelist.object.Obj_bai_hat;


public class Adapter_BAIHAT extends
        RecyclerView.Adapter<Adapter_BAIHAT.ContactViewHolder> {
    private List<Obj_bai_hat> list_all_baihat;
    private List<Obj_bai_hat> list_baihat;
    Context mcon;

    public Adapter_BAIHAT(Context mcon, List<Obj_bai_hat> list_all_baihat) {
        this.mcon=mcon;
        this.list_all_baihat = list_all_baihat;
        list_baihat = new ArrayList<Obj_bai_hat>(this.list_all_baihat);
    }
    public void get_search(String key){
        list_baihat.clear();
        if (key.length()>0){
            for (Obj_bai_hat oMBA : list_all_baihat){
                if (oMBA.getTEN_BH_TK().contains(key)
                        || oMBA.getCHAR_START().contains(key)
                        || oMBA.getLOI_RG().contains(key)){
                    list_baihat.add(oMBA);
                }
            }
        }else{
            list_baihat = new ArrayList<Obj_bai_hat>(this.list_all_baihat);
        }
        notifyDataSetChanged();

    }

    @Override
    public int getItemCount() {
        return list_baihat.size();
    }

    @Override
    public void onBindViewHolder(ContactViewHolder contactViewHolder, int i) {
        final Obj_bai_hat ci = list_baihat.get(i);

        contactViewHolder.tv_mabaihat.setText(""+ci.getMA_BH());
        contactViewHolder.tv_tenbaihat.setText(ci.getTEN_BH());
        contactViewHolder.tv_loibaihat.setText(ci.getLOI_BH());


        contactViewHolder.setClickListener(new ContactViewHolder.ClickListener() {
            public void onClick(View v, int pos, boolean isLongClick) {
                if (isLongClick) {
                    Toast.makeText(mcon, "longclick " + ci.getTEN_BH(), Toast.LENGTH_LONG).show();
                } else {
                    String TT = "thong tin ";
//                    TT=TT+ci.getTEN_BH()+"\n";
//                    TT=TT+"MSTS :"+ci.getMSTS()+"\n";
//                    TT=TT+"Thuộc kho :"+ci.getKho()+"\n";
//                    TT=TT+"Nhà sx :"+ci.getNha_sanxuat()+"\n";
//                    TT=TT+"Công suất :"+ci.getCong_suat()+"\n";
//                    TT=TT+"Nấc vận hành :"+ci.getNac_vanhanh()+"\n";
//                    showBasicLongContent(TT);
                    to_loibaihat(ci);
                }
            }
        });
    }
    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.cardview_baihat, viewGroup, false);
        return new ContactViewHolder(itemView);
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener{
        public TextView tv_mabaihat;
        public TextView tv_tenbaihat;
        public TextView tv_loibaihat;

        private ClickListener clickListener;

        public ContactViewHolder(View v) {
            super(v);

            tv_mabaihat = (TextView) v
                    .findViewById(R.id.tv_mabaihat_cardview_baihat);
            tv_tenbaihat = (TextView) v
                    .findViewById(R.id.tv_tenbaihat_cardview_baihat);
            tv_loibaihat = (TextView) v
                    .findViewById(R.id.tv_loibaihat_cardview_baihat);
            v.setOnClickListener(this);
        }
        /* Interface for handling clicks - both normal and long ones. */
        public interface ClickListener {
            public void onClick(View v, int position, boolean isLongClick);

        }

        /* Setter for listener. */
        public void setClickListener(ClickListener clickListener) {
            this.clickListener = clickListener;
        }

        @Override
        public void onClick(View v) {
            // If not long clicked, pass last variable as false.
            clickListener.onClick(v, getPosition(), false);
        }
        @Override
        public boolean onLongClick(View v) {

            // If long clicked, passed last variable as true.
            clickListener.onClick(v, getPosition(), true);
            return true;
        }


    }
    private void showBasicLongContent(String thongtin) {
        new MaterialDialog.Builder(mcon)
                .title(R.string.thongtin)
                .content(thongtin)
                    .positiveText(R.string.dong)
                .negativeText(R.string.sua)
                .show();
    }
    private void to_loibaihat(Obj_bai_hat oBH) {
        Intent i = new Intent(mcon, Activity_Loibaihat.class);
        i.putExtra("BH",oBH);
        mcon.startActivity(i);
    }
}
