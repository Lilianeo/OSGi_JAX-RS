/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eclipse.osgiee;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.ServiceUnavailableException;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;


/**
 *
 * @author USER
 */
public class ServiceLocator {
    private ServiceTracker st;
    
    public ServiceLocator(BundleContext bc)
    {
        st=new ServiceTracker(bc,BundleUtils.class.getName(),null);
        st.open();
    }
     
    public BundleUtils getBundleUtils(long timeout) throws ServiceUnavailableException
    {
        BundleUtils service=null;
        try {
            System.out.println("in");
            service=  BundleUtils.class.cast(timeout==-1 ? st.getService(): st.waitForService(timeout));
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
        if(service==null) throw new ServiceUnavailableException();
        return service;
    }
}

