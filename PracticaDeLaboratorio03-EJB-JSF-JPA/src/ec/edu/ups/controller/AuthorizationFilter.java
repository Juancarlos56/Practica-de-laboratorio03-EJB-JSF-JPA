package ec.edu.ups.controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter({"/Empleado/PrincipalEmpleadoJSF.jsf","/Empleado/CrearFactura.jsf","/Empleado/CrearUsuario.jsf",
			"/Empleado/ListarClientes.jsf","/Empleado/ListarFacturas.jsf","/Administrador/GestionarBodegas.jsf",
			"/Administrador/InformeGeneral.jsf"})
public class AuthorizationFilter implements Filter {

	public AuthorizationFilter() {
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		try {

			HttpServletRequest reqt = (HttpServletRequest) request;
			HttpServletResponse resp = (HttpServletResponse) response;
			HttpSession ses = reqt.getSession(false);

			String reqURI = reqt.getRequestURI();
			if (ses.getAttribute("contador") != null)
				chain.doFilter(request, response);
			else
				resp.sendRedirect(reqt.getContextPath() + "/menupricp.jsf");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void destroy() {

	}
}