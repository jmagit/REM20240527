package com.example;

import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.example.demos.Cliente;
import com.example.demos.Factura;
import com.example.demos.FacturaProxy;
import com.example.demos.FacturaRepository;
import com.example.demos.FacturaRepositoryImpl;
import com.example.demos.FacturaRepositoryMock;
import com.example.demos.FacturaService;
import com.example.demos.FacturaServiceImpl;
import com.example.demos.FacturaServiceProxy;
import com.example.demos.Instanciador;
import com.example.demos.composicion.Area;
import com.example.demos.composicion.Circulo;
import com.example.demos.composicion.Contenedor;
import com.example.demos.composicion.ContenedorDecorator;
import com.example.demos.composicion.ContenedorImpl;
import com.example.demos.composicion.ContenedorLoggerImpl;
import com.example.demos.composicion.ContenedorPersistente;
import com.example.demos.composicion.ContenedorPersistenteImpl;
import com.example.demos.composicion.Foto;
import com.example.demos.composicion.Panel;
import com.example.demos.composicion.Rectangulo;
import com.example.demos.composicion.Triangulo;
import com.example.demos.ingenieria.Arandela;
import com.example.demos.ingenieria.Carter;
import com.example.demos.ingenieria.Culata;
import com.example.demos.ingenieria.Motor;
import com.example.demos.ingenieria.TornilloEstrella;
import com.example.demos.ingenieria.TornilloPlano;
import com.example.demos.ingenieria.Vehiculo;
import com.example.juegos.Color;
import com.example.juegos.JuegoException;
import com.example.juegos.Pieza;
import com.example.juegos.Tablero;
import com.example.juegos.ajedrez.AjedrezJuego;
import com.example.juegos.ajedrez.Alfil;
import com.example.juegos.ajedrez.Caballo;
import com.example.juegos.ajedrez.Dama;
import com.example.juegos.ajedrez.PromocionEvent;
import com.example.juegos.ajedrez.Torre;

public class Demos {

	public static void main(String[] args) {
		proxies();
	}
	public static void proxies() {
		var cliente = Cliente.getBuilder().razonSocial("ACME S.L.").addCorreo("kk@acme.com").build();
		Factura factura = new FacturaProxy(1, cliente);
//		factura.loadLineas();
//		System.out.println(factura.getTotal());
////		factura.loadLineas();
//		System.out.println(factura.getTotal());
////		var lista = List.of("ddd", "333");
////		factura.setLineas(lista);
////		lista.clear();
		System.out.println("version local");
		FacturaService srv = new FacturaServiceImpl();
		factura = srv.getById(1);
		System.out.println(factura.getTotal());
		factura.loadLineas();
		System.out.println(factura.getTotal());
		System.out.println("version remota");
		srv = new FacturaServiceProxy();
		factura = srv.getById(1);
		System.out.println(factura.getTotal());
		factura.loadLineas();
		System.out.println(factura.getTotal());
		System.out.println("version remota");
		
	}
	public static void ingenieria() {
		var motor = (Motor)Motor.getNew()
				.addChild(Carter.getNew().addChild(new TornilloPlano(1)).addChild(new TornilloEstrella(1.5)))
				.addChild(Culata.getNew().addChild(new Arandela()).addChild(new Arandela()));
		System.out.println("Carter: " + motor.getCarter().get().getPeso());
		System.out.println("Culata: " + motor.getCulata().get().getPeso());
		System.out.println("Motor: " + motor.getPeso());
		var coche = new Vehiculo();
		coche.setMotor(motor);
		System.out.println("Vehiculo: " + coche.getPeso());
		System.out.println("Vehiculo Motor: " + coche.getMotor().getPeso());
	}
	
