/**
 * ResponseMovimenti.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package service;

public class ResponseMovimenti extends service.Response implements java.io.Serializable {
	private service.Movimenti[] movimenti;

	public ResponseMovimenti() {
	}

	public ResponseMovimenti(java.lang.String description, int errorCode, boolean successo,
			service.Movimenti[] movimenti) {
		super(description, errorCode, successo);
		this.movimenti = movimenti;
	}

	/**
	 * Gets the movimenti value for this ResponseMovimenti.
	 * 
	 * @return movimenti
	 */
	public service.Movimenti[] getMovimenti() {
		return movimenti;
	}

	/**
	 * Sets the movimenti value for this ResponseMovimenti.
	 * 
	 * @param movimenti
	 */
	public void setMovimenti(service.Movimenti[] movimenti) {
		this.movimenti = movimenti;
	}

	public service.Movimenti getMovimenti(int i) {
		return this.movimenti[i];
	}

	public void setMovimenti(int i, service.Movimenti _value) {
		this.movimenti[i] = _value;
	}

	private java.lang.Object __equalsCalc = null;

	public synchronized boolean equals(java.lang.Object obj) {
		if (!(obj instanceof ResponseMovimenti))
			return false;
		ResponseMovimenti other = (ResponseMovimenti) obj;
		if (obj == null)
			return false;
		if (this == obj)
			return true;
		if (__equalsCalc != null) {
			return (__equalsCalc == obj);
		}
		__equalsCalc = obj;
		boolean _equals;
		_equals = super.equals(obj) && ((this.movimenti == null && other.getMovimenti() == null)
				|| (this.movimenti != null && java.util.Arrays.equals(this.movimenti, other.getMovimenti())));
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
		if (getMovimenti() != null) {
			for (int i = 0; i < java.lang.reflect.Array.getLength(getMovimenti()); i++) {
				java.lang.Object obj = java.lang.reflect.Array.get(getMovimenti(), i);
				if (obj != null && !obj.getClass().isArray()) {
					_hashCode += obj.hashCode();
				}
			}
		}
		__hashCodeCalc = false;
		return _hashCode;
	}

	// Type metadata
	private static org.apache.axis.description.TypeDesc typeDesc = new org.apache.axis.description.TypeDesc(
			ResponseMovimenti.class, true);

	static {
		typeDesc.setXmlType(new javax.xml.namespace.QName("http://service/", "responseMovimenti"));
		org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("movimenti");
		elemField.setXmlName(new javax.xml.namespace.QName("", "movimenti"));
		elemField.setXmlType(new javax.xml.namespace.QName("http://service/", "movimenti"));
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
	public static org.apache.axis.encoding.Serializer getSerializer(java.lang.String mechType,
			java.lang.Class _javaType, javax.xml.namespace.QName _xmlType) {
		return new org.apache.axis.encoding.ser.BeanSerializer(_javaType, _xmlType, typeDesc);
	}

	/**
	 * Get Custom Deserializer
	 */
	public static org.apache.axis.encoding.Deserializer getDeserializer(java.lang.String mechType,
			java.lang.Class _javaType, javax.xml.namespace.QName _xmlType) {
		return new org.apache.axis.encoding.ser.BeanDeserializer(_javaType, _xmlType, typeDesc);
	}

}
