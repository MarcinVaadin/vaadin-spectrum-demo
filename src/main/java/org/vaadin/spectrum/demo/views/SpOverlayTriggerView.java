package org.vaadin.spectrum.demo.views;

import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.router.Route;
import org.vaadin.spectrum.*;
import org.vaadin.spectrum.demo.DemoLayout;
import org.vaadin.spectrum.demo.DemoView;
import org.vaadin.spectrum.properties.HasSizeFluent;

@Route(value = "overlay-trigger", layout = DemoLayout.class)
public class SpOverlayTriggerView extends DemoView {

    private Span status = new Span();

    public SpOverlayTriggerView() {
        super(SpOverlayTrigger.class);

        String lorem = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut " +
                "labore et dolore magna aliqua. Auctor augue mauris augue neque gravida. Libero volutpat sed ornare a" +
                "rcu. Quisque egestas diam in arcu cursus euismod quis viverra.";

        add(SpHtml.header().text("Buttons and footer").asH3());
        add(new SpDivider().setSize(HasSizeFluent.Size.S));

        SpButton okButton = new SpButton().setText("OK").setVariant(SpButton.Variant.PRIMARY);
        SpButton cancelButton = new SpButton().setText("Cancel").setVariant(SpButton.Variant.SECONDARY);

        SpDialog dialog = new SpDialog().setHeading("Lorem ipsum").addButton(okButton).addButton(cancelButton)
                .setFooter(new Span("Is above ok?")).setSize(HasSizeFluent.Size.S).setDismissable(true);
        dialog.add(new Span(lorem));

        SpOverlayTrigger overlayTrigger = new SpOverlayTrigger().setClickContent(dialog);
        SpButton openButton = new SpButton().setText("Open");
        overlayTrigger.setTrigger(openButton);
        overlayTrigger.setHoverContent(new SpTooltip().setText("Click me to open!"));

        okButton.addClickListener(ev -> overlayTrigger.close());
        cancelButton.addClickListener(ev -> overlayTrigger.close());

        add(overlayTrigger);

    }

}
