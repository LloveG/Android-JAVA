package com.lijing.studentsignin;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends BaseActivity  {

    private  static final  String Tag="MainActivity";

    private Button  btnSignin;
    private Button  btnQingjia;
    private Button  btnZuoye;
    private Button  btnGeren;

    @Override
    protected int ContentID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        btnSignin=findViewById(R.id.btnToSigninView);
        btnQingjia=findViewById(R.id.btnQingjia);
        btnZuoye=findViewById(R.id.btnZuoye);
        btnGeren=findViewById(R.id.btnGeren);
    }

    @Override
    protected void initData() {


    }

    @Override
    protected void initListener() {
        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GotoActivity(SignInActivity.class);
            }
        });
        btnQingjia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GotoActivity(DayoffActivity.class);
            }
        });
        btnZuoye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(userType!=1&&userType!=2){
                    Toast.makeText(MainActivity.this, "对不起，你不是教师用户，无作业管理权限！", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });
        btnGeren.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GotoActivity(UserInfoActivity.class);
            }
        });
    }

    @Override
    public void onBackPressed() {
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("提示")//设置对话框的标题
                .setMessage("你确定要退出程序吗？")//设置对话框的内容
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                        System.exit(0);
                    }
                }).create();
        dialog.show();
    }

}
