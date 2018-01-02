//package com.crypto.initializer;
 
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
// 
//@Configuration
//@EnableWebMvc
//@ComponentScan(basePackages = "com.websystique.springmvc")
package com.crypto.initializer;  
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
@Configuration 
@ComponentScan("com.crypto") 
@EnableWebMvc   
public class AppConfig {  
} 