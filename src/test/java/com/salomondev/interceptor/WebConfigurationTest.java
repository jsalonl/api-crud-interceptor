package com.salomondev.interceptor;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class WebConfigurationTest {

    @InjectMocks
    WebConfiguration webConfiguration;

    @Test
    void testAddInterceptors() {
        InterceptorRegistry interceptorRegistry = mock(InterceptorRegistry.class);
        ReflectionTestUtils.setField(webConfiguration, "generalInterceptor", new GeneralInterceptor());
        ReflectionTestUtils.setField(webConfiguration, "interceptorEnabled", true);
        webConfiguration.addInterceptors(interceptorRegistry);
        verify(interceptorRegistry).addInterceptor(any(GeneralInterceptor.class));
    }
}