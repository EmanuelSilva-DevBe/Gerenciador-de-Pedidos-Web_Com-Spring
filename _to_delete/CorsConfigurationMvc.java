package com.Emanuel.GerenciadorDePedidos.Configuration.Cors;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public interface CorsConfigurationMvc extends WebMvcConfigurer {
    void addCorsMapping(CorsRegistry registry);
}
