package com.example.donghe.rangeseekbar;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Schedule22Activity extends AppCompatActivity {

    @BindView(R.id.ll_1)
    LinearLayout ll_1;
    @BindView(R.id.ll_2)
    LinearLayout ll_2;
    @BindView(R.id.ll_3)
    LinearLayout ll_3;

    private float mDensity;

    //String arrays[] = {"0", "5", "10", "15", "20", "25", "40", "60", "80", "100"};
    String[] arrays = {
            "08:00", "08:30", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:00",
            "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00",
            "19:00", "19:30", "20:00", "20:30", "21:00", "21:30", "22:00", "22:30", "23:00"};
    String[] array2 = {"14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00"};
    String[] arrays3 = {"19:00", "19:30", "20:00", "20:30", "21:00", "21:30", "22:00", "22:30", "23:00"};
    private String str = "默认:";
    private List<String> timeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_22);
        ButterKnife.bind(this);
        timeList = Arrays.asList(arrays);
        mDensity = getResources().getDisplayMetrics().density;
        for (int i = 0; i < timeList.size(); i++) {
            View inflate = LayoutInflater.from(this).inflate(R.layout.item_time, null);
            TextView tvTime = (TextView) inflate.findViewById(R.id.tv_item_time);
            tvTime.setText(timeList.get(i));
            ll_1.addView(inflate);
        }
        addCourse();


    }

    private void addCourse() {
        String s1 = "08:00-10:30";
        String s2 = "15:30-18:00";
        String s3 = "20:00-22:30";
        int i1start = timeList.indexOf("08:00");
        int i1end = timeList.indexOf("10:30");
        int i2start  = timeList.indexOf("15:30");
        int i2end = timeList.indexOf("18:00");
        int i3start  = timeList.indexOf("20:00");
        int i3end = timeList.indexOf("22:30");
        int duration1 = i1end-i1start;
        int margin2 = i2start-i1end;
        int duration2 = i2end-i2start;
        int margin3 = i3start-i2end;
        int duration3 = i3end-i3start;
        int itemHeight = 40;
        for (int i = 0; i < 3; i++) {
            View inflateCourse = LayoutInflater.from(this).inflate(R.layout.item_course, null);
            ll_2.addView(inflateCourse);
            LinearLayout.LayoutParams layoutParamsCourse = (LinearLayout.LayoutParams) inflateCourse.getLayoutParams();
            View inflateStudent = LayoutInflater.from(this).inflate(R.layout.item_student, null);
            ll_3.addView(inflateStudent);
            LinearLayout.LayoutParams layoutParamsStudent = (LinearLayout.LayoutParams) inflateStudent.getLayoutParams();
            switch (i) {
                case 0:
                    layoutParamsCourse.height = (int) (mDensity*itemHeight*duration1);
                    layoutParamsCourse.setMargins(0, (int) (mDensity*(itemHeight/2)+mDensity*itemHeight*0),0,0);
                    layoutParamsStudent.height = (int) (mDensity*itemHeight*duration1);
                    layoutParamsStudent.setMargins(0, (int) (mDensity*(itemHeight/2)+mDensity*itemHeight*0),0,0);
                    break;
                case 1:
                    layoutParamsCourse.height = (int) (mDensity*itemHeight*duration2);
                    layoutParamsCourse.setMargins(0, (int) (mDensity*itemHeight*margin2),0,0);
                    layoutParamsStudent.height = (int) (mDensity*itemHeight*duration2);
                    layoutParamsStudent.setMargins(0, (int) (mDensity*itemHeight*margin2),0,0);
                    break;
                case 2:
                    layoutParamsCourse.height = (int) (mDensity*itemHeight*duration3);
                    layoutParamsCourse.setMargins(0, (int) (mDensity*itemHeight*margin3),0,0);
                    layoutParamsStudent.height = (int) (mDensity*itemHeight*duration3);
                    layoutParamsStudent.setMargins(0, (int) (mDensity*itemHeight*margin3),0,0);
                    break;
                default:
            }
            inflateCourse.setLayoutParams(layoutParamsCourse);
            inflateStudent.setLayoutParams(layoutParamsStudent);
        }









    }

    @OnClick({})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            /*case R.id.tv_1:
               // seekbar.initDate(arrays);
                //tv_index.setText(str+"左边:"+arrays[seekbar.getLeftCursorIndex()]+"--"+"右边:"+arrays[seekbar.getRightCursorIndex()]);
                break;*/

            default:
                break;
        }
    }

   /* public void onEventMainThread(RangBarEvent event) {
        int mesg = event.getMsg();
        int type = event.getType();
        if (type == 1) {
            //左边游标对应值
            tvLeft.setText("左边:" + arrays[mesg]);
        } else if (type == 2) {
            //右边游标对应值
            tvRight.setText("右边：" + arrays[mesg]);
        }
    }*/
}
