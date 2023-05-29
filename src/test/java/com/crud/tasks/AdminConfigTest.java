package com.crud.tasks;

import com.crud.tasks.config.AdminConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AdminConfigTest {
    @Autowired
    private AdminConfig adminConfig;
    @Test
    void getAdminMailTest(){
        Assertions.assertEquals("paulina.borzym@op.pl",adminConfig.getAdminMail());
    }
}
