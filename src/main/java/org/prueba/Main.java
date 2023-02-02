package org.prueba;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String ruta = System.getenv("VIAFIRMA_PATH");

        if(ruta!=null)
            addPage(ruta);
        else
            System.err.println("La variable de entorno \"VIAFIRMA_PATH\" no existe.");

    }

    public static File[] lista(String ruta) {
        File archivos = new File(ruta); //Obtengo los archivos de la ruta fijada en la variable de entorno.
        File[] pdfs;

        if(archivos.isDirectory()) {
            pdfs = archivos.listFiles(new Filtro(".pdf")); // Filtro los archivos para que sean solo pdf
        } else {
            if(archivos.isFile())
                System.err.println("La variable de entorno \"VIAFIRMA_PATH\" apunta a un fichero.");
            else
                System.err.println("La variable de entorno \"VIAFIRMA_PATH\" apunta a un directorio que no existe.");

            pdfs = null;
        }

        return pdfs;
    }

    public static void addPage(String ruta) throws IOException {
        File[] pdfs = lista(ruta); // Obtengo solo los pdfs.

        if(pdfs != null) {

            for (File contenido: pdfs) { // Recorro la lista
                File pdf = new File(contenido.getPath()); // Genero un objeto file del pdf
                PDDocument docu = PDDocument.load(pdf); // Cargo el documento

                try {
                    docu.addPage(new PDPage()); // Añado un nueva página al documento.
                    docu.save(pdf); // Guardo los cambios y cierro el documento.
                } finally {
                    docu.close();
                }

            }

        }


    }

}