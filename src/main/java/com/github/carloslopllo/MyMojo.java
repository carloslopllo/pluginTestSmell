package com.github.carloslopllo;

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

    }
}
