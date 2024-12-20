package techbrain.think.insight.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import techbrain.think.insight.interceptor.TechBrainServiceInterceptor;

@Configuration
public class TechBrainServiceInterceptorAppConfig implements WebMvcConfigurer {

    private final TechBrainServiceInterceptor serviceInterceptor;

    public TechBrainServiceInterceptorAppConfig(TechBrainServiceInterceptor serviceInterceptor) {
        this.serviceInterceptor = serviceInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(serviceInterceptor);
    }
}
