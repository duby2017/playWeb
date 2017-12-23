package com.dby.test.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Administrator on 2017/12/23.
 */
@FeignClient(value = "service-request")
public interface HelloService {

    @GetMapping(value = "/request/hello")
    String sayRequstHello(@RequestParam(value = "name") String name);
}
