package com.algaworks.algafood.core.web;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class ApiDeprecationHandler extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getRequestURI().startsWith("/v1/")) {
            response.addHeader("X-Algafood-Deprecated",
                    "Essa versãoda API está depreciada e deixará de existir a partir do dia 01/01/2024. " +
                            "Por favor, utilize a versão mais atual");

//            Desligamento de uma API
//            response.setStatus(HttpStatus.GONE.value());
        }
        return true;
    }
}
