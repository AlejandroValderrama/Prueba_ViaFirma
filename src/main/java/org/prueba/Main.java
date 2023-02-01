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
        File archivos = new File(ruta); //Obtengo los archivos de la ruta fijada en la variable de entorno.
        String[] listaPdf;

        listaPdf = archivos.list(new Filtro(".pdf")); // Filtro los archivos para que sean solo pdf.

        return listaPdf;
    }

    public static void addPage(String ruta) throws IOException {
        String[] listaPdf = lista(ruta); // Obtengo solo los pdfs.

        for (String contenido: listaPdf) { // Recorro la lista
            File pdf = new File(ruta+"\\"+contenido); // Genero un objeto file del pdf
            PDDocument docu = PDDocument.load(pdf); // Cargo el documento
            docu.addPage(new PDPage()); // Añado un nueva página al documento.
            docu.save(pdf); // Guardo los cambios y cierro el documento.
            docu.close();
        }

    }

}