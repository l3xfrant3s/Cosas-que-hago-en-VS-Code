const express = require('express');
const fs = require('fs');
const app = express();
const port = 3000;

// Ruta para obtener el valor actual del contador (GET)
app.get('/api/contador', (req, res) => {
    // Leer el archivo de texto y enviar el valor del contador
    fs.readFile('contador.txt', 'utf8', (err, data) => {
        if (err) {
            console.error(err);
            return res.status(500).send('Error al leer el archivo de texto.');
        }
        const contador = parseInt(data) || 0;
        res.json({ contador });
    });
});

// Ruta para incrementar el contador (POST)
app.post('/api/contador/incrementar', (req, res) => {
    // Leer el archivo de texto, incrementar el contador y guardar el archivo actualizado
    fs.readFile('contador.txt', 'utf8', (err, data) => {
        if (err) {
            console.error(err);
            return res.status(500).send('Error al leer el archivo de texto.');
        }
        const contador = parseInt(data) || 0;
        const nuevoContador = contador + 1;
        fs.writeFile('contador.txt', nuevoContador.toString(), (err) => {
            if (err) {
                console.error(err);
                return res.status(500).send('Error al escribir en el archivo de texto.');
            }
            res.json({ contador: nuevoContador });
        });
    });
});

// Ruta para resetear el contador (POST)
app.post('/api/contador/resetear', (req, res) => {
    // Reiniciar el contador y guardar el archivo actualizado
    const nuevoContador = 0;
    fs.writeFile('contador.txt', nuevoContador.toString(), (err) => {
        if (err) {
            console.error(err);
            return res.status(500).send('Error al escribir en el archivo de texto.');
        }
        res.json({ contador: nuevoContador });
    });
});

app.listen(port, () => {
    console.log(`Servidor escuchando en http://localhost:${port}`);
});