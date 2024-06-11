<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
<xsl:template match="/">

<html>
    <head>
        <style>
            table, th, td{border: 1px solid black}
        </style>
    </head>
    <body>
        <h1>Clasificación Liga <xsl:value-of select="//nacionalidad"/></h1>
        <table>
            <tr>
                <th>Equipo</th>
                <th>Puntuación</th>
                <th>Goles a favor</th>
                <th>Goles en contra</th>
                <th>Golaverage</th>
            </tr>
            <xsl:for-each select="//equipo">
            <tr>
                <td><xsl:value-of select="nombre"/></td>
                <td><xsl:value-of select="puntuacion"/></td>
                <td><xsl:value-of select="afavor"/></td>
                <td><xsl:value-of select="encontra"/></td>
                <xsl:choose>
                    <xsl:when test="(afavor - encontra) &gt; 0">
                        <td style="color:green;border-color:green"><xsl:value-of select="afavor - encontra"/></td>
                    </xsl:when>
                    <xsl:when test="(afavor - encontra) &lt; 0">
                        <td style="color:red;border-color:red"><xsl:value-of select="afavor - encontra"/></td>
                    </xsl:when>
                </xsl:choose>
            </tr>
            </xsl:for-each>
        </table>
    </body>
</html>

</xsl:template>
</xsl:stylesheet>