package com.lijing.studentsignin;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class UserInfoActivity extends BaseActivity implements View.OnClickListener {

    private Button btnDoChange;
    private Button btnMoreInfo;
    @Override
    public void onClick(View v) {
        if(v.equals(btnDoChange)){
            Toast.makeText(this, "修改成功", Toast.LENGTH_SHORT).show();
            return;
        }
        setContentView(R.layout.activity_more_info);
    }

    @Override
    protected int ContentID() {
        return R.layout.activity_user_info;
    }

    @Override
    protected void initView() {
        btnDoChange=findViewById(R.id.btnDoSignin2);
        btnMoreInfo=findViewById(R.id.btnDoSignin);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {
        btnDoChange.setOnClickListener(this);
        btnMoreInfo.setOnClickListener(this);
    }
}
