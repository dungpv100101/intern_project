package com.example.demo_keycloak_security_final.handler;

import com.example.demo_keycloak_security_final.dto.request.RequestData;
import com.example.demo_keycloak_security_final.dto.request.command.CommandRequestData;
import com.example.demo_keycloak_security_final.dto.request.query.QueryRequestData;
import com.example.demo_keycloak_security_final.handler.command.CommandHandler;
import com.example.demo_keycloak_security_final.handler.query.QueryHandler;
import lombok.NoArgsConstructor;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;

import javax.annotation.PostConstruct;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;

@Component
@NoArgsConstructor
public class HandlerManagement implements ApplicationContextAware {
    private ApplicationContext context;
    private Map<Class<? extends CommandRequestData>, CommandHandler> COMMAND_HANDLER_MAP = new HashMap<>();
    private Map<Class<? extends QueryRequestData>, QueryHandler> QUERY_HANDLER_MAP = new HashMap<>();

    public <T extends RequestData> IHandler getHandler(T requestData) {
        if (requestData instanceof CommandRequestData) return getCommandHandler(requestData);
        if (requestData instanceof QueryRequestData) return getQueryHandler(requestData);
        return null;
    }
    private <T extends RequestData> CommandHandler getCommandHandler(T requestData) {
        return COMMAND_HANDLER_MAP.get(requestData.getClass());
    }

    private <T extends RequestData> QueryHandler getQueryHandler(T requestData) {
        return QUERY_HANDLER_MAP.get(requestData.getClass());
    }

    @PostConstruct
    private void init() {
        initCommandHandlerMap();
        initQueryHandlerMap();
    }

    private void initCommandHandlerMap() {
        Map<String, CommandHandler> handles = context.getBeansOfType(CommandHandler.class);
        handles.forEach((key, value) -> {
            Class<CommandHandler> temp = (Class<CommandHandler>) ClassUtils.getUserClass(value);

            String requestBeanName = ((ParameterizedType) temp.getGenericSuperclass())
                    .getActualTypeArguments()[0]
                    .getTypeName();

            Class request = getClassByName(requestBeanName);

            COMMAND_HANDLER_MAP.put(request, value);
        });
    }

    private void initQueryHandlerMap() {
        Map<String, QueryHandler> handles = context.getBeansOfType(QueryHandler.class);
        handles.forEach((key, value) -> {
            Class<QueryHandler> temp = (Class<QueryHandler>) ClassUtils.getUserClass(value);

            String requestBeanName = ((ParameterizedType) temp.getGenericSuperclass())
                    .getActualTypeArguments()[0]
                    .getTypeName();

            Class request = getClassByName(requestBeanName);

            QUERY_HANDLER_MAP.put(request, value);
        });
    }

    private Class getClassByName(String name) {
        try {
            Class newClass = Class.forName(name);
            return newClass;
        } catch (ClassNotFoundException e) {
            System.out.println(e.toString());
        }
        return null;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
