/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eclipse.osgiee.service;

import aQute.bnd.annotation.component.Activate;
import aQute.bnd.annotation.component.Component;
import aQute.bnd.annotation.component.Deactivate;
import eclipse.osgiee.common.BundleUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.FrameworkUtil;

/**
 *
 * Ici on a l'impelemntation des services décrit dans BundleUtils
 */
@Component(immediate = true)
public class ServiceImpl implements BundleUtils,BundleActivator{
   private BundleContext ctx;
  
    @Override
    public void hello() {
    System.out.println("hello");
    }

    @Override
    public void installBundle_(String URLjar) {
       String prefix="file:";
       try {  
           ctx.installBundle(prefix+URLjar);
       } catch (BundleException ex) {
           Logger.getLogger(ServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

    @Override
    public List<Bundle> getBundles_() {
         //BundleContext ctx =  FrameworkUtil.getBundle(this.getClass()).getBundleContext();
        Bundle[] bundles=this.ctx.getBundles();
         for (int i = 0; i < bundles.length; i++) {
			Bundle bundle = bundles[i];
                         System.out.println("Bundle    "+bundle.getBundleId()+"  "+bundle.getSymbolicName()+"  "+bundle.getState());
     }
         List<Bundle> tabList = Arrays.asList(bundles);
        // return "aaaan";
       return tabList;
            }

    @Override
    public void startBundle(int idBundle)  {
       Bundle[] bundles = ctx.getBundles();
		for (Bundle bundle : bundles) {
			if(idBundle==bundle.getBundleId()){
                            try {
                                bundle.start();
                            } catch (BundleException ex) {
                                Logger.getLogger(ServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                            }
			}
		}
    }
    @Override
    public void stopBundle(int idBundle) {
        
         Bundle[] bundles = ctx.getBundles();
		for (Bundle bundle : bundles) {
			if(idBundle==bundle.getBundleId()){
                            try {
                                bundle.stop();
                            } catch (BundleException ex) {
                                Logger.getLogger(ServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                            }
			}
		}
           }
    @Override
    public void updateBundle(int idBundle) {
        Bundle[] bundles = ctx.getBundles();
		for (Bundle bundle : bundles) {
			if(idBundle==bundle.getBundleId()){
                            try {
                                bundle.update();
                            } catch (BundleException ex) {
                                Logger.getLogger(ServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                            }
			}
		}
    }

    @Override
    public void uninstallBundle(int idBundle) {
          Bundle[] bundles = ctx.getBundles();
		for (Bundle bundle : bundles) {
			if(idBundle==bundle.getBundleId()){
                            try {
                                bundle.uninstall();
                            } catch (BundleException ex) {
                                Logger.getLogger(ServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                            }
			}
		}
           }

    @Override
    public void start(BundleContext bc) throws Exception {
      this.ctx=bc;
    }

    @Override
    public void stop(BundleContext bc) throws Exception {
       }
    
}
