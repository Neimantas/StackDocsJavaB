package Controllers;

import Services.Modules.HigherServiceModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ServletListener implements ServletContextListener {
    public static Injector injector;
    //Run this before web application is started
    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        System.out.println("ServletContextListener started ===============================");
        injector = Guice.createInjector(new HigherServiceModule());
    }
}
