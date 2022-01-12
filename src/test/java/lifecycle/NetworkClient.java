package lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient {

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

	/*implements InitializingBean, DisposableBean ��� */ 
//	@Override
//	public void afterPropertiesSet() throws Exception {
//		System.out.println("afterPropertiesSet");
//		connect();
//		call("�ʱ�ȭ ���� �޽���");
//	}
//	
//	@Override
//	public void destroy() throws Exception{
//		System.out.println("destroy");
//		disconnect();
//	}
	
	/*@Bean(initMethod="init", destroyMethod="close" ��� */ 
//	public void init() {
//		System.out.println("afterPropertiesSet");
//		connect();
//		call("�ʱ�ȭ ���� �޽���");
//	}
//	
//	public void close() {
//		System.out.println("destroy");
//		disconnect();
//	}
	
	@PostConstruct
	public void init() {
		System.out.println("afterPropertiesSet");
		connect();
		call("�ʱ�ȭ ���� �޽���");
	}
	@PreDestroy
	public void close() {
		System.out.println("destroy");
		disconnect();
	}


}
