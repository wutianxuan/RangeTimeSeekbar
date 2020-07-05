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
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Tian on 2020/7/2.
 */
class CourseScheduleStudentView extends RelativeLayout {

    private TextView tvTitleTime;
    private TextView tvTitleCourse;
    private TextView tvTitleStudent;
    private Context mContext;
    private int textTitleHeight = 64;
    private int textTitleSize = 14;
    private String textTitleBg = "#FC9549";
    private int textTitleDivider = 10;


    public CourseScheduleStudentView(Context context) {
        this(context, null);
    }

    public CourseScheduleStudentView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
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

        //1获取当前控件的大小
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);

        //获取所有子控件，拿到它的layoutparams对象，这样就可以拿到他的自定义属性
        int childCount = this.getChildCount();
        int viewWidth = width/3;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);

            MarginLayoutParams layoutParams = (MarginLayoutParams) childAt.getLayoutParams();
            layoutParams.width = viewWidth;
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }


    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        int lineWidth = 0;
        int lineHeight = 0;
        int top = 0;
        int left = 0;

        int count = getChildCount();

        for (int i = 0; i < count; i++) {

            View childAt = getChildAt(i);

            MarginLayoutParams layoutParams = (MarginLayoutParams) childAt.getLayoutParams();

            //得到子view的测量建议高度
            int measuredHeight = childAt.getMeasuredHeight() + layoutParams.bottomMargin + layoutParams.topMargin;
            int measuredWidth = childAt.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin;

            //换行
            if (measuredWidth + lineWidth > getMeasuredWidth()) {

                top += lineHeight;
                left = 0;
                lineHeight = measuredHeight;
                lineWidth = measuredWidth;
            } else {

                lineHeight = Math.max(measuredHeight, lineHeight);
                lineWidth += measuredWidth;
            }

            //文字view的当前位置
            int ll = left + layoutParams.leftMargin;
            int tt = top + layoutParams.topMargin;
            int rr = ll + childAt.getMeasuredWidth();
            int bb = tt + childAt.getMeasuredHeight();

            //设置子view的确定位置
            childAt.layout(ll, tt, rr, bb);

            left += measuredWidth;

        }

    }

    private void initView() {
        tvTitleTime = new TextView(mContext);
        tvTitleCourse = new TextView(mContext);
        tvTitleStudent = new TextView(mContext);
        tvTitleTime.setText("时间");
        tvTitleTime.setTextSize(textTitleSize);
        tvTitleTime.setHeight(textTitleHeight);
        tvTitleTime.setBackgroundColor(Color.parseColor("#F67171"));
        tvTitleTime.setTextColor(Color.parseColor("#333333"));
        tvTitleTime.setGravity(Gravity.CENTER);
        tvTitleCourse.setText("课程");
        tvTitleCourse.setTextSize(textTitleSize);
        tvTitleCourse.setHeight(textTitleHeight);
        tvTitleCourse.setBackgroundColor(Color.parseColor(textTitleBg));
        tvTitleCourse.setTextColor(Color.parseColor("#333333"));
        tvTitleCourse.setGravity(Gravity.CENTER);
        tvTitleStudent.setText("学生");
        tvTitleStudent.setTextSize(textTitleSize);
        tvTitleStudent.setHeight(textTitleHeight);
        tvTitleStudent.setBackgroundColor(Color.parseColor("#5D91BF"));
        tvTitleStudent.setTextColor(Color.parseColor("#333333"));
        tvTitleStudent.setGravity(Gravity.CENTER);
        addView(tvTitleTime);
        addView(tvTitleCourse);
        addView(tvTitleStudent);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) tvTitleCourse.getLayoutParams();
        layoutParams.setMargins(textTitleDivider, 0, textTitleDivider, 0);
        tvTitleCourse.setLayoutParams(layoutParams);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

    }

    /*//要使子控件的margin属性有效，必须定义静态内部类，继承ViewGroup.MarginLayoutParams
    public static class LayoutParams extends ViewGroup.MarginLayoutParams{

        public LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
        }
    }
    //要使子控件的margin属性有效，必须重写该函数，返回内部类实例

    @Override
    public RelativeLayout.LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new RelativeLayout.LayoutParams(getContext(),attrs);
    }*/


}
