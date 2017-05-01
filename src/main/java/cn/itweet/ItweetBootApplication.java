package cn.itweet;

import cn.itweet.common.repository.BaseRepositoryFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "cn.itweet",repositoryFactoryBeanClass = BaseRepositoryFactoryBean.class)
@SpringBootApplication
public class ItweetBootApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ItweetBootApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(ItweetBootApplication.class, args);
	}

}
