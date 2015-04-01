<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
xmlns="http://www.w3.org/TR/REC-html40">

<xsl:output
  method="xml"
  encoding="UTF-8"
  indent="yes"/>

    <xsl:template match="lfm/results">
        <albums>
            <xsl:for-each select="albummatches/album">
                <album>
                    <id>
                        <xsl:value-of select="id"/>
                    </id>
                    <name>
                        <xsl:value-of select="name"/>
                    </name>
                </album>
            </xsl:for-each>
        </albums>
    </xsl:template >

</xsl:stylesheet>
