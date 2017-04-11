package com.yzz.not.used.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupTest {

	/**
	 * @author 杨志钊
	 * @date 2017-3-31 下午4:34:41
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		String outputStr = "public class WeChatErrorMsg { public static void main(String[] args) { System.out.println(errorMsg(-1)); }public static String errorMsg(int errorCode) { String errorMsg = null; switch (errorCode) {";
		String url = "https://mp.weixin.qq.com/wiki/10/6380dc743053a91c544ffd2b7c959166.html";
		Document doc = Jsoup.connect(url).get();
		Elements table = doc.getElementsByTag("table");
		Elements trs = table.select("tr");
		for (Element tr : trs) {
			Elements tds = tr.select("td");
			int count = 0;
			for (Element td : tds) {
				if (count == 0) {
					outputStr += " case " + td.html() + ": ";
				} else {
					outputStr += "errorMsg = \"" + td.html() + "\"; break; \n";
				}
				count++;
			}
		}
		outputStr += "} return errorMsg; } }";

		File file = new File("C:\\Users\\Administrator\\Desktop\\WeChatErrorMsg.java");
		FileOutputStream fos = new FileOutputStream(file);
		fos.write(outputStr.getBytes("UTF-8"));
		fos.close();
		System.out.println(outputStr);
	}

}
