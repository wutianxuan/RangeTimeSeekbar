package com.example.donghe.rangeseekbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.BindArray;
import butterknife.BindView;
import butterknife.ButterKnife;
import de.greenrobot.event.EventBus;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.seekbar)
    RangeSeekbar seekbar;
    @BindView(R.id.tv_left)
    TextView tvLeft;
    @BindView(R.id.tv_right)
    TextView tvRight;
    //String arrays[] = {"0", "5", "10", "15", "20", "25", "40", "60", "80", "100"};
    String[]  arrays = {"08:00", "08:30", "09:00", "09:30","10:00", "10:30", "11:00", "11:30", "12:00"};
    String[]  array2 = {"14:00", "14:30",  "15:00","15:30", "16:00", "16:30", "17:00", "17:30", "18:00"};
    String[]  arrays3 = {"19:00", "19:30","20:00", "20:30", "21:00", "21:30", "22:00", "22:30", "23:00"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //EventBus.getDefault().register(this);
        seekbar.setOnCursorChangeListener(arrays,new RangeSeekbar.OnCursorChangeListener() {
            @Override
            public void onLeftCursorChanged(int location, String textMark) {
                tvLeft.setText("左边:" + textMark);
            }

            @Override
            public void onRightCursorChanged(int location, String textMark) {
                tvRight.setText("右边：" + textMark);
            }
        });

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
