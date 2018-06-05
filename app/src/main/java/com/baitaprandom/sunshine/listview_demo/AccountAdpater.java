package com.baitaprandom.sunshine.listview_demo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AccountAdpater extends RecyclerView.Adapter<AccountAdpater.ViewHolder>{
    ArrayList<Account> accountArrayList;
    Context context;

    public AccountAdpater(ArrayList<Account> accountArrayList, Context context) {
        this.accountArrayList = accountArrayList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.account_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.txtAccountName.setText(accountArrayList.get(position).accountName);
        holder.txtAmount.setText(accountArrayList.get(position).amount);

        holder.imgClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeAccount(position);
                Toast.makeText(context, "Xóa thành công!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return accountArrayList.size();
    }

    public void removeAccount(int pos){
        accountArrayList.remove(pos);
        notifyItemRemoved(pos);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtAccountName, txtAmount;
        ImageView imgClose;

        public ViewHolder(View itemView) {
            super(itemView);

            txtAccountName = itemView.findViewById(R.id.txtAccount_name);
            txtAmount = itemView.findViewById(R.id.txtAmount);
            imgClose = itemView.findViewById(R.id.imgClose);
        }
    }

}
