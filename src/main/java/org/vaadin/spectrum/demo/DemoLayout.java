package org.vaadin.spectrum.demo;

import com.vaadin.flow.component.HasElement;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.RouteBaseData;
import com.vaadin.flow.router.RouterLayout;
import org.vaadin.spectrum.*;
import org.vaadin.spectrum.properties.HasSizeFluent;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class DemoLayout extends SpTheme implements RouterLayout {

    private HorizontalLayout contentWrapper = new HorizontalLayout();

    public DemoLayout() {
        getElement().getStyle().set("background-color", "var(--spectrum-global-color-gray-50)");
        getElement().getStyle().set("padding", "0 20%").set("min-height", "100%");
        getElement().getStyle().set("display", "flex").set("flex-direction", "column");
        // normally Spectrum theme uses 'adobe-clean' and 'adobe-clean-serif' font family
        // they needed to be aligned with stylesheet provided by cdnfonts.com
        getElement().getStyle().set("--spectrum-global-font-family-base", "\"Adobe Clean\",\"Source Sans Pro\",-apple-system,BlinkMacSystemFont,\"Segoe UI\",Roboto,Ubuntu,\"Trebuchet MS\",\"Lucida Grande\",sans-serif");
        getElement().getStyle().set("--spectrum-global-font-family-serif", "\"Adobe Clean Serif\",\"Source Serif Pro\",Georgia,serif");

        SpSideNav sideNav = new SpSideNav();
        sideNav.getStyle().set("width", "200px").set("margin", "20px 50px 0 0");
        getItems().forEach(sideNav::add);

        add(SpHtml.header().text("Spectrum Web Components for Vaadin").size(HasSizeFluent.Size.S).asH1());

        contentWrapper.addClassName(SpConstants.TYPOGRAPHY);
        Div drawer = new Div();
        drawer.add(SpHtml.header().text("Components").asH2());
        drawer.add(sideNav);
        contentWrapper.add(drawer);
        add(contentWrapper);
    }

    private List<SpSideNavItem> getItems() {
        return UI.getCurrent().getInternals().getRouter().getRegistry().getRegisteredRoutes().stream()
                .map(RouteBaseData::getTemplate)
                .filter(t -> !t.isEmpty())
                .sorted()
                .map(t -> new SpSideNavItem().setLabel(t).setHref(t))
                .collect(Collectors.toList());
    }

    @Override
    public void showRouterLayoutContent(HasElement content) {
        if (content != null) {
            contentWrapper.getElement()
                    .appendChild(Objects.requireNonNull(content.getElement()));
        }
    }

}
