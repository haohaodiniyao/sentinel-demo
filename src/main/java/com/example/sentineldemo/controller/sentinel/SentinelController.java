package com.example.sentineldemo.controller.sentinel;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/sentinel")
public class SentinelController {
    @RequestMapping(value = "/test")
    @SentinelResource(value = "sentinelTest",blockHandler = "exceptionHandler",fallback = "fallback")
    public String sentinelTest(){
        System.out.println("请求");
        return "success";
    }
    public void exceptionHandler(String str, BlockException ex) {
        System.out.println("异常");
    }
    public void fallback() {
        System.out.println("降级");
    }
}
