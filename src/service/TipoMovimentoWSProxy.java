package service;

public class TipoMovimentoWSProxy implements service.TipoMovimentoWS {
	private String _endpoint = null;
	private service.TipoMovimentoWS tipoMovimentoWS = null;

	public TipoMovimentoWSProxy() {
		_initTipoMovimentoWSProxy();
	}

	public TipoMovimentoWSProxy(String endpoint) {
		_endpoint = endpoint;
		_initTipoMovimentoWSProxy();
	}

	private void _initTipoMovimentoWSProxy() {
		try {
			tipoMovimentoWS = (new service.TipoMovimentoWSServiceLocator()).getTipoMovimentoWSPort();
			if (tipoMovimentoWS != null) {
				if (_endpoint != null)
					((javax.xml.rpc.Stub) tipoMovimentoWS)._setProperty("javax.xml.rpc.service.endpoint.address",
							_endpoint);
				else
					_endpoint = (String) ((javax.xml.rpc.Stub) tipoMovimentoWS)
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
		if (tipoMovimentoWS != null)
			((javax.xml.rpc.Stub) tipoMovimentoWS)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);

	}

	public service.TipoMovimentoWS getTipoMovimentoWS() {
		if (tipoMovimentoWS == null)
			_initTipoMovimentoWSProxy();
		return tipoMovimentoWS;
	}

	public service.ResponseTipoMovimento findById(java.lang.Integer arg0) throws java.rmi.RemoteException {
		if (tipoMovimentoWS == null)
			_initTipoMovimentoWSProxy();
		return tipoMovimentoWS.findById(arg0);
	}

	public service.ResponseTipoMovimento find(service.RicercaDb arg0) throws java.rmi.RemoteException {
		if (tipoMovimentoWS == null)
			_initTipoMovimentoWSProxy();
		return tipoMovimentoWS.find(arg0);
	}

	public service.Response remove(service.TipoMovimento arg0) throws java.rmi.RemoteException {
		if (tipoMovimentoWS == null)
			_initTipoMovimentoWSProxy();
		return tipoMovimentoWS.remove(arg0);
	}

	public service.ResponseTipoMovimento findAll(java.lang.Boolean arg0) throws java.rmi.RemoteException {
		if (tipoMovimentoWS == null)
			_initTipoMovimentoWSProxy();
		return tipoMovimentoWS.findAll(arg0);
	}

	public service.Response insert(service.TipoMovimento arg0) throws java.rmi.RemoteException {
		if (tipoMovimentoWS == null)
			_initTipoMovimentoWSProxy();
		return tipoMovimentoWS.insert(arg0);
	}

	public service.Response update(service.TipoMovimento arg0) throws java.rmi.RemoteException {
		if (tipoMovimentoWS == null)
			_initTipoMovimentoWSProxy();
		return tipoMovimentoWS.update(arg0);
	}

}