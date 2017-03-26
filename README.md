# OSGi_JAX-RS
This project aims to create a tool to manage OSGi bundles deployed on an EQUINOX container
# Common: 
we can find there the interface "BundleUtils" which contains the methods may be called by the Simple client
# SimpleService:
It contains "BundleUtilsImpl"; the implementation of methods of "BundlesUtils"(getBundles,installBundle,startBundle...) and also the a "ServiceActivator" used here for the registration of the service.
# SimpleClient
Contains "ClientActivator" andthe servce tracker in "ServiceLocator"
