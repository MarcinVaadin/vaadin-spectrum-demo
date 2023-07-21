package org.vaadin.spectrum.demo.views;

import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;
import org.vaadin.spectrum.SpCard;
import org.vaadin.spectrum.demo.DemoLayout;
import org.vaadin.spectrum.demo.DemoView;
import org.vaadin.spectrum.properties.HasSizeFluent;

@Route(value = "sp-card", layout = DemoLayout.class)
public class SpCardView extends DemoView {

    public SpCardView() {
        super(SpCard.class);

        sectionDivider("Example");

        HorizontalLayout wrapper = wrapHorizontal();
        wrapper.setAlignItems(FlexComponent.Alignment.START);
        SpCard card = new SpCard("Card Heading");
        card.setSubheading("With cover-photo");
        card.setFooter("Footer");
        card.setCoverPhoto(new Image("https://picsum.photos/200/300", "Example image"));
        wrapper.add(card);

        card = new SpCard("Card Heading");
        card.setSubheading("With preview");
        card.setFooter("Footer");
        card.setPreview(new Image("https://picsum.photos/200/300", "Example image"));
        wrapper.add(card);

        add(wrapper);

        sectionDivider("Variants");

        wrapper = wrapHorizontal();
        wrapper.setAlignItems(FlexComponent.Alignment.START);

        for (SpCard.Variant variant : SpCard.Variant.values()) {
            card = new SpCard("Card Heading");
            card.setSubheading(variant.name().toLowerCase());
            card.setFooter("Footer");
            card.setVariant(variant);
            card.setPreview(new Image("https://picsum.photos/200/300", "Example image"));
            wrapper.add(card);
        }

        add(wrapper);

        sectionDivider("Horizontal");

        card = new SpCard("Card Heading");
        card.setSubheading("Horizontal");
        card.setHorizontal(true);
        card.setSize(HasSizeFluent.Size.S);
        card.setPreview(new Image("https://picsum.photos/100/100", "Example image"));
        add(card);

    }
}