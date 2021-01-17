package xyz.eden.learn.springboot.web.service;


import org.junit.jupiter.api.*;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

@DisplayName(value = "User Service 单元测试")
public class IUserServiceTest {

    @BeforeAll
    public static void beforeAll() {
        System.out.println("[@BeforeAll] beforeAll()");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("[@AfterAll] afterAll()");
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("[@BeforeEach] beforeEach()");

    }

    @AfterEach
    public void afterEach() {
        System.out.println("[@BeforeEach] afterEach()");
    }

    @DisplayName(value = "提供 id 获取 User")
    @Test
    public void getUserById() throws InterruptedException {
        System.out.println("[@Test] getUserById()");
        Assertions.assertTrue(Objects.equals(1, 1));
    }

    @Disabled
    @Test
    public void getUserList() {
        System.out.println("[@Test] getUserList()");
    }
}