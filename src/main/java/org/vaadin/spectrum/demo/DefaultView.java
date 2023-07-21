package org.vaadin.spectrum.demo;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.router.Route;
import org.reflections.Reflections;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.vaadin.spectrum.SpAsset;
import org.vaadin.spectrum.SpConstants;
import org.vaadin.spectrum.SpHtml;
import org.vaadin.spectrum.SpLink;
import org.vaadin.spectrum.demo.components.SpectrumComponentsGrid;
import org.vaadin.spectrum.properties.HasSizeFluent;

import java.util.Set;

@Route(value = "", layout = DemoLayout.class)
public class DefaultView extends Div {

    public DefaultView() {
        setWidthFull();
        addClassName(SpConstants.TYPOGRAPHY);
        String url = "https://opensource.adobe.com/spectrum-web-components/components/";
        add(SpHtml.paragraph().components(
                new Text("Vaadin implementation of Spectrum Web Components. More information about Spectrum can be found "),
                new SpLink(url, "here"),
                new Text(".")
        ).size(HasSizeFluent.Size.XXL).build());
        add(SpHtml.paragraph().components(
                new SpLink("https://github.com/MarcinVaadin/vaadin-spectrum-web-components", "Check on GitHub")
        ).size(HasSizeFluent.Size.XL).build());


        add(SpHtml.header().text("Components").asH3());
        Reflections reflections = new Reflections(new ConfigurationBuilder()
                .setUrls(ClasspathHelper.forPackage("org.vaadin.spectrum")));
        Set<Class<? extends Object>> allClasses =
                reflections.getTypesAnnotatedWith(NpmPackage.class);

        SpectrumComponentsGrid grid = new SpectrumComponentsGrid();
        grid.setItems(new ListDataProvider<>(allClasses));
        add(grid);
    }

}
