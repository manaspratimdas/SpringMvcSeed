package nee.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * 
 * Initialized the webapplication. All the configuration that is done on web.xml
 * can be done here. We define servlet,servlet filter and servlet listner here
 * 
 * @author Manas.Das 
 */
public class NeeWebAppInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext) throws ServletException {

		/* WebApplicationContext implementation which accepts annotated classes
		 as input*/
		AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
		appContext.register(ApplicationContextConfig.class);

		// Dispatcher Servlet
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("SpringDispatcher",
				new DispatcherServlet(appContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");

		dispatcher.setInitParameter("contextClass", appContext.getClass().getName());

		servletContext.addListener(new ContextLoaderListener(appContext));

	}

}
