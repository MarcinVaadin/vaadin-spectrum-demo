package org.vaadin.spectrum.demo;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.server.AppShellSettings;
import com.vaadin.flow.theme.NoTheme;

@NoTheme
@CssImport("@spectrum-web-components/styles/typography.css")
public class DemoApp implements AppShellConfigurator {

    @Override
    public void configurePage(AppShellSettings settings) {
        settings.addLink("stylesheet", "https://fonts.cdnfonts.com/css/adobe-clean");
    }

}
