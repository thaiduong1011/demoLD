package com.baitaprandom.sunshine.listview_demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class AccountManagerActivity extends AppCompatActivity {

   public static ArrayList<Account> accounts;
    RecyclerView recyclerView;
    AccountAdpater accountAdpater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_manager);

        initView();
    }

    public void initView(){
        recyclerView = findViewById(R.id.account_recyclerView);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        DividerItemDecoration decoration = new DividerItemDecoration(this, layoutManager.getOrientation());
        recyclerView.addItemDecoration(decoration);

        accounts = new ArrayList<>();
        accounts.add(new Account("tk1", "123456"));
        accounts.add(new Account("tk2", "123456"));
        accounts.add(new Account("tk3", "123456"));
        accounts.add(new Account("tk4", "123456"));
        accounts.add(new Account("tk5", "123456"));
        accounts.add(new Account("tk6", "123456"));

        accountAdpater = new AccountAdpater(accounts, this);
        recyclerView.setAdapter(accountAdpater);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getTitle().toString().equals("Add")){
            AddAccountDialog dialog = new AddAccountDialog(this, accountAdpater);
            dialog.show();
        }
        return super.onOptionsItemSelected(item);
    }
}
