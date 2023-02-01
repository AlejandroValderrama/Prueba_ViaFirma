package org.prueba;

import java.io.FilenameFilter;
import java.io.File;
public class Filtro implements FilenameFilter {

    private String extension;

    public Filtro(String extension) {
        this.extension = extension;
    }

    @Override
    public boolean accept(File dir, String nombre) {
        return nombre.endsWith(extension);
    }
}
