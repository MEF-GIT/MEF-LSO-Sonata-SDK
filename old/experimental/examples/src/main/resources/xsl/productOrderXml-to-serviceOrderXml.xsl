<xsl:stylesheet version="2.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xs="http://www.w3.org/2001/XMLSchema"
                xmlns:xmime="http://www.w3.org/2005/05/xmlmime" xmlns:o="http://orange.com/soa/schemas/oadl/v2"
                xmlns:js="json-schema.org" xmlns:json="http://json.org/"
                exclude-result-prefixes="o xs js xmime">

    <xsl:output method="xml" version="1.0" encoding="UTF-8"
                indent="yes" />

    <xsl:strip-space elements="*" />

    <!-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ TEMPLATE ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->

    <!-- Template to match the root node so that the stylesheet can also be
        used on the command line. -->
    <xsl:template match="/productorder">

        <xsl:copy-of select="o:generate(.)" />

    </xsl:template>

    <!-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->
    <!-- Root -->
    <!-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->

    <xsl:function name="o:generate" as="node()">
        <xsl:param name="input" as="node()" />

        <serviceOrder>
            <xsl:copy-of select="$input/note" />
            <externalId>
                <xsl:value-of select="$input/externalId" />
            </externalId>
            <priority>
                <xsl:value-of select="$input/expeditePriority" />
            </priority>
            <xsl:copy-of select="$input/requestedStartDate" />
            <xsl:copy-of select="$input/requestedCompletionDate" />

            <xsl:for-each select="$input/relatedParty">
                <xsl:if
                        test="role = 'Buyer' or role = 'Implementation Contact' or role = 'Technical Contact' ">
                    <relatedParty json:force-array="true">
                        <xsl:copy-of select="node()" />
                    </relatedParty>
                </xsl:if>
            </xsl:for-each>

            <xsl:for-each select="$input/orderItem">
                <orderItem json:force-array="true">
                    <xsl:copy-of select="id" />
                    <xsl:copy-of select="action" />
                    <serviceSpecification>
                        <xsl:if test="starts-with(product/productSpecification/id,'UNISpec')">
                            <id>UNI_ServiceSpec</id>
                            <metatype>UNI_ServiceSpec</metatype>
                        </xsl:if>
                        <xsl:if test="starts-with(product/productSpecification/id,'eLine')">
                            <id>eLine_ServiceSpec</id>
                            <metatype>eLine_ServiceSpec</metatype>
                        </xsl:if>
                        <xsl:if test="starts-with(product/productSpecification/id,'UNICE')">
                            <id>UNICEEndPoint_ServiceSpec</id>
                            <metatype>UNICEEndPoint_ServiceSpec</metatype>
                        </xsl:if>
                        <xsl:if test="starts-with(product/productSpecification/id ,'ENNICE')">
                            <id>ENNICEEndPoint_ServiceSpec</id>
                            <metatype>ENNICEEndPoint_ServiceSpec</metatype>
                        </xsl:if>
                    </serviceSpecification>
                    <xsl:for-each select="orderItemRelationship">
                        <orderItemRelationship json:force-array="true">
                            <xsl:copy-of select="node()" />
                        </orderItemRelationship>
                    </xsl:for-each>
                    <service>
                        <id></id>
                        <serviceState>Active</serviceState>
                        <serviceRelationship json:force-array="true">
                            <xsl:copy-of select="product/productRelationship/type" />
                            <service>
                                <xsl:copy-of select="product/productRelationship/product/id" />
                            </service>
                        </serviceRelationship>

                        <xsl:if test="product/geographicAddress/role = 'UNI Site'">
                            <xsl:for-each select="product/geographicAddress">
                                <geographicAddress json:force-array="true">
                                    <xsl:copy-of select="node()" />
                                </geographicAddress>
                            </xsl:for-each>
                        </xsl:if>

                        <xsl:if test="product/geographicLocation/role = 'UNI Site'">
                            <xsl:for-each select="product/geographicLocation">
                                <geographicLocation json:force-array="true">
                                    <xsl:copy-of select="node()" />
                                </geographicLocation>
                            </xsl:for-each>
                        </xsl:if>

                        <xsl:if test="product/site/role = 'UNI Site'">
                            <xsl:for-each select="product/site">
                                <site json:force-array="true">
                                    <xsl:copy-of select="node()" />
                                </site>
                            </xsl:for-each>
                        </xsl:if>

                        <xsl:for-each select="product/relatedParty">
                            <xsl:if
                                    test="role = 'Buyer' or role = 'Implementation Contact' or role = 'Technical Contact' ">
                                <relatedParty json:force-array="true">
                                    <xsl:copy-of select="node()" />
                                </relatedParty>
                            </xsl:if>
                        </xsl:for-each>

                        <xsl:if test="starts-with(product/productSpecification/id ,'ENNICE')">
                            <xsl:for-each select="product/svlanId" json:force-array="true" >
                                <xsl:copy-of select="json:create-array-number-svlanId(node())"/>
                            </xsl:for-each>
                            <xsl:copy-of select="product/svlanIdLast" />
                            <xsl:for-each select="product/ingressBWProfile" json:force-array="true" >
                                <ingressBWProfile json:force-array="true" >
                                    <cosId><xsl:value-of select="cosId" /></cosId>
                                    <cir>
                                        <amount datatype="int"><xsl:value-of select="cir/amount" /></amount>
                                        <unit><xsl:value-of select="cir/unit" /></unit>
                                    </cir>
                                </ingressBWProfile>
                            </xsl:for-each>
                            <xsl:for-each select="product/egressBWProfile">
                                <egressBWProfile json:force-array="true">
                                    <xsl:copy-of select="node()" />
                                </egressBWProfile>
                            </xsl:for-each>
                            <xsl:copy-of select="product/type" />
                            <xsl:copy-of select="product/schemaLocation" />
                            <xsl:copy-of select="product/BandwidthProfile" />
                            <xsl:copy-of select="product/informationRate" />
                        </xsl:if>
                        <xsl:if test="starts-with(product/productSpecification/id,'UNICE')">
                            <xsl:copy-of select="product/subscriberMegMipEnabled" />
                            <xsl:for-each select="product/cvlanId" json:force-array="true" >
                                <xsl:copy-of select="json:create-array-number-cvlanId(node())"/>
                            </xsl:for-each>
                            <xsl:copy-of select="product/cvlanidLast" />
                            <xsl:for-each select="product/ingressBWProfile" json:force-array="true" >
                                <ingressBWProfile json:force-array="true" >
                                    <cosId><xsl:value-of select="cosId" /></cosId>
                                    <cir>
                                        <amount datatype="int"><xsl:value-of select="cir/amount" /></amount>
                                        <unit><xsl:value-of select="cir/unit" /></unit>
                                    </cir>
                                </ingressBWProfile>
                            </xsl:for-each>
                            <xsl:for-each select="product/egressBWProfile">
                                <egressBWProfile json:force-array="true">
                                    <xsl:copy-of select="node()" />
                                </egressBWProfile>
                            </xsl:for-each>
                            <xsl:copy-of select="product/BandwidthProfile" />
                            <xsl:copy-of select="product/informationRate" />
                        </xsl:if>
                        <xsl:if test="starts-with(product/productSpecification/id,'eLine')">
                            <xsl:copy-of select="product/buyerId" />
                            <mtuSize datatype="int"><xsl:value-of select="product/mtuSize" /></mtuSize>
                            <xsl:copy-of select="product/colorFowardingEnabled" />
                        </xsl:if>
                        <xsl:if test="starts-with(product/productSpecification/id,'UNISpec')">
                            <xsl:copy-of select="product/buyerId" />
                            <xsl:copy-of select="product/physicalLayer" />
                            <xsl:copy-of select="product/synchronousModeEnabled" />
                            <xsl:copy-of select="product/numberOfLinks" />
                            <xsl:copy-of select="product/tokenShareEnabled" />
                            <xsl:copy-of select="product/uniResiliency" />
                            <xsl:copy-of select="product/maxServiceFrameSize" />
                            <xsl:copy-of select="product/allToOneBundling" />
                            <xsl:copy-of select="product/linkOamEnabled" />
                            <xsl:copy-of select="product/UniMegEnabled" />
                            <xsl:copy-of select="product/UniElmiEnabled" />
                            <xsl:copy-of select="product/UniL2CpAddressSet" />
                            <xsl:copy-of select="product/serviceMultiplexing" />
                            <xsl:copy-of select="product/bundling" />
                            <maxAggBw>
                                <amount datatype="int"><xsl:value-of select="product/maxAggBw/amount" /></amount>
                                <xsl:copy-of select="product/maxAggBw/unit" />
                            </maxAggBw>
                            <xsl:copy-of select="product/informationRate" />
                        </xsl:if>
                    </service>
                </orderItem>
            </xsl:for-each>
        </serviceOrder>
    </xsl:function>


    <xsl:function name="json:create-array-number-cvlanId" as="node()">
        <xsl:param name="node" as="node()"/>
        <xsl:element name="cvlanId" json:force-array="true" >
            <xsl:attribute name="datatype">int</xsl:attribute>
            <xsl:attribute name="json:force-array">true</xsl:attribute>
            <xsl:value-of select="$node" />
        </xsl:element>
    </xsl:function>

    <xsl:function name="json:create-array-number-svlanId" as="node()">
        <xsl:param name="node" as="node()"/>
        <xsl:element name="svlanId" json:force-array="true" >
            <xsl:attribute name="datatype">int</xsl:attribute>
            <xsl:attribute name="json:force-array">true</xsl:attribute>
            <xsl:value-of select="$node" />
        </xsl:element>
    </xsl:function>

</xsl:stylesheet>
