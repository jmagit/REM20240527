package com.example.demos;

import java.lang.reflect.InvocationTargetException;

public class Instanciador {
	public static Object crear(String className, Object ... initargs) throws 
	  ClassNotFoundException, InvocationTargetException, 
	  InstantiationException, IllegalAccessException {
	      return Class.forName(className)
	          .getDeclaredConstructors()[0]
	          .newInstance(initargs);
	}
	public static Object crearTest(Class interfaz) throws 
	  ClassNotFoundException, InvocationTargetException, 
	  InstantiationException, IllegalAccessException {
	      return crear(interfaz.getName() + "Mock", null);
	}
	public static Object crearProduccion(Class interfaz) throws 
	  ClassNotFoundException, InvocationTargetException, 
	  InstantiationException, IllegalAccessException {
//	      return crear(interfaz.getName() + "Impl", null);
	      return crear(interfaz.getName() + "Adapter", null);
	}

}
