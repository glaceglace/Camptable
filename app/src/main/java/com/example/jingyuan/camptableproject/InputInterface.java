package com.example.jingyuan.camptableproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;

import cn.skw.calculator.Calculator;



public class InputInterface extends AppCompatActivity {
    private GridView mGridView = null;
    private EditText mEditInput = null;
    private ArrayAdapter mAdaptor = null;
    private final String[] mTextBtns = new String[]{
                "1","2","3","+",
                "4","5","6","-",
                "7","8","9","=",
                ".","0","Back","Enter"
    };
    private String mPreStr = "";
    private String mLastStr = "";
    private Object mResult = null;
    private final String NEWLINE = "<br>";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_calculator);
        mGridView = (GridView) findViewById(R.id.bt_gl);
        mEditInput = (EditText) findViewById(R.id.input_tv);
        mAdaptor = new ArrayAdapter(this,android.R.layout.simple_list_item_1, mTextBtns);
        mGridView.setAdapter(mAdaptor);
        mEditInput.setKeyListener(null);
        mGridView.setOnItemClickListener(new OnButtonItemClickListener());
    }

    private void executeExpression(){
        try{
            mResult = Calculator.execute(mLastStr);
        }catch (Exception e){
            return;
        }
        mEditInput.setText(mResult.toString());
        mLastStr = mResult.toString();
    }

    private class OnButtonItemClickListener implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            String text = (String) mAdaptor.getItem(i);
            if(text.equals("=")){
                executeExpression();
            }else if(text.equals("Back")){
                if(mLastStr.length() == 0){

                }else{
                    mLastStr = mLastStr.substring(0,mLastStr.length() - 1);
                    mEditInput.setText(mLastStr);
                }
            }else{
                mLastStr+=text;
                mEditInput.setText(mLastStr);
            }

        }
    }
}
