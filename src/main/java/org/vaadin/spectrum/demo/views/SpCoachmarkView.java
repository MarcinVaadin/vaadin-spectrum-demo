package org.vaadin.spectrum.demo.views;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;
import org.vaadin.spectrum.SpCoachmark;
import org.vaadin.spectrum.demo.DemoLayout;
import org.vaadin.spectrum.demo.DemoView;

@Route(value = "sp-coachmark", layout = DemoLayout.class)
public class SpCoachmarkView extends DemoView {

    public SpCoachmarkView() {
        super(SpCoachmark.class);

        sectionDivider("Variants, Standard");

        HorizontalLayout wrapper = wrapHorizontal();
        for (SpCoachmark.Variant variant : SpCoachmark.Variant.values()) {
            SpCoachmark coachmark = new SpCoachmark();
            coachmark.setVariant(variant);
            wrapper.add(coachmark);
        }
        add(wrapper);

        sectionDivider("Variants, Quiet");

        wrapper = wrapHorizontal();
        for (SpCoachmark.Variant variant : SpCoachmark.Variant.values()) {
            SpCoachmark coachmark = new SpCoachmark(true);
            coachmark.setVariant(variant);
            wrapper.add(coachmark);
        }
        add(wrapper);

    }
}