package staj.eTicaret;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableSwagger2
public class ETicaretApplication {

	public static void main(String[] args) {
		SpringApplication.run(ETicaretApplication.class, args);
	}
	
	/* @Bean
	    public Docket api() { 
	        return new Docket(DocumentationType.SWAGGER_2)  
	          .select()                                  
	          .apis(RequestHandlerSelectors.basePackage("staj.eTicaret;"))                                   
	          .build();                                           
	    }*/

}
