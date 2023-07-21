package org.vaadin.spectrum.demo.views;

import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.router.Route;
import org.vaadin.spectrum.*;
import org.vaadin.spectrum.demo.DemoLayout;
import org.vaadin.spectrum.demo.DemoView;
import org.vaadin.spectrum.properties.HasSizeFluent;
import org.vaadin.spectrum.utils.Placement;

@Route(value = "sp-dialog-base", layout = DemoLayout.class)
public class SpDialogBaseView extends DemoView {

    private Span status = new Span();

    public SpDialogBaseView() {
        super(SpDialogBase.class);

        add(SpHtml.header().text("Examples").asH3());
        add(new SpDivider().setSize(HasSizeFluent.Size.S));

        SpOverlayTrigger overlayTrigger = new SpOverlayTrigger().setPlacement(Placement.NONE);
        SpDialogBase dialogBase = new SpDialogBase().setDismissable(true);
        dialogBase.setDialog(buildDialog(overlayTrigger));
        overlayTrigger.setClickContent(dialogBase);
        overlayTrigger.setTrigger(new SpButton().setText("Defaults"));

        SpOverlayTrigger overlayTrigger2 = new SpOverlayTrigger().setType(SpOverlayTrigger.Type.MODAL).setPlacement(Placement.NONE);
        dialogBase = new SpDialogBase().setMode(SpDialogBase.Mode.FULLSCREEN).setUnderlay(true).setDismissable(true);
        dialogBase.setDialog(buildDialog(overlayTrigger2));
        overlayTrigger2.setClickContent(dialogBase);
        overlayTrigger2.setTrigger(new SpButton().setText("Modal fullscreen"));

        add(wrapHorizontal(overlayTrigger, overlayTrigger2));
    }

    private SpDialog buildDialog(SpOverlayTrigger overlayTrigger) {
        String lorem = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut " +
                "labore et dolore magna aliqua. Auctor augue mauris augue neque gravida. Libero volutpat sed ornare a" +
                "rcu. Quisque egestas diam in arcu cursus euismod quis viverra.";

        SpButton okButton = new SpButton().setText("OK").setVariant(SpButton.Variant.PRIMARY);
        SpButton cancelButton = new SpButton().setText("Cancel").setVariant(SpButton.Variant.SECONDARY);

        SpDialog dialog = new SpDialog().setHeading("Lorem ipsum").addButton(okButton).addButton(cancelButton).setFooter(new Span("Is above ok?"));

        okButton.addClickListener(ev -> overlayTrigger.close());
        cancelButton.addClickListener(ev -> overlayTrigger.close());

        dialog.add(new Span(lorem));
        return dialog;
    }

}
