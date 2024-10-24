package com.github.carloslopllo;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;

@Mojo(name="pluginTestSmell", defaultPhase=LifecyclePhase.TEST)
public class MyMojo extends AbstractMojo {
    public void execute() throws MojoExecutionException {

    }
}
