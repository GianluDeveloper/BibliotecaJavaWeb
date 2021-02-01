/**
 * Movimenti.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package service;

public class Movimenti implements java.io.Serializable {
	private java.lang.String dataMovimento;

	private int iban;

	private int id;

	private int idTipoMovimento;

	private float importo;

	public Movimenti() {
	}

	public Movimenti(java.lang.String dataMovimento, int iban, int id, int idTipoMovimento, float importo) {
		this.dataMovimento = dataMovimento;
		this.iban = iban;
		this.id = id;
		this.idTipoMovimento = idTipoMovimento;
		this.importo = importo;
	}

	/**
	 * Gets the dataMovimento value for this Movimenti.
	 * 
	 * @return dataMovimento
	 */
	public java.lang.String getDataMovimento() {
		return dataMovimento;
	}

	/**
	 * Sets the dataMovimento value for this Movimenti.
	 * 
	 * @param dataMovimento
	 */
	public void setDataMovimento(java.lang.String dataMovimento) {
		this.dataMovimento = dataMovimento;
	}

	/**
	 * Gets the iban value for this Movimenti.
	 * 
	 * @return iban
	 */
	public int getIban() {
		return iban;
	}

	/**
	 * Sets the iban value for this Movimenti.
	 * 
	 * @param iban
	 */
	public void setIban(int iban) {
		this.iban = iban;
	}

	/**
	 * Gets the id value for this Movimenti.
	 * 
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id value for this Movimenti.
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the idTipoMovimento value for this Movimenti.
	 * 
	 * @return idTipoMovimento
	 */
	public int getIdTipoMovimento() {
		return idTipoMovimento;
	}

	/**
	 * Sets the idTipoMovimento value for this Movimenti.
	 * 
	 * @param idTipoMovimento
	 */
	public void setIdTipoMovimento(int idTipoMovimento) {
		this.idTipoMovimento = idTipoMovimento;
	}

	/**
	 * Gets the importo value for this Movimenti.
	 * 
	 * @return importo
	 */
	public float getImporto() {
		return importo;
	}

	/**
	 * Sets the importo value for this Movimenti.
	 * 
	 * @param importo
	 */
	public void setImporto(float importo) {
		this.importo = importo;
	}

	private java.lang.Object __equalsCalc = null;

	public synchronized boolean equals(java.lang.Object obj) {
		if (!(obj instanceof Movimenti))
			return false;
		Movimenti other = (Movimenti) obj;
		if (obj == null)
			return false;
		if (this == obj)
			return true;
		if (__equalsCalc != null) {
			return (__equalsCalc == obj);
		}
		__equalsCalc = obj;
		boolean _equals;
		_equals = true
				&& ((this.dataMovimento == null && other.getDataMovimento() == null)
						|| (this.dataMovimento != null && this.dataMovimento.equals(other.getDataMovimento())))
				&& this.iban == other.getIban() && this.id == other.getId()
				&& this.idTipoMovimento == other.getIdTipoMovimento() && this.importo == other.getImporto();
		__equalsCalc = null;
		return _equals;
	}

	private boolean __hashCodeCalc = false;

	public synchronized int hashCode() {
		if (__hashCodeCalc) {
			return 0;
		}
		__hashCodeCalc = true;
		int _hashCode = 1;
		if (getDataMovimento() != null) {
			_hashCode += getDataMovimento().hashCode();
		}
		_hashCode += getIban();
		_hashCode += getId();
		_hashCode += getIdTipoMovimento();
		_hashCode += new Float(getImporto()).hashCode();
		__hashCodeCalc = false;
		return _hashCode;
	}

	// Type metadata
	private static org.apache.axis.description.TypeDesc typeDesc = new org.apache.axis.description.TypeDesc(
			Movimenti.class, true);

	static {
		typeDesc.setXmlType(new javax.xml.namespace.QName("http://service/", "movimenti"));
		org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("dataMovimento");
		elemField.setXmlName(new javax.xml.namespace.QName("", "dataMovimento"));
		elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setMinOccurs(0);
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("iban");
		elemField.setXmlName(new javax.xml.namespace.QName("", "iban"));
		elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("id");
		elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
		elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("idTipoMovimento");
		elemField.setXmlName(new javax.xml.namespace.QName("", "idTipoMovimento"));
		elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("importo");
		elemField.setXmlName(new javax.xml.namespace.QName("", "importo"));
		elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
		elemField.setNillable(false);
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
