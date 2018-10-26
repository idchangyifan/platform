package com.orchard.platform.controller.anno;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@RestController
@RequestMapping(path = { "/api" }, produces = { "application/json" })
public @interface RestApi {
	String value() default "";
}
