package com.lijing.studentsignin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

public abstract class BaseActivity extends AppCompatActivity {

    protected String userName;
    protected int userType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //取消标题栏
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        //取消状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        initBundle(savedInstanceState);
        initIntent();


        setContentView(ContentID());

        initView();
        initData();
        initListener();
    }



    protected void initBundle(Bundle bundle){
        if(bundle==null){
            return;
        }
        String username=bundle.getString("username");
        if(username!=null){
            userName= username;
        }
        int usertype=bundle.getInt("usertype",-1);
        if(usertype!=-1){
            userType= usertype;
        }
    }


    protected void initIntent() {
        Intent intent=getIntent();
        if(intent == null)return;
        Bundle bundle=intent.getExtras();
        initBundle(bundle);

    }

    protected abstract int ContentID();
    protected abstract void initView();
    protected abstract void initData();
    protected abstract void initListener() ;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("username",userName );
        outState.putInt("usertype",userType );
    }

    protected void GotoActivity( Class<?>  c){
        if(c==MainActivity.class){
            finish();
            return;
        }
        Bundle bundle=new Bundle();
        bundle.putString("username", userName);
        bundle.putInt("usertype", userType);

        Intent intent=new Intent(this,c);
        intent.putExtras(bundle);
        startActivity(intent);
//        finish();
    }


}
