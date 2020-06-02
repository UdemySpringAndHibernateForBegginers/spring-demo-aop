package com.luv2code.aop.aroundwithhandleexception.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.luv2code.aop.aroundwithhandleexception")
public class DemoConfig {
}
