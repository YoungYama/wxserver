package com.yzz.not.used.util;

import java.io.File;
import java.net.URI;

/**
 * 获取文件编译到的绝对路径
 * 
 * @author 杨志钊
 * @date 2017-3-22 下午4:39:29
 * 
 */
public class CurrentPathTest {

	public static void main(String[] args) throws Exception {
		URI url = CurrentPathTest.class.getClassLoader().getResource("")
				.toURI();
		File file = new File(url);
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getParent());
		System.out.println(new File(file.getParent() + "\\web.xml").exists());
		System.out.println(new File(file.getAbsolutePath() + "\\path.properties").exists());
	}

}
