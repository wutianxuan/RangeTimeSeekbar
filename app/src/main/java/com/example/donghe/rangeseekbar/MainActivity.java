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
    String arrays[] = {"08:00", "08:30", "09:00", "10:00", "10:30", "11:00", "11:30", "12:00"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //EventBus.getDefault().register(this);
        seekbar.setOnCursorChangeListener(new RangeSeekbar.OnCursorChangeListener() {
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
