package com.example.donghe.rangeseekbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Tian on 2020/7/2.
 */
class CourseScheduleStudentView extends RelativeLayout {

    private TextView tvTitleTime ;
    private TextView tvTitleCourse ;
    private TextView tvTitleStudent;
    private Context mContext;


    public CourseScheduleStudentView(Context context) {
        this(context,null);
    }

    public CourseScheduleStudentView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CourseScheduleStudentView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        TypedArray typedArray = mContext.obtainStyledAttributes(attrs, R.styleable.CourseScheduleStudentView);
        typedArray.recycle();
        initView();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }


    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
    }

    private void initView() {
        View layoutInflater = LayoutInflater.from(mContext).inflate(R.layout.activity_test, null);
        tvTitleTime = new TextView(mContext);
        tvTitleCourse = new TextView(mContext);
        tvTitleStudent = new TextView(mContext);
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

        addView(tvTitleTime);
        addView(tvTitleCourse);
        addView(tvTitleStudent);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

    }
}
