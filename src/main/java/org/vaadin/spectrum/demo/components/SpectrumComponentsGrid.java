package org.vaadin.spectrum.demo.components;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.grid.Grid;

public class SpectrumComponentsGrid extends Grid<Class<? extends Object>> {

    private String npmApi = "https://registry.npmjs.com/-/v1/search?size=1&text=";

    public SpectrumComponentsGrid() {
        addColumn(c -> c.getAnnotation(Tag.class).value()).setHeader("Tag").setSortable(true);
        addColumn(Class::getSimpleName).setHeader("Component");
        addColumn(c -> c.getAnnotation(NpmPackage.class).version()).setHeader("Version");
        setWidthFull();
    }

}
