package com.example.donghe.rangeseekbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 *
 * @author Tian
 * @date 2020/7/2
 */
public class CourseScheduleStudentView extends RelativeLayout {
    private static final String TAG = "CourseScheduleStudentVi";

    private TextView tvTitleTime;
    private TextView tvTitleCourse;
    private TextView tvTitleStudent;
    private Context mContext;
    private int textTitleHeight = 64;
    private int textTitleSize = 14;
    private String textTitleBg = "#FC9549";
    private int textTitleDivider = 10;
    private Paint mCoursePaint;
    private float mDensity;
    private String[] arrays = {"08:00", "08:30", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:00"};
    private String[] array2 = {"14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00"};
    private String[] arrays3 = {"19:00", "19:30", "20:00", "20:30", "21:00", "21:30", "22:00", "22:30", "23:00"};
    private LinearLayout linearTime;

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
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        // 获取宽-测量规则的模式和大小
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);

        // 获取高-测量规则的模式和大小
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        Log.e(TAG, "widthSize:"+widthSize + ","+"heightSize:" + heightSize);
        Log.e(TAG, "widthMode:"+widthMode + ","+"heightMode:" + heightMode);

        //int layoutWidth = 0;
        //int layoutHeight = 0;
        // 计算出所有的childView的宽和高
        /*measureChildren(widthMeasureSpec, heightMeasureSpec);

        int cWidth = 0;
        int cHeight = 0;
        int count = getChildCount();

        if(widthMode == MeasureSpec. EXACTLY){
            //如果布局容器的宽度模式是确定的（具体的size或者match_parent），直接使用父窗体建议的宽度
            layoutWidth = widthSize;
        } else{
            //如果是未指定或者wrap_content，我们都按照包裹内容做，宽度方向上只需要拿到所有子控件中宽度做大的作为布局宽度
            for ( int i = 0; i < count; i++)  {
                View child = getChildAt(i);
                cWidth = child.getMeasuredWidth();
                //获取子控件最大宽度
                layoutWidth = Math.max(cWidth, layoutWidth);
            }
        }
        //高度很宽度处理思想一样
        if(heightMode == MeasureSpec. EXACTLY){
            layoutHeight = heightSize;
        } else{
            for ( int i = 0; i < count; i++)  {
                View child = getChildAt(i);
                cHeight = child.getMeasuredHeight();
                layoutHeight = Math.max(cHeight, layoutHeight);
            }
        }
        Log.e(TAG, "layoutWidth:"+layoutWidth + ","+"layoutHeight:" + layoutHeight);
        //获取所有子控件，拿到它的layoutparams对象，这样就可以拿到他的自定义属性
        int childCount = this.getChildCount();*/
        int viewWidth = widthSize/3;
        int usedWidth = 0 ;
        //遍历前三个title的子view
        for (int i = 0; i < 3; i++) {
            View childAt = getChildAt(i);
            //自view自己测量
            //measureChild(childAt, widthMeasureSpec, heightMeasureSpec);
            MarginLayoutParams layoutParams = (MarginLayoutParams) childAt.getLayoutParams();
            switch (i) {
                case 0:
                    layoutParams.width = viewWidth;
                    View childAt3 = getChildAt(3);
                    MarginLayoutParams layoutParams3 = (MarginLayoutParams) childAt3.getLayoutParams();
                    layoutParams3.width = viewWidth;
                    break;
                case 1:
                    layoutParams.width = (widthSize-usedWidth-layoutParams.leftMargin-layoutParams.rightMargin)/2;
                    break;
                case 2:
                    layoutParams.width = widthSize-usedWidth;

                    break;
                default:
                    break;
            }
            usedWidth += layoutParams.width;
            // 测量并保存layout的宽高
            //setMeasuredDimension(layoutWidth, layoutHeight);
        }
    }


    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        //int lineWidth = 0;
       // int lineHeight = 0;
        int top = 0;
        int left = 0;

        int count = getChildCount();

        for (int i = 0; i < 3; i++) {

            View childAt = getChildAt(i);

            MarginLayoutParams layoutParams = (MarginLayoutParams) childAt.getLayoutParams();
            //得到子view的测量建议高度
            int measuredHeight = childAt.getMeasuredHeight() + layoutParams.bottomMargin + layoutParams.topMargin;
            int measuredWidth = childAt.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin;

            /*//换行
            if (measuredWidth + lineWidth > getMeasuredWidth()) {

                top += lineHeight;
                left = 0;
                lineHeight = measuredHeight;
                lineWidth = measuredWidth;
            } else {

                lineHeight = Math.max(measuredHeight, lineHeight);
                lineWidth += measuredWidth;
            }*/

            //文字view的当前位置
            int ll = left + layoutParams.leftMargin;
            int tt = top + layoutParams.topMargin;
            int rr = ll + childAt.getMeasuredWidth();
            int bb = tt + childAt.getMeasuredHeight();
            //设置子view的确定位置
            childAt.layout(ll, tt, rr, bb);
            left += measuredWidth;
            switch (i) {
                case 0:
                    View childAt4 = getChildAt(3);
                    int ll3 = childAt.getLeft();
                    int tt3= textTitleDivider+childAt.getBottom();
                    int rr3 = childAt.getRight();
                    int bb3 = tt3 + childAt4.getMeasuredHeight();
                    //设置子view的确定位置
                    childAt4.layout(ll3, tt3, rr3, bb3);

                    break;
                case 1:
                    //layoutParams.width = (width-usedWidth-layoutParams.leftMargin-layoutParams.rightMargin)/2;
                    break;
                case 2:
                    //layoutParams.width = width-usedWidth;
                    break;
                default:
                    break;
            }


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
        linearTime = new LinearLayout(mContext);
        linearTime.setOrientation(LinearLayout.VERTICAL);
        linearTime.setBackgroundColor(Color.parseColor("#1BBEFF"));
        addView(tvTitleTime);
        addView(tvTitleCourse);
        addView(tvTitleStudent);
        addView(linearTime);
        RelativeLayout.LayoutParams layoutParamsTitle = (RelativeLayout.LayoutParams) tvTitleCourse.getLayoutParams();
        layoutParamsTitle.setMargins(textTitleDivider, 0, textTitleDivider, 0);
        tvTitleCourse.setLayoutParams(layoutParamsTitle);
        //左侧时间的linealayout
        /*RelativeLayout.LayoutParams layoutParamsLinearTime = (RelativeLayout.LayoutParams) linearTime.getLayoutParams();
        layoutParamsLinearTime.width = RelativeLayout.LayoutParams.MATCH_PARENT;
        linearTime.setLayoutParams(layoutParamsLinearTime);*/
        for (int i = 0; i < arrays.length; i++) {
            LinearLayout ItemLinearTime = new LinearLayout(mContext);
            ItemLinearTime.setOrientation(LinearLayout.HORIZONTAL);
            ItemLinearTime.setBackgroundColor(Color.parseColor("#27FFC0"));
            ItemLinearTime.setGravity(Gravity.CENTER_VERTICAL);
            linearTime.addView(ItemLinearTime);

            LinearLayout.LayoutParams layoutParamsItem = (LinearLayout.LayoutParams) ItemLinearTime.getLayoutParams();
            layoutParamsItem.height = 200;
            layoutParamsItem.width = LinearLayout.LayoutParams.MATCH_PARENT;
            layoutParamsItem.setMargins(0,0,0,10);
            ItemLinearTime.setLayoutParams(layoutParamsItem);
            TextView timeTV = new TextView(mContext);
            timeTV.setText(arrays[i]);
            timeTV.setGravity(Gravity.CENTER);
            timeTV.setBackgroundColor(Color.parseColor("#A8E4FF"));
            ImageView timeIv = new ImageView(mContext);
            timeIv.setBackgroundColor(Color.parseColor("#E0E0E0"));
            ImageView timeIv2 = new ImageView(mContext);
            timeIv2.setBackgroundColor(Color.parseColor("#E0E0E0"));
            ItemLinearTime.addView(timeIv);
            ItemLinearTime.addView(timeTV);
            ItemLinearTime.addView(timeIv2);
            LinearLayout.LayoutParams tvParams = (LinearLayout.LayoutParams) timeTV.getLayoutParams();
            tvParams.weight = 1;
//            tvParams.width = 0;
            timeTV.setLayoutParams(tvParams);
            LinearLayout.LayoutParams ivParams1 = (LinearLayout.LayoutParams) timeIv.getLayoutParams();
            ivParams1.height = 3;
            ivParams1.width = 30;
            timeIv.setLayoutParams(ivParams1);
            LinearLayout.LayoutParams ivParams2 = (LinearLayout.LayoutParams) timeIv2.getLayoutParams();
            ivParams2.height = 3;
            ivParams2.width = 30;
            timeIv2.setLayoutParams(ivParams2);
        }



        mDensity = getContext().getResources().getDisplayMetrics().density;
        initPaint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);

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

    private void initPaint() {
        mCoursePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mCoursePaint.setAntiAlias(true);
        mCoursePaint.setStyle(Paint.Style.FILL);
       // mCoursePaint.setStrokeWidth(0.1f * mDensity);
    }

}
