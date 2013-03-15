<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
				version="1.0">
 
    <xsl:output method="xml" encoding="UTF-8" />
 
    <xsl:template match="csv-set">
        <order><xsl:apply-templates/></order>
    </xsl:template>
    
    <xsl:template match="csv-record">
    	<item>
    		<product-name><xsl:value-of select="product"/></product-name>
    		<quantity><xsl:value-of select="quantity"/></quantity>
    	</item>
    </xsl:template>
</xsl:stylesheet>