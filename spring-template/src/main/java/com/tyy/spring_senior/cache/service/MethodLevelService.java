package com.tyy.spring_senior.cache.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class MethodLevelService {
	@Cacheable("user")
	public Object f1(int id, String name) {
		return new Object();
	}
	
	// 即使方法不同，参数列表一致也会返回缓存数据（如果要避免这种状况，可以使用不同缓存区）
	@Cacheable("user")
	public Object f2(int id, String name) {
		return "abc";
	}
	
	
}
