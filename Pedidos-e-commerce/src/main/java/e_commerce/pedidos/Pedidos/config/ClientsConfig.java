package e_commerce.pedidos.Pedidos.config;


import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "e_commerce.pedidos.Pedidos.client")
public class ClientsConfig {
}
