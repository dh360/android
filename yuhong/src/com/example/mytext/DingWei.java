package com.example.mytext;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DingWei extends Activity {
	private Button bt1;
	private Button bt2;
	private Button bt3;
	private Button bt4;
	private Button bt5;
	private Button bt6;
	private Button bt7;
	private Button bt8;
	private Button bt9;
	private Button bt10;
	private Button bt11;
	private Button bt12;
	private Button bt13;
	private Button bt14;
	private Button bt15;
	private Button bt16;
	private Button bt17;
	private TextView tv1;
	private EditText ed1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dingwei);
		OnClickListener listener = new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				Button bt = (Button) arg0;
				Bundle bundle = new Bundle();
				Intent intent = new Intent();
				String name = bt.getText().toString();
				bundle.putString("result",name);
				intent.putExtras(bundle);
				setResult(0x101,intent);
				finish();

			}
		};
		bt1=(Button) findViewById(R.id.button1);
		bt1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Bundle bundle = new Bundle();
				Intent intent = new Intent();
				String name = ed1.getText().toString();
				bundle.putString("result",name);
				intent.putExtras(bundle);
				setResult(0x101,intent);
				finish();
			}
		});
		bt2=(Button) findViewById(R.id.button2);
		bt2.setOnClickListener(listener);
		bt3=(Button) findViewById(R.id.button3);
		bt3.setOnClickListener(listener);
		bt4=(Button) findViewById(R.id.button4);
		bt4.setOnClickListener(listener);
		bt5=(Button) findViewById(R.id.button5);
		bt5.setOnClickListener(listener);
		bt6=(Button) findViewById(R.id.button6);
		bt6.setOnClickListener(listener);
		bt7=(Button) findViewById(R.id.button7);
		bt7.setOnClickListener(listener);
		bt8=(Button) findViewById(R.id.button8);
		bt8.setOnClickListener(listener);
		bt9=(Button) findViewById(R.id.button9);
		bt9.setOnClickListener(listener);
		bt10=(Button) findViewById(R.id.button10);
		bt10.setOnClickListener(listener);
		bt11=(Button) findViewById(R.id.button11);
		bt11.setOnClickListener(listener);
		bt12=(Button) findViewById(R.id.button12);
		bt12.setOnClickListener(listener);
		bt13=(Button) findViewById(R.id.button13);
		bt13.setOnClickListener(listener);
		bt14=(Button) findViewById(R.id.button14);
		bt14.setOnClickListener(listener);
		bt15=(Button) findViewById(R.id.button15);
		bt15.setOnClickListener(listener);
		bt16=(Button) findViewById(R.id.button16);
		bt16.setOnClickListener(listener);
		bt17=(Button) findViewById(R.id.button17);
		bt17.setOnClickListener(listener);
		tv1=(TextView) findViewById(R.id.textView1);
		ed1=(EditText) findViewById(R.id.et1);
		
		
		
	}
}
