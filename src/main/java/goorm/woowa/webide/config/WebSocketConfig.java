package goorm.woowa.webide.config;

import goorm.woowa.webide.common.handler.JwtInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketTransportRegistration;

@Configuration
@EnableWebSocketMessageBroker
@RequiredArgsConstructor
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    private final JwtInterceptor jwtInterceptor;
    //todo error handler
    // custom shake handler

    @Override
    public void configureWebSocketTransport(WebSocketTransportRegistration registration) {
        registration.setMessageSizeLimit(1024 * 1024);
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry){
        // `/sub`에게 모두 전달
        registry.enableSimpleBroker("/queue");

        // `/pub` 시작 메시지가 message-handling methods로 라우팅
        registry.setApplicationDestinationPrefixes("/pub");

    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws")
                .addInterceptors()
                .setAllowedOrigins("*").withSockJS();
        //todo: errorhandler, handshake handler 추가
    }

    @Override
    public void configureClientInboundChannel(ChannelRegistration registration) {
        registration.interceptors(jwtInterceptor);
    }
}
