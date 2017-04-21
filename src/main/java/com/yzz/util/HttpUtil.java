package com.yzz.util;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class HttpUtil {
	
	/**
	 * get请求，返回JSONObject
	 * @param url 请求地址
	 * @return
	 * @throws ParseException
	 * @throws IOException
	 */
	public static JSONObject doGetStr(String url) throws ClientProtocolException, IOException{
		DefaultHttpClient client = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(url);
		JSONObject jsonObject = null;
		HttpResponse httpResponse = client.execute(httpGet);
		HttpEntity entity = httpResponse.getEntity();
		if(entity != null){
			String result = EntityUtils.toString(entity,"UTF-8");
			jsonObject = JSON.parseObject(result);
		}
		return jsonObject;
	}
	
	/**
	 * POST请求，返回JSONObject
	 * @param url 请求地址
	 * @param jsonString 设置的请求参数
	 * @return
	 * @throws ParseException
	 * @throws IOException
	 */
	public static JSONObject doPostStr(String url,String jsonString) throws ParseException, IOException{
		DefaultHttpClient client = new DefaultHttpClient();
		HttpPost httpost = new HttpPost(url);
		JSONObject jsonObject = null;
		httpost.setEntity(new StringEntity(jsonString,"UTF-8"));
		HttpResponse response = client.execute(httpost);
		String result = EntityUtils.toString(response.getEntity(),"UTF-8");
		jsonObject = JSON.parseObject(result);
		return jsonObject;
	}
	
}
//package com.yzz.util;
//
//import java.io.BufferedReader;
//import java.io.DataOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.io.OutputStream;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.text.ParseException;
//import java.util.Set;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//
//public class HttpUtil {
//
//	/**
//	 * get请求，返回JSONObject
//	 * 
//	 * @param url
//	 *            请求地址
//	 * @return
//	 * @throws ParseException
//	 * @throws IOException
//	 */
//	public static JSONObject doGetStr(String url) throws Exception {
//		JSONObject jsonObject = null;
//		HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(url).openConnection();
//		httpURLConnection.setRequestMethod("GET");// 设置URL请求方法，默认为“GET”
//
//		InputStream inputStream = httpURLConnection.getInputStream();
//		InputStreamReader isr = new InputStreamReader(inputStream);
//		if (HttpURLConnection.HTTP_OK == httpURLConnection.getResponseCode()) {
//			// 获取输入流
//			BufferedReader br = new BufferedReader(isr);
//			String line;
//			StringBuilder sb = new StringBuilder();
//			while ((line = br.readLine()) != null) {// 循环读取流
//				sb.append(line);
//			}
//			// 关闭流
//			inputStream.close();
//			isr.close();
//			br.close();
//			httpURLConnection.disconnect();// 断开连接
//
//			jsonObject = JSON.parseObject(sb.toString());
//		}
//
//		return jsonObject;
//
//	}
//
//	/**
//	 * POST请求，返回JSONObject
//	 * 
//	 * @param url
//	 *            请求地址
//	 * @param jsonStr
//	 *            设置的请求参数
//	 * @return
//	 * @throws ParseException
//	 * @throws IOException
//	 */
//	public static JSONObject doPostStr(String url, String jsonStr) throws Exception {
//		JSONObject jsonObject = null;
//		HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(url).openConnection();
//		httpURLConnection.setRequestMethod("POST");// 设置URL请求方法，默认为“GET”
//		// 是否允许输入输出
//		httpURLConnection.setDoInput(true);
//		httpURLConnection.setDoOutput(true);
//		// 设置维持长连接
//		httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
//		// 设置文件字符集:
//		httpURLConnection.setRequestProperty("Charset", "UTF-8");
//		// 设置发送数据的格式
//		httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
//		// 链接地址
//		httpURLConnection.connect();
//		OutputStream outputStream = httpURLConnection.getOutputStream();
//		DataOutputStream out = new DataOutputStream(outputStream);
//
//		jsonObject = JSON.parseObject(jsonStr);
//		Set<String> keys = jsonObject.keySet();
//		StringBuilder params = new StringBuilder();
//		for (String key : keys) {
//			Object value = jsonObject.get(key);
//			params.append(key + "=" + value + "&");
//		}
//		params.deleteCharAt(params.lastIndexOf("&"));
//		
//		// 发送参数
//		out.writeBytes((params.toString()));
//		// 清理当前编辑器的左右缓冲区，并使缓冲区数据写入基础流
//		out.flush();
//		outputStream.close();
//		out.close();
//
//		if (HttpURLConnection.HTTP_OK == httpURLConnection.getResponseCode()) {
//			// 获取输入流
//			InputStream inputStream = httpURLConnection.getInputStream();
//			InputStreamReader isr = new InputStreamReader(inputStream);
//			BufferedReader br = new BufferedReader(isr);
//
//			String line;
//			StringBuilder sb = new StringBuilder();
//			while ((line = br.readLine()) != null) {// 循环读取流
//				sb.append(line);
//			}
//			// 关闭流
//			inputStream.close();
//			isr.close();
//			br.close();
//			httpURLConnection.disconnect();// 断开连接
//
//			jsonObject = JSON.parseObject(sb.toString());
//		}
//
//		return jsonObject;
//	}
//
//}

