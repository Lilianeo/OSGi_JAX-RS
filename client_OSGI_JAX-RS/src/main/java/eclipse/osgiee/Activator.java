package eclipse.osgiee;

import java.util.List;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import java.util.List;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 *
 * @author USER
 */
public class Activator implements BundleActivator{
private BundleContext ctx;
    @Override
    public void start(final BundleContext bc) throws Exception {
       this.ctx=bc;
       System.out.println(" ClienActivator started");
        ServiceLocator sl=new ServiceLocator(bc);
               try
               { 
                  sl.getBundleUtils(0).hello();
                         //  List<Bundle> b= sl.getBundleUtils(0).getBundles_();
                  // sl.getBundleUtils(0).installBundle_("‪C:\\Users\\USER\\Downloads\\ping.psb.jar");
                  // sl.getBundleUtils(0).startBundle(5);//comment récuperer le ping.psb en question  en question 
                 //  sl.getBundleUtils(0).stopBundle(1);
                //   sl.getBundleUtils(0).updateBundle(1);
              
                   
               }catch(Exception ex)
               {
                      System.out.println(" ClienActivator tawaghiiiiiiiiith");
                   
               }
       
       new Thread(){
           public void run(){
               ServiceLocator sl=new ServiceLocator(bc);
               try
               {
                   List<Bundle> b= sl.getBundleUtils(0).getBundles_();
                   sl.getBundleUtils(0).installBundle_("‪C:\\Users\\USER\\Downloads\\ping.psb.jar");
                  // sl.getBundleUtils(0).startBundle(5);//comment récuperer le ping.psb en question  en question 
                 //  sl.getBundleUtils(0).stopBundle(1);
                //   sl.getBundleUtils(0).updateBundle(1);
              
                   
               }catch(Exception ex)
               {
                      System.out.println(" ClienActivator error");
                   
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
