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
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;



public class MainActivity extends Activity {
	private Button bt1;
	private Button bt2;
	private ImageButton bt3;
	private Button bt4;
	private String cityname;
	private TextView tv_show0;
	private TextView tv_show1;
	private TextView tv_show2;
	private TextView tv_show3;
	private TextView tv_show4;
	private TextView tv_show5;
	private TextView tv_show6;
	private StringBuffer buffer;
	private WeatherMsg msg = new WeatherMsg();
	private Handler mHandler = new Handler() {
		public void handleMessage(android.os.Message handmsg) {
			tv_show0.setTextColor(Color.WHITE);
			tv_show0.setTextSize(60);
			tv_show0.setText(msg.toString());
			tv_show0.setText(msg.getCityName());
			tv_show1.setText(msg.getDay());
			tv_show2.setText(msg.getWeek());
			tv_show3.setText(msg.getTemp());
			tv_show4.setText(msg.getWeather());
			tv_show5.setText(msg.getHumidity());
			tv_show6.setText(msg.getWind());
		};
	};
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_ui);
		bt3=(ImageButton) findViewById(R.id.fenxiang);
		bt2=(Button) findViewById(R.id.weilai);
        bt1=(Button) findViewById(R.id.biaoji);
        bt4=(Button) findViewById(R.id.denglu);
        tv_show0=(TextView) findViewById(R.id.place);
		tv_show1 = (TextView) findViewById(R.id.day);
		tv_show2 = (TextView) findViewById(R.id.week);
		tv_show3 = (TextView) findViewById(R.id.temp);
		tv_show4 = (TextView) findViewById(R.id.weather);
		tv_show5 = (TextView) findViewById(R.id.humidity);
		tv_show6 = (TextView) findViewById(R.id.fengli);
		new MyThread().start();
        bt1.setOnClickListener(new OnClickListener() {
        	
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				new MyThread().start();
				intent.setClass(MainActivity.this, DingWei.class);
				startActivityForResult(intent, 0x100);
				
			}
		});
        bt2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				new MyThread().start();
				Bundle bundle=new Bundle();
				String str=tv_show0.getText().toString();
				bundle.putString("city", str);
				intent.putExtras(bundle);
				intent.setClass(MainActivity.this, WeiLai.class);
				startActivity(intent);
			}
		});
        bt3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(MainActivity.this, FenXiangActivity.class);
				startActivity(intent);
			}
		}); 
        bt4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(MainActivity.this, DEngLu.class);
				startActivity(intent);
			}
		}); 
    }
  
    private class MyThread extends Thread {
		@Override
		public void run() {
			String url = "http://v.juhe.cn/weather/index?format=2&cityname=";
			String url2 = "&key=422cee36626c7a824a438c1214d05914";
			cityname=tv_show0.getText().toString();
	  if(cityname.isEmpty())
         {
    	  cityname="烟台";
          }
			try {
				
				// 将中文转成utf-8格式
				cityname = new String(cityname.getBytes(), "utf-8");
				// 将中文转换成Urlencode格式
				cityname = URLEncoder.encode(cityname, "utf-8");

			} catch (UnsupportedEncodingException e) {
				
				e.printStackTrace();
			}
			try {
				URL mUrl = new URL(url + cityname + url2);
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
			msg.setCityName(object3.getString("city"));
			msg.setDay(object3.getString("date_y"));
			msg.setWeek(object3.getString("week"));
			msg.setTemp(object3.getString("temperature"));
			msg.setWeather(object3.getString("weather"));
			msg.setHumidity(object1.getString("humidity"));
			msg.setWind(object3.getString("wind"));
		}
	}

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    	if(requestCode==0x100&&resultCode==0x101){
			Bundle bundle=data.getExtras();
			String str = bundle.getString("result");
			tv_show0.setText(str);
			new MyThread().start();
		}
    	super.onActivityResult(requestCode, resultCode, data);
    } 
}
