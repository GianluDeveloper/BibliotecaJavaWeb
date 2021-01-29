/**
 * ContoCorrenteWS.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package service;

public interface ContoCorrenteWS extends java.rmi.Remote {
    public service.ResponseContoCorrente findById(java.lang.Integer arg0) throws java.rmi.RemoteException;
    public service.ResponseContoCorrente find(service.RicercaDb arg0) throws java.rmi.RemoteException;
    public service.Response remove(service.ContoCorrente arg0) throws java.rmi.RemoteException;
    public service.ResponseContoCorrente findAll(java.lang.Boolean arg0) throws java.rmi.RemoteException;
    public service.Response insert(service.ContoCorrente arg0) throws java.rmi.RemoteException;
    public service.Response update(service.ContoCorrente arg0) throws java.rmi.RemoteException;
}
