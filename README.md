# Prueba_ViaFirma

#### ¿Cómo harías para poder ejecutar N veces el proceso sobre el mismo directorio y solo modificar cada pdf una sola vez?
Comprobaría la fecha de la última modificación del archivo y si ya ha sido modificado saltaría al siguiente.

#### ¿Qué pasa si el directorio contiene un fichero que no es un pdf?
Se puede filtrar los archivos del directorio con FilenameFilter y quedarse solo con los pdf.

#### ¿Cómo probar / ejecutar la aplicación?
Desde un IDE.

#### ¿Cómo podemos ver los logs?
Buscar en la carpeta del proyecto una carpeta llamada log o buscar en las propiedades del proyecto el directorio donde se almacena estos archivos. 