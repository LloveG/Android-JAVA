package com.lijing.studentsignin.Layout;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.lijing.studentsignin.R;

import java.util.ArrayList;
import java.util.List;

public class SigninInfo  extends BaseLayout {
    private  List<StudentInfo> list=new ArrayList<>();
    private TableLayout tableLayout;
    public SigninInfo(){
        list.add(new StudentInfo(10001,"赵一","签到"));
        list.add(new StudentInfo(10002,"钱二","签到"));
        list.add(new StudentInfo(10003,"孙三","签到"));
        list.add(new StudentInfo(10004,"李四","缺勤"));
        list.add(new StudentInfo(10005,"周五","请假"));
        list.add(new StudentInfo(10006,"吴六","签到"));
    }

    @Override
    public void Init() {
        tableLayout=this.getLayout().findViewById(R.id.tableLayout);


        for(int i=0;i<list.size();i++){

            StudentInfo info= list.get(i);
            Log.v("aaaaaa",info.Name);
            TableRow tr=new TableRow(this.getLayout().getContext());
            tr.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));

            TextView idx=new TextView(this.getLayout().getContext());
            idx.setText(i+"");
            idx.setWidth(42);
            idx.setGravity(Gravity.CENTER);
            tr.addView(idx);


            TextView id=new TextView(this.getLayout().getContext());
            id.setText(info.Id+"");
            id.setWidth(66);
            id.setGravity(Gravity.CENTER);
            tr.addView(id);

            TextView name=new TextView(this.getLayout().getContext());
            name.setText(info.Name+"");
            name.setWidth(72);
            name.setGravity(Gravity.CENTER);
            tr.addView(name);

            TextView status=new TextView(this.getLayout().getContext());
            status.setText(info.Type+"");
            status.setWidth(71);
            status.setGravity(Gravity.CENTER);
            tr.addView(status);

            Button btn=new Button(this.getLayout().getContext());
            btn.setText("联系");
            //btn.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT));
            status.setWidth(90);
            btn.setGravity(Gravity.CENTER);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getLayout().getContext(),android.R.style.Theme_Holo_Light_Dialog);
                    builder.setIcon(R.drawable.school);
                    builder.setTitle("选择联系方式");
                    //    指定下拉列表的显示数据
                    final String[] cities = {"电话", "短信","邮件"};
                    //    设置一个下拉的列表选择项
                    builder.setItems(cities, new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialog, int which)
                        {
                            Toast.makeText(getLayout().getContext(), "选择的联系方式为：" + cities[which], Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.show();
                }
            });
            tr.addView(btn);

            tableLayout.addView(tr);
        }
    }
}


class StudentInfo{
    public StudentInfo(){

    }
    public StudentInfo(int id,String name,String type){
        Id=id;
        Name=name;
        Type=type;
    }
    public int Id;
   public String Name;
   public String Type;
   //可以继续添加手机号码等字段
}