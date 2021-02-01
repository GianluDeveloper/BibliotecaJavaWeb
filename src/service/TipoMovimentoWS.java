/**
 * TipoMovimentoWS.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package service;

public interface TipoMovimentoWS extends java.rmi.Remote {
	public service.ResponseTipoMovimento findById(java.lang.Integer arg0) throws java.rmi.RemoteException;

	public service.ResponseTipoMovimento find(service.RicercaDb arg0) throws java.rmi.RemoteException;

	public service.Response remove(service.TipoMovimento arg0) throws java.rmi.RemoteException;

	public service.ResponseTipoMovimento findAll(java.lang.Boolean arg0) throws java.rmi.RemoteException;

	public service.Response insert(service.TipoMovimento arg0) throws java.rmi.RemoteException;

	public service.Response update(service.TipoMovimento arg0) throws java.rmi.RemoteException;
}
