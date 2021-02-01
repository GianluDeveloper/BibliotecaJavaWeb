package service;

public class ContoCorrenteWSProxy implements service.ContoCorrenteWS {
	private String _endpoint = null;
	private service.ContoCorrenteWS contoCorrenteWS = null;

	public ContoCorrenteWSProxy() {
		_initContoCorrenteWSProxy();
	}

	public ContoCorrenteWSProxy(String endpoint) {
		_endpoint = endpoint;
		_initContoCorrenteWSProxy();
	}

	private void _initContoCorrenteWSProxy() {
		try {
			contoCorrenteWS = (new service.ContoCorrenteWSServiceLocator()).getContoCorrenteWSPort();
			if (contoCorrenteWS != null) {
				if (_endpoint != null)
					((javax.xml.rpc.Stub) contoCorrenteWS)._setProperty("javax.xml.rpc.service.endpoint.address",
							_endpoint);
				else
					_endpoint = (String) ((javax.xml.rpc.Stub) contoCorrenteWS)
							._getProperty("javax.xml.rpc.service.endpoint.address");
			}

		} catch (javax.xml.rpc.ServiceException serviceException) {
		}
	}

	public String getEndpoint() {
		return _endpoint;
	}

	public void setEndpoint(String endpoint) {
		_endpoint = endpoint;
		if (contoCorrenteWS != null)
			((javax.xml.rpc.Stub) contoCorrenteWS)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);

	}

	public service.ContoCorrenteWS getContoCorrenteWS() {
		if (contoCorrenteWS == null)
			_initContoCorrenteWSProxy();
		return contoCorrenteWS;
	}

	public service.ResponseContoCorrente findById(java.lang.Integer arg0) throws java.rmi.RemoteException {
		if (contoCorrenteWS == null)
			_initContoCorrenteWSProxy();
		return contoCorrenteWS.findById(arg0);
	}

	public service.ResponseContoCorrente find(service.RicercaDb arg0) throws java.rmi.RemoteException {
		if (contoCorrenteWS == null)
			_initContoCorrenteWSProxy();
		return contoCorrenteWS.find(arg0);
	}

	public service.Response remove(service.ContoCorrente arg0) throws java.rmi.RemoteException {
		if (contoCorrenteWS == null)
			_initContoCorrenteWSProxy();
		return contoCorrenteWS.remove(arg0);
	}

	public service.ResponseContoCorrente findAll(java.lang.Boolean arg0) throws java.rmi.RemoteException {
		if (contoCorrenteWS == null)
			_initContoCorrenteWSProxy();
		return contoCorrenteWS.findAll(arg0);
	}

	public service.Response insert(service.ContoCorrente arg0) throws java.rmi.RemoteException {
		if (contoCorrenteWS == null)
			_initContoCorrenteWSProxy();
		return contoCorrenteWS.insert(arg0);
	}

	public service.Response update(service.ContoCorrente arg0) throws java.rmi.RemoteException {
		if (contoCorrenteWS == null)
			_initContoCorrenteWSProxy();
		return contoCorrenteWS.update(arg0);
	}

}