package com.example.ashishkumarpatel.tops;

import android.support.v7.widget.RecyclerView;
import android.content.Context;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageView;
import android.view.*;
import java.util.List;

/**
 * Created by ashishkumarpatel on 26/02/18.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

private Context mContext;
private List<UserData> userDataList;

public class MyViewHolder extends RecyclerView.ViewHolder {
    public TextView txtName, txtAddress,txtPhoneNumber;
    public Button btnEdit, btnDelete;

    public MyViewHolder(View view) {
        super(view);
        txtName = (TextView) view.findViewById(R.id.txt_name);
        txtAddress = (TextView) view.findViewById(R.id.txt_address);
        txtPhoneNumber=(TextView)view.findViewById(R.id.txt_phone_number);
        btnEdit = (Button) view.findViewById(R.id.btn_edit);
        btnDelete = (Button) view.findViewById(R.id.btn_delete);
    }
}


    public RecyclerViewAdapter(Context mContext, List<UserData> userDataList) {
        this.mContext = mContext;
        this.userDataList = userDataList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_row, parent, false);

        return new MyViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        UserData user = userDataList.get(position);
        holder.txtName.setText(user.getName());
        holder.txtPhoneNumber.setText(user.getMobileNo());
        holder.txtAddress.setText(user.getAddress());
        //holder.count.setText(user.getNumOfSongs() + " songs");
        // loading album cover using Glide libraryssh-add -l


        holder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //showPopupMenu(holder.overflow);
            }
        });
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppDataBase.getAppDatabase(mContext).userDao() .delete(user);
                userDataList.remove(position);

                notifyDataSetChanged();
            }
        });
    }





    @Override
    public int getItemCount() {
        return userDataList.size();
    }
}
