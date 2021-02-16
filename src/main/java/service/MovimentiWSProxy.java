package service;

public class MovimentiWSProxy implements service.MovimentiWS {
  private String _endpoint = null;
  private service.MovimentiWS movimentiWS = null;
  
  public MovimentiWSProxy() {
    _initMovimentiWSProxy();
  }
  
  public MovimentiWSProxy(String endpoint) {
    _endpoint = endpoint;
    _initMovimentiWSProxy();
  }
  
  private void _initMovimentiWSProxy() {
    try {
      movimentiWS = (new service.MovimentiWSServiceLocator()).getMovimentiWSPort();
      if (movimentiWS != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)movimentiWS)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)movimentiWS)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (movimentiWS != null)
      ((javax.xml.rpc.Stub)movimentiWS)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public service.MovimentiWS getMovimentiWS() {
    if (movimentiWS == null)
      _initMovimentiWSProxy();
    return movimentiWS;
  }
  
  public service.ResponseMovimenti findById(java.lang.Integer arg0) throws java.rmi.RemoteException{
    if (movimentiWS == null)
      _initMovimentiWSProxy();
    return movimentiWS.findById(arg0);
  }
  
  public service.ResponseMovimenti find(service.RicercaDb arg0) throws java.rmi.RemoteException{
    if (movimentiWS == null)
      _initMovimentiWSProxy();
    return movimentiWS.find(arg0);
  }
  
  public service.Response remove(service.Movimenti arg0) throws java.rmi.RemoteException{
    if (movimentiWS == null)
      _initMovimentiWSProxy();
    return movimentiWS.remove(arg0);
  }
  
  public service.ResponseMovimenti findAll(java.lang.Boolean arg0) throws java.rmi.RemoteException{
    if (movimentiWS == null)
      _initMovimentiWSProxy();
    return movimentiWS.findAll(arg0);
  }
  
  public service.Response insert(service.Movimenti arg0) throws java.rmi.RemoteException{
    if (movimentiWS == null)
      _initMovimentiWSProxy();
    return movimentiWS.insert(arg0);
  }
  
  public service.Response update(service.Movimenti arg0) throws java.rmi.RemoteException{
    if (movimentiWS == null)
      _initMovimentiWSProxy();
    return movimentiWS.update(arg0);
  }
  
  
}