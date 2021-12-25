package printBean;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.AppConfig;

public class PrintBeanTest {
	
	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
	
	@Test
	@DisplayName("모든 빈 출력하기.")
	public void printAllBeans(){
		String[] beanDefinitionNames = ac.getBeanDefinitionNames();
		for(String beanDefinitionName : beanDefinitionNames) {
			Object bean = ac.getBean(beanDefinitionName);
			System.out.println("bean = " + beanDefinitionName + " Object = " + bean);
		}
		System.out.println("--------------------------------");
	}
	
	@Test
	@DisplayName("애플리케이션 빈 출력하기.")
	public void printApplicationBeans() {
		String[] beanDefinitionNames = ac.getBeanDefinitionNames();
		for(String beanDefinitionName : beanDefinitionNames) {
			BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);
			
			// ROLE_APPLICATION : 직접 등록한 어플리케이션 빈
			// ROLE_INFRASTRUCTURE : 스프링이 내부에서 사용하는 빈 
			if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
				Object bean = ac.getBean(beanDefinitionName);
				System.out.println("bean = " + beanDefinitionName + " Object = " + bean);
			}
		}
	}

}
