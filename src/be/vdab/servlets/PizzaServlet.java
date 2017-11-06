package be.vdab.servlets;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.vdab.entities.Pizza;
import be.vdab.repositories.PizzaRepository;

@WebServlet("/pizzas.htm")
public class PizzaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/pizzas.jsp";
	private static final String PIZZA_REQUESTS = "pizzaRequests";
	private final PizzaRepository pizzaRepository = new PizzaRepository();
	private String pizzaFotosPad;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		((AtomicInteger) this.getServletContext().getAttribute(PIZZA_REQUESTS)).incrementAndGet();
		List<Pizza> pizzas = pizzaRepository.findAll();
		request.setAttribute("pizzas", pizzas);
		request.setAttribute("pizzaIdsMetFoto",
			pizzas.stream()
				.filter(pizza -> Files.exists(Paths.get(pizzaFotosPad,
					pizza.getId() + ".jpg")))
				.map(pizza -> pizza.getId())
				.collect(Collectors.toList()));
		request.getRequestDispatcher(VIEW).forward(request, response);
	}
	
	@Override
	public void init() throws ServletException {
		this.getServletContext().setAttribute(PIZZA_REQUESTS, new AtomicInteger());
		pizzaFotosPad = this.getServletContext().getRealPath("/pizzafotos");
	}
}