	public static void composicion() {
		Contenedor canvas = new ContenedorImpl();
		canvas = new ContenedorPersistenteImpl(new ContenedorLoggerImpl(canvas));
//		var canvas = new ContenedorLoggerImpl(original);
		canvas.addChild(new Circulo());
		canvas.addChild(new Triangulo());
		canvas.addChild(new Circulo());
		Contenedor hijo = new Panel();
		canvas.addChild(hijo);
		hijo.addChild(new Rectangulo());
		hijo.addChild(new Foto());
		Contenedor nieto = new Area();
		nieto.addChild(new Foto());
		hijo.addChild(nieto);
		nieto = new Panel();
		canvas.addChild(new Circulo());
		canvas.addChild(new Circulo());
		hijo.addChild(nieto);
		System.out.println(nieto.getContenedor());
		canvas.addChild(hijo);
		canvas.addChild(nieto);
		canvas.pintate();
		System.out.println(nieto.getContenedor());
		if(canvas instanceof ContenedorPersistente)
			((ContenedorPersistente)canvas).cargar();
	}
	@FunctionalInterface
	interface Comparador<T, R> {
		int compara(T a, R b);
	}
	public static void Reflexion(String[] args) throws JuegoException {
		boolean test = false;
		FacturaRepository dao;
		try {
			if (test) {
//				dao = (FacturaRepository) Instanciador.crear("com.example.demos.FacturaRepositoryMock");
				dao = (FacturaRepository) Instanciador.crearTest(FacturaRepository.class);
			} else {
//				dao = (FacturaRepository) Instanciador.crear("com.example.demos.FacturaRepositoryImpl");				
//				dao = (FacturaRepository) Instanciador.crear(FacturaRepositoryImpl.class.getName());				
				dao = (FacturaRepository) Instanciador.crearProduccion(FacturaRepository.class);
			}
			dao.removeById(1);
			var c = Class.forName("com.example.demos.FacturaRepositoryImpl");
			var instancia = c.newInstance();
			var m = instancia.getClass().getMethods()[6]; //. c.getMethod("removeById", Integer.TYPE);
			System.out.println(m.getName());
//			m.invoke(instancia, 3);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//		} catch (InstantiationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//		} catch (NoSuchMethodException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void Builder(String[] args) throws JuegoException {
		Reflexion(args);
		var cliente = Cliente.getBuilder().razonSocial("ACME S.L.").addCorreo("kk@acme.com").build();
		System.out.println(cliente);
//		cliente.setRazonSocial(null);
		try {
			var fld = cliente.getClass().getDeclaredField("nombre");
			fld.setAccessible(true);
			fld.set(cliente, null);
			System.out.println(cliente);
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		cliente = Cliente.getBuilder().nombre("Pepito", "Grillo").addTelefono("555 123 456").addTelefono("555 654 321")
//				.addTelefono("555 123 456").addDireccion("C/ Tripa Ballena 12").build();
//		System.out.println(cliente);
//		cliente = Cliente.getBuilder().nombre("Pepito", "Grillo")
////				.addTelefono("555 123 456")
////				.addTelefono("555 123 456")
////				.addDireccion("C/ Tripa Ballena 12")
//				.build();
//		var app = new Demos();
//		app.ajedrez();
//		String cad = null;
//
//		if (cad.equals("") || "".equals(cad)) {
//
//		}
//		var l = new ArrayList<String>();
//		ordena(l, new Comparador<String, String>() {
//			@Override
//			public int compara(String a, String b) {
//				return a.compareTo(b);
//			}
//		});
//		ordena(l, (a, b) -> a.compareTo(b));
//		ordena(l, (a, b) -> -a.toLowerCase().compareTo(b.toLowerCase()));
//		FacturaRepository dao = new FacturaRepositoryMock();
//		var kk = dao.getAll();
//		var f = dao.getById((Integer) 1);
//		dao.modify(f);
//		;
	}

	private static void ordena(List<String> lista, Comparador<String, String> comparador) {
		String eleAct = "", eleAnt = "";
		// ...
		if (comparador.compara(eleAct, eleAnt) == 0) {

		} else if (comparador.compara(eleAct, eleAnt) > 0) {

		}
	}

	private static final Scanner teclado = new Scanner(System.in);
	private static final PrintStream out = new PrintStream(System.out, true, StandardCharsets.UTF_8);

	public void ajedrez() {
		var juego = new AjedrezJuego();
		juego.inicializar();
		juego.addPromocionaListener(this::pidePieza);
		juego.addPromocionaListener(ev -> System.out.println(ev.getColor().toString()));
		do {
			try {
				pintaTablero(juego.getResultado());
				System.out.print("Juegan las " + (juego.getTurno() == Color.BLANCO ? "blancas" : "negras")
						+ ". Dame jugada [CFCF]: ");
				juego.jugada(teclado.nextLine().toUpperCase());
			} catch (JuegoException e) {
				System.out.println(e.getMessage());
			}
		} while (!juego.getFinalizado());
		System.out.println("Juego Finalizado");
	}

	private void pintaTablero(Tablero t) {
		for (int f = 8; f > 0; f--) {
			System.out.print(String.format("%2s ", f));
			for (int c = 1; c <= 8; c++) {
				if (t.hayPieza(f, c))
					System.out.print(String.format("%10s ", t.getPieza(f, c)));
				else
					System.out.print(Tablero.colorEscaque(f, c) == Color.BLANCO ? "            " : "-----------");
			}
			System.out.println();
		}
		for (char c = 'A'; c <= 'H'; c++) {
			System.out.print(String.format("%8c    ", c));
		}
		System.out.println();
	}

	private void pidePieza(PromocionEvent e) {
		System.out.print("\t1: Dama\n\t2: Alfil\n\t3: Torre\n\t4: Caballo\n\t5: Cancelar\n"
				+ "Dame la opción para promocionar el peón " + (e.getColor() == Color.BLANCO ? "blanco: " : "negro:"));
		switch (Integer.parseInt(teclado.nextLine())) {
		case 1:
			e.setPieza(new Dama(e.getColor()));
			break;
		case 2:
			e.setPieza(new Alfil(e.getColor()));
			break;
		case 3:
			e.setPieza(new Torre(e.getColor()));
			break;
		case 4:
			e.setPieza(new Caballo(e.getColor()));
			break;
		case 5:
			e.setCancel(true);
			break;
		default:
			e.setPieza(null);
			break;
		}
	}

}
