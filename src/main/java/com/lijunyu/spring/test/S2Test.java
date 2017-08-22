package com.lijunyu.spring.test;

import org.seasar.framework.container.S2Container;
import org.seasar.framework.container.factory.SingletonS2ContainerFactory;

public class S2Test {
	private static final String PATH = "app.dicon";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SingletonS2ContainerFactory.setConfigPath(PATH);
		SingletonS2ContainerFactory.init();
		S2Container container = SingletonS2ContainerFactory.getContainer();
	}
}
