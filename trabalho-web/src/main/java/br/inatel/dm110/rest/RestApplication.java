package br.inatel.dm110.rest;

import java.util.HashSet;
import java.util.Set;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import br.inatel.dm110.impl.CustomerRestServiceImpl;
@ApplicationPath("/api")
public class RestApplication extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<>();

		classes.add(CustomerRestServiceImpl.class);
		return classes;
	}
}
