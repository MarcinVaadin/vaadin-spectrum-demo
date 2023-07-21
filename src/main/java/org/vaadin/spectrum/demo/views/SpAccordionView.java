package org.vaadin.spectrum.demo.views;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.router.Route;
import org.vaadin.spectrum.*;
import org.vaadin.spectrum.demo.DemoLayout;
import org.vaadin.spectrum.demo.DemoView;
import org.vaadin.spectrum.properties.HasSizeFluent;

import java.util.List;
import java.util.stream.Collectors;

@Route(value = "sp-accordion", layout = DemoLayout.class)
public class SpAccordionView extends DemoView implements ComponentEventListener<SpAccordion.SpAccordionToggleEvent> {

    private Span status = new Span();

    public SpAccordionView() {
        super(SpAccordion.class);
        add(new Paragraph(new Span("Events: "), status));
        add(new SpDivider().setSize(HasSizeFluent.Size.S));

        SpAccordion accordion = createAccordion().setAllowMultiple(true);
        SpButtonGroup actionButtons = new SpButtonGroup();
        actionButtons.add(
                createActionButton("Open all items", ev -> {accordion.openAllItems();}),
                createActionButton("Close all items", ev -> {accordion.closeAllItems();}),
                createActionButton("Get opened items", ev -> {
                    status.setText(itemsToString(accordion.getOpenItems()));}),
                createActionButton("Enable all items", ev -> {accordion.getItems().forEach(item -> item.setDisabled(false));}));
        add(new Paragraph(actionButtons));

        add(new SpDivider().setSize(HasSizeFluent.Size.S));
        add(new Paragraph(SpHtml.header().text("Example - Allow multiple").asH3()));
        add(accordion);
    }

    private SpAccordion createAccordion() {
        SpAccordion accordion = new SpAccordion();
        accordion.addToggleEventListener(this);
        for (int i = 0 ; i < 8 ; i++) {
            SpAccordionItem item = new SpAccordionItem().setLabel("Heading " + i);
            item.add(new Paragraph("Some content of item " + i));
            item.setDisabled(i % 3 == 0);
            accordion.addItem(item);
        }
        return accordion;
    }

    private SpButton createActionButton(String text, ComponentEventListener<ClickEvent<SpButton>> listener) {
        SpButton button = new SpButton().setText(text).setVariant(SpButton.Variant.SECONDARY);
        button.addClickListener(listener);
        return button;
    }

    @Override
    public void onComponentEvent(SpAccordion.SpAccordionToggleEvent spAccordionToggleEvent) {
        SpAccordionItem item = spAccordionToggleEvent.getToggledItem();
        String status = item.isOpen() ? "opened" : "closed";
        status += ", fromClient: " + spAccordionToggleEvent.isFromClient();
        this.status.setText(item.getLabel() + " [" + status + "]");
    }

    private String itemsToString(List<SpAccordionItem> items) {
        return items.stream().map(SpAccordionItem::getLabel).collect(Collectors.joining(", "));
    }
}
