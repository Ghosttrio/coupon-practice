package com.ghosttrio.couponpractice.blog;

import com.ghosttrio.couponpractice.blog.TestService.ExecuteProxy;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final ExecuteProxy executeProxy;

    @PostMapping("/test")
    public String test() {
        executeProxy.execute();
        return "ok";
    }
}
