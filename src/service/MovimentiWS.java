/**
 * MovimentiWS.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package service;

public interface MovimentiWS extends java.rmi.Remote {
    public service.ResponseMovimenti findById(java.lang.Integer arg0) throws java.rmi.RemoteException;
    public service.ResponseMovimenti find(service.RicercaDb arg0) throws java.rmi.RemoteException;
    public service.Response remove(service.Movimenti arg0) throws java.rmi.RemoteException;
    public service.ResponseMovimenti findAll(java.lang.Boolean arg0) throws java.rmi.RemoteException;
    public service.Response insert(service.Movimenti arg0) throws java.rmi.RemoteException;
    public service.Response update(service.Movimenti arg0) throws java.rmi.RemoteException;
}
