package com.example.mytext;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class DEngLu extends Activity {
	private Button bt1;
	private Button bt2;
	private Button bt3;
	private Button bt4;
	private Button bt5;
	private Button bt6;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_denglu);
		bt1=(Button) findViewById(R.id.denglu);
		bt2=(Button) findViewById(R.id.xiaoxi);
		bt3=(Button) findViewById(R.id.pifu);
		bt4=(Button) findViewById(R.id.youxi);
		bt5=(Button) findViewById(R.id.shezhi);
		bt6=(Button) findViewById(R.id.fanhui1);
		bt1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(DEngLu.this, MainActivity.class);
				startActivity(intent);
			}
		});
		bt2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

			}
		});
		bt3.setOnClickListener(new OnClickListener() {
	
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

			}
		});
		bt4.setOnClickListener(new OnClickListener() {
	
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

			}
		});
		bt5.setOnClickListener(new OnClickListener() {
	
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

			}
		});
		bt6.setOnClickListener(new OnClickListener() {
	
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(DEngLu.this, MainActivity.class);
				startActivity(intent);
			}
		});
	}
}
