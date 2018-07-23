package main.Configuration;
import java.util.Optional;

import Controllers.ServletIndex;
import Controllers.ServletTopics;
import eu.lestard.easydi.EasyDI;
import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;

public class Main {

    public static final Optional<String> PORT = Optional.ofNullable(System.getenv("PORT"));
    public static final Optional<String> HOSTNAME = Optional.ofNullable(System.getenv("HOSTNAME"));

    public static void main(String[] args) throws Exception {
        String contextPath = "/" ;
        String appBase = ".";
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(Integer.valueOf(PORT.orElse("8080") ));
        tomcat.setHostname(HOSTNAME.orElse("localhost"));
        tomcat.getHost().setAppBase(appBase);
        Context context = tomcat.addWebapp(contextPath,appBase);
//        EasyDI easyDI = new EasyDI();
        Tomcat.addServlet(context, "ServletIndex", new ServletIndex());  //paduot easyDi reikia :)
        Tomcat.addServlet(context,"ServletTopics",new ServletTopics());  //paduot easyDi reikia :)

//        context.
//        context.addServletMapping("/ServletIndex" , "ServletIndex");
//        context.addServletMapping("/ServletTopics","ServletTopics");



        tomcat.addWebapp(contextPath, appBase); // bbz



        tomcat.start();
        tomcat.getServer().await();
    }
}