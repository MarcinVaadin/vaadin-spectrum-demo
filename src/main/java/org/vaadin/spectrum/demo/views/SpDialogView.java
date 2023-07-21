package org.vaadin.spectrum.demo.views;

import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.router.Route;
import org.vaadin.spectrum.SpButton;
import org.vaadin.spectrum.SpDialog;
import org.vaadin.spectrum.SpDivider;
import org.vaadin.spectrum.SpHtml;
import org.vaadin.spectrum.demo.DemoLayout;
import org.vaadin.spectrum.demo.DemoView;
import org.vaadin.spectrum.properties.HasSizeFluent;

@Route(value = "sp-dialog", layout = DemoLayout.class)
public class SpDialogView extends DemoView {

    private Span status = new Span();

    public SpDialogView() {
        super(SpDialog.class);

        String lorem = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut " +
                "labore et dolore magna aliqua. Auctor augue mauris augue neque gravida. Libero volutpat sed ornare a" +
                "rcu. Quisque egestas diam in arcu cursus euismod quis viverra.";

        add(SpHtml.header().text("Sizes").asH3());
        add(new SpDivider().setSize(HasSizeFluent.Size.S));

        SpDialog dialog = new SpDialog().setHeading("Small dialog").setSize(HasSizeFluent.Size.S);
        dialog.add(new Span(lorem));
        add(dialog);

        dialog = new SpDialog().setHeading("Medium dialog").setSize(HasSizeFluent.Size.M);
        dialog.add(new Span(lorem));
        add(dialog);

        dialog = new SpDialog().setHeading("Large dialog").setSize(HasSizeFluent.Size.L);
        dialog.add(new Span(lorem));
        add(dialog);

        add(SpHtml.header().text("Dismissable").asH3());
        add(new SpDivider().setSize(HasSizeFluent.Size.S));
        add(new Paragraph(new Span("Events: "), status));
        add(new SpDivider().setSize(HasSizeFluent.Size.S));

        dialog = new SpDialog().setHeading("Lorem ipsum").setDismissable(true);
        dialog.add(new Span(lorem));
        dialog.addCloseEventListener(ev -> status.setText(ev.getSource().getHeading() + " closed"));
        add(dialog);

        add(SpHtml.header().text("Hero and no divider").asH3());
        add(new SpDivider().setSize(HasSizeFluent.Size.S), new Paragraph(""));

        dialog = new SpDialog().setHeading("Lorem ipsum").setNoDivider(true)
                .setHero(new Image("http://placekitten.com/500/100", "Kitten"));
        dialog.add(new Span(lorem));
        add(dialog);

        add(SpHtml.header().text("Buttons and footer").asH3());
        add(new SpDivider().setSize(HasSizeFluent.Size.S));

        SpButton okButton = new SpButton().setText("OK").setVariant(SpButton.Variant.PRIMARY);
        SpButton cancelButton = new SpButton().setText("Cancel").setVariant(SpButton.Variant.SECONDARY);

        dialog = new SpDialog().setHeading("Lorem ipsum").addButton(okButton).addButton(cancelButton).setFooter(new Span("Is above ok?"));
        dialog.add(new Span(lorem));
        add(dialog);

    }

}
