package com.lijing.studentsignin;

import android.view.View;

public class DayoffActivity extends BaseActivity implements View.OnClickListener {


    @Override
    protected int ContentID() {
        if(this.userType==0){
            return R.layout.activity_dayoff;
        }
        return R.layout.activity_dayoff_review;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    public void onClick(View v) {

    }
}
