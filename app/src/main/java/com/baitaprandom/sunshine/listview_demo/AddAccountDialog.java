package com.baitaprandom.sunshine.listview_demo;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddAccountDialog extends Dialog{

    EditText edtAccountName, edtPass;
    TextView txtNoti;
    Button btnAdd;

    AccountAdpater accountAdpater;

    public AddAccountDialog(@NonNull Context context, AccountAdpater accountAdpater) {
        super(context);
        this.accountAdpater = accountAdpater;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_add_account);

        AnhXa();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean added = addNewAccount();
                if (added == true){
                    dismiss();
                    accountAdpater.notifyItemInserted(AccountManagerActivity.accounts.size() - 1);
                }
            }
        });
    }

    void AnhXa(){
        edtAccountName = findViewById(R.id.edtAccountName);
        edtPass = findViewById(R.id.edtPass);
        txtNoti = findViewById(R.id.noti);
        btnAdd = findViewById(R.id.btnAdd);
    }

    boolean addNewAccount(){
        String name = edtAccountName.getText().toString();
        String pass = edtPass.getText().toString();

        for (Account account: AccountManagerActivity.accounts){
            if (name.equals(account.accountName)){
                txtNoti.setText("Tài khoản không đúng, vui lòng nhập lại");
                return false;
            }
        }

        AccountManagerActivity.accounts.add(new Account(name, pass));
        return true;
    }
}
