package com.example.donghe.rangeseekbar;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Tian on 2020/7/2.
 */
class CourseScheduleStudentView extends RelativeLayout {

    private TextView tvTitleTime = new TextView(getContext());
    private TextView tvTitleCourse = new TextView(getContext());
    private TextView tvTitleStudent = new TextView(getContext());


    public CourseScheduleStudentView(Context context) {
        this(context,null);
    }

    public CourseScheduleStudentView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CourseScheduleStudentView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }


    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }

    private void initView() {
        tvTitleTime.setText("时间");
        tvTitleTime.setHeight(64);
        tvTitleTime.setTextColor(Color.parseColor("#333333"));
        tvTitleTime.setGravity(Gravity.CENTER);
        tvTitleCourse.setText("课程");
        tvTitleCourse.setHeight(64);
        tvTitleCourse.setTextColor(Color.parseColor("#333333"));
        tvTitleCourse.setGravity(Gravity.CENTER);
        tvTitleStudent.setText("学生");
        tvTitleStudent.setHeight(64);
        tvTitleStudent.setTextColor(Color.parseColor("#333333"));
        tvTitleStudent.setGravity(Gravity.CENTER);
    }

}
