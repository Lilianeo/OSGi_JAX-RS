/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eclipse.osgiee.simpleclient;

import java.util.List;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 *
 * @author USER
 */
public class ClientActivator implements BundleActivator{
private BundleContext ctx;
    @Override
    public void start(final BundleContext bc) throws Exception {
       this.ctx=bc;
       System.out.println(" ClienActivator started");
       
       new Thread(){
           public void run(){
               ServiceLocator sl=new ServiceLocator(bc);
               try
               {
                   List<Bundle> b= sl.getBundleUtils(4).getBundles_();
                   sl.getBundleUtils(4).installBundle_("‪C:\\Users\\USER\\Downloads\\ping.psb.jar");
                   sl.getBundleUtils(4).startBundle(1);//comment récuperer le ping.psb en question  en question 
                 //  sl.getBundleUtils(0).stopBundle(1);
                //   sl.getBundleUtils(0).updateBundle(1);
                   
               }catch(Exception ex)
               {
                   
               }
           }
       };
               }

    @Override
    public void stop(BundleContext bc) 
    {
          System.out.println("Stopping th bundle");
    }
  
}
