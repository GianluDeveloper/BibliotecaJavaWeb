/**
 * ResponseTipoMovimento.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package service;

public class ResponseTipoMovimento  extends service.Response  implements java.io.Serializable {
    private service.TipoMovimento[] tipoMovimento;

    public ResponseTipoMovimento() {
    }

    public ResponseTipoMovimento(
           java.lang.String description,
           int errorCode,
           boolean successo,
           service.TipoMovimento[] tipoMovimento) {
        super(
            description,
            errorCode,
            successo);
        this.tipoMovimento = tipoMovimento;
    }


    /**
     * Gets the tipoMovimento value for this ResponseTipoMovimento.
     * 
     * @return tipoMovimento
     */
    public service.TipoMovimento[] getTipoMovimento() {
        return tipoMovimento;
    }


    /**
     * Sets the tipoMovimento value for this ResponseTipoMovimento.
     * 
     * @param tipoMovimento
     */
    public void setTipoMovimento(service.TipoMovimento[] tipoMovimento) {
        this.tipoMovimento = tipoMovimento;
    }

    public service.TipoMovimento getTipoMovimento(int i) {
        return this.tipoMovimento[i];
    }

    public void setTipoMovimento(int i, service.TipoMovimento _value) {
        this.tipoMovimento[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ResponseTipoMovimento)) return false;
        ResponseTipoMovimento other = (ResponseTipoMovimento) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.tipoMovimento==null && other.getTipoMovimento()==null) || 
             (this.tipoMovimento!=null &&
              java.util.Arrays.equals(this.tipoMovimento, other.getTipoMovimento())));
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
        if (getTipoMovimento() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTipoMovimento());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTipoMovimento(), i);
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
        new org.apache.axis.description.TypeDesc(ResponseTipoMovimento.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://service/", "responseTipoMovimento"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoMovimento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tipoMovimento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://service/", "tipoMovimento"));
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
