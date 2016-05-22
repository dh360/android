package com.example.mytext;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class WeiLai extends Activity {
	private Button bt1;
	private TextView tv0;
	private TextView tv1;
	private TextView tv2;
	private TextView tv3;
	private TextView tv4;
	private TextView tv5;
	private TextView tv6;
	private TextView tv7;
	private TextView tv8;
	private TextView tv9;
	private TextView tv10;
	private TextView tv11;
	private TextView tv12;
	private String cityname;
	private StringBuffer buffer;
	private WeatherMsg[] futureMsg;
	private Handler mHandler = new Handler() {
	public void handleMessage(android.os.Message handmsg) {
		
			tv0.setText(cityname);
			tv1.setText(futureMsg[1].getDay());
			tv2.setText(futureMsg[1].getWeek());
			tv3.setText(futureMsg[1].getTemp());
			tv4.setText(futureMsg[1].getWeather());
			tv5.setText(futureMsg[2].getDay());
			tv6.setText(futureMsg[2].getWeek());
			tv7.setText(futureMsg[2].getTemp());
			tv8.setText(futureMsg[2].getWeather());
			tv9.setText(futureMsg[3].getDay());
			tv10.setText(futureMsg[3].getWeek());
			tv11.setText(futureMsg[3].getTemp());
			tv12.setText(futureMsg[3].getWeather());
			
		};
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_weilai);
		bt1 = (Button) findViewById(R.id.fanhui);
		tv0 = (TextView) findViewById(R.id.cityname);
		tv1 = (TextView) findViewById(R.id.date1);
		tv2 = (TextView) findViewById(R.id.week1);
		tv3 = (TextView) findViewById(R.id.temp1);
		tv4 = (TextView) findViewById(R.id.weather1); 
		tv5 = (TextView) findViewById(R.id.date2);
		tv6 = (TextView) findViewById(R.id.week2);
		tv7 = (TextView) findViewById(R.id.temp2);
		tv8 = (TextView) findViewById(R.id.weather2);
		tv9 = (TextView) findViewById(R.id.date3);
		tv10 = (TextView) findViewById(R.id.week3);
		tv11= (TextView) findViewById(R.id.temp3);
		tv12= (TextView) findViewById(R.id.weather3);
		  Intent intent = getIntent();
		  Bundle bundle = intent.getExtras();
		  cityname = bundle.getString("city");
		  new MyThread().start();
		
		
		
		bt1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent();
				intent.setClass(WeiLai.this, MainActivity.class);
				startActivity(intent);
			}
		});
	}

	private class MyThread extends Thread {
		String cityname1;
		@Override
		public void run() {
			String url = "http://v.juhe.cn/weather/index?format=2&cityname=";
			String url2 = "&key=422cee36626c7a824a438c1214d05914";
			try {
				// 将中文转成utf-8格式
				 cityname1 = new String(cityname.getBytes(), "utf-8");
				// 将中文转换成Urlencode格式
				cityname1 = URLEncoder.encode(cityname1, "utf-8");
			} catch (UnsupportedEncodingException e) {

				e.printStackTrace();
			}
			try {
				URL mUrl = new URL(url + cityname1 + url2);
				// 打开连接
				URLConnection connection = mUrl.openConnection();
				InputStream is = connection.getInputStream();
				// 将字节流转换成字符流
				InputStreamReader reader = new InputStreamReader(is, "utf-8");
				buffer = new StringBuffer();
				int c = -1;
				while ((c = reader.read()) != -1) {
					buffer.append((char) c);
				}
				try {
					Log.i("test", buffer.toString());
					parserJson(buffer.toString());
				} catch (JSONException e) {

					e.printStackTrace();
				}// 数据解析完，实例化完成。
				mHandler.sendEmptyMessage(100);// 发送消息修改主界面后执行handleMessage

			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		private void parserJson(String json) throws JSONException {
			JSONObject object = new JSONObject(json);
			int resultCode = object.getInt("resultcode");
			
			if (resultCode != 200) {
				return;
			}
			JSONObject object2 = object.getJSONObject("result");
			JSONObject object1 = object2.getJSONObject("sk");
			JSONObject object3 = object2.getJSONObject("today");
			JSONArray objectArray = object2.getJSONArray("future");
			futureMsg = new WeatherMsg[objectArray.length()];
			for (int i = 0; i < objectArray.length(); i++) {
				JSONObject object4 = objectArray.getJSONObject(i);
				 WeatherMsg msg= new WeatherMsg();
				msg.setDay(object4.getString("date"));
				msg.setWeek(object4.getString("week"));
				msg.setTemp(object4.getString("temperature"));
				msg.setWeather(object4.getString("weather"));
				futureMsg[i]=msg;

			}

		}
	}
}
