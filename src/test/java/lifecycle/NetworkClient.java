package lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class NetworkClient implements InitializingBean, DisposableBean {

	private String url;
	
	public NetworkClient() {
		System.out.println("������ ȣ�� : " + url);
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	// ���� ���۽� ȣ��
	public void connect() {
		System.out.println("connect : " + url);
	}
	
	public void call(String message) {
		System.out.println("call : " + url + " message : " + message);
	}
	
	// ���� ����� ȣ��
	public void disconnect() {
		System.out.println("disconnect : " + url);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet");
		connect();
		call("�ʱ�ȭ ���� �޽���");
	}
	
	@Override
	public void destroy() throws Exception{
		System.out.println("destroy");
		disconnect();
	}
}
