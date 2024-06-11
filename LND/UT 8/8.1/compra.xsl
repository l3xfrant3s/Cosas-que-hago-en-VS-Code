<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
<xsl:template match="/">
<!--Asumiendo que este archivo está en la misma carpeta que compra.xml
y que se añade la siguiente linea a compra.xml:
<?xml-stylesheet type="text/xsl" href="compra.xsl"?>
Debería funcionar-->
<html>
    <head>
        <style>
            h1{color:blue;}
            h2{color:green}
            table, th, td{border: 1px solid black}
        </style>
    </head>
    <body>
        <h1><xsl:value-of select="compra/lugar"/></h1>
        <h2><xsl:value-of select="compra/fecha"/></h2>
        <table>
            <tr>
                <th>Producto</th>
                <th>Unidades</th>
                <th>Precio</th>
                <th>Coste</th>
            </tr>
            <xsl:for-each select="//producto">
            <tr>
                <td><xsl:value-of select="nombre"/></td>
                <td><xsl:value-of select="unidades"/></td>
                <td><xsl:value-of select="precio"/></td>
                <td><xsl:value-of select="unidades * precio"/></td>
            </tr>
            </xsl:for-each>
        </table>
    </body>
</html>


</xsl:template>
</xsl:stylesheet>