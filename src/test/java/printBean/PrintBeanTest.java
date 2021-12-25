package printBean;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.AppConfig;

public class PrintBeanTest {
	
	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
	
	@Test
	@DisplayName("��� �� ����ϱ�.")
	public void printAllBeans(){
		String[] beanDefinitionNames = ac.getBeanDefinitionNames();
		for(String beanDefinitionName : beanDefinitionNames) {
			Object bean = ac.getBean(beanDefinitionName);
			System.out.println("bean = " + beanDefinitionName + " Object = " + bean);
		}
		System.out.println("--------------------------------");
	}
	
	@Test
	@DisplayName("���ø����̼� �� ����ϱ�.")
	public void printApplicationBeans() {
		String[] beanDefinitionNames = ac.getBeanDefinitionNames();
		for(String beanDefinitionName : beanDefinitionNames) {
			BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);
			
			// ROLE_APPLICATION : ���� ����� ���ø����̼� ��
			// ROLE_INFRASTRUCTURE : �������� ���ο��� ����ϴ� �� 
			if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
				Object bean = ac.getBean(beanDefinitionName);
				System.out.println("bean = " + beanDefinitionName + " Object = " + bean);
			}
		}
	}

}
