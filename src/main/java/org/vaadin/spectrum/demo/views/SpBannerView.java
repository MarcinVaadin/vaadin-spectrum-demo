package org.vaadin.spectrum.demo.views;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;
import org.vaadin.spectrum.SpBanner;
import org.vaadin.spectrum.demo.DemoLayout;
import org.vaadin.spectrum.demo.DemoView;

@Route(value = "sp-banner", layout = DemoLayout.class)
public class SpBannerView extends DemoView {

    public SpBannerView() {
        super(SpBanner.class);

        sectionDivider("Example");

        SpBanner banner = new SpBanner("Header text", "Content of the banner");
        add(banner);

        sectionDivider("Variants");

        HorizontalLayout wrapper = wrapHorizontal();
        for (SpBanner.Type type : SpBanner.Type.values()) {
            banner = new SpBanner(type.name().toLowerCase(), "Content of the banner");
            banner.setType(type);
            wrapper.add(banner);
        }
        add(wrapper);

        sectionDivider("Corner");

        Div div = new Div();
        div.getElement().setAttribute("style", "width: 350px;" +
                "max-width: 75%;" +
                "height: 75px;" +
                "background-color: antiquewhite;" +
                "position: relative;");
        banner = new SpBanner("Info", "In the corner");
        banner.setCorner(true);
        div.add(banner);
        add(div);

    }
}