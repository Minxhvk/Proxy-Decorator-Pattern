package hello.proxy.config.v1_porxy;

import hello.proxy.app.v1.*;
import hello.proxy.config.v1_porxy.interface_proxy.OrderControllerInterfaceProxy;
import hello.proxy.config.v1_porxy.interface_proxy.OrderRepositoryInterfaceProxy;
import hello.proxy.config.v1_porxy.interface_proxy.OrderServiceInterfaceProxy;
import hello.proxy.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InterfaceProxyConfig {
    /***
     * 실제 객체가 아닌, Proxy 객체를 Spring Bean으로 등록한다.
     * 실제 객체는 Proxy 객체를 통해서 참조될 뿐. -> 실제 객체는 Spring에서 직접 관리하지 않음
     */

    @Bean
    public OrderControllerV1 orderController(LogTrace logTrace) {

        OrderControllerV1Impl orderControllerImpl = new OrderControllerV1Impl(orderService(logTrace));

        return new OrderControllerInterfaceProxy(orderControllerImpl, logTrace);
    }

    @Bean
    public OrderServiceV1 orderService(LogTrace logTrace) {

        OrderServiceV1Impl orderServiceImpl = new OrderServiceV1Impl(orderRepository(logTrace));
        return new OrderServiceInterfaceProxy(orderServiceImpl, logTrace);
    }

    @Bean
    public OrderRepositoryV1 orderRepository(LogTrace logTrace) {

        OrderRepositoryV1Impl orderRepositoryImpl = new OrderRepositoryV1Impl();
        return new OrderRepositoryInterfaceProxy(orderRepositoryImpl, logTrace);
    }

}
