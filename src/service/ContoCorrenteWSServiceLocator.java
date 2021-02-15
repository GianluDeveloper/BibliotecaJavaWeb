/**
 * ContoCorrenteWSServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package service;

public class ContoCorrenteWSServiceLocator extends org.apache.axis.client.Service implements service.ContoCorrenteWSService {

    /**
	 * 
	 */
	private static final long serialVersionUID = 6259257787653595855L;

	public ContoCorrenteWSServiceLocator() {
    }


    public ContoCorrenteWSServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ContoCorrenteWSServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ContoCorrenteWSPort
    private java.lang.String ContoCorrenteWSPort_address = "http://localhost:8080/EWallet-0.1/ContoCorrenteWS";

    public java.lang.String getContoCorrenteWSPortAddress() {
        return ContoCorrenteWSPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ContoCorrenteWSPortWSDDServiceName = "ContoCorrenteWSPort";

    public java.lang.String getContoCorrenteWSPortWSDDServiceName() {
        return ContoCorrenteWSPortWSDDServiceName;
    }

    public void setContoCorrenteWSPortWSDDServiceName(java.lang.String name) {
        ContoCorrenteWSPortWSDDServiceName = name;
    }

    public service.ContoCorrenteWS getContoCorrenteWSPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ContoCorrenteWSPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getContoCorrenteWSPort(endpoint);
    }

    public service.ContoCorrenteWS getContoCorrenteWSPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            service.ContoCorrenteWSServiceSoapBindingStub _stub = new service.ContoCorrenteWSServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getContoCorrenteWSPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setContoCorrenteWSPortEndpointAddress(java.lang.String address) {
        ContoCorrenteWSPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    @SuppressWarnings("rawtypes")
	public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (service.ContoCorrenteWS.class.isAssignableFrom(serviceEndpointInterface)) {
                service.ContoCorrenteWSServiceSoapBindingStub _stub = new service.ContoCorrenteWSServiceSoapBindingStub(new java.net.URL(ContoCorrenteWSPort_address), this);
                _stub.setPortName(getContoCorrenteWSPortWSDDServiceName());
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
        if ("ContoCorrenteWSPort".equals(inputPortName)) {
            return getContoCorrenteWSPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://service/", "ContoCorrenteWSService");
    }

    @SuppressWarnings("rawtypes")
	private java.util.HashSet ports = null;

    @SuppressWarnings({ "rawtypes", "unchecked" })
	public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://service/", "ContoCorrenteWSPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ContoCorrenteWSPort".equals(portName)) {
            setContoCorrenteWSPortEndpointAddress(address);
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
