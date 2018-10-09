package org.dentinger.boot2demo;

import org.dentinger.boot2demo.handlers.DemoHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Component
public class DemoRouter {

    @Bean
    public RouterFunction<ServerResponse> route(DemoHandler greetingHandler) {

        return RouterFunctions
                .route(RequestPredicates.GET("/hello").
                        and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), greetingHandler::hello);
    }
}
