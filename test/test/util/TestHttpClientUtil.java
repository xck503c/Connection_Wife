package test.util;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import com.xck.util.HttpClientUtil;

public class TestHttpClientUtil {

	public static void main(String[] args){
		//HttpClientUtil.connectionUrl("http://a.nuist.edu.cn/index.php?url=aHR0cDovL2dvLm1pY3Jvc29mdC5jb20vZndsaW5rLz9MaW5rSUQ9MjE5NDcyJmNsY2lkPTB4NDA5&LinkID=219472&clcid=0x409");
		for(int i=0; i<20; i++){
			try {
				HttpClientUtil.connectionUrl("http://a.nuist.edu.cn/index.php/index/login?username=02502325322&domain=Unicom&password=MzIxMTIz&enablemacauth=0");
//              http://a.nuist.edu.cn/index.php/index/login?username=02502325322&domain=Unicom&password=&enablemacauth=0
				Thread.currentThread().sleep(1000*60*3);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
		}
	}
}
