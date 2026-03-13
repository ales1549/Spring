package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import javax.servlet.ServletContext;


@Configuration
@EnableWebMvc
@ComponentScan(value="controller")
public class WebConf implements WebMvcConfigurer {
    @Autowired
    private ServletContext servContext;

    @Bean
    public ServletContextTemplateResolver templateResolver(){
        ServletContextTemplateResolver tempResolver = new ServletContextTemplateResolver(servContext);
        tempResolver.setTemplateMode(TemplateMode.HTML);
        tempResolver.setCharacterEncoding("UTF-8");
        tempResolver.setPrefix("/WEB-INF/pages/");
        tempResolver.setSuffix(".html");
        return tempResolver;
    }
    @Bean
    public SpringTemplateEngine templateEngine(){
        SpringTemplateEngine tempEngine = new SpringTemplateEngine();
        tempEngine.setTemplateResolver(templateResolver());
        tempEngine.setEnableSpringELCompiler(true);
        return tempEngine;
    }
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry){
        ThymeleafViewResolver res = new ThymeleafViewResolver();
        res.setTemplateEngine(templateEngine());
        res.setCharacterEncoding("UTF-8");
        res.setContentType("text/html;charset=UTF-8");
        registry.viewResolver(res);
    }
}
