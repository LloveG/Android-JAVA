package com.lijing.studentsignin.Layout;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.lijing.studentsignin.R;

public  class DoSignin  extends BaseLayout implements  AdapterView.OnItemSelectedListener {

    private Spinner spinner2;
    private Spinner spinner3;
    private Button btnBack;

    @Override
    public void Init() {
        spinner2=  this.getLayout().findViewById(R.id.spinner2);
        spinner3=  this.getLayout().findViewById(R.id.spinner3);
        btnBack= this.getLayout().findViewById(R.id.button);
        spinner2.setOnItemSelectedListener(this);
        btnBack.setOnClickListener(this.listener);
    }




    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String[] items;
        switch ((int)id)
        {
            case 0:
                items = this.getLayout().getResources().getStringArray(R.array.signin_shangke);
                break;
            case 1:
                items= this.getLayout().getResources().getStringArray(R.array.signin_wangui);
                break;
            case 2:
                items= this.getLayout().getResources().getStringArray(R.array.signin_huodong);
                break;
                default:return;
        }
        ArrayAdapter<String> adapter= new ArrayAdapter<>(this.getLayout().getContext(), android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}
