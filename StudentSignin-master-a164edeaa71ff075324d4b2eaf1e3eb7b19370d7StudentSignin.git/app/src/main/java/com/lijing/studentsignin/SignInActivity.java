package com.lijing.studentsignin;


import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.Button;

import com.lijing.studentsignin.Layout.DoSignin;
import com.lijing.studentsignin.Layout.SigninInfo;

public class SignInActivity extends BaseActivity implements View.OnClickListener {

    private ConstraintLayout mainLayout;
    private DoSignin doSignin=new DoSignin();
    private SigninInfo signinInfo=new SigninInfo();


    private Button btnDoSignin;
    private Button btnSigninInfo;
    private Button btnBack;

    private Boolean inMain=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainLayout = findViewById(R.id.viewSignin);
    }

    @Override
    protected int ContentID() {
        return R.layout.activity_signin;
    }

    @Override
    protected void initView() {
        btnDoSignin=findViewById(R.id.btnToSigninView);
        btnBack=findViewById(R.id.button);
        btnSigninInfo=findViewById(R.id.button2);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {
        btnDoSignin.setOnClickListener(this);
        btnBack.setOnClickListener(this);
        btnSigninInfo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.equals(btnDoSignin)){
            inMain=false;
            if(doSignin.getLayout()!=null){
                setContentView(doSignin.getLayout());
            }else{
                setContentView(R.layout.activity_dosignin);
                doSignin.setLayout((ConstraintLayout) findViewById(R.id.viewDoSignin));
                doSignin.SetBackClick(this);
                doSignin.Init();

            }
            return;
        }
        if(v.equals(btnSigninInfo)){
            inMain=false;
            if(signinInfo.getLayout()!=null){
                setContentView(signinInfo.getLayout());
            }else{
                setContentView(R.layout.activity_signin_info);
                signinInfo.setLayout((ConstraintLayout) findViewById(R.id.viewSigninInfo));
                signinInfo.SetBackClick(this);
                signinInfo.Init();

            }
            return;
        }
        inMain=true;
        if(v.equals(btnBack)){
            GotoActivity(MainActivity.class);
            return;
        }

        setContentView(mainLayout);
    }
    @Override
    public void onBackPressed() {
        if(inMain){
            finish();
        }else{
            inMain=true;
            setContentView(mainLayout);
        }
    }
}
