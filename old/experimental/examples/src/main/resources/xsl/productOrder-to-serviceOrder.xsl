<xsl:stylesheet version="2.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xs="http://www.w3.org/2001/XMLSchema"
	xmlns:xmime="http://www.w3.org/2005/05/xmlmime" xmlns:o="http://orange.com/soa/schemas/oadl/v2"
	xmlns:js="json-schema.org" xmlns:json="http://json.org/"
	exclude-result-prefixes="o xs js xmime">

	<xsl:import href="productOrderXml-to-serviceOrderXml.xsl" />
	<xsl:import href="serviceOrderXml-to-serviceOrderJson.xsl" />

	<!-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ TEMPLATE ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->

	<xsl:template match="/productorder">

		<xsl:variable name="serviceOrder" select="o:generate(.)" />

		<xsl:value-of select="json:generate($serviceOrder)" />

	</xsl:template>


</xsl:stylesheet>
