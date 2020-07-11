package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	private Logger logger = LoggerFactory.getLogger(HelloController.class);

	@Autowired
	private DiscoveryClient client;

	@RequestMapping(value = { "/hello/{name}", "/hello" })
	@ResponseBody
	public String helloUsername(@PathVariable(value = "name") String userName) {
		ServiceInstance instance = client.getLocalServiceInstance();
		logger.info("hello,host:" + instance.getHost() + ",service_id:" + instance.getServiceId());
		return "hello " + (null == userName ? "" : userName).toString();
	}
}
