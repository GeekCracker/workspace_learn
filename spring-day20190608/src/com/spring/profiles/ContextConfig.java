package com.spring.profiles;

import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

@Configuration
@PropertySource(value={})
public class ContextConfig implements EmbeddedValueResolverAware{
	@Override
	public void setEmbeddedValueResolver(StringValueResolver arg0) {
		
	}
}
