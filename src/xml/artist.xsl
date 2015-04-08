<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
xmlns="http://www.w3.org/TR/REC-html40"
xmlns:ext="http://musicbrainz.org/ns/ext#-2.0">

<xsl:output
  method="xml"
  encoding="UTF-8"
  indent="yes"/>

    <xsl:template match="lfm/results">
        <artists>
            <xsl:for-each select="artistmatches/artist">
                <artist>
                    <id>
                        <xsl:value-of select="mbid"/>
                    </id>
                    <name>
                        <xsl:value-of select="name | title"/>
                    </name>
                    <url>
                        <xsl:value-of select="url"/>
                    </url>
                    <image>
                        <xsl:value-of select="image[@size='mega'] | image[@size='extralarge']"/>
                    </image>
                    <listeners>
                        <xsl:value-of select="listeners"/>
                    </listeners>
                </artist>
            </xsl:for-each>
        </artists>
    </xsl:template >

</xsl:stylesheet>
