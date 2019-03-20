package com.stylefeng.guns;

import com.stylefeng.guns.rest.AlipayApplication;
import com.stylefeng.guns.rest.common.util.FTPUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AlipayApplication.class)
public class GunsRestApplicationTests {

	@Autowired
	private FTPUtil ftpUtil;


	@Test
	public void contextLoads() {

		String fileStrByAddress = ftpUtil.getFileStrByAddress("seats/123214.json");

		File file = new File("C:/Users/hxk/Desktop/qrcode/qr-mooc.png");
		boolean b = ftpUtil.uploadFile("qr-mooc.png",file);
		System.out.println("上传是否成功:"+b);

		System.out.println(fileStrByAddress);
	}

}
