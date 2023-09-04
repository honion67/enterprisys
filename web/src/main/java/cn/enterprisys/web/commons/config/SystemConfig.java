package cn.enterprisys.web.commons.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.validation.constraints.NotNull;


@Configuration
@ConfigurationProperties(prefix = "system")
@Setter
@Getter
public class SystemConfig {

    @NotNull
    private String name;
}
