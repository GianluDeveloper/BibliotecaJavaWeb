/**
 * MovimentiWSServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package service;

public class MovimentiWSServiceLocator extends org.apache.axis.client.Service implements service.MovimentiWSService {

    /**
	 * 
	 */
	private static final long serialVersionUID = 7006298408419273819L;

	public MovimentiWSServiceLocator() {
    }


    public MovimentiWSServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public MovimentiWSServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for MovimentiWSPort
    private java.lang.String MovimentiWSPort_address = "http://localhost:8080/EWalletBiblioteca/MovimentiWS";

    public java.lang.String getMovimentiWSPortAddress() {
        return MovimentiWSPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String MovimentiWSPortWSDDServiceName = "MovimentiWSPort";

    public java.lang.String getMovimentiWSPortWSDDServiceName() {
        return MovimentiWSPortWSDDServiceName;
    }

    public void setMovimentiWSPortWSDDServiceName(java.lang.String name) {
        MovimentiWSPortWSDDServiceName = name;
    }

    public service.MovimentiWS getMovimentiWSPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(MovimentiWSPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getMovimentiWSPort(endpoint);
    }

    public service.MovimentiWS getMovimentiWSPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            service.MovimentiWSServiceSoapBindingStub _stub = new service.MovimentiWSServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getMovimentiWSPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setMovimentiWSPortEndpointAddress(java.lang.String address) {
        MovimentiWSPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    @SuppressWarnings("rawtypes")
	public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (service.MovimentiWS.class.isAssignableFrom(serviceEndpointInterface)) {
                service.MovimentiWSServiceSoapBindingStub _stub = new service.MovimentiWSServiceSoapBindingStub(new java.net.URL(MovimentiWSPort_address), this);
                _stub.setPortName(getMovimentiWSPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    @SuppressWarnings("rawtypes")
	public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("MovimentiWSPort".equals(inputPortName)) {
            return getMovimentiWSPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://service/", "MovimentiWSService");
    }

    @SuppressWarnings("rawtypes")
	private java.util.HashSet ports = null;

    @SuppressWarnings({ "rawtypes", "unchecked" })
	public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://service/", "MovimentiWSPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("MovimentiWSPort".equals(portName)) {
            setMovimentiWSPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
