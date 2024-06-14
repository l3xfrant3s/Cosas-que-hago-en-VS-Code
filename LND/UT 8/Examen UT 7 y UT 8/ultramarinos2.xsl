<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
<xsl:template match="/">

<html>
    <head>
        <style>
            h1{color:yellow;}
            th{color:blue;}
            table, th, td{border: 1px solid black;}
        </style>
    </head>
    <body>
        <xsl:for-each select="//factura">
        <h1>Fecha de Factura: <xsl:value-of select="fecha"/><br/>Nombre del Comprador: <xsl:value-of select="comprador"/></h1>
        <table>
            <tr>
                <th>Nombre</th>
                <th>Unidades</th>
                <th>Precio</th>
                <th>Importe</th>
                <th>IGIC</th>
            </tr>
            <xsl:for-each select="producto">
            <tr>
                <td><xsl:value-of select="nombre"/></td>
                <td><xsl:value-of select="unidades"/></td>
                <td><xsl:value-of select="precio"/></td>
                <td><xsl:value-of select="unidades * precio"/></td>
                <td><xsl:value-of select="round(unidades * precio * 7) div 100"/></td>
            </tr>
            </xsl:for-each>
        </table>
        </xsl:for-each>
    </body>
</html>


</xsl:template>
</xsl:stylesheet>