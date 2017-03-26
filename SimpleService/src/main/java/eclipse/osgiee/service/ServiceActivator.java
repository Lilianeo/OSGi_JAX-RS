/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eclipse.osgiee.service;

import eclipse.osgiee.common.BundleUtils;
import java.util.Hashtable;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

/**
 *
 * a ce niveau, on a l'enregistrement des services 
 */
public class ServiceActivator implements BundleActivator{
 private ServiceRegistration registration;
    @Override
    public void start(BundleContext bc) throws Exception {
    Hashtable props = new Hashtable();
  //  props.put("osgi.http.whiteboard.servlet.pattern", "/hello");
  //  props.put("servlet.init.message", "Hello World!");
 props.put("org.apache.cxf.ws.address",  "http://localhost:8080/converter");
    //this.registration = bc.registerService(Servlet.class.getName(), new HelloWorldServlet(), props);
        bc.registerService(BundleUtils.class.getName(), new ServiceImpl(), props);
        System.out.println("ServiceActivator started...");
         }

    @Override
    public void stop(BundleContext bc) throws Exception {
         System.out.println("ServiceActivator stoppend...");  
    }
    
}
