package com.example.learing;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import java.util.concurrent.Executor;


@Configuration
@EnableAsync
public class AppConfiguration {

    @Bean("customAsyncTask")
    public Executor asyncTaskExecutor() {
        ThreadPoolTaskExecutor asyncExecutor = new ThreadPoolTaskExecutor();
        asyncExecutor.setCorePoolSize(4);
        asyncExecutor.setQueueCapacity(150);
        asyncExecutor.setMaxPoolSize(4);
        asyncExecutor.setThreadNamePrefix("AsyncTaskThread-");
        asyncExecutor.initialize();
        return asyncExecutor;
    }
}
