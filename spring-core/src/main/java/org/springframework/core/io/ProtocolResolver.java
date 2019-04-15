/*
 * Copyright 2002-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.core.io;

import org.springframework.lang.Nullable;

/**
 *
 * 用户自定义协议资源解决策略
 * 它允许用户自定义资源加载协议，而不需要继承 ResourceLoader 的子类。
 * 有了 ProtocolResolver 后，我们不需要直接继承 DefaultResourceLoader，改为实现 ProtocolResolver 接口也可以实现自定义的 ResourceLoader。
 *
 * Spring 框架中并没有这个接口的实现类，在DefaultResourceLoader.java中的 addProtocolResolver 方法加入这个实现类即可加入 Spring 体系
 *
 * 		public void addProtocolResolver(ProtocolResolver resolver) {
 * 			Assert.notNull(resolver, "ProtocolResolver must not be null");
 * 			this.protocolResolvers.add(resolver);
 *      }
 *
 *
 */
@FunctionalInterface
public interface ProtocolResolver {

	/**
	 * 使用指定的 ResourceLoader ，解析指定的 location 。
	 * 若成功，则返回对应的 Resource 。
	 */
	@Nullable
	Resource resolve(String location, ResourceLoader resourceLoader);

}
