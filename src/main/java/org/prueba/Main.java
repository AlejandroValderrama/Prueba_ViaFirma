package org.prueba;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        addPage(System.getenv("VIAFIRMA_PATH"));

    }

    public static String[] lista(String ruta) {
        File dir = new File(ruta);
        String[] contenido;

        contenido = dir.list(new Filtro(".pdf"));

        return contenido;
    }

    public static void addPage(String ruta) throws IOException {
        String[] archivos = lista(ruta);

        for (String contenido: archivos) {
            File pdf = new File(ruta+"\\"+contenido);
            PDDocument docu = PDDocument.load(pdf);
            docu.addPage(new PDPage());
            docu.save(pdf);
            docu.close();
        }

    }
    
}