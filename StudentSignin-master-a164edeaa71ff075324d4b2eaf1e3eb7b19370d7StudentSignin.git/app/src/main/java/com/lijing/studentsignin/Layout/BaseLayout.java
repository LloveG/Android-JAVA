package com.lijing.studentsignin.Layout;

import android.support.constraint.ConstraintLayout;
import android.view.View;


public abstract class BaseLayout {
    private ConstraintLayout layout;
    public ConstraintLayout getLayout(){
        return  layout;
    }
    protected View.OnClickListener listener;
    public void setLayout(ConstraintLayout layout){
        this.layout=layout;
    }

    public abstract void Init();
    public void SetBackClick(View.OnClickListener listener){
        this.listener = listener;
    }
}
