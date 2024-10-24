package com.github.carloslopllo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

@Mojo(name="pluginTestSmell", defaultPhase=LifecyclePhase.TEST)
public class MyMojo extends AbstractMojo {
    // Parámetro para las rutas del src (varias rutas)
    @Parameter(property = "mainPaths", required = true)
    private String[] mainPaths;

    // Parámetro para las rutas del test (varias rutas)
    @Parameter(property = "testPaths", required = true)
    private String[] testPaths;

    // Parámetro para el nombre del proyecto
    @Parameter(property = "projectName", required = true)
    private String projectName;

    // Parámetro para el nombre del archivo CSV
    @Parameter(property = "csvName", required = true)
    private String csvName;

    // Parámetro para el directorio donde se guardará el CSV
    @Parameter(property = "csvDirectory", required = true)
    private String csvDirectory;

    // Parámetro para la ruta al archivo .jar
    @Parameter(property = "jarPath", required = true)
    private String jarPath;

    //Parámetro para la ruta del CSV de salida
    @Parameter(property = "exitPath", required = true)
    private String exitPath;

    public void execute() throws MojoExecutionException {
        File csvFile = csvParamJar();

    }

    private File csvParamJar() throws MojoExecutionException {
        getLog().debug("Parámetros: projectName=" + projectName + ", csvName=" + csvName + ", csvDirectory=" + csvDirectory);
        getLog().debug("Test paths: " + String.join(", ", testPaths));
        getLog().debug("Main paths: " + String.join(", ", mainPaths));

        // Crear el archivo CSV
        File csvFile = new File(csvDirectory, csvName);

        try (FileWriter writer = new FileWriter(csvFile)) {
            // Iterar sobre las rutas de pruebas y producción y escribirlas en el CSV
            for (int i = 0; i < testPaths.length; i++) {
                getLog().debug("Escribiendo en CSV: projectName=" + projectName + ", testPath=" + testPaths + ", mainPath=" + mainPaths);
                String testPath = testPaths[i];
                String mainPath = i < mainPaths.length ? mainPaths[i] : "";

                // Escribir línea en el archivo CSV
                writer.write(projectName + "," + testPath + "," + mainPath + "\n");
            }

            getLog().info("CSV creado en: " + csvFile.getAbsolutePath() + " con nombre " + csvName);
        } catch (IOException e) {
            getLog().error("Error creando el archivo CSV", e);
            throw new MojoExecutionException("Error creando el archivo CSV", e);
        }
        return csvFile;
    }
}
