package com.ztb.nanke;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import com.ztb.nanke.adapter.HomeAdapter;
import com.ztb.nanke.common.MyDecoration;
import com.ztb.nankerlibrary.base.BaseActivity;

import java.util.ArrayList;

/**
 * Created by nanker on 2017/4/20.
 */
public class MainActivity extends BaseActivity {
    private Button mName;
    private RecyclerView mRecyclerView;
    private ArrayList<String> mDatas;
    private RecyclerView.Adapter mAdapter;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
        mName = (Button) findViewById(R.id.tv_name);
        mRecyclerView = (RecyclerView) findViewById(R.id.id_recyclerview);
//设置布局管理器
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//设置adapter
        mRecyclerView.setAdapter(mAdapter = new HomeAdapter(this,mDatas));
//设置Item增加、移除动画
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
//添加分割线
        //这句就是添加我们自定义的分隔线
        mRecyclerView.addItemDecoration(new MyDecoration(getApplicationContext(), MyDecoration.HORIZONTAL_LIST));
    }
    protected void initData()
    {
        mDatas = new ArrayList<String>();
        for (int i = 'A'; i < 'z'; i++)
        {
            mDatas.add("" + (char) i);
        }
    }
}

