package com.salomondev;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class ApiCrudPostgresqlInterceptorApplicationTests {

    @Test
    void contextLoads() {
        ApiCrudPostgresqlInterceptorApplication.main(new String[] {});
        assertTrue(true);
    }

}