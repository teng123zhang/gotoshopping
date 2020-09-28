package com.rc.gmall2020.manage;

import java.io.IOException;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GmallManageWebApplicationTests {

	@Test
	public void contextLoads() {
		
	}
	
	@Test
	
	public void  textFileUpload() throws IOException,MyException{
		
		String file = this.getClass().getResource("/tracker.conf").getFile();
		ClientGlobal.init(file);
		TrackerClient trackerClient =new TrackerClient();
		TrackerServer trackerServer =trackerClient.getConnection();
		StorageClient storageClient = new StorageClient(trackerServer,null);
		String orginaFileName="D://pic//5.jpg";
		String[] upload_file=storageClient.upload_file(orginaFileName, "jpg", null);
		for(int i=0;i<upload_file.length;i++) {
			String s= upload_file[i];
			System.out.println("s="+s);
		}
		
		
	}

}
