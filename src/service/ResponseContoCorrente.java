/**
 * ResponseContoCorrente.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package service;

public class ResponseContoCorrente  extends service.Response  implements java.io.Serializable {
    private service.ContoCorrente[] contoCorrente;

    public ResponseContoCorrente() {
    }

    public ResponseContoCorrente(
           java.lang.String description,
           int errorCode,
           boolean successo,
           service.ContoCorrente[] contoCorrente) {
        super(
            description,
            errorCode,
            successo);
        this.contoCorrente = contoCorrente;
    }


    /**
     * Gets the contoCorrente value for this ResponseContoCorrente.
     * 
     * @return contoCorrente
     */
    public service.ContoCorrente[] getContoCorrente() {
        return contoCorrente;
    }


    /**
     * Sets the contoCorrente value for this ResponseContoCorrente.
     * 
     * @param contoCorrente
     */
    public void setContoCorrente(service.ContoCorrente[] contoCorrente) {
        this.contoCorrente = contoCorrente;
    }

    public service.ContoCorrente getContoCorrente(int i) {
        return this.contoCorrente[i];
    }

    public void setContoCorrente(int i, service.ContoCorrente _value) {
        this.contoCorrente[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ResponseContoCorrente)) return false;
        ResponseContoCorrente other = (ResponseContoCorrente) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.contoCorrente==null && other.getContoCorrente()==null) || 
             (this.contoCorrente!=null &&
              java.util.Arrays.equals(this.contoCorrente, other.getContoCorrente())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getContoCorrente() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getContoCorrente());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getContoCorrente(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ResponseContoCorrente.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://service/", "responseContoCorrente"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contoCorrente");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contoCorrente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://service/", "contoCorrente"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
