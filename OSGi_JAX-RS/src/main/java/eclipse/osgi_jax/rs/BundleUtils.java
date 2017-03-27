/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eclipse.osgi_jax.rs;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import org.osgi.framework.Bundle;

/**
 * Ici, on définit l'interface qui contient toutes les focntionalité du ervice BundlesUtils
 */
 @Path("/BundleUtils")
 public interface BundleUtils {
     String ECHO_TYPE_PROP = "echo_type";
   @GET
   @Produces("text/plain")
   @Path("/hello") 
     public void hello();   //fonction pour test
   
   @GET
   @Path("/installBundle")
     public void installBundle_( @QueryParam("URLjar")String URLjar);
   @GET
   @Path("/getBundles")
     public List<Bundle> getBundles_();
     
   @GET
   @Path("/startBundle")
     public void startBundle( @QueryParam("URLjar") int idBundle);
   
   @GET
   @Path("/stopBundle")
     public void stopBundle(@QueryParam("URLjar") int idBundle);
   
   @GET
   @Path("/updateBundle")
    public void updateBundle( @QueryParam("URLjar") int idBundle);
   
    @GET
   @Path("/uninstallBundle")
    public void uninstallBundle( @QueryParam("URLjar") int idBundle);

   
}

