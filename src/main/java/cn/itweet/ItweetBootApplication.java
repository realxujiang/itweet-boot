package cn.itweet;

import cn.itweet.modules.admin.document.utils.StorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class ItweetBootApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ItweetBootApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(ItweetBootApplication.class, args);
	}

}
