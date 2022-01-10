package applicationContextTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.support.GenericXmlApplicationContext;

public class ApplicationContextTest {
	//AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
	GenericXmlApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");
	
	
	@Test
	void findApplicationBeans() {
		String[] beanDefinitionNames = ac.getBeanDefinitionNames();
		for(String beanDefinitionName : beanDefinitionNames) {
			BeanDefinition beanDefiniton = ac.getBeanDefinition(beanDefinitionName);
			
			if(beanDefiniton.getRole() == BeanDefinition.ROLE_APPLICATION) {
				System.out.println("bean : " + beanDefinitionName + " beanDefinition : " + beanDefiniton );
			}
		}
	}

}
 