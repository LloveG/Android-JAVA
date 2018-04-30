package com.lijing.studentsignin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class LoginActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner spinner;

    private EditText username;
    private EditText password;

    private Button btnLogin;

    private  static final  String Tag="LoginActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //取消标题栏
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        //取消状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);


        initView();
        initData();
        initListener();
    }

    /**
     * 初始化控件
     */
    private void initView() {
        spinner = findViewById(R.id.spinner);
        username=findViewById(R.id.userName);
        password=findViewById(R.id.passWord);
        btnLogin=findViewById(R.id.btnLogin);
    }

    /**
     * 初始化数据
     */
    private void initData() {
//        String[] list1 = new String[]{"学生","教师","辅导员"};
//        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, list1);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner.setAdapter(adapter);
    }

    private void initListener() {
        spinner.setOnItemSelectedListener(this);
        btnLogin.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Log.v(Tag,"点击了登陆按钮");
                Bundle bundle=new Bundle();
                bundle.putString("username", username.getText().toString());
                bundle.putInt("usertype", (int)spinner.getSelectedItemId());

                Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}
