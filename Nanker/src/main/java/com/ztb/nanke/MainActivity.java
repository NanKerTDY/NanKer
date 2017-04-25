package com.ztb.nanke;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ztb.nankerlibrary.base.BaseActivity;
import com.ztb.nankerlibrary.utils.LogUtil;

import org.litepal.tablemanager.Connector;

/**
 * Created by nanker on 2017/4/20.
 */

public class MainActivity extends BaseActivity {
    Button mName;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mName = (Button) findViewById(R.id.tv_name);
        MySqLiteHelper sqLiteHelper = new MySqLiteHelper(this,"nankes.db",null,1);
        SQLiteDatabase db = sqLiteHelper.getWritableDatabase();
        db.execSQL("insert into pepoles (name ,age ,phone) values('zhangsan' , 18 , '1008611');");
//         String str = db.execSQL("select * from pepoles where 'zhangsan'");
//        mName.setText();
        mName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mName.setText("111");
                LogUtil.debug("dianjil");
                runnable.run();
            }
        });
    }

    Runnable runnable = new Runnable() {
        public void run() {
            mName.setText("1111");
            SQLiteDatabase db = Connector.getDatabase();
            db.execSQL("insert into Pepoles (name ,age ) values('zhangsan' , 18 );");
        }
    };
}
