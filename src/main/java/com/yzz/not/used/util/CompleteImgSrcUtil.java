package com.yzz.not.used.util;

class CompleteImgSrcUtil {
	public static void main(String[] args) {
		String domain = "http://avatar.csdn.net";
		String html = "<img id = 'id' src='/0/E/B/1_baidu_33320352.jpg' class = 'class' /><img id = 'id' src='https://www.baidu.com/0/E/B/1_baidu_33320352.jpg'  class = 'class' /><img id = 'id' src='http://www.baidu.com/0/E/B/1_baidu_33320352.jpg'  class = 'class' />";
		System.out.println(html);
		html = html.replaceAll("<img(.*?)src=\'((?!http|hppts).*?)", "<img$1src=\'" + domain);
		System.out.println("-------------------------------");
		System.out.println(html);
	}
